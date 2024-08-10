import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Aluno {
  private Scanner leia;
  private Statement s;

  public Aluno(Statement s) throws Exception {
    this.leia = new Scanner(System.in);
    this.s = s;
  }
  
	public void inserirAluno() throws Exception {
		String SQL = "";
		String tabela = "Alunos";
		ResultSet rset = s.executeQuery("SELECT * from " + tabela);

		String valores = "";
		String campos = "";

		ResultSetMetaData rsmd = rset.getMetaData();
		int numColumns = rsmd.getColumnCount();

		for (int i = 0; i < numColumns; i++) {
			System.out.print("Insira o dado para a coluna=" + rsmd.getColumnName(i + 1) + ": ");

			if ((rsmd.getColumnTypeName(i + 1)).equals("INT")) {
				if (i != numColumns - 1) {
					valores = valores + leia.next() + ",";
					campos = campos + rsmd.getColumnName(i + 1) + ",";
				} else {
					valores = valores + leia.next();
					campos = campos + rsmd.getColumnName(i + 1);
				}
			} else {
				if (i != numColumns - 1) {
					valores = valores + "'" + leia.nextLine() + "',";
					campos = campos + rsmd.getColumnName(i + 1) + ",";
				} else {
					valores = valores + "'" + leia.next() + "'";
					campos = campos + rsmd.getColumnName(i + 1);
				}
			}
		}

		SQL = "INSERT INTO " + tabela + " (" + campos + ") VALUES (" + valores + ")";
		System.out.println(SQL);
		s.executeUpdate(SQL);
		System.out.println("Dados Inseridos!");
	}

	public void buscarAlunoPorCPF() throws Exception {
		System.out.print("Digite o CPF do aluno: ");
		String cpf = leia.nextLine();

		String SQL = "SELECT * from Alunos WHERE cpf = '" + cpf + "'";
		ResultSet rs = s.executeQuery(SQL);

		if (rs.next()) {
			System.out.println("Nome: " + rs.getString("nome"));
			System.out.println("Curso: " + rs.getString("curso"));
			System.out.println("Fase: " + rs.getInt("fase"));
			System.out.println("CPF: " + rs.getString("cpf"));
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}

	public void deletarAlunoPorCPF() throws Exception {
		System.out.print("Digite o CPF do aluno a ser deletado: ");
		String cpf = leia.nextLine();

		String SQL = "DELETE FROM Alunos WHERE cpf = '" + cpf + "'";
		int rowsAffected = s.executeUpdate(SQL);

		if (rowsAffected > 0) {
			System.out.println("Aluno deletado com sucesso.");
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}

	public void modificarFaseDoAluno() throws Exception {
		System.out.print("Digite o CPF do aluno: ");
		String cpf = leia.nextLine();

		String SQL = "SELECT * from Alunos WHERE cpf = '" + cpf + "'";
		ResultSet rs = s.executeQuery(SQL);

		if (rs.next()) {
			System.out.println("Dados atuais do aluno:");
			System.out.println("Nome: " + rs.getString("nome"));
			System.out.println("Curso: " + rs.getString("curso"));
			System.out.println("Fase: " + rs.getInt("fase"));
			System.out.println("CPF: " + rs.getString("cpf"));

			System.out.print("Digite a nova fase do aluno: ");
			int novaFase = leia.nextInt();
			leia.nextLine();

			SQL = "UPDATE Alunos SET fase = " + novaFase + " WHERE cpf = '" + cpf + "'";
			s.executeUpdate(SQL);

			System.out.println("Fase atualizada com sucesso!");

			rs = s.executeQuery("SELECT * from Alunos WHERE cpf = '" + cpf + "'");
			if (rs.next()) {
				System.out.println("Dados atualizados do aluno:");
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Curso: " + rs.getString("curso"));
				System.out.println("Fase: " + rs.getInt("fase"));
				System.out.println("CPF: " + rs.getString("cpf"));
			}
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}
}

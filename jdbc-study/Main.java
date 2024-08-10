import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String database = "alunos_database";
		Scanner leia = new Scanner(System.in);

		try {
			Connection Conn = DriverManager.getConnection(makeConnectionString("postgres"));
			Statement s = Conn.createStatement();

			System.out.println("BD Conectado");
			Conn = startDatabase(Conn, s, database);
			s = Conn.createStatement();
			int opcao;
			do {
				System.out.println("\nMenu:");
				System.out.println("1. Inserir novo aluno");
				System.out.println("2. Buscar aluno por CPF");
				System.out.println("3. Deletar aluno por CPF");
				System.out.println("4. Modificar fase do aluno");
				System.out.println("0. Sair");
				System.out.print("Escolha uma opção: ");
				opcao = leia.nextInt();
				leia.nextLine();
				Aluno aluno = new Aluno(s);

				switch (opcao) {
					case 1:
						aluno.inserirAluno();
						break;
					case 2:
						aluno.buscarAlunoPorCPF();
						break;
					case 3:
						aluno.deletarAlunoPorCPF();
						break;
					case 4:
						aluno.modificarFaseDoAluno();
						break;
					case 0:
						System.out.println("Saindo...");
						break;
					default:
						System.out.println("Opção inválida!");
				}
			} while (opcao != 0);

		} catch (Exception e) {
			System.err.println("Ocorreu um Erro!");
			e.printStackTrace();
		} finally {
			leia.close();
		}
	}

	private static Connection startDatabase(Connection Conn, Statement s, String database) throws Exception {
		String SQL = "";
		ArrayList<String> list = new ArrayList<>();
		DatabaseMetaData meta = Conn.getMetaData();
		ResultSet rs = meta.getCatalogs();
		while (rs.next()) {
			String listofDatabases = rs.getString("TABLE_CAT");
			list.add(listofDatabases);
		}
		if (list.contains(database)) {
			s.executeUpdate("DROP DATABASE " + database);
			s.executeUpdate("CREATE DATABASE " + database);
			System.out.println("Database criada!");
		} else {
			s.executeUpdate("CREATE DATABASE " + database);
			System.out.println("Database criada!");
		}
		rs.close();

		Conn.close();
		Conn = DriverManager.getConnection(makeConnectionString(database));
		s = Conn.createStatement();
		System.out.println("Conectado à base de dados " + database);

		SQL = "CREATE TABLE Alunos (nome varchar(50), curso varchar(50), fase int, cpf varchar(50) PRIMARY KEY)";
		s.executeUpdate(SQL);
		System.out.println("Tabela 'Alunos' Criada!");

		return Conn;
	}

	private static String makeConnectionString(String database) {
		String url = "jdbc:postgresql://localhost:5432/" + database + "?user=postgres&password=123456";
		return url;
	}
}

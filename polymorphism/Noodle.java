public class Noodle extends Produto{
    protected String nome;
    protected String nacionalidade;

    public Noodle() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Noodle{" +
                "nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

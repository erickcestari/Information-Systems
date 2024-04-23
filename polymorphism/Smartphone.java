public class Smartphone extends Produto{
    protected String nome;
    protected String tipoTela;
    protected boolean usado;

    public Smartphone() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "nome='" + nome + '\'' +
                ", tipoTela='" + tipoTela + '\'' +
                ", usado=" + usado +
                ", id='" + id + '\'' +
                '}';
    }
}

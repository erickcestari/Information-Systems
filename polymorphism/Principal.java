public class Principal {
  public static void main(String[] args) {
    Smartphone smartphone = new Smartphone();
    smartphone.setNome("Samsung Galaxy S10");
    smartphone.setTipoTela("AMOLED");
    smartphone.setUsado(false);
    smartphone.setId("1234567890");

    Noodle noodle = new Noodle();
    noodle.setNome("Ramen");
    noodle.setNacionalidade("Japão");
    noodle.setId("0987654321");

    CadastroProduto cadastroProduto = new CadastroProduto(smartphone);
    cadastroProduto.mostrarDadosdoProduto();

    CadastroProduto cadastroProduto2 = new CadastroProduto(noodle);
    cadastroProduto2.mostrarDadosdoProduto();
  }
}

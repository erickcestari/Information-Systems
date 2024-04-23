public class CadastroProduto extends Produto {
  private Produto produto;

  CadastroProduto(Produto produto) {
    this.produto = produto;
  }

  public void mostrarDadosdoProduto() {
    System.out.println(produto.toString());
  }
}

public class Principal2 {
  public static void main(String args[]) {
    PardeElementos<String> palavras = new PardeElementos<String>("Ana", "José");
    System.out.println(palavras.primeiroElemento);
    System.out.println(palavras.segundoElemento);
    PardeElementos<Integer> numeros = new PardeElementos<Integer>(1, 2);
    System.out.println(numeros.primeiroElemento);
    System.out.println(numeros.segundoElemento);
  }
}
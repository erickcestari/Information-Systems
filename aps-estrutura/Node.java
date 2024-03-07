public class Node {
  public int age;
  public String matricula;
  public Node previous;
  public Node next;

  Node(int age, String matricula) {
    this.age = age;
    this.matricula = matricula;
    this.previous = null;
    this.next = null;
  }
}
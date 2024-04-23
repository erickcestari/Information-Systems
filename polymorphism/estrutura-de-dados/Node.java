public class Node<T> {
  public T data;
  public Node<T> previous;
  public Node<T> next;

  Node(T data) {
    this.data = data;
  }
}
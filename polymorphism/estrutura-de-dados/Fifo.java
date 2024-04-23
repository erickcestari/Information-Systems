public class Fifo<T> {
  private Node<T> initial;
  private Node<T> end;

  Fifo() {
    initial = null;
    end = null;
  }

  public void push(T data) {
    Node<T> aux = new Node<T>(data);
    if (this.initial == null) {
      this.initial = aux;
      this.end = aux;
      return;
    }
    this.end.next = aux;
    aux.previous = this.end;
    this.end = aux;
  }

  public T shift() {
    if (this.initial == null)
      return null;
    var node = this.initial;
    this.initial = node.next;
    if (this.initial != null)
      this.initial.previous = null;
    return node.data;
  }

  public void display() {
    Node<T> aux = this.initial;
    while (aux != null) {
      System.out.println(aux.data.toString());
      aux = aux.next;
    }
  }

  public void displayReverse() {
    Node<T> aux = this.end;
    while (aux != null) {
      System.out.println(aux.data.toString());
      aux = aux.previous;
    }
  }

  public void reset() {
    this.initial = null;
    this.end = null;
  }

  public T getHead() {
    if (this.initial == null)
      return null;
    return this.initial.data;
  }

  public T getTail() {
    if (this.end == null)
      return null;
    return this.end.data;
  }
}

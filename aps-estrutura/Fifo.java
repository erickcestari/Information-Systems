public class Fifo {
  private Node initial;
  private Node end;

  Fifo() {
    initial = null;
    end = null;
  }

  public void push(int age, String matricula) {
    Node aux = new Node(age, matricula);
    if (this.initial == null) {
      this.initial = aux;
      this.end = aux;
      return;
    }
    this.end.next = aux;
    aux.previous = this.end;
    this.end = aux;
  }

  public Node shift() {
    var node = this.initial;
    this.initial = this.initial.next;
    this.initial.previous = null;
    return node;
  }

  public void display() {
    Node aux = this.initial;
    while (aux != null) {
      System.out.println("Matricula: " + aux.matricula + " Age: " + aux.age);
      aux = aux.next;
    }
  }

  public void displayReverse() {
    Node aux = this.end;
    while (aux != null) {
      System.out.println("Matricula: " + aux.matricula + " Age: " + aux.age);
      aux = aux.previous;
    }
  }

  public int search(String matricula) {
    Node aux = this.initial;
    while (aux != null) {
      if (aux.matricula.equals(matricula)) {
        return aux.age;
      }
      aux = aux.next;
    }
    return -1;
  }

  public void reset() {
    this.initial = null;
    this.end = null;
  }

  public String getHead() {
    if (this.initial == null)
      return null;
    return this.initial.matricula;
  }

  public String getTail() {
    if (this.end == null)
      return null;
    return this.end.matricula;
  }

  public float averageAge() {
    Node aux = this.initial;
    int sum = 0;
    int count = 0;
    while (aux != null) {
      sum += aux.age;
      count++;
      aux = aux.next;
    }
    return sum / count;
  }
}

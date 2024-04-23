import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Fifo<Integer> fifo = new Fifo<>();

    int choice;
    do {
      System.out.println("1. Inserir");
      System.out.println("2. Retirar");
      System.out.println("3. Mostrar");
      System.out.println("4. Mostrar Invertida");
      System.out.println("5. Reinicializar");
      System.out.println("6. Mostrar Calda");
      System.out.println("7. Mostrar Base");
      System.out.println("8. Vazar");
      System.out.println("Enter your choice (1-8): ");

      choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Enter the age: ");
          var age = scanner.nextInt();
          fifo.push(age);
          break;
        case 2:
          var matriculaResult = fifo.shift();
          if (matriculaResult == null) {
            System.out.println("Base vazia.");
            break;
          }
          System.out.println("Matricula do retirado: " + matriculaResult);
          break;
        case 3:
          fifo.display();
          break;
        case 4:
          fifo.displayReverse();
          break;
        case 5:
          fifo.reset();
          break;
        case 6:
          var tail = fifo.getTail();
          if (tail == null) {
            System.out.println("Calda vazia.");
            break;
          }
          System.out.println("Calda: " + tail);
          break;
        case 7:
          var base = fifo.getHead();
          if (base == null) {
            System.out.println("Base vazia.");
            break;
          }
          System.out.println("Base: " + fifo.getHead());
          break;
        case 8:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please enter a number between 1 and 10.");
      }
    } while (choice != 8);

    scanner.close();
  }
}
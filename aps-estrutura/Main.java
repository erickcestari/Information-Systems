import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Fifo fifo = new Fifo();

    int choice;
    do {
      System.out.println("1. Inserir");
      System.out.println("2. Retirar");
      System.out.println("3. Mostrar");
      System.out.println("4. Mostrar Invertida");
      System.out.println("5. Procurar");
      System.out.println("6. Media Idade");
      System.out.println("7. Reinicializar");
      System.out.println("8. Mostrar Calda");
      System.out.println("9. Mostrar Base");
      System.out.println("10. Vazar");
      System.out.println("Enter your choice (1-10): ");

      choice = scanner.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Enter the age: ");
          int age = scanner.nextInt();
          System.out.println("Enter the matricula: ");
          String matricula = scanner.next();
          fifo.push(age, matricula);
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
          System.out.println("Enter the matricula: ");
          String matriculaToSearch = scanner.next();
          int ageFound = fifo.search(matriculaToSearch);
          if (ageFound == -1) {
            System.out.println("Matricula not found.");
            break;
          }
          System.out.println("Age found: " + ageFound);
          break;
        case 6:
          System.out.println("Average age: " + fifo.averageAge());
          break;
        case 7:
          fifo.reset();
          break;
        case 8:
          var tail = fifo.getTail();
          if (tail == null) {
            System.out.println("Calda vazia.");
            break;
          }
          System.out.println("Calda: " + tail);
          break;
        case 9:
          var base = fifo.getHead();
          if (base == null) {
            System.out.println("Base vazia.");
            break;
          }
          System.out.println("Base: " + fifo.getHead());
          break;
        case 10:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please enter a number between 1 and 10.");
      }
    } while (choice != 10);

    scanner.close();
  }
}
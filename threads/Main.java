import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(1301) + 200;
        Product product = new Product(random);
        Distributor first = new Distributor("First", product);
        Distributor second = new Distributor("Second", product);
        Distributor third = new Distributor("Third", product);

        first.start();
        second.start();
        third.start();
    }
}

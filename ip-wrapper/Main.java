import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an IPv4 address(xxx.xxx.xxx.xxx): : ");
    String ipv4 = sc.nextLine();
    System.out.println("Enter a subnet mask(xxx.xxx.xxx.xxx): ");
    String subnetMask = sc.nextLine();

    Ip ip = new Ip(ipv4, subnetMask);
    System.out.println(ip.toString());
    System.out.println(ip.getClassType());
    System.out.println(ip.getNetworkIp());
    System.out.println(ip.getBinaryNetworkIp());
  }
}
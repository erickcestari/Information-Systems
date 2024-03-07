import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.regex.Matcher;

public class Ip {
  private enum ClassType {
    A, B, C
  }

  private ClassType classType;
  private String ipv4;
  private String subnetMask;

  private static final Pattern SUBNET_MASK_PATTERN = Pattern
      .compile("^((255|254|252|248|240|224|192|128|0)\\.){3}(255|254|252|248|240|224|192|128|0)$");
  private static final Pattern IPV4_PATTERN = Pattern
      .compile(
          "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\/([0-9]|[1-2][0-9]|3[0-2]))?$");

  public Ip(String ipv4String, String subnetMask) {
    validateIpv4(ipv4String);
    validateSubnetMaskIpv4Format(subnetMask);

    this.classType = takeDefaultClassTypeByIpv4String(ipv4String);
    this.subnetMask = subnetMask;
    this.ipv4 = ipv4String;
  }

  public Ip(String ipv4String) {
    validateIpv4(ipv4String);

    var subnetMaskFromIpv4 = takeSubnetMask(ipv4String);
    var classType = takeDefaultClassTypeByIpv4String(ipv4String);

    if (subnetMaskFromIpv4 != null) {
      validateSubnetMask(classType, subnetMaskFromIpv4);
    }

    this.classType = takeDefaultClassTypeByIpv4String(ipv4String);
    this.ipv4 = ipv4String;
  }

  public void setIpv4(String ipv4String) {
    validateIpv4(ipv4String);
    this.classType = takeDefaultClassTypeByIpv4String(ipv4String);
    this.ipv4 = ipv4String;
  }

  public ClassType getClassType() {
    return this.classType;
  }

  public String getSubnetMask() {
    return this.subnetMask;
  }

  public void setSubnetMask(String subnetMask) {
    validateSubnetMaskIpv4Format(subnetMask);
    this.subnetMask = subnetMask;
  }

  public String getNetworkIp() {
    if (this.subnetMask == null) {
      throw new IllegalArgumentException("Subnet mask is not set");
    }
    var ipv4Parts = this.ipv4.split("/")[0].split("\\.");
    var subnetMaskParts = this.subnetMask.split("\\.");

    int[] networkIpParts = new int[4];
    for (int i = 0; i < 4; i++) {
      networkIpParts[i] = Integer.parseInt(ipv4Parts[i]) & Integer.parseInt(subnetMaskParts[i]);
    }

    return String.join(".", Arrays.stream(networkIpParts).mapToObj(String::valueOf).toArray(String[]::new));
  }

  public String getBinaryNetworkIp() {
    var netWorkIp = getNetworkIp();
    var netWorkIpParts = netWorkIp.split("\\.");

    StringBuilder binaryNetworkIp = new StringBuilder();
    for (String part : netWorkIpParts) {
      String binaryPart = Integer.toBinaryString(Integer.parseInt(part));
      binaryNetworkIp.append(String.format("%8s", binaryPart).replace(' ', '0'));
      binaryNetworkIp.append(".");
    }
    binaryNetworkIp.deleteCharAt(binaryNetworkIp.length() - 1);

    return binaryNetworkIp.toString();
  }

  public String toString() {
    return ipv4;
  }

  private ClassType takeDefaultClassTypeByIpv4String(String ipv4String) {
    int firstOctet = takeFirstOctet(ipv4String);
    String binaryString = Integer.toBinaryString(firstOctet);
    String paddedBinaryString = String.format("%8s", binaryString).replace(' ', '0');
    String firstTwoBits = paddedBinaryString.substring(0, 2);

    switch (firstTwoBits) {
      case "00":
      case "01":
        return ClassType.A;
      case "10":
        return ClassType.B;
      case "11":
        return ClassType.C;
      default:
        throw new IllegalArgumentException("Invalid IPv4 format");
    }
  }

  private static int takeFirstOctet(String ipv4String) {
    return Integer.parseInt(ipv4String.split("\\.")[0]);
  }

  private static void validateIpv4(String ipv4String) {
    Matcher matcher = IPV4_PATTERN.matcher(ipv4String);
    if (!matcher.find()) {
      throw new IllegalArgumentException("Invalid IPv4 format");
    }
  }

  private static void validateSubnetMaskIpv4Format(String subnetMask) {
    Matcher matcher = SUBNET_MASK_PATTERN.matcher(subnetMask);
    if (!matcher.find()) {
      throw new IllegalArgumentException("Invalid subnetMask format");
    }
  }

  private static String takeSubnetMask(String ipv4String) {
    String[] parts = ipv4String.split("/");
    if (parts.length == 1) {
      return null;
    }

    return parts[1];
  }

  private static void validateSubnetMask(ClassType classType, String subnetMask) {
    int subnetMaskInt = Integer.parseInt(subnetMask);
    if (subnetMaskInt < 0 || subnetMaskInt > 32) {
      throw new IllegalArgumentException("Invalid subnet mask");
    }

    switch (classType) {
      case A:
        if (subnetMaskInt != 8) {
          throw new IllegalArgumentException("Invalid subnet mask for class A");
        }
        break;
      case B:
        if (subnetMaskInt != 16) {
          throw new IllegalArgumentException("Invalid subnet mask for class B");
        }
        break;
      case C:
        if (subnetMaskInt != 24) {
          throw new IllegalArgumentException("Invalid subnet mask for class C");
        }
        break;
    }
  }
}
import javax.swing.JOptionPane;

public class DynamicBinaryTree {
  public Node root;

  DynamicBinaryTree() {
    root = null;
  }

  public Node getRoot() {
    return root;
  }

  public void buildTree(Node node, char side, int quem) {
    String input = "error";
    switch(side) {
      case 's': 
        input = JOptionPane.showInputDialog("Insert the root ");
        break;
      case 'l': 
        input = JOptionPane.showInputDialog("Insert left node of " + quem);
        break;
      case 'r': 
        input = JOptionPane.showInputDialog("Insert the right node of " + quem);
        break;
    }
    int intInput = Integer.parseInt(input);
    if (intInput != 0) {
      Node where = insert(node, intInput, side);
      buildTree(where, 'l', intInput);
      buildTree(where, 'r', intInput);
    }
  }

  public Node insert(Node node, int intInput, char side) {
    Node newNode = new Node(intInput);
    if (root == null) {
      root = newNode;
      return newNode;
    }

    switch(side) {
      case 'l': 
        node.left = newNode;
        break;
      case 'r': 
        node.right = newNode;
        break;
    }

    return newNode;
  }

  public void printPreOrderRight(Node root) {
    if (root != null) {
      System.out.print(" " + root.data);
      printPreOrderRight(root.right);
      printPreOrderRight(root.left);
    }
  }

  public void printPreOrderLeft(Node root) {
    if (root != null) {
      System.out.print(" " + root.data);
      printPreOrderLeft(root.left);
      printPreOrderLeft(root.right);
    }
  }

  public void printPosOrderLeft(Node root) {
    if (root != null) {
      printPosOrderLeft(root.left);
      printPosOrderLeft(root.right);
      System.out.print(" " + root.data);
    }
  }

  public void printPosOrderRight(Node root) {
    if (root != null) {
      printPosOrderRight(root.right);
      printPosOrderRight(root.left);
      System.out.print(" " + root.data);
    }
  }

  public void printInOrderLeft(Node root) {
    if (root != null) {
      printInOrderLeft(root.left);
      System.out.print(" " + root.data);
      printInOrderLeft(root.right);
    }
  }

  public void printInOrderRight(Node root) {
    if (root != null) {
      printInOrderRight(root.right);
      System.out.print(" " + root.data);
      printInOrderRight(root.left);
    }
  }

}

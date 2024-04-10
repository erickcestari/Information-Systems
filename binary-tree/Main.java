public class Main {
  public static void main(String[] args) {
    // var vBTree = new VBinaryTree(3);
    // vBTree.loadTree();
    // vBTree.pre_ordem(0);
    // System.out.println();
    // vBTree.in_ordem(0);
    // System.out.println();
    // vBTree.pos_ordem(0);

    // var tree = new DynamicBinaryTree();
    // tree.buildTree(null, 's', 0);
    // tree.printPreOrderLeft(tree.getRoot());

    var tree = new DynamicThirdTree();
    tree.buildTree(null, 's', 0);
    tree.printPreOrderLeft(tree.getRoot());
  }
}

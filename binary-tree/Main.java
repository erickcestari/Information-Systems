public class Main {
  public static void main(String[] args) {
    // BinaryTree bTree = new BinaryTree();
    // bTree.setRoot(new Node(10));
    // var left = bTree.addLeft(bTree.getRoot(), -1);
    // var right = bTree.addRight(bTree.getRoot(), 1);

    // bTree.addRight(left, 2);
    // bTree.addLeft(left, -2);
    // bTree.addRight(right, 2);
    // bTree.addLeft(right, -2);

    
    // bTree.printTreePreOrder();

    // var vBTree = new VBinaryTree(3);
    // vBTree.loadTree();
    // vBTree.pre_ordem(0);
    // System.out.println();
    // vBTree.in_ordem(0);
    // System.out.println();
    // vBTree.pos_ordem(0);

    var arvore = new DynamicBinaryTree();
    arvore.buildTree(null, 's', 0);
    arvore.printPreOrderLeft(arvore.getRoot());
  }
}

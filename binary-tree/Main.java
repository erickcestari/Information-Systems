public class Main {
  public static void main(String[] args) {
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

// Erick Cestari

import java.util.Scanner;

public class VBinaryTree {
  public int[] tree;

  VBinaryTree(int height) {
    var size = Math.pow(2, height) - 1;
    tree = new int[(int) size];
  }

  public void loadTree() {
    var sc = new Scanner(System.in);
    for (var i = 0; i < tree.length; i++) {
      if (i == 0) {
        System.out.println("Root");
        tree[0] = sc.nextInt();
        continue;
      }

      if (i % 2 == 1) {
        System.out.println("Write the left leaf of: " + tree[(i - 1) / 2]);
        tree[i] = sc.nextInt();
      }
      if (i % 2 == 0) {
        System.out.println("Write the right leaf of: " + tree[(i - 2) / 2]);
        tree[i] = sc.nextInt();
      }
    }
  }

  public void printTree() {
    int height = (int) (Math.log(tree.length + 1) / Math.log(2));
    int index = 0;
    int level = 0;
    int spaces = (int) Math.pow(2, height) - 1;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < spaces; j++) {
        System.out.print("  ");
      }
      spaces /= 2;

      for (int j = 0; j < Math.pow(2, level); j++) {
        if (index < tree.length) {
          System.out.print("|_" + tree[index] + "_|");
          index++;
        }
      }
      level++;
      System.out.println();
    }
  }

  public void pos_ordem(int i) {
    if (tree.length > i && tree[i] != 0) {
      pos_ordem(i * 2 + 1);
      pos_ordem(i * 2 + 2);
      System.out.print(" " + tree[i]);
    }
  }

  public void in_ordem(int i) {
    if (tree.length > i && tree[i] != 0) {
      in_ordem(i * 2 + 1);
      System.out.print(" " + tree[i]);
      in_ordem(i * 2 + 2);
    }
  }

  public void pre_ordem(int i) {
    if (tree.length > i && tree[i] != 0) {
      System.out.print(" " + tree[i]);
      pre_ordem(i * 2 + 1);
      pre_ordem(i * 2 + 2);
    }
  }

  public void pos_ordem_right(int i) {
    if (tree.length > i && tree[i] != 0) {
      pos_ordem(i * 2 + 2);
      pos_ordem(i * 2 + 1);
      System.out.print(" " + tree[i]);
    }
  }

  public void in_ordem_right(int i) {
    if (tree.length > i && tree[i] != 0) {
      in_ordem(i * 2 + 2);
      System.out.print(" " + tree[i]);
      in_ordem(i * 2 + 1);
    }
  }

  public void pre_ordem_right(int i) {
    if (tree.length > i && tree[i] != 0) {
      System.out.print(" " + tree[i]);
      pre_ordem(i * 2 + 2);
      pre_ordem(i * 2 + 1);
    }
  }
}
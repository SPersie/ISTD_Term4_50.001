package PS3PartBCC.Q2TinarySearchTree;

/**
 * Created by study on 5/11/17.
 */

public class TestTrinaryTree {
    public static void main(String[] args) {
        int[] num = {100, 200, 590, 70, 80, 360, 110, 105, 102,107};
        //String S = "SUTD ISTD ASD ESD EPD";


        TrinarySearchTree t = new TrinarySearchTree();

        for (int i = 0; i < num.length; i++) {
            t.insert(num[i]);
        }
        System.out.println("\nPreOrder Traversal: ");
        t.preOrder(t.root);
        System.out.println("\nInOrder Traversal: ");
        t.inOrder(t.root);
        System.out.println("\nPostOrder Traversal: ");
        t.postOrder(t.root);

        System.out.println("\n");
        int t1 =t.search(t.root, 100, 0);
        System.out.println("found 100 at depth " +t1);
        int t2 =t.search(t.root, 590, 0);
        System.out.println("found 590 at depth " +t2);
        int t3 =t.search(t.root, 107, 0);
        System.out.println("found 107 at depth " +t3);

        System.out.println("Minimum value: " +t.findMin(t.root));
        System.out.println("Maximum value: " +t.findMax(t.root));
    }
}

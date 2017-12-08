package PS3PartBHW.Q2ArrayofTrees;

/**
 * Created by study on 6/11/17.
 */

class Nodel {
    protected int counter;
    protected String data;
    protected Nodel left;
    protected Nodel right;
    public Nodel (String data) {
        this.data = data;
        counter = 1;
    }
    public Nodel(String data, Nodel left, Nodel right) {
        this.data =data;
        this.left = left;
        this.right = right;
    }


}
class Nodet {
    protected Nodel rootl;
    protected Nodet left;
    protected Nodet right;
    public Nodet(String data) {
        rootl = new Nodel(data);
    }
    public Nodet(String data, Nodet left, Nodet right) {
        this(data);
        this.left = left;
        this.right = right;
    }
    public void insert(String data) {
        myinsert(data,rootl);

    }
    public static void myinsert(String data, Nodel n) {
        if (data.equals(n.data)) {
            n.counter +=1;
            return;
        }
        if (data.compareTo(n.data) > 0) {
            if (n.right == null) {
                n.right = new Nodel(data,null,null);
                return;
            }
            myinsert(data, n.right);
        } else {
            if (n.left == null) {
                n.left = new Nodel(data, null, null);
                return;
            }
            myinsert(data,n.left);
        }
    }
    public void display() {
        System.out.print("\nInorder Traversal:");
        mydisplay(rootl);
    }
    public static void mydisplay(Nodel node) {
        if (node.left != null) {
            mydisplay(node.left);
        }
        System.out.print(" "+node.data + " (" + node.counter + ")");
        if (node.right != null) {
            mydisplay(node.right);
        }
    }

}

public class ArrayofTrees {
    Nodet root;

    public ArrayofTrees() {
    }

    public ArrayofTrees(String data) {
        root = new Nodet(data, null, null);
    }

    public void insert(String data) {
        if (root == null) {
            root = new Nodet(data, null, null);
            return;
        }
        myinsert(data, root);
    }

    public static void myinsert(String data, Nodet node) {
        if (data.charAt(0) == node.rootl.data.charAt(0)) {
            node.insert(data);
            return;
        }
        if (data.charAt(0) < node.rootl.data.charAt(0)) {
            if (node.left == null) {
                node.left = new Nodet(data, null, null);
                return;
            }
            myinsert(data, node.left);
        } else {
            if (node.right == null) {
                node.right = new Nodet(data, null, null);
                return;
            }
            myinsert(data, node.right);
        }
    }

    public void display() {
        mydisplay(root);
    }

    public static void mydisplay(Nodet node) {
        if (node.left != null) {
            mydisplay(node.left);
        }
        node.display();
        if (node.right != null) {
            mydisplay(node.right);
        }
    }
}


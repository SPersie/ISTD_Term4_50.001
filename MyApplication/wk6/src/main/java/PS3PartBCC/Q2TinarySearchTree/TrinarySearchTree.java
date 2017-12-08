package PS3PartBCC.Q2TinarySearchTree;

/**
 * Created by study on 5/11/17.
 */
class Node1{
    int datal;
    int datar;
    Node1 left;
    Node1 middle;
    Node1 right;
    public Node1(int datal, int datar){
        this.datal = datal;
        this.datar = datar;
        left = null;
        middle = null;
        right = null;
    }
}

public class TrinarySearchTree {
    public static  Node1 root;
    public TrinarySearchTree(){
        this.root = null;
    }

    public void insert(int id){
        if(root ==null) {
            Node1 newnode1 =new Node1(id, -1);
            root =newnode1;
            return;
        } else if(root.datar ==-1) {
            if(id <root.datal) {
                root.datar =root.datal;
                root.datal =id;
            } else if(id ==root.datal) {
                return;
            } else {
                root.datar =id;
            }
            return;
        }

        Node1 current =root;
        Node1 parent =null;

        while(true) {
            parent =current;
            if(id ==current.datal || id ==current.datar) {
                return;
            } else if(id <current.datal & id <current.datar) {
                current =current.left;
                if(current ==null) {
                    parent.left =new Node1(id, -1);
                    return;
                } else if(current.datar ==-1) {
                    if(id <current.datal) {
                        current.datar =current.datal;
                        current.datal =id;
                    } else if(id ==current.datal) {
                        return;
                    } else {
                        current.datar =id;
                    }
                    return;
                }
            } else if(id >current.datal & id <current.datar) {
                current =current.middle;
                if(current ==null) {
                    parent.middle =new Node1(id, -1);
                    return;
                } else if(current.datar ==-1) {
                    if(id <current.datal) {
                        current.datar =current.datal;
                        current.datal =id;
                    } else if(id ==current.datal) {
                        return;
                    } else {
                        current.datar =id;
                    }
                    return;
                }

            } else {
                current = current.right;
                if (current == null) {
                    parent.right = new Node1(id, -1);
                    return;
                } else if (current.datar == -1) {
                    if (id < current.datal) {
                        current.datar = current.datal;
                        current.datal = id;
                    } else if (id == current.datal) {
                        return;
                    } else {
                        current.datar = id;
                    }
                    return;
                }
            }
        }
    }

    public int search (Node1 root, int x, int depth) {
        if(x ==root.datal || x ==root.datar) {
            return depth;
        } else if(x <root.datal & x <root.datar) {
            return search(root.left, x, depth +1);
        } else if(x >root.datal & x <root.datar) {
            return search(root.middle, x, depth +1);
        } else {
            return search(root.right, x, depth +1);
        }
    }

	public int findMin(Node1 root) {
        if(root.left ==null) {
            return root.datal;
        } else {
            return findMin(root.left);
        }
    }

	public int findMax(Node1 root) {
        if(root.right ==null) {
            return root.datar;
        } else {
            return findMax(root.right);
        }
    }



    public void preOrder(Node1 root){
        if(root!=null){
            System.out.print(" " + root.datal + " " +root.datar);
            preOrder(root.left);
            preOrder(root.middle);
            preOrder(root.right);
        }
    }

    public void inOrder(Node1 root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(" " + root.datal);
            inOrder(root.middle);
            System.out.println(" " +root.datar);
            inOrder(root.right);
        }
    }

    public void postOrder(Node1 root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.middle);
            postOrder(root.right);
            System.out.print(" " + root.datal +" " +root.datar);
        }
    }

}

/*

1) Inorders are the same. print from the smallest to the largest.
2) Preorder and Postorder, they are different. Because of their different data structure.
    Binary tree has two children and Trinary tree has three children.
 */
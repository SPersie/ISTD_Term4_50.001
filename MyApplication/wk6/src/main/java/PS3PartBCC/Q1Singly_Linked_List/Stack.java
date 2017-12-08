package PS3PartBCC.Q1Singly_Linked_List;

/**
 * Created by study on 5/11/17.
 */
import java.util.Scanner;

class Node1{
    protected int data;
    protected Node1 link;

    /*  Constructor  */
    public Node1()    {
        link = null;
        data = 0;
    }
    /*  Constructor  */
    public Node1(int d,Node1 n)    {
        data = d;
        link = n;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node1 n)
    {
        link = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }
    /*  Function to get link to next node  */
    public Node1 getLink()
    {
        return link;
    }
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}

class LinkedList1
{
    protected Node1 start;
    protected Node1 end ;
    public int size ;

    /*  Constructor  */
    public LinkedList1()    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }
    /*  Function to insert an element at begining  */
    public void insertAtStart(int val)
    {
        Node1 nptr = new Node1(val, null);
        size++ ;
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setLink(start);
            start = nptr;
        }
    }
    /*  Function to insert an element at end  */
    public void insertAtEnd(int val)
    {
        Node1 nptr = new Node1(val,null);
        size++ ;
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
    /*  Function to insert an element at position  */
    public void insertAtPos(int val , int pos)
    {
        Node1 nptr = new Node1(val, null);
        Node1 ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++)
        {
            if (i == pos)
            {
                Node1 tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {
        if (pos == 1)        {
            start = start.getLink();
            size--;
            return ;
        }
        if (pos == size)        {
            Node1 s = start;
            Node1 t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        Node1 ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++)        {
            if (i == pos)           {
                Node1 tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }
    /*  Function to display elements  */
    public void display()    {
        System.out.print("\nStack = ");
        if (size == 0)        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null)        {
            System.out.println(start.getData() );
            return;
        }
        Node1 ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)       {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}




public class Stack{
    public static void main(String[] args)    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        LinkedList1 list = new LinkedList1();
        System.out.println("Stack Test\n");
        char ch;
        /*  Perform list operations  */
        do        {
            System.out.println("\nStack Operations\n");
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. Pop");
            System.out.println("4. Check empty");
            System.out.println("5. Display");
            int choice = scan.nextInt();
            switch (choice)            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    list.insertAtStart( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println(list.start.getData());
                    break;
                case 3 :
                    list.deleteAtPos(1);
                    break;
                case 4 :
                    System.out.println("Empty status = "+ list.isEmpty());
                    break;
                case 5 :
                    list.display();
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}

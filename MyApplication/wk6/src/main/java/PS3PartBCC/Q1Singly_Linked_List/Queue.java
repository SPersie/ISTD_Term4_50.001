package PS3PartBCC.Q1Singly_Linked_List;

/**
 * Created by study on 5/11/17.
 */

import java.util.Scanner;

/*  Class Node  */
class Node2{
    protected int data;
    protected Node2 link;

    /*  Constructor  */
    public Node2()    {
        link = null;
        data = 0;
    }
    /*  Constructor  */
    public Node2(int d,Node2 n)    {
        data = d;
        link = n;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node2 n)
    {
        link = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }
    /*  Function to get link to next node  */
    public Node2 getLink()
    {
        return link;
    }
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}

/* Class linkedList */
class LinkedList2
{
    protected Node2 start;
    protected Node2 end ;
    public int size ;

    /*  Constructor  */
    public LinkedList2()    {
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
        Node2 nptr = new Node2(val, null);
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
        Node2 nptr = new Node2(val,null);
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
        Node2 nptr = new Node2(val, null);
        Node2 ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++)
        {
            if (i == pos)
            {
                Node2 tmp = ptr.getLink() ;
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
            Node2 s = start;
            Node2 t = start;
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
        Node2 ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++)        {
            if (i == pos)           {
                Node2 tmp = ptr.getLink();
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
        System.out.print("\nQueue = ");
        if (size == 0)        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null)        {
            System.out.println(start.getData() );
            return;
        }
        Node2 ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)       {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}

/*  Class SinglyLinkedList  */
public class Queue{
    public static void main(String[] args)    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        LinkedList list = new LinkedList();
        System.out.println("Queue Test\n");
        char ch;
        /*  Perform list operations  */
        do        {
            System.out.println("\nQueue Operations\n");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Check empty");
            System.out.println("4. Display");
            int choice = scan.nextInt();
            switch (choice)            {

                case 1 :
                    System.out.println("Enter integer element to insert");
                    list.insertAtEnd( scan.nextInt() );
                    break;
                case 2 :
                    list.deleteAtPos(1);
                    break;
                case 3 :
                    System.out.println("Empty status = "+ list.isEmpty());
                    break;
                case 4 :
                    list.display();
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
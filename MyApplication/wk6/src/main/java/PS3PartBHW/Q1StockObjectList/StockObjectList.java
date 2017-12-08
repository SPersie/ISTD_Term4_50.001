package PS3PartBHW.Q1StockObjectList;

/**
 * Created by study on 5/11/17.
 */

import java.util.Scanner;

/*  Class Node  */
class Node1  {
    protected String data;
    protected int header;
    protected Node1 next, prev;

    /* Constructor */
    public Node1()     {
        next = null;
        prev = null;
        data = null;
        header =0;
    }
    /* Constructor */
    public Node1(String d, Node1 n, Node1 p)    {
        data = d;
        next = n;
        prev = p;
        header =d.length();
    }
    /* Function to set link to next node */
    public void setLinkNext(Node1 n)    {
        next = n;
    }
    /* Function to set link to previous node */
    public void setLinkPrev(Node1 p)    {
        prev = p;
    }
    /* Funtion to get link to next node */
    public Node1 getLinkNext()    {
        return next;
    }
    /* Function to get link to previous node */
    public Node1 getLinkPrev()    {
        return prev;
    }
    /* Function to set data to node */
    public void setData(String d)    {
        data = d;
    }
    /* Function to get data from node */
    public String getData()    {
        return data;
    }
}

/* Class LinkedList */
class LinkedList1 {
    protected Node1 start;
    protected Node1 end ;
    public int size;

    /* Constructor */
    public LinkedList1()    {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()     {
        return start == null;
    }
    /* Function to get size of list */
    public int getSize()     {
        return size;
    }
    /* Function to insert element at begining */
    public void insertAtStart(String val)    {
        Node1 nptr = new Node1(val, null, null);
        if(start == null)         {
            start = nptr;
            end = start;
        }
        else         {
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
    }
    /* Function to insert element at end */
    public void insertAtEnd(String val)    {
        Node1 nptr = new Node1(val, null, null);
        if(start == null)        {
            start = nptr;
            end = start;
        }
        else        {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
    }
    /* Function to insert element at position */
    public void insertAtPos(String val , int pos)    {
        Node1 nptr = new Node1(val, null, null);
        if (pos == 1)        {
            insertAtStart(val);
            return;
        }
        Node1 ptr = start;
        for (int i = 2; i <= size; i++)        {
            if (i == pos)            {
                Node1 tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++ ;
    }
    /* Function to delete node at position */
    public void deleteAtPos(int pos)    {
        if (pos == 1)        {
            if (size == 1)            {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return ;
        }
        if (pos == size)        {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size-- ;
        }
        Node1 ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)        {
            if (i == pos)            {
                Node1 p = ptr.getLinkPrev();
                Node1 n = ptr.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }
    }
    /* Function to display status of list */
    public void display()    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0)        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null)        {
            System.out.println(start.getData() +" Header:" +start.header);
            return;
        }
        Node1 ptr = start;
        System.out.print(start.getData()+ " Header:" +start.header +" <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)        {
            System.out.print(ptr.getData()+ " Header:" +ptr.header + " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData()+ " Header:" +ptr.header +"\n");
    }

    public void displaypos(int pos) {
        if (size == 0)        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null)        {
            System.out.println(start.getData() +" Header:" +start.header );
            return;
        }
        Node1 ptr = start;
        int counter =1;
        while (counter !=pos)        {
            ptr = ptr.getLinkNext();
            counter +=1;
        }
        System.out.print(ptr.getData()+" Header:" +ptr.header + "\n");
    }

    public void sort(String val) {

        Node1 ptr = start;
        int counter = 1;
        while (ptr.header < val.length()) {
            if(ptr.getLinkNext() ==null) {
                insertAtEnd(val);
            } else {
                ptr = ptr.getLinkNext();
                counter += 1;
            }
        }
        if(ptr.getLinkNext() !=null) {
            insertAtPos(val, counter);
        }
    }
}

/* Class DoublyLinkedList */
public class StockObjectList {
    public static void main(String[] args)    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        LinkedList1 list = new LinkedList1();
        System.out.println("Doubly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do        {
            System.out.println("\nDoubly Linked List Operations\n");
            System.out.println("1. enterObject");
            System.out.println("2. displayObject(pos)");
            System.out.println("3. dumpObjects");
            System.out.println("4. check empty");

            int choice = scan.nextInt();
            switch (choice)            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    String takein =scan.next();
                    if(list.getSize() ==0) {
                        list.insertAtStart(takein);
                    } else if(list.getSize() ==1) {
                        if(list.start.header >takein.length()) {
                            list.insertAtStart(takein);
                        } else {
                            list.insertAtEnd(takein);
                        }
                    } else {
//                        list.insertAtPos(takein, list.sort(takein));
                        list.sort(takein);
                    }
                    break;
                case 3 :
                    list.display();
                    break;
                case 4 :
                    System.out.println("Empty status = "+ list.isEmpty());
                    break;
                case 2 :
                    System.out.println("Choose Subject");
                    int pos1 =scan.nextInt();
                    if(pos1 <=list.getSize()) {
                        list.displaypos(pos1);
                    } else {
                        System.out.println("Invalid position\n");
                    }
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
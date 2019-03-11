import java.sql.SQLOutput;
import java.util.Scanner;

class Node{
    private int data;
    private Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class CircularSinglyLinkedList {
    Node start;

    public boolean isEmpty(){
        return start==null;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("No node available");
            return;
        }
        Node temp = start;
        while (temp.getNext()!=start){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
        System.out.println(temp.getData());
    }

    public void insertEnd(int data){
        Node n = new Node();
        n.setData(data);
        if(isEmpty()){
            start = n;
            n.setNext(start);
        }
        else{
            Node temp = start;
            while (temp.getNext()!=start){
                temp = temp.getNext();
            }
            temp.setNext(n);
            n.setNext(start);
        }
    }

    public void insertFirst(int data){
        Node n = new Node();
        n.setData(data);
        if(isEmpty()){
            start = n;
            n.setNext(start);
        }
        else{
            Node temp = start;
            while (temp.getNext()!=start){
                temp = temp.getNext();
            }
            temp.setNext(n);
            n.setNext(start);
            start = n;
        }
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node temp = start;
        while (temp.getNext()!=start){
            temp = temp.getNext();
        }
        start = start.getNext();
        temp.setNext(start);
    }

    public void deleteLast(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node temp = start;
        Node temp1 = start;
        while (temp.getNext()!=start){
            temp1 = temp;
            temp = temp.getNext();
        }
        temp1.setNext(start);
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList obj = new CircularSinglyLinkedList();
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.Insert at beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Display");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at End");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    obj.insertFirst(sc.nextInt());
                    break;
                case 2:
                    obj.insertEnd(sc.nextInt());
                    break;
                case 3:
                    obj.display();
                    break;
                case 4:
                    obj.deleteFirst();
                    break;
                case 5:
                    obj.deleteLast();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (choice!=6);
    }
}

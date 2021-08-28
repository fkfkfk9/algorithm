import java.util.*;

public class ListEx {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        ListEx list = new ListEx();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));

        list.print();
        list.reverse();
        list.print();
        list.reverse2();
        list.print();
    }

    private void print(){
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null){
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node){
        if(head == null){
            head = node;
            tail = node;
        }else if(tail != null){
            tail.next = node;
            tail = tail.next;
        }
    }

    //링크드 리스트를 역으로 뒤집는다.
    //시간복잡도는 반복문이 있어 O(n) 공간복잡도는 고정된 변수만 사용하므로 O(1)이다.
    private void reverse(){
        LinkedNode current = this.head;
        LinkedNode prev = null;
        LinkedNode next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.tail = this.head;
        this.head = prev;
    }

    //링크드 리스트를 역으로 뒤집는다.
    //재귀함수를 사용한다. 시간복잡도는 O(n), 공간복잡도 또한 O(n)이다.
    private void reverse2(){
        LinkedNode head = this.head;
        this.head = reverseRecursive(head);
        this.tail = head;

    }

    //재귀함수이다.
    private LinkedNode reverseRecursive(LinkedNode node){
        if(node == null || node.next ==null){
            return node;
        }

        LinkedNode newHwad = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return newHwad;
    }
}

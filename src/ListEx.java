import java.util.*;

public class ListEx {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        ListEx list = new ListEx();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(7));
        list.add(new LinkedNode(8));

        list.print();
        list.reverse();
        list.print();
        list.reverse2();
        list.print();

        LinkedNode node = list.findFromLast(2);
        LinkedNode node2 = list.findFromLast2(2);
        LinkedNode node3 = list.findFromLast3(2);
        System.out.println("findFromLast Result : " + node.number);
        System.out.println("findFromLast2 Result : " + node2.number);
        System.out.println("findFromLast3 Result : " + node3.number);

        ListEx list2 = new ListEx();
        list2.add(new LinkedNode(2));
        list2.add(new LinkedNode(2));
        list2.add(new LinkedNode(2));
        list2.add(new LinkedNode(3));
        list2.add(new LinkedNode(4));

        list2.print();
        list2.removeDuplicates();
        list2.print();
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

    /*
    * 링크드 리스트에서 뒤에서 n번째 값을 가져온다.
    * O(n)의 방식으로 하기 위해 HashMap을 사용한다.
    * HashMap과 HashTable는 ArrayList와 Vector의 차이와 같다.
    * LinkedList는 크기를 알려면 한번 순회를 해주어야 한다는 단점이 있다.
    * */
    private LinkedNode findFromLast(int n){
        Map<Integer, LinkedNode> nodeMap = new HashMap<>();
        int idx = 0;
        LinkedNode current = this.head;

        while(current != null){
            nodeMap.put(idx++, current);
            current = current.next;
        }

        return nodeMap.get(nodeMap.size() - n);
    }

    //순회를 하여 O(2n)의 방식으로 한다.
    //순회를 함으로써 2n이 되면 여전히 O(n)이고 공간복잡도가 O(1)이 된다.
    private LinkedNode findFromLast2(int n){
        LinkedNode current = this.head;
        int length = 0;

        while(current != null){
            length++;
            current = current.next;
        }

        int targetIdx = length - n;
        LinkedNode target = this.head;

        while(targetIdx > 0){
            targetIdx--;
            target = target.next;
        }

        return target;
    }

    //순회를 한번만 하여 O(n)의 방식으로 한다.
    //순회를 할 때 오른쪽 좌표 왼쪽 좌표를 두고 해당 좌표 사이를
    // n으로하여 오른쪽 끝에 도달할때 왼쪽 좌표가 리턴할 노드이다.
    private LinkedNode findFromLast3(int n){
        LinkedNode rightNode = this.head;
        LinkedNode leftNode = this.head;
        int length = 0;

        while(rightNode != null){
            length++;
            rightNode = rightNode.next;
            if(length > n){
                leftNode = leftNode.next;
            }
        }

        return leftNode;
    }

    /*
    * 링크드 리스트에서 중복되는 노드를 제거
    * */
    private void removeDuplicates(){
        LinkedNode current = this.head;
        while (current != null){
            LinkedNode next = current;
            while(next != null && next.number == current.number){
                next = next.next;
            }

            current.next = next;
            current = current.next;
        }
    }

    private void removeDuplicates2(){
        LinkedNode current = this.head;
        LinkedNode prev = this.head;

        while (current != null){
            if(current.number != prev.number){
                prev.next = current;
                prev = current;
            }

            current = current.next;
        }

        if(prev != current){
            prev.next = null;
        }
    }
}

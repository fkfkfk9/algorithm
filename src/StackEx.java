import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> numStack = new Stack<>();

        numStack.push(3);
        numStack.push(8);
        numStack.push(13);
        numStack.push(33);
        numStack.push(88);

        System.out.println(numStack);

        StackEx stackEx = new StackEx();
        Stack<Integer> reverseStack = stackEx.stackReverse1(numStack);

        System.out.println(reverseStack);
    }

    /*
    스택을 뒤집는다.
    스택을 만들어 그대로 넣어준다.
    맨위부터 나와 가장 아래로 들어가기 때문에 그냥 빼서 다른 스택에 차래대로만 넣어주면 역순이다.
    * */
    private Stack<Integer> stackReverse1(Stack<Integer> stack){
        Stack<Integer> reverseStack = new Stack<>();
        while (!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }

        return reverseStack;
    }

    /*
    스택을 뒤집는다.
    재귀함수를 사용한다.
    뒤집는 다는건 기존 데이터를 아래로 넣는 작업이기 때문에 이를 재귀로 아래로 넣게 반복시킨다.
    * */
    private void stackReverse2(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        stackReverse2(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack<Integer> stack, int num){
        if(stack.isEmpty()){
            stack.push(num);
        }else{
            int temp = stack.pop();
            insertAtBottom(stack, num);
            stack.push(temp);
        }
    }
}

package ads_4;

/*
 * StackX class from Datastructures and Algorithms in Java (Listing 4.7)
 */
public class StackNode {

    private int maxSize;
    private Node[] stackArray;
    private int top;
    private char type;
    
    public StackNode(int s) {
        maxSize = s;
        stackArray = new Node[maxSize];
        top = -1;
    }
    
    public void push(Node j) // put item on top of stack
    {
        stackArray[++top] = j;
    }
    
    public Node pop() // take item from top of stack
    {
        return stackArray[top--];
    }
    
    public Node peek() // peek at top of stack
    {
        return stackArray[top];
    }
    
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
    
    public int size() // return size
    {
        return top + 1;
    }
    
    public Node peekN(int n) // return item at index n
    {
        return stackArray[n];
    }
    
    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.println(peekN(j));
        }
        System.out.println("");
    }
}

package ads_4;

// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
import java.util.*;               // for Stack class

class Node {

    public char data;              // data item (key)
    public Node leftChild;         // this node's left child
    public Node rightChild;        // this node's right child

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(data);
        System.out.print("} ");
    }

    @Override
    public String toString() {
        String returnString;

        boolean done = false;
        //while(!done) {
        // Get bottom left node

        // Get node

        Stack globalStack = new Stack();
        globalStack.push(ADS_4.stack.peek());
        int nBlanks = 64;
        boolean isRowEmpty = false;
        System.out.println("");
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null
                            || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("  ");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }  // end while isRowEmpty is false
        System.out.println("......................................................");


        //}

        return "";
    }
}  // end class Node

class Tree {

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            if (!isDigit(localRoot.data)) {
                System.out.print("(");
            }

            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data);
            inOrder(localRoot.rightChild);

            if (!isDigit(localRoot.data)) {
                System.out.print(")");
            }
        }
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data);
        }
    }

    private boolean isDigit(char ch) {
        boolean isDigit = (ch >= '0' && ch <= '9');
        return isDigit;
    }
}  // end class Tree


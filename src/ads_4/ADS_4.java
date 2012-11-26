/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ads_4;

/**
 *
 * @author Jeff
 */
public class ADS_4 {

    //{'+', '-', '/', '*', '^'};
    /**
     * @param args the command line arguments
     */
    
    public static StackNode stack;
    
    public static void main(String[] args) {
        //String postfix = "42^24*8*-82^+48-/";
        String postfix = "12+3*";
        
        stack = new StackNode(20);

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);            
            
            if (isDigit(ch)) {
                Node n = new Node();
                n.data = ch;
                stack.push(n);
                
            } else {
                Node n = new Node();
                n.data = ch; // Operator
                
                Node left;
                Node right;
                
                System.out.println(stack.size());
                //stack.displayStack("Stack: ");
                
                right = stack.pop();
                left = stack.pop();
                
                n.leftChild = left;
                n.rightChild = right;
                
                stack.push(n);
                
            }
        }
        
        stack.displayStack("");
        
        Tree tree = new Tree();
        
        System.out.println("-------------");
        System.out.print("prefix:  " );
        tree.preOrder(stack.peek());
        System.out.print("\ninfix:   " );
        tree.inOrder(stack.peek());
        System.out.print("\npostfix: " );
        tree.postOrder(stack.peek());
        System.out.println("");
        
        

    }
    
    private static boolean isDigit(char ch) {
        boolean isDigit = (ch >= '0' && ch <= '9');
        return isDigit;
    }
}



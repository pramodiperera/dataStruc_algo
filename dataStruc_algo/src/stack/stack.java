
package stack;

/**
 *
 * @author USER
 */
public class stack {
    public static void main(String args[]){
        StackArray st = new StackArray(5);
            st.push(2);
            st.push(7);
            st.push(5);
            st.push(9);
            st.push(4);
            st.display();
         try{
           st.pop();
           st.display(); 
           System.out.println("Peek is "+st.peek()); 
            
        }catch(Exception e){
           System.out.println(e);
        }
   
    }
}

class StackArray{
    int[] stackData;
    int max;
    int top;
    
    // constructor
    public StackArray(int maxSize){
        this.stackData = new int[maxSize];
        this.max = maxSize;
        this.top = -1;
    }

    // full stack
    public boolean isFull(){
        return (this.top == this.max-1);
    }
    
    // empty stack
    public boolean isEmpty(){
        return (this.top == -1);
    }
    
    // insert an element
    public void push(int n){
        if(isFull()){
                System.out.println("stack is full . can't push");
                return;
            }
        this.top++;
        this.stackData[top] = n;
            
    }
    
    // remove an element
    public int pop() throws Exception{
      if(isEmpty()){
        throw new Exception("stack is empty. can't pop");
      }
       int tempInx = top;
        this.top--;
        return this.stackData[tempInx];
    }
    
    // return the top element of  the stack
    public int peek() throws Exception{
       if(isEmpty()){
            throw new Exception("Stack is empty.No peek");
       }
        return this.stackData[top];
    }
    
    // display stack
    public void display(){ // start from the top
       if(isEmpty()){
           System.out.println("Stack is empty");
           return;
       }
       System.out.println(" start of content ...........");
            for(int i=top;i>=0;i--){
                System.out.println(this.stackData[i]);
            }
            System.out.println("end of content .......");
    }
       
    
}

package queue;

/**
 *
 * @author USER
 */
public class queue {
    public static void main(String[] args) {
       QueueArray x=new QueueArray(5);
       x.display();
       x.enqueue(2);
       x.enqueue(8);
       x.enqueue(3);
       x.display();
       try{
           x.dequeue();
           x.display();
       }catch(Exception e){
           System.out.println(e.toString());
       }
    }
}


class QueueArray{
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    // constructor
    public  QueueArray(int max){
        this.queArray = new int[max];
        this.maxSize = max;
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;   //currently  available items
    }
    
    
    // empty queue
    public boolean isEmpty(){
        return this.nItems == 0;
    }
    
    
    // queue is full
    public boolean isFull(){
        return this.nItems == this.maxSize;
    }
    
    
    //currently  available items
    public int size(){
        return this.nItems;
    }
    
    
    // insert an element
    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full. can't insert");
            return;
        }
        /*
            if(this.rear==this.maxSize-1){
                this.rear = 0;
            }
            else{
                this.rear++;
            }
        */
            this.rear = (this.rear+1)% this.maxSize;
            this.queArray[rear] = value;
            this.nItems++;
        
    }
    
    
    // remove an element
    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty"); 
        }
        int temp = this.queArray[this.front];
        /*
            if(this.front == this.maxSize-1){
                this.front = 0;
            }
            else{
                this.front++;
            }
        */
        this.front = (this.front+1)%this.maxSize;
        this.nItems--;
        return temp;
    }
    
    
    // return front of the queue
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty. No any peek"); 
        }
        return this.queArray[this.front];
    }
    
    
    // display from front to rear
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to display");
            return;
        }
        int i = this.front;
        while(i != this.rear){
            System.out.print(this.queArray[i]+" ");
            /*
                if(i == this.maxSize-1){
                    i = 0;
                }else{
                    i++;
                }
            */
               i = (i+1) % this.maxSize;
        }
        System.out.println(this.queArray[this.rear]+" ");
        System.out.println("");
    }
    
    
}
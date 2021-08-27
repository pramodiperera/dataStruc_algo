
                            // avoid insert duplicated elements to array

package array;

/**
 *
 * @author USER
 */
public class no_duplicate_array {
    public static void main(String[] args) {
        NoDupArray x = new NoDupArray(6);
        x.insert(9);
        x.insert(6);
        x.insert(3);
        x.insert(8);
        x.display();
        x.insert(8);
    }
}


class NoDupArray { 
 
    private long[] a;   
    private int nElements;
 
    
    // constructor
    public NoDupArray(int max) {
        this.a = new long[max];
        this.nElements = 0;
    } 
 
    
    
    public boolean find(long SearchKey) {
       for(int i=0; i < this.nElements; i++){
           if(this.a[i] == SearchKey){
               return true;
           }          
       } 
       return false;
    } 
 
    
    
    public void insert(long value) {
        if(this.a.length == this.nElements){
            System.out.println("Array is full");
            return;
        }
        
        if(find(value)){
            System.out.println("Value is already exists. Insertion terminated !");
        }
        else{
            a[this.nElements]=value;
            this.nElements++;
        }
        
       
    }
   
    public boolean delete(long value) { 
            for(int i=0;i<this.nElements;i++){
                if(this.a[i]==value){
                    for(int j=i; j< this.nElements-1; j++){
                        this.a[j]=this.a[j+1];                               
                    }
                    this.nElements--;
                    System.out.println("deleted value");
                    return true;
                }
            }
            System.out.println("value not found");
            return false;
    } 
 
    public void display() {
        System.out.println("-- values of the array --");
        for(int i=0;i<this.nElements;i++){
            System.out.print(this.a[i]+" ");
        }
        System.out.println("");
    }  
 } 
    

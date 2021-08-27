
package array;

/**
 *
 * @author USER
 */
public class ordered_array {
    public static void main(String[] args) {
        OrdArray x = new OrdArray(7);
        x.insert(2);
        x.insert(9);
        x.insert(7);
        x.insert(7);
        x.insert(3);
        x.display();
        x.delete(7);
        x.display();
              
    }
}


class OrdArray {
    private long[] a; 
    private int nElements; // currently available no
    
    
    // constructor
    public OrdArray(int max) {
        this.a = new long[max];
        this.nElements = 0;
    }
    
    
    // max size of the array
    public int size() { 
         return this.a.length;
    }
    
    
    public int find(long searchKey) {
        for(int i=0;i< this.nElements;i++){
            if(this.a[i]==searchKey){
                return i;
            }
        }
        return -1;
    }
    
    
    public void insert(long value) { // insert while sorting
        if(this.nElements==size()){
            System.out.println("array is full");
            return;
        }
        for(int i=0;i<this.nElements;i++){
           if(this.a[i]>value){
               for(int j=this.nElements-1;j>=i;j--){
                   this.a[j+1] = this.a[j];
               }
               this.a[i]=value;
               this.nElements++;
               return;
           } 
        }
        this.a[this.nElements] = value;
        this.nElements++;
    }
    
    
    
    public boolean delete(long value) {
        int index = find(value);
        if(index == -1){
            System.out.println("value not found.Deletion terminated !");
            return false;
        }
        else{
           for(int i=index;i<this.nElements-1;i++){
               this.a[i] = this.a[i+1];
           }
           this.nElements--;
           return true;
        }
    }
    
    
    
    void display() { 
        System.out.println("-- Values of array --");
        for(int i=0; i<this.nElements;i++){
            System.out.print(a[i]+" ");
        }System.out.println("");    
    }
}
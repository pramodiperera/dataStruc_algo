
                                // bubble sort, insertion sort, selection sort
package sorting;

/**
 *
 * @author USER
 */
public class simple_sorting {
    
     public static void main(String[] args) {
        SimpleSorting x = new SimpleSorting(7);
        x.insert(4);
        x.insert(8); 
        x.insert(1); 
        x.insert(3); 
        x.display();
        x.insertionSort();
        x.display();
    }
}


class SimpleSorting {
    private int[] a;
    private int nElems;// currently available number of elements
    
    
    // constructor
    public SimpleSorting(int max) {
        this.a = new int[max];
        this.nElems =0;
    }
    
    
    public void insert(int value){
        if(this.nElems == this.a.length){
            System.out.println("array is full");
            return;
        }
        this.a[this.nElems] = value;
        this.nElems++;
    }
    
    
    public void display(){
        System.out.println("---- array content ----");
        for(int i=0;i<this.nElems;i++){
            System.out.print(this.a[i]+" ");
        }
        System.out.println("");
    }
    
    
    private void swap(int index1, int index2)
    {
        int temp = this.a[index1];
        this.a[index1] = this.a[index2];
        this.a[index2] = temp;
    }
    
    
    public void bubbleSort() {
        for(int i=0;i<this.nElems-1;i++){
            for(int j=0;j<(this.nElems-1)-i;j++){
                if(this.a[j]>this.a[j+1]){
                    swap(j,j+1);
                }
            }
        }
        System.out.println("Sorted by bubble sort");
    }
    
    
    public void selectionSort() {
        for(int i=0;i<this.nElems-1;i++){
            int minInx =i;
            for(int j=i+1;j<this.nElems;j++){
                if(this.a[j]<this.a[minInx]){
                    minInx=j;
                }
            }
            swap(i,minInx);
        }
        System.out.println("Sorted by selection sort");
    }
    
    
    public void insertionSort() {
        for(int i=1;i<this.nElems;i++){
            int key = this.a[i];
            int j=i-1;
            while(j>=0){ // while(j>=0 && this.a[j]>key)
                if(this.a[j]>key){
                    this.a[j+1]=this.a[j];
                }
                else{
                    break;
                }
                j--;
            }   
            this.a[j+1]=key;    
        }
        System.out.println("Sorted by insertion sort");
    }
    
   
}

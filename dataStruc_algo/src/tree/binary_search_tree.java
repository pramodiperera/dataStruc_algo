
package tree;

/**
 *
 * @author USER
 */
public class binary_search_tree {
    
    public static void main(String[] args) {
        BSTree t = new BSTree();
        t.addNode(10);
        t.addNode(5);
        t.inOrderTraversal(t.root);
        t.remove(10);
        System.out.println("");
        t.inOrderTraversal(t.root);
    }
    
}


class BSTNode { 
    int data; 
    BSTNode leftChild;
    BSTNode rightChild; 
    
    public BSTNode(int data){
        this.data=data; 
    } 
    
    @Override 
    public String toString(){
        return data+" ";
    }
    
    
    // to create deletion method
    //method to get the minimum value - successor
    public int minValue(){
        if(this.leftChild == null){//no left branch 
            return this.data;
        }
        else{
            return this.leftChild.minValue();
        }
    }
    
    
    public boolean remove(int data, BSTNode parent){
        if(data < this.data){
            if(this.leftChild != null){
                return this.leftChild.remove(data, this);
            }else{
                return false;
            }
        }
        else if(data > this.data){
            if(this.rightChild != null){
                return this.rightChild.remove(data, this);
            }else{
                return false;
            }
        }
        else{ // equal case - at the node to be deleted
          
            if(this.leftChild!=null && this.rightChild!=null){// nodes are in both side                   //using successor
               this.data = this.rightChild.minValue();
               this.rightChild.remove(this.data, this);
            }else if(parent.leftChild == this){ //a node in left side              
                parent.leftChild = (this.leftChild==null)? this.rightChild:this.leftChild;
            }
            else if(parent.rightChild == this){//a node in right side
                parent.rightChild = (this.leftChild==null)? this.rightChild:this.leftChild; 
            }
            return true;
        }
    }
}





 class BSTree { 
    BSTNode root;
    
    public boolean remove(int data){
        if(root == null){
            return false;
        }
        if(root.leftChild==null ){
            root = root.rightChild;
        }
        else if(root.rightChild==null ){
            root = root.leftChild;
        }
        return root.remove(data, null);
    }
    
    
    public void addNode(int data) {
        BSTNode newNode = new BSTNode(data);
        if(this.root == null){
            this.root = newNode;
        }else{
            BSTNode curr = root;
            while(true){
                BSTNode parent = curr;  
                if(newNode.data<curr.data){
                    curr=curr.leftChild;
                    if(curr==null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    curr=curr.rightChild; 
                    if(curr==null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
      
    }
    
    
    public void preOrderTraversal(BSTNode curr){//passing the root, from where to start
        if(curr == null){
            return;
        }
        System.out.print(curr); //call toString similar to "curr.toString"
        preOrderTraversal(curr.leftChild);
        preOrderTraversal(curr.rightChild);
    }
    
    
    public void postOrderTraversal(BSTNode curr){
        if(curr == null){
            return;
        }
        postOrderTraversal(curr.leftChild);
        postOrderTraversal(curr.rightChild);
        System.out.print(curr); //call toString
    }
    
    
     public void inOrderTraversal(BSTNode curr){
         if(curr == null){
            return;
        }
        inOrderTraversal(curr.leftChild);
        System.out.print(curr); //call toString
        inOrderTraversal(curr.rightChild);
    }
     
     
    public BSTNode findNode(int data){
        BSTNode curr = root;
        while(curr!=null){
           if(data == curr.data){
               return curr;
           }else{
               if(data<curr.data){
                   curr = curr.leftChild;
               }else{
                   curr = curr.rightChild;
               }
           }
        }
        return null;
    }
     
    
}
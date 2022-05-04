package packa;
public class LinkedList
{
  Node head;//inputting head
  
  //constructor
  LinkedList()
  {
    this.head = null;//setting list to null initially
  }
  
  //Decreasing Stock
  //-----------------------------------------------------------------------------------------
  //Precondition: takes 2 integer values from input file, ComponentNumber and unitsToRemove
  //PostCondidtion: based on component number, it determins which node is selected
  //                and then that node is subtracted by unitsToRemove, changing the CurrentStock
  //-----------------------------------------------------------------------------------------
  public void removeFromStock(int componentNumber, int unitsToRemove)
  {
    Node curr;
    if(head == null)//setting base case(if list is 0)
      return;
    else{ //if head needs to be selected and subtracted
      if(head.getComponentNumber() == componentNumber){
        head.setCurrentStock(head.getCurrentStock() - unitsToRemove);
      }//end if
      else{//for any other node 
        curr = head;
        while(componentNumber != curr.getComponentNumber()){//traversing the list
          curr = curr.next;
        }//end while
          if(componentNumber == curr.getComponentNumber()){
            curr.setCurrentStock(curr.getCurrentStock() - unitsToRemove);//when found, subtract by set number
            if(curr.getCurrentStock() < 0)
              System.out.println("\n"+"COMPONENT NUMBER " + curr.getComponentNumber() + " Does not have adequate stock."
                                   +" Stock level: "+ curr.getCurrentStock()+"\n");
          }//end if
        }//end if
      }//end else
    }//end method
  
  //Increasing Stock
  //-----------------------------------------------------------------------------------------
  //Precondition: takes 2 integer values from input file, ComponentNumber and unitsToAdd
  //PostCondidtion: based on component number, it determins which node is selected
  //                and then that node is subtracted by unitsToRemove, changing the CurrentStock
  //-----------------------------------------------------------------------------------------
  public void addToStock(int componentNumber, int unitsToAdd)
  {
    Node curr;
    if(head == null)//setting base case, if list is 0
      return;
    else{//if head need to be selested a added
      if(head.getComponentNumber() == componentNumber){
        head.setCurrentStock(head.getCurrentStock() + unitsToAdd);
      }//end if
      else{//if anoter other node needs to be selested
        curr = head;
        while(componentNumber != curr.getComponentNumber() && curr.next != null){//traversing the list
          curr = curr.next;
        }//end while
          if(componentNumber == curr.getComponentNumber()){//finding the number needed
            curr.setCurrentStock(curr.getCurrentStock() + unitsToAdd);//when found, add stock by set number
          }//end if
        }//end else
      }//end else
    }//end method 
  
  //Deleting a component
  //-----------------------------------------------------------------------------------------
  //Precondition: takes one integer values from input file, ComponentNumber
  //PostCondidtion: based on component number, it determins which node is selected
  //                and then that node is tagged for garbage collection
  //-----------------------------------------------------------------------------------------
  public void Delete(int componentNumber)
  {
    Node curr, prev;
    if(head == null)//sets the base case if list is 0
      return;
    else if(head != null){//if head needs to be deleted
      if(head.getComponentNumber() == componentNumber){
      curr = head;
      head = head.next;
      curr = null;
      }//end if
      else{///if any other node needs to be deleted
        prev = head;
        curr = head;
        while(curr!=null){//traversing through the list
          if(componentNumber == curr.getComponentNumber()){//when found + deletion  
            prev.next = curr.next;
            curr = null;
          }//end if
          else{//if not found, traver the list
            prev = curr;
            curr = curr.next;
          }//end else  
          }//end while
        }//end else
      }//end else if   
    }//end method
  
  //Inserting a component
  //-----------------------------------------------------------------------------------------
  //Precondition: takes 4 values from input file, ComponentNumber,desctirption,currectStock and reorderLevel
  //PostCondidtion: Takes componentNumber and assigns it to a node in order from least to greatest
  //                as well as stores all other data into the node created and assigned to
  //                as new node
  //-----------------------------------------------------------------------------------------
  public void Insert(int componentNumber,String description,int currentStock,int reorderLevel)
  {
    //creating the new node operator
    Node newNode = new Node(componentNumber,description,currentStock,reorderLevel);
    
    if(head == null)//if list is empty 
      head = newNode;
    else{//if node need be inserted infrount of head
      if(newNode.getComponentNumber() < head.getComponentNumber()){//replacing head
        newNode.next = head;
        head = newNode;
      }//end if
      else{//if node is in the list
          Node curr = head;//setting curr to head
          Node prev = null;//setting prev to null
          //treversing the list for insertion
          while(newNode.getComponentNumber() > curr.getComponentNumber() && curr.next != null){
            prev = curr;
            curr = curr.next;
          }//end while
          if(curr.getComponentNumber() < newNode.getComponentNumber()){//when number if found,insert
            curr.next = newNode;//set curr to newNode
          }//end if
          else{//setting prev and curr to correct place
            prev.next = newNode;
            newNode.next = curr;
          }//end else
        }//end else
      }//end else 
    }//end method
  
  //Traversing a list
  //-----------------------------------------------------------------------------------------
  //Precondition: none
  //PostCondidtion: prints all items that are stored in the linked list
  //-----------------------------------------------------------------------------------------
  public void traverse(){
    Node curr = head;//setting curr to head
    while(curr != null){//traversing the list
      
      if(curr.getCurrentStock() < 0)
        System.out.println("Item is removed");
      else if(curr.getCurrentStock()==curr.getReorderLevel()){
        System.out.println(curr.getComponentNumber()+ "\t\t\t"+curr.getDescription()+"\t"+curr.getCurrentStock()+"\t\t\t"+curr.getReorderLevel()+" *REORDER");
        curr = curr.next;
      }
      
      System.out.println(curr.getComponentNumber()+ "\t\t\t"+curr.getDescription()+"\t"+curr.getCurrentStock()+"\t\t\t"+curr.getReorderLevel());//values needed
      curr = curr.next;//traversing to the next node
    }//end while
  }//end method
}
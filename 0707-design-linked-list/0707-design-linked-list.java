class MyLinkedList {

    class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;


    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
   

    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
         }
        int i=0;
        ListNode temp=head;
        while(temp!=null){
            if(i==index){
                return temp.data;
            }
            i++;
            temp=temp.next; 
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if(head==null){
            head=tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        } 
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if(head==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        for(int i=0; i<index-1; i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
     
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return;
        }
        if(index==0){
            head=head.next;
            if(head==null){
                head=tail=null;
            }
            size--;
            return;
        }
        ListNode temp=head;
        for(int i=0; i<index-1; i++){
            temp=temp.next;
        }
        ListNode toDelete=temp.next;
        temp.next=toDelete.next;
        if(toDelete==tail){
            tail=temp;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
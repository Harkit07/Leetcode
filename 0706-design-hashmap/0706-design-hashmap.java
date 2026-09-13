class MyHashMap {
    class Node{
        int key;
        int value;

        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private int n;
    private int N;
    private LinkedList<Node> buckets[];

    public MyHashMap() {
        this.N=4;
        this.buckets=new LinkedList[4];
        for(int i=0; i<4; i++){
            buckets[i]=new LinkedList<>();
        }
    }
    
    private int hashFunction(int key){
        int hc = Integer.hashCode(key);
        return Math.abs(hc)%N;
    }

    private int searchInLL(int key,int bi){
        LinkedList<Node> ll = buckets[bi];
        int di=0;
        for(int i=0; i<ll.size(); i++){
            Node node = ll.get(i);
            if(node.key==key){
                return di;
            }
            di++;
        }
        return -1;
    }

    private void rehash(){
        LinkedList<Node>[] oldBucket = buckets;
        N=N*2;
        buckets = new LinkedList[N];
        for(int i=0; i<buckets.length; i++){
            buckets[i]= new LinkedList<>();
        }
        for(int i=0; i<oldBucket.length; i++){
            LinkedList<Node> ll = oldBucket[i];
            for(int j=0; j<ll.size(); j++){
                Node node = ll.get(j);
                put(node.key, node.value);
            }
        }
    }

    public void put(int key, int value) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if(di!=-1){
            Node node = buckets[bi].get(di);
            node.value=value;
        }else{
            buckets[bi].add(new Node(key, value));
            n++;
        }
    }
    
    public int get(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if(di!=-1){
            Node node = buckets[bi].get(di);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if(di!=-1){
           buckets[bi].remove(di);
            n--;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
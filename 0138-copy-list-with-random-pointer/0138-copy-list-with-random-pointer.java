/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){ return head;}
        Node temp=head;
        Map<Node,Node> map=new HashMap<>();
        while(temp!=null){
            if(!map.containsKey(temp)){
            Node copy=new Node(temp.val);
            map.put(temp,copy);}
            if(temp.next!=null){
                if(!map.containsKey(temp.next)){
                    map.put(temp.next,new Node(temp.next.val));
                }
                map.get(temp).next=map.get(temp.next);
            }
            if(temp.random!=null){
                if(!map.containsKey(temp.random)){
                    map.put(temp.random,new Node(temp.random.val));
                }
                map.get(temp).random=map.get(temp.random);
            }
            temp=temp.next;
        }
        return map.get(head);
        /*intuition
        the random pointer assignment will be heavy if we traverse every time
        -sol:storing in dict or hashmap(for easy access)
        the key for values should be actual node, bcoz if we use the node.val as refernce we
        cant handle the duplicate values
        -sol: use the node as reference as they are unique
        instead of traversing two times in single time only
        -traverse
            create node 
            check if next node and random node exist or not by hashmap 
            if exist directly point to them or else 
            create store and point it
        */

        



        


        
    }
}
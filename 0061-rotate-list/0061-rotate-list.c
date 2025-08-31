/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    struct ListNode *temp=head;
    int len=1;// for large value of k(put len =1 for nodes)
    if(!head||head->next==NULL) return head;
    while(temp->next!=NULL){
        temp=temp->next;
        len++;
    }
    k=k%len;
    if(k==0) return head;
    temp->next=head;
    temp=head;
    int steps=len-k;
    while(steps>1){
        temp=temp->next;
        steps--;
    }
    head=temp->next;
    temp->next=NULL;
    return head;

    
}
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if(head==NULL||head->next==NULL){ return head;}
    struct ListNode dummy;
    dummy.next=head;
    struct ListNode *prev=&dummy,*first=head,*second=head->next;
    while(first&&second){
        first->next=second->next;
        second->next=first;
        prev->next=second;
        prev=first;
        first=first->next;
        if(first){
        second=first->next;}
        else{
            second=NULL;
        }
    }
    return dummy.next;

    
    
}
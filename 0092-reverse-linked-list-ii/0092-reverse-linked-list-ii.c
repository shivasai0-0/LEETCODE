/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseBetween(struct ListNode* head, int left, int right) {
    if(!head||!head->next){ return head;}
    struct ListNode dummy;
    struct ListNode *prev=&dummy;
    dummy.next=head;
    for(int i=1;i<left;i++){
        prev=prev->next;
    }
    struct ListNode *curr=prev->next;
    struct ListNode *nex=curr->next;
    while(left<right){
        curr->next = nex->next;
        nex->next = prev->next;
        prev->next = nex;
        nex = curr->next;
        left++;
    }
    return dummy.next;
    
}
/* head insertion
        curr->next = nex->next;
        nex->next = prev->next;
        prev->next = nex;
        nex = curr->next;*/

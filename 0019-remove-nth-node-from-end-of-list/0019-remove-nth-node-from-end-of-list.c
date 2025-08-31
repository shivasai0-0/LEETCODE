/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode dummy;
    dummy.next=head;//it is introduced to handle the head test case 
    struct ListNode* fast=&dummy;
    struct ListNode* slow=&dummy;
    int i=0;
    while(fast!=NULL){
        if(i<=n){//when dummy node is used the fast should move 1 step more
            fast=fast->next;
            i++;
        }
        else{
            fast=fast->next;
            slow=slow->next;
        }
    }
    slow->next=slow->next->next;
    return dummy.next;
}
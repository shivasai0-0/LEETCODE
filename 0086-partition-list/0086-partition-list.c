/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* partition(struct ListNode* head, int x) {
    if(head==NULL) return head;
    struct ListNode smallhead,largehead,*curr=head,*small,*large;
    small=&smallhead;
    large=&largehead;
    while(curr!=NULL){
        if (curr->val>=x){
            large->next=curr;
            large=curr;

        }
        else{
            small->next=curr;
            small=curr;
        }
        curr=curr->next;
    }
    large->next=NULL;
    small->next=largehead.next;
    return smallhead.next;

}
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void reorderList(struct ListNode* head) {
    if (head==NULL){ 
    return;}
    struct ListNode *slow=head,*fast=head;
    while(fast!=NULL&&fast->next!=NULL){// always first check fast and then fast->next 
        fast=fast->next->next;
        slow=slow->next;
    }
    struct ListNode *curr=slow->next,*prev=NULL,*next;
    slow->next=NULL;
    while(curr!=NULL){
        next=curr->next;
        curr->next=prev;
        prev=curr;
        curr=next;
    }
    struct ListNode *first=head,*second=prev;
    struct ListNode *temp1,*temp2;
    while(second){
       temp1=first->next;
       temp2=second->next;
       first->next=second;
       second->next=temp1;
       first=temp1;
       second=temp2;
    }

    
}
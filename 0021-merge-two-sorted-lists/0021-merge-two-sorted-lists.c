/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    
    struct ListNode* p1=list1;
    struct ListNode* p2=list2;
    struct ListNode* temp;
    struct ListNode dummy;
    temp=&dummy;
    dummy.next=NULL;
    while(p1!=NULL&&p2!=NULL){
        if(p1->val>p2->val){
            temp->next=p2;
            p2=p2->next;
        }
        else{
            temp->next=p1;
            p1=p1->next;
        }
        temp=temp->next;

    }
    temp->next=(p1)? p1:p2;
    return dummy.next;
}
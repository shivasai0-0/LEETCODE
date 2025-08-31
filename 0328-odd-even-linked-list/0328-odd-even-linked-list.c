/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* oddEvenList(struct ListNode* head) {
   if(!head||!head->next){ return head;}
   struct ListNode *odd=head,*even=head->next,*evenhead=even;
   //for odd we will be using head pointer 
   //for similar problems use head pointer
   while(even&&even->next){
    odd->next=even->next;
    odd=odd->next;
    even->next=odd->next;
    even=even->next;
   }
   odd->next=evenhead;
   return head;


}
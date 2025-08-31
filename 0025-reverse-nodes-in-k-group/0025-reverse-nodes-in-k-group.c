/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseKGroup(struct ListNode* head, int k) {
    if (!head || k == 1) return head;
    struct ListNode dummy; dummy.next = head;
    struct ListNode* prev = &dummy; struct ListNode* curr; struct ListNode* tail;
    while (1) {
        curr = prev;
        for (int i = 0; i < k && curr; i++) curr = curr->next;
        if (!curr) break;
        tail = prev->next;
        for (int i = 1; i < k; i++) {
            struct ListNode* tmp = tail->next;
            tail->next = tmp->next;
            tmp->next = prev->next;
            prev->next = tmp;
        }
        prev = tail;
    }
    return dummy.next;
    
}
//intuition
/* traverse the left to right in each time 
if null is found break the loop 
or else 
use the head insertion reversal for the in bound revrese 
*/
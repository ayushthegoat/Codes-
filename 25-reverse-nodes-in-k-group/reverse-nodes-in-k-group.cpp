/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
         ListNode* temp = head;
    ListNode* preserve = nullptr;
    ListNode* next = nullptr;
    
    while (temp != nullptr) {
        ListNode* kthNode = getKthNode(temp, k);
        if (kthNode == nullptr) {
            if (preserve != nullptr) {
                preserve->next = temp;
            }
            break;
        }
        
        next = kthNode->next;
        kthNode->next = nullptr;
        
        reverseList(temp);
        if (temp == head) {
            head = kthNode;
        } else {
            preserve->next = kthNode;
        }
        preserve = temp;
        temp = next;
    }
    return head;
    }
    ListNode* getKthNode(ListNode* head,int k){
        k-=1;
        while(head!=nullptr && k>0){
            k--;
            head = head->next;
        }
        return head;
    }
    ListNode* reverseList(ListNode* head){
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while(curr!=nullptr){
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
};
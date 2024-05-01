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
    int pairSum(ListNode* head) {
        if(head->next->next==nullptr)return head->val + head->next->val;
        ListNode* mid = findMid(head);
        ListNode* revHead = reverseList(mid->next);
        mid->next = nullptr;

        int mx = INT_MIN;
        ListNode* temp1 = head;
        ListNode* temp2 = revHead;

        while(temp1!=nullptr && temp2!=nullptr){
            int currsum = temp1->val + temp2->val;
            mx = max(mx,currsum);

            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        return mx;
       
        

    }
    ListNode* reverseList(ListNode* head){
        ListNode* curr = head;
        ListNode* prev = nullptr;

        while(curr!=nullptr){
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
  
    }
    ListNode* findMid(ListNode* head){
        
        ListNode* fast = head->next->next;
        ListNode* slow = head->next;
        fast = fast->next;

        while(fast!=nullptr && fast->next!=nullptr ){
            
            slow = slow->next;
            fast = fast->next->next;
        } 
        return slow;
    }
};
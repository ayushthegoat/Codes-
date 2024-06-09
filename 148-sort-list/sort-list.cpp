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
    ListNode* findMid(ListNode* head) {
        if (head == nullptr)
            return head;
        ListNode* fast = head->next;
        ListNode* slow = head;

        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        return slow;
    }

    ListNode* merge(ListNode* head1, ListNode* head2) {
        ListNode* node = new ListNode(0); // Dummy node
        ListNode* runner = node;

        while (head1 != nullptr && head2 != nullptr) {
            if (head1->val <= head2->val) {
                runner->next = head1;
                head1 = head1->next;
            } else {
                runner->next = head2;
                head2 = head2->next;
            }
            runner = runner->next;
        }

        if (head1 != nullptr) {
            runner->next = head1;
        }

        if (head2 != nullptr) {
            runner->next = head2;
        }

        return node->next; // Return the merged list, skipping the dummy node
    }

    ListNode* sortList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* mid = findMid(head);
        ListNode* afterMid = mid->next;
        mid->next = nullptr;

        ListNode* l1 = sortList(head);
        ListNode* l2 = sortList(afterMid);

        return merge(l1, l2);
    }
};
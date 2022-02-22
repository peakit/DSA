#include <iostream>
#include <stddef.h>

//Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *removeNthFromEnd(struct ListNode *head, int n)
{
    struct ListNode *slow = head;
    struct ListNode *fast = head;

    while (n > 0)
    {
        fast = fast->next;
        n--;
    }

    struct ListNode *toDelete = NULL;
    if(fast == NULL) {
        // we are deleting head
        toDelete = head;
        head = head->next;
        delete toDelete;
        return head;
    }

    while (fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next;
    }

    toDelete = slow->next;
    slow->next = slow->next->next;
    delete toDelete;
    return head;
}

int main()
{
    ListNode *n1 = new ListNode();
    n1->val = 1;

    ListNode *n2 = new ListNode();
    n2->val = 2;

    // ListNode *n3 = new ListNode();
    // n3->val = 3;

    // ListNode *n4 = new ListNode();
    // n4->val = 4;

    n1->next = n2;
    n2->next = NULL;
    // n2->next = n3;
    // n3->next = n4;
    // n4->next = NULL;

    ListNode *head = n1;

    int n = 0;

    std::cout << "Enter nth node to delete: ";
    std::cin >> n;
    head = removeNthFromEnd(head, n);

    while (head != NULL)
    {
        std::cout << head->val << "\n";
        head = head->next;
    }
}
#include <iostream>

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *middleNode(struct ListNode *head)
{
    struct ListNode *slow = head;
    struct ListNode *fast = slow;

    while (fast != NULL && fast->next != NULL && fast->next->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    if (fast->next != NULL && fast->next->next == NULL)
    {
        return slow->next;
    }
    return slow;
}

int main()
{
    ListNode *n1 = new ListNode();
    n1->val = 1;

    ListNode *n2 = new ListNode();
    n2->val = 2;

    ListNode *n3 = new ListNode();
    n3->val = 3;

    ListNode *n4 = new ListNode();
    n4->val = 4;

    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = NULL;

    ListNode *head = n1;
    std::cout << "Middle node: " << middleNode(head)->val;
}
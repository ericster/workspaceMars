/*
 * main.cpp
 *
 *  Created on: Apr 11, 2018
 *      Author: Eric
 */

#include <iostream>

using namespace std;

struct node
{
    int data;
    node *next;
};

class linked_list
{
private:
    node *head,*tail;
public:
    linked_list()
    {
        head = NULL;
        tail = NULL;
    }

    void add_node(int n)
    {
        node *tmp = new node;
        tmp->data = n;
        tmp->next = NULL;

        if(head == NULL)
        {
            head = tmp;
            tail = tmp;
        }
        else
        {
            tail->next = tmp;
            tail = tail->next;
        }
    }

    node* gethead()
    {
        return head;
    }

    static void display(node *head)
    {
        if(head == NULL)
        {
            cout << "NULL" << endl;
        }
        else
        {
            cout << head->data << endl;
            display(head->next);
        }
    }

    static void concatenate(node *a,node *b)
    {
        if( a != NULL && b!= NULL )
        {
            if (a->next == NULL)
                a->next = b;
            else
                concatenate(a->next,b);
        }
        else
        {
            cout << "Either a or b is NULL\n";
        }
    }

    void front(int n)
    {
        node *tmp = new node;
        tmp -> data = n;
        tmp -> next = head;
        head = tmp;
    }

    void after(node *a, int value)
    {
        node* p = new node;
        p->data = value;
        p->next = a->next;
        a->next = p;
    }

    node* search(int key)
    {
        node* current = head;  // Initialize current
        while (current != NULL)
        {
            if (current->data == key)
                return current;
            current = current->next;
        }
        return NULL;
    }

    void del(int key)
    {
    	node* temp = head; // If head node itself holds the key to be deleted
    	node* prev;
    	if (temp != NULL && temp->data == key)
    	{
    		head = temp->next;
    		return;
    	}

    	// Search for the key to be deleted, keep track of the
    	// previous node as we need to change 'prev->next'
    	while (temp !=NULL && temp->data != key)
    	{
    		prev = temp;
    		temp = temp->next;
    	}

    	// If key was not present in linked list
    	if (temp == NULL) return;

    	// Unlik the node from linked list
    	prev->next = temp->next;
    }
};

int main()
{
    linked_list a;
    a.add_node(1);
    a.add_node(2);
    a.front(3);
    a.add_node(5);
    a.add_node(15);
    a.after(a.gethead()->next->next->next, 10);
    a.del(15);
    linked_list::display(a.gethead());
    return 0;
}





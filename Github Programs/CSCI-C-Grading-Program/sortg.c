#include <stdio.h>
#include "grades.h"


// Inserts the students into the linked list sorted from highes grade to lowest


void SortedInsert(Node_t** head, Node_t* new_node){

	Node_t* cur;

	if(*head == NULL || (*head)->st->grade < new_node->st->grade){


		new_node->next = *head;

		*head = new_node;


	}

	else{
	
		cur = *head;

		while(cur->next != NULL && cur->next->st->grade > new_node->st->grade){
			cur = cur->next;


		}
		
		new_node->next = cur->next;
		cur->next = new_node;
	
	
	}

	return;



}



//Sorts them by grade

void Sort(Node_t** head){

	Node_t* sorted = NULL;

	Node_t* cur = *head;

	while(cur != NULL){

		Node_t* next = cur->next;

		SortedInsert(&sorted, cur);

		cur = next;


	}

	*head = sorted;

	return;

}







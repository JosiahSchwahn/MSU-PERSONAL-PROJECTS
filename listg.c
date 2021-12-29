#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "grades.h"

//Inserts the new stundet in the list from the file


void ListInsert(Node_t** head, Student_t* st){
	
	Node_t* new_node = malloc(sizeof(Node_t));
	
	new_node->st = st;

	new_node->next = NULL;

	Node_t* old_head = *head;

	*head = new_node;

	new_node->next = old_head;

	return;


}

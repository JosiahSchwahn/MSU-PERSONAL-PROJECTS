#include <stdio.h>
#include "grades.h"


//PRints the final results of the linked list of students in order


void PrintGrades(Node_t* head){

	FILE* outptr = fopen("output.txt", "w");

	Node_t* cur = head;

	while(cur != NULL){


		fprintf(outptr, "Name: %-1s %s\t Grade: %.4lf %-10s Curved? %c\n", cur->st->first_name, cur->st->last_name, cur->st->grade, cur->st->letter, cur->st->curve);

		cur = cur->next;

	}

	return;

}

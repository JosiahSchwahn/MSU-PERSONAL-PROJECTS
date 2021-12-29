#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "grades.h"

//Calls all the  functions to run the program 2

int main(void){


	Node_t* head = NULL;
	ReadGrades(&head);
	Sort(&head);
	CalculateLetterGrades(head);
	PrintGrades(head);

	return(0);


}

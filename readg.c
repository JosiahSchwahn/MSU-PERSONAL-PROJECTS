#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "grades.h"

//Reads the grades from the input file and then gives them a name and grade to the item in the linked list


void ReadGrades(Node_t** head){

	FILE* input = fopen("/public/examples/pgm1/grades.txt", "r");

	char* answer;

	char line[80];

	if (input == NULL){

		printf("BAD FILE\n");

	}

	while(fgets(line, 80, input) != NULL){

		Student_t* st = malloc(sizeof(Student_t));

		answer = strtok(line, ",");
		strcpy(st->last_name, answer);

		answer = strtok(NULL, ",\n");
		strcpy(st->first_name, answer);

		answer = strtok(NULL, ",\n");
		sscanf(answer,"%lf", &st->grade);

		ListInsert(head,st);

	}

	fclose(input);


}

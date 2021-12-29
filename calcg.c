#include <stdio.h>
#include <string.h>
#include "grades.h"


//Calcs the letter grde then determines it is curved or not 
// then it assigs those values to the item in the linked list 


void CalculateLetterGrades(Node_t* head){

	Node_t* cur = head;

	while(cur != NULL){

		if(cur->st->grade >= 92.5){
			strcpy(cur->st->letter, "A");

			if(cur->st->grade < 93){
				cur->st->curve = 'y';

			}else{
				cur->st->curve = 'n';

			}


		}

		else if(cur->st->grade < 92.5 && cur->st->grade >= 89.5){

			strcpy(cur->st->letter, "A-");
			if(cur->st->grade < 90){
				cur->st->curve = 'y';

			} else{
				cur->st->curve = 'n';

			}

		}

		else if(cur->st->grade < 89.5 && cur->st->grade >= 86.5){

                        strcpy(cur->st->letter, "B+");
                        if(cur->st->grade < 87){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		else if(cur->st->grade < 86.5 && cur->st->grade >= 82.5){

                        strcpy(cur->st->letter, "B");
                        if(cur->st->grade < 83){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		else if(cur->st->grade < 82.5 && cur->st->grade >= 79.5){

                        strcpy(cur->st->letter, "B-");
                        if(cur->st->grade < 80){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		else if(cur->st->grade < 79.5 && cur->st->grade >= 76.5){

                        strcpy(cur->st->letter, "C+");
                        if(cur->st->grade < 77){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		
		else if(cur->st->grade < 76.5 && cur->st->grade >= 72.5){

                        strcpy(cur->st->letter, "C");
                        if(cur->st->grade < 73){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }
		
		
		else if(cur->st->grade < 72.5 && cur->st->grade >= 69.5){

                        strcpy(cur->st->letter, "C-");
                        if(cur->st->grade < 70){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		else if(cur->st->grade < 69.5 && cur->st->grade >= 66.5){

                        strcpy(cur->st->letter, "D+");
                        if(cur->st->grade < 67){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		else if(cur->st->grade < 66.5 && cur->st->grade >= 62.5){

                        strcpy(cur->st->letter, "D");
                        if(cur->st->grade < 63){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		else if(cur->st->grade < 62.5 && cur->st->grade >= 59.5){

                        strcpy(cur->st->letter, "D-");
                        if(cur->st->grade < 60){
                                cur->st->curve = 'y';

                        } else{
                                cur->st->curve = 'n';

                        }

                }

		cur = cur->next;


	}
}

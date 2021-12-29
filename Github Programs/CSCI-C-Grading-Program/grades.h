typedef struct{
  
        char first_name[10];
        char last_name[10];
        double grade;
        char letter[5];
        char curve;



} Student_t;


typedef struct node_t{


        Student_t* st;
        struct node_t *next;


} Node_t;


void ListInsert(Node_t**, Student_t*);
void Sort(Node_t**);
void ReadGrades(Node_t**);
void CalculateLetterGrades(Node_t*);
void PrintGrades(Node_t*);

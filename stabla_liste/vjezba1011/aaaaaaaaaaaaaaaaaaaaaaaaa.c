#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX_LENGTH (50)
#define MAX_LINE (1024)
#define FAILED_MEMORY_ALLOCATION (-1)
#define FILE_NOT_OPEN (1)

struct list;
typedef struct list* Pozicija;
typedef struct list
{
	char word[MAX_LENGTH];
	Pozicija next;
}List;
struct tree;
typedef struct tree* Position;
typedef struct tree
{
	char string[MAX_LENGTH];
	int length;
	Position left;
	Position right;
}Tree;

Position readFile(Position root, Pozicija headList);
Position stvoriRijec(Position root, char* string);
Position insertNewWord(Position root, Position word);
Pozicija addToTheList(Pozicija noviEl, Pozicija headList);
Pozicija createNewElement(char* string);
int printList(Pozicija headList);
int findAboveAverage(Position root, float res, Pozicija headList);
float average(float sum, int br);
void freeList(Pozicija headList);
void freeTree(Position root);

int main()
{
	Position rootTree = NULL;
	List headList =
	{
		.word = {0}, .next = NULL
	};
	
	rootTree = readFile(rootTree, &headList);

	printList(headList.next);
	freeTree(rootTree);
	freeList(headList.next);
	
	return EXIT_SUCCESS;
}
void freeList(Pozicija headList) 
{
	Pozicija current = headList;
	while (current != NULL) {
		Pozicija temp = current;
		current = current->next;
		free(temp);
	}
}
void freeTree(Position root)
{
	if (root == NULL)
		return;

	freeTree(root->left);
	freeTree(root->right);
	free(root);
}
int printList(Pozicija headList)
{
	while (headList != NULL)
	{
		printf("%s\n", headList->word);
		headList = headList->next;
	}

	return EXIT_SUCCESS;
}
Position readFile(Position root, Pozicija headList)
{
	FILE* filePointer = NULL;
	Position createWord = NULL;
	char string[MAX_LENGTH] = { 0 };
	int br = 0;
	float sum = 0;
	filePointer = fopen("tekst.txt", "r");
	if (!filePointer)
	{
		printf("Cant open the file\n");
		return FILE_NOT_OPEN;
	}
	while (fscanf(filePointer, " %s", string) == 1)
	{
		createWord = stvoriRijec(root, string);
		root = insertNewWord(root, createWord);
		sum += strlen(string);
		br++;
	}
	float res = average(sum, br); // sve ukupni prosjek rijeci

	findAboveAverage(root, res, headList);

	fclose(filePointer);

	return root;
}

int findAboveAverage(Position root, float res, Pozicija headList)
{
	Pozicija noviEl = NULL;

	if (root == NULL)
		return EXIT_SUCCESS;

	findAboveAverage(root->left, res, headList);
	if (root->length > res)
	{
		noviEl = createNewElement(root->string);
		if(noviEl != NULL)
			addToTheList(noviEl, headList);
	}
	findAboveAverage(root->right, res, headList);
	
	return EXIT_SUCCESS;
}
Pozicija addToTheList(Pozicija noviEl, Pozicija headList)
{
	Pozicija current = headList;

	while (current->next != NULL)
	{
		current = current->next;
	}

	current->next = noviEl;
	noviEl->next = NULL;

	return noviEl;
}
Pozicija createNewElement(char* string)
{
	Pozicija newElement = NULL;
	newElement = (Pozicija)malloc(sizeof(List));

	if (!newElement)
	{
		printf("cant allocate memory\n");
		return FAILED_MEMORY_ALLOCATION;
	}

	strcpy(newElement->word, string);
	newElement->next = NULL;

	return newElement;
}
float average(float sum, int br)
{
	return sum / br;
}
Position stvoriRijec(Position root, char* string)
{
	Position newWord = NULL;
	newWord = (Position)malloc(sizeof(Tree));

	if (!newWord)
	{
		printf("cant allocate memory\n");
		return FAILED_MEMORY_ALLOCATION;
	}

	strcpy(newWord->string, string);
	newWord->left = NULL;
	newWord->right = NULL;
	newWord->length = strlen(string);

	return newWord;
}
Position insertNewWord(Position root, Position word)
{
	if (root == NULL)
		return word;
	
	if (strcmp(root->string, word->string) >= 0)
		root->left = insertNewWord(root->left, word);
	else if (strcmp(root->string, word->string) < 0)
		root->right = insertNewWord(root->right, word);
	return root;
}
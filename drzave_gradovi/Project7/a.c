#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct town;
typedef struct town* PositionTown;
typedef struct town
{
	char name[50];
	int ID;
	PositionTown left;
	PositionTown right;
}Town;

struct country;
typedef struct country* PositionCountry;
typedef struct country
{
	char name[50];
	int ID;
	PositionCountry next;
	PositionTown countryRootTree;
}Country;

int readFromFile(PositionCountry headList);
PositionCountry createCountry(char name[50], int ID);
int insertInList(PositionCountry countryList, PositionCountry newCountry);
int readFromFile2(PositionCountry headList);
PositionTown createTown(char name[50], int ID);
int insertTown(PositionCountry firstElement, PositionTown newTown);
int InsertTownInTree(PositionTown root, PositionTown newTown);
int printList(PositionCountry firstEl);
int printTree(PositionTown root);

int main()
{
	Country headList =
	{
		.name = {0}, .ID = 0, .next = NULL, .countryRootTree = NULL
	};

	readFromFile(&headList);
	readFromFile2(headList.next);
	printList(headList.next);
	return 0;
}
int printList(PositionCountry firstEl)
{
	while (firstEl != NULL)
	{
		printf("Country: %s, ID: %d\n", firstEl->name, firstEl->ID);
		printTree(firstEl->countryRootTree);
		firstEl = firstEl->next;
	}

	return 0;
}
int printTree(PositionTown root)
{
	if (root == NULL)
		return 0;
	
	printTree(root->left);
	printf("Town: %s, ID: %d", root->name, root->ID);
	printTree(root->right);

	return 0;
}
int readFromFile(PositionCountry headList)
{
	char name[50] = { 0 };
	int ID = 0;
	FILE* fp = NULL;
	fp = fopen("drzave.txt", "r");
	if (!fp)
	{
		printf("cant open the file\n");
		return NULL;
	}

	while (fscanf(fp, " %s %d", name, &ID) == 2)
	{
		PositionCountry newCountry = NULL;
		newCountry = createCountry(name, ID);
		if (!newCountry)
		{
			printf("cant create new country\n");
			return NULL;
		}
		insertInList(headList, newCountry);
	}
	fclose(fp);

	return 0;
}
PositionCountry createCountry(char name[50], int ID)
{
	PositionCountry newEl = NULL;
	newEl = (PositionCountry)malloc(sizeof(Country));
	if (!newEl)
	{
		printf("cant allocate mem\n");
		return NULL;
	}

	strcpy(newEl->name, name);
	newEl->ID = ID;
	newEl->next = NULL;
	newEl->countryRootTree = NULL;

	return newEl;
}
int insertInList(PositionCountry countryList, PositionCountry newCountry)
{
	while (countryList->next != NULL && strcmp(countryList->next->name, newCountry->name) < 0)
	{
		countryList = countryList->next;
	}
	newCountry->next = countryList->next;
	countryList->next = newCountry;

	return 0;
}
int readFromFile2(PositionCountry headList)
{
	char name[50] = { 0 };
	int ID = 0;
	FILE* fp = NULL;
	fp = fopen("gradovi.txt", "r");
	if (!fp)
	{
		printf("cantopen the file\n");
		return NULL;
	}

	while (fscanf(fp, " %s %d", name, &ID) == 2)
	{
		PositionTown newTown = NULL;
		newTown = createTown(name, ID);
		if (!newTown)
		{
			printf("cant create new town\n");
			return NULL;
		}
		insertTown(headList, newTown);
	}

	fclose(fp);

	return 0;
}
PositionTown createTown(char name[50], int ID)
{
	PositionTown newTown = NULL;
	newTown = (PositionTown)malloc(sizeof(Town));
	if (!newTown)
	{
		printf("cant allocate mem\n");
		return NULL;
	}

	strcpy(newTown->name, name);
	newTown->ID = ID;
	newTown->left = NULL;
	newTown->right = NULL;
	
	return newTown;
}
int insertTown(PositionCountry firstElement, PositionTown newTown)
{
	while (firstElement->next != NULL && firstElement->ID != newTown->ID)
	{
		firstElement = firstElement->next;
	}
	
	firstElement->countryRootTree = InsertTownInTree(firstElement->countryRootTree, newTown);

	return 0;
}
int InsertTownInTree(PositionTown root, PositionTown newTown)
{
	if (root == NULL)
		return newTown;
	if (strcmp(root->name, newTown->name) < 0)
		root->left = InsertTownInTree(root->left, newTown);
	else if (strcmp(root->name, newTown->name) > 0)
		root->right = InsertTownInTree(root->right, newTown);

	return root;
}
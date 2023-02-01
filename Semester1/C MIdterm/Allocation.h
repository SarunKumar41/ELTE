#include <stdio.h>
#include <stdlib.h>

#ifndef Allocation_Function
#define Allocation_Function

void allocationf(int i, int j, int stringlimit, char** arr)
{
        for (i; i<j; i++)
        {
                arr[i] = (char*) malloc(stringlimit * sizeof(char));
                if (arr[i] == NULL)
                {
                        for (int k = 0; k < i; k++)
                        {
                                free(arr[j]);
                        }
                        free(arr);
                        fprintf(stderr, "%s", "Memory allocation failed!");
                        exit(1);
                }
        }        
}

#endif

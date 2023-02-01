#include <stdio.h>
#include <stdlib.h>
#include "reverse.h"
#include "Allocation.h"

int main(int argc, char* argv[])
{
        int memory_size = 3, stringlimit = 1024;
        if (argc < 2)
        {
                char** str = (char**) malloc((sizeof(char*))* memory_size);
                if (str == NULL)
                {
                        fprintf(stderr, "%s", "Memory allocation failed!");
                        exit(1);
                }
                allocationf(0, memory_size, stringlimit, str);

                int index = 0;
                while (fgets(str[index], 1024, stdin) != NULL)
                {
                        int x = 0;
                        while (str[index][x] != '\n')
                        {
                                x++;
                        }
                        str[index][x] = '\0';

                        index++;
                        if (index == memory_size)
                        {
                                memory_size *= 2;
                                str = (char**) realloc(str, (sizeof(char*))* memory_size);
                                if (str == NULL)
                                {
                                        fprintf(stderr, "%s", "Memory allocation failed!");
                                        exit(1);
                                }
                                allocationf(index, memory_size, stringlimit, str);
                        }
                }

                for (index; index > 0; index--)
                {
                        reverse(str[index - 1]);
                        printf("%d %s\n", index, str[index - 1]);
                }
                for (int z = 0; z < memory_size; z++)
                {
                        free(str[z]);
                }
                free(str);
        }
        else
        {
                for (int a = 1; a < argc; a++)
                {
                        FILE* fp;
                        fp = fopen(argv[a], "r");
                        if (fp == NULL)
                        {
                                fprintf(stderr, "%s", "File opening unsuccessful!");
                        }

                        char** str = (char**) malloc((sizeof(char*))* memory_size);
                        if (str == NULL)
                        {
                                fprintf(stderr, "%s", "Memory allocation failed!");
                                exit(1);
                        }
                        allocationf(0, memory_size, stringlimit, str);

                        int index = 0;
                        while (fgets(str[index], 1024, fp) != NULL)
                        {
                                int x = 0;
                                while (str[index][x] != '\n')
                                {
                                        x++;
                                }
                                str[index][x] = '\0';

                                index++;
                                if (index == memory_size)
                                {
                                        memory_size = memory_size * 2;
                                        str = (char**) realloc(str, (sizeof(char*))* memory_size);
                                        if (str == NULL)
                                        {
                                                fprintf(stderr, "%s", "Memory allocation failed!");
                                                exit(1);
                                        }
                                        allocationf(index, memory_size, stringlimit, str);
                                }
                        }

                        for (index; index > 0; index--)
                        {
                                reverse(str[index - 1]);
                                printf("%d %s\n", index, str[index - 1]);
                        }

                        for (int z = 0; z< memory_size; z++)
                        {
                                free(str[z]);
                        }
                        free(str);
                        fclose(fp);
                }
        }
        return 0;
}

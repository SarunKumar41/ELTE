#include <stdio.h>

#ifndef Length_Count
#define Length_Count
int lengthcount(char s[])
{
        int c = 0;
        while (s[c] != '\0')
        {
                c++;
        }
        return c;
}

#endif

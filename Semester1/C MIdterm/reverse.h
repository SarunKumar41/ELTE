#include <stdlib.h>
#include "lengthcount.h"

#ifndef Reverse_Function
#define Reverse_Function

void reverse(char w[])
{
        int length = lengthcount(w);
        for (int i = 0; i < (length / 2); i++)
        {
                char temp = w[i];
                w[i] = w[length - 1 - i];
                w[length - 1 - i] = temp;
        }
}

#endif 
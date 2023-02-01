#include <iostream>
using namespace std;
int main()
{
    int days, count=0;
    double minimum[100], maximum[100];
    cin >> days;
    for(int i=0; i<days ; i++)
    {
    cin >> minimum[i] >> maximum[i];
    }
    for(int j=0; j<days; j++)
    {
        if((maximum[j] - minimum[j])>=10)
        {
            count++;
        }
    }
    cout <<  count;
    return 0;
}

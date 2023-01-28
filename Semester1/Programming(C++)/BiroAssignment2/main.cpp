#include <iostream>
using namespace std;

struct Purchase
{
    string brand; int amount;
};
int main()
{
    int npurchase,count=0;
    Purchase  Purchases[101];
    string brandname[101];
    cin >> npurchase;
    
    for (int i=1;i<=npurchase;i++)
    {
        cin >> Purchases[i].brand;
        cin >> Purchases[i].amount;
    }
    for (int i=1;i<=npurchase;i++)
    {
        if(Purchases[i].amount>500)
        {
            count++;
            brandname[count]= Purchases[i].brand;
        }
    }
    cout << count << " " ;
    for (int i=1;i<=count;i++)
    {
        cout << brandname[i] << " ";
    }
}

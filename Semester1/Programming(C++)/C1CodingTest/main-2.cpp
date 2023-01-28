// Date: 10/11/2021   Topic: C1B
// Name: Sarun Kumar    Neptun Code: IWCYYD

#include <iostream>
using namespace std;

struct Wine{
    int Amount, Price;
};

int main()
{
    int wCount, i;
    Wine Wines[101];
    
    do{
    cout << "Enter the count of wines: ";
    cin >> wCount;
        if(wCount<0 || wCount>100 )
        {
            cout << "Please, enter the value between 0 and 100\n";
        }
    }while (wCount<0 || wCount>100 );
    
    for(i =1; i<=wCount;i++)
    {
        
        do{
            cout << "Enter the amount(production) of wine no. " << i << ": " ;
            cin >> Wines[i].Amount;
            if(Wines[i].Amount<1 || Wines[i].Amount>10000)
            {
                cout << "Please, enter the appropriate value\n";
            }
        }while (Wines[i].Amount<1 || Wines[i].Amount>10000);
        do{
            cout << "Enter the price of wine no. " << i << ": ";
            cin >> Wines[i].Price;
            if(Wines[i].Price< 1 || Wines[i].Price>10000)
            {
                cout << "Please, enter the appropriate value\n";
            }
        }while (Wines[i].Price< 1 || Wines[i].Price>10000);
    }
    
    i=1;
    while (i<=wCount && Wines[i].Amount<=2000)
    {
        i++;
    }
    
    int BigPrice;
    bool ExistsBig = i<=wCount;
    if(ExistsBig)
    {
        BigPrice = Wines[i].Price;
    }
    else
    {
        BigPrice = -1;
    }
    cout << "Cost of the first wine which is produced more than 2000 litres is: " << BigPrice << "\n";
    
    int CountCheap = 0, Cheap[101];
    for ( i=1;i<=wCount;i++)
    {
        if(Wines[i].Price<1500)
        {
            CountCheap++;
            Cheap[CountCheap] = i;
        }
    }
    cout << "Count of wines with price lesser than 1500: " << CountCheap << "\n";
    cout << "Wines with price lesser than 1500: " ;
    for(i=1;i<=CountCheap;i++)
    {
        cout << Cheap[i] << " ";
    }
    cout << endl;
}

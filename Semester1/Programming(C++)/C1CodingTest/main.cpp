#include <iostream>
using namespace std;

struct Employee{
    int Age,Salary;
};
int main ()
{
    int eCount=0, L;
    Employee Employees[101];
    do{
    cout << "Enter the number of employees";
    cin >> eCount;
    }while (eCount<0 || eCount>100 );
        
    do{
        cout << "Enter the age limit";
    cin >> L;
    }while (L<1 || L>100 );
        
    for(int i =1; i<=eCount;i++)
    {
        
        do{
            cout << "Enter the employee " << i << " age" ;
            cin >> Employees[i].Age;
        }while (Employees[i].Age< 0 || Employees[i].Age>100);
        do{
            cout << "Enter the Salary of the employee";
            cin >> Employees[i].Salary;
        }while (Employees[i].Salary< 0 || Employees[i].Salary>100);
    }
    int oldS;
    int i = 1;
    while(i <= eCount && Employees[i].Age <= L)
    {
        i++;
    }
    bool ExistsOld = i<= eCount;
    if(ExistsOld)
    {
        oldS = Employees[i].Salary;
    }
    else
    {
        oldS = -1;
    }
    cout << "Salary of the first Employee older than age limit" << oldS;
    
    int YoungCount=0;
    int Young[101];
    for(i=1;i<=eCount;i++)
    {
        if(Employees[i].Age < L)
        {
            YoungCount++;
            Young[YoungCount]=Employees[i].Age;
        }
    }
    cout << "no. of employees" << YoungCount;
    for(int i=0;i<eCount;i++)
    {
    cout << "Ages of the employees" << Young[i];
    }
}

#include "menu.hpp"
#include <sstream>
#define menuCount 7 


///Check if the given menuitem number exists
bool check(int a){return a>=0 && a<=menuCount;}
//inline bool valid(int a){return true;}

void Menu::Run()
{
    int v;
    do{
        
        v=MenuPrint();
        switch(v)
        {
            case 1:
                putIn();
                print();
                break;
            case 2:
                takeOut();
                print();
                break;
            case 3:
                isEmpty();
                print();
                break;
            case 4:
                contains();
                print();
                break;
            case 5:
                random();
                print();
                break;
            case 6:
                largest();
                print();
                break;
            case 7:
                print();
                break;
            default:
                cout<<"\nGoodbye!\n";
                break;
            
        }
        //system("clear");
    }while(v!=0);
}

int Menu::MenuPrint()
{
    int choice;
    cout<<"\n****************************************\n";
    cout<<"0. Exit\n";
    cout<<"1. Put in\n";
    cout<<"2. Take out\n";
    cout<<"3. Is empty\n";
    cout<<"4. contains\n";
    cout<<"5. random\n";
    cout<<"6. largest entry\n";
    cout <<"7. print the set \n";
    cout<<"****************************************\n";
    ///flexible error message
    ostringstream s;
    s<<"choose a number between 0 and "<<menuCount<<"!";
    string errmsg=s.str();
    ///read choice with read.hpp
    choice = read<int>("Choose a menuitem: ",errmsg,check);

    return choice;
}

void Menu::putIn()
{
    string input;
    int a;
    //cout << "Entry:\n";
    a = read<int>("Entry:\n ","Invalid input",valid);
    //cin >> a;
    try{
    mainSet.setElem(a);
    }catch(Set_Type::setError err)
    {
        if(err==Set_Type::Duplicate_Value)
        {
            cout << "The element already exists, set cannot store duplicate values.\n";
        }
    }
}

void Menu::takeOut()
{
    int a;
    bool error=false;
    //cout << "Enter the entry you want to remove:\n";
    //cin >>a;
    a = read<int>("Enter the entry you want to remove:\n ","Invalid input",valid);
    try{
        mainSet.remElem(a);
    }catch(Set_Type::setError err)
    {
        error=true;
        if(err==Set_Type::Empty_Set_Error)
        {
            cout << "Take out is unsuccessful, the queue is empty.\n";
        }
        else
        {
            cout << "Take out is unsuccessful, the entry does not exist.\n ";
        }
    }
    if(!error) cout<<"Removed successfully the element: " <<a<<endl;
}
void Menu::isEmpty()
{
    if(mainSet.isEmpty())
    {
        cout << "The set is empty.\n";
    }
    else
    {
        cout << "The set is not empty.\n";
    }
}

void Menu::contains()
{
    int a;
    cout << "Enter the entry you want to check:\n";
    cin >> a;
        if(mainSet.checksElement(a))
        {
            cout << "The given element is present in the set.\n";
        }
        else 
        {
            cout << "The given element is not present in the set.\n";
        }
        if(mainSet.isEmpty())
        {cout << "The set is empty.\n";}
}

void Menu::random()
{
    try{
        int rand=mainSet.getRandElem();
        cout << "A random element from the set is " << rand << endl;
    }catch(Set_Type::setError err)
    {
        if(err==Set_Type::Empty_Set_Error)
        cout << "The set is empty.\n";
    }
    
}

void Menu::largest()
{
    try{
        int large=mainSet.LargeEntry();
        cout << "The largest element from the set is " << large << endl;
    }catch(Set_Type::setError err)
    {
        if(err==Set_Type::Empty_Set_Error)
        cout << "The set is empty.\n";
    }
}

void Menu:: print()
{
    cout << mainSet << endl;
}



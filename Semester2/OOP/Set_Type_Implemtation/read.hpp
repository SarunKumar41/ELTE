#pragma once

#include <iostream>
#include <string>
using namespace std;
 //Task: 	Read an Item type data from the keyboard
//Input:    string msg - text that must be written before reading
//          string err - text that must be written after a
//          bool valid(Item) - function that checks the correctness of the data that is read
//Output:   Item  n    - the value the data that is read
//Activity:	Reading a data from the keyboard, checking it according to the function valid
//          if the data is incorrect trying to read it once more
template <typename Item>
Item read( const string &msg, const string &err, bool valid(Item))
{
    Item n;
    bool wrong;
    do{
        cout << msg;
        cin >> n;
        if((wrong = cin.fail())) cin.clear();
        string tmp = "";
        getline(cin, tmp);
        wrong = wrong || tmp.size()!=0 || !valid(n);
        if(wrong) cout << err << endl;
    }while(wrong);
    return n;
}
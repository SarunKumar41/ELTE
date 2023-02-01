#ifndef Set_HPP
#define Set_HPP
#include <string>
#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include "read.hpp"
using namespace std;

inline bool valid(int a){return true;}
/*
Implement the set type which contains integers. Represent the set as a sequence of its elements. Implement as methods:
inserting an element, removing an element, returning whether the set is empty, returning whether the set contains an element,
returning a random element without removing it from the set, returning the largest
element of the set (suggestion: store the largest entry and update it when the set
changes), printing the set. */
class Set_Type
{
private:
    // data 
    vector<int> _set;

public:
    // error
    enum setError {Empty_Set_Error,Not_Existing_Element,Duplicate_Value,Illegal_Argument};
    
    // constructor
    //set(){};
    //set(int size);

    //getter
    int getSize() const {return _set.size();}
    vector<int> getElements() const; //used in testing
    bool isEmpty() const; //checks if the set is empty or not
    bool checksElement(int a) const; // checks if the given element is present in the set 
    int getRandElem()const throw (setError); // returns a random element from the set
    int getLargeInd()const throw (setError); // returns the index of the largest element
    int LargeEntry()const throw (setError); // return the largest entry in the set 
    
    //setter
    void setElem(int a) throw (setError); // inserts an element in the set
    void remElem(int a) throw (setError); // removes an element 

    //others
    friend ostream &operator<<(ostream &s,const Set_Type &a)
    {
        s << "Size of set: " << a.getSize() << endl;
        if(a.getSize()>0)
        {
            s << "{ ";
            for(int i=0;i<a.getSize()-1;i++)
            {
                s << a._set[i] << ", ";
            }
            s << a._set[a.getSize()-1] <<" }" << endl;
        }
       return s;
    }
    friend istream &operator>>(istream &s, int &a)
    {
        a= read<int>("Entry: ","Integer is needed!",valid);
        return s;
    }
    
};


#endif
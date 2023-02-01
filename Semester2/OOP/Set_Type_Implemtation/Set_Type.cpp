#include "Set_Type.hpp"
/*
set:: set(int size)
{
    _set.resize(size);
} */

vector<int> Set_Type:: getElements() const
{
     vector<int> vec;
    for(int i=0;i<_set.size();i++)
    {
       vec.push_back(_set[i]);
    }
    return vec;
}
bool Set_Type:: isEmpty() const 
{
    return (_set.size()==0);
}

bool Set_Type::checksElement(int a) const
{
     for(int i=0;i<_set.size();i++)
     {
         if(_set[i]==a){return true;}
     }
     return false;
}
int Set_Type::getRandElem() const throw (setError)
{
    if(isEmpty()) throw Empty_Set_Error;
    srand(time(nullptr));
    int randInd = (rand() %_set.size()); 
    return _set[randInd];
}

int Set_Type::getLargeInd()const throw (setError)
{
    if(isEmpty()) throw Empty_Set_Error;
    int ind=0;
    for(int i=0;i<_set.size();i++)
    {
        if(_set[i]>_set[ind])
        {
            ind=i;
        }
    }
    return ind;
}

int Set_Type:: LargeEntry()const throw (setError)
{
    if(isEmpty()) throw Empty_Set_Error;
    return _set[getLargeInd()];
}

void Set_Type::setElem(int a) throw (setError)
{
    if(checksElement(a)) throw Duplicate_Value;
    _set.push_back(a);
}

void Set_Type::remElem(int a) throw (setError)
{
    if(isEmpty()) throw Empty_Set_Error;
    if(!checksElement(a)) throw Not_Existing_Element;
    int remInd;
    for(int i=0;i<_set.size();i++)
    {
        if(a==_set[i])
        {remInd=i;}
    }
    _set[remInd]=_set[_set.size()-1];
    _set.pop_back();
}





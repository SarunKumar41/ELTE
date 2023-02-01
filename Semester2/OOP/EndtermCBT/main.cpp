#include <iostream>
#include "library/seqinfileenumerator.hpp"
#include "library/stringstreamenumerator.hpp"
#include "library/linsearch.hpp"

using namespace std;


struct PartData
{
    string ID;
    string partName;
    int number;
    friend istream &operator >> (istream &is, PartData &p)
    {
        is >> p.ID >> p.partName >> p.number ;
        return is;
    }
};

class CheckWood : public LinSearch<PartData>
{
    bool cond(const PartData &e) const override
    {
        return e.partName=="wood";
    }
};

int main()
{
    try
    {
        CheckWood cw;
        SeqInFileEnumerator<PartData> enor ("input.txt");
        cw.addEnumerator(&enor);
        cw.run();
        if(cw.found())
        {
            cout << cw.elem().ID << endl;
        }
        else
        {
            cout << "No" << endl;
        }


    }
    catch (SeqInFileEnumerator<PartData>::Exceptions err)
    {
        cout << "File not found!\n";
        return 1;
    }
    return 0;
}


#include "InFile.hpp"

using namespace std;

int main()
{
    try
    {
        InFile t("inp.txt");
        t.first();
        int count=0;
        while (!t.end())
        {
            if(t.current().bTime==true)
            {
                cout << t.current().team << ", ";
                count++;
            }
            t.next();
        }
        cout << endl;
        if (count == 0)
        {
                cout << "There is no team having best time lesser than 1:17:00" << endl;
        }
    }
    catch (InFile::Errors e)
    {
        cerr << "Opening file failed.\n";
        exit(-1);
    }
    return 0;
}
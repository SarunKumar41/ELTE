/*
Sarun Kumar, IWCYYD
This solution was prepared and submitted by the student stated above
for the assignment of the Programming course.
I declare that this solution is my own work. I have not copied or used
third party solutions. I have not passed my solution to my classmates,
neither made it public.
Students’ regulation of Eötvös Loránd University (ELTE Regulations
Vol. II. 74/C.§) states that as long as a student presents another
student’s work - or at least the significant part of it - as his/her
own performance, it will count as a disciplinary fault. The most
serious consequence of a disciplinary fault can be dismissal of the
student from the University.
*/


#include <iostream>
#include <vector>
using namespace  std;
struct Pair {
    string language; int speaker;
};
struct PairC{
    string language; int count;
};
struct MostLang{
    int speakerNumber; vector<string> languages;
};

int matchIndex(vector<PairC> different,string language)
{
    for(int i=0;i<different.size();i++)
    {
        if(language==different[i].language)
        {
            return i;
        }
    }
    return -1;
}

bool forSpeakernumber(vector<int> contain,int check)
{
    for(int i=0;i<contain.size();i++)
    {
        if(check==contain[i])
        {
            return false;
        }
    }
    return true;
}

bool checksamevector (vector<string> one,vector<string> two)
{
    int count=0;
    for(int i=0;i<one.size();i++)
    {
        if(one[i]==two[i])
        {
            count++;
        }
    }
    if(count==one.size())
    {
        return true;
    }
    return false;
}

int main()
{
    int students,dataPairs;
    cin >> students >> dataPairs;
    Pair pairs[2000];
    
    for(int i=0;i<dataPairs;i++)
    {
        cin >> pairs[i].language;
        cin >> pairs[i].speaker;
    }
    
    //subtask1
    int countlanguages=0;
    vector<PairC> different;
    for(int i=0;i<dataPairs;i++)
    {
        int j= matchIndex(different, pairs[i].language);
        if(j==-1)
        {
            PairC add;
            add.language=pairs[i].language;
            add.count=0;
            different.push_back(add);
            j=different.size()-1;
            countlanguages++;
        }
        different[j].count++;
    }
    cout << "#" << endl;
    cout << countlanguages << endl;
    cout << "#" << endl;
    
    //subtask 2
    int onlyLanguage=-1;
    for(int i=0;i<different.size();i++)
    {
        if(different[i].count==1)
        {
            onlyLanguage=i;
        }
    }
    if(onlyLanguage==-1)
    {
        cout << "NONE" << endl;
    }
    else
    {
        cout << different[onlyLanguage].language << endl;
    }
    cout << "#" << endl;
    //subtask 3
    for(int i=0;i<different.size();i++)
    {
        cout << different[i].language << " " << different[i].count << endl;
    }
    cout << "#" << endl;
    //subtask 4
    int Speakers[1000]={0};
    for(int i=0;i<dataPairs;i++)
    {
        int j=pairs[i].speaker;
        Speakers[j]++;
    }
    int mostSpeaker=1;
    for(int i=2;i<1000;i++)
    {
        if(Speakers[i]>Speakers[mostSpeaker])
        {
            mostSpeaker=i;
        }
    }
    cout << pairs[mostSpeaker-1].speaker << endl;
    cout << "#" << endl;
    //subtask 5
    vector<MostLang> forGroups;
    for(int i=0;i<dataPairs;i++)
    {
        MostLang language;
        vector<string> insert;
        vector<int> contain;
        int j=pairs[i].speaker;
        if(forSpeakernumber(contain, j))
        {
            for(int k=0;k<dataPairs;k++)
            {
                if(j==pairs[k].speaker)
                {
                    insert.push_back(pairs[k].language);
                }
                
            }
            language.languages=insert;
            language.speakerNumber=j;
            forGroups.push_back(language);
            insert.clear();
            contain.push_back(j);
        }
        
    }
}


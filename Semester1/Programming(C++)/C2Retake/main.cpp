//
//  main.cpp
//  C2Retake
//
//  Created by Sarun Kumar on 2022. 01. 13..
//

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
using namespace std;

struct SDetail {
    string Language; int Identifier;
};

struct LangCounting{
    string Language; int count;
};

struct ForEach {
    int Identifier; vector<string> type;
};

bool typeCheck (string check,vector<string> types)
{
    for(int i=0;i<types.size();i++)
    {
        if(check==types[i])
        {
            return false;
        }
    }
    return true;
}

int matchIndex(vector<LangCounting> LangType,string language)
{
    for(int i=0;i<LangType.size();i++)
    {
        if(language==LangType[i].Language)
        {
            return i;
        }
    }
    return -1;
}

bool IdentifierCheck (int Identifier,vector<ForEach> Each)
{
    for(int i=0;i<Each.size();i++)
    {
        if(Identifier==Each[i].Identifier)
        {
            return false;
        }
    }
    return true;
}

bool checkForGroup (int Identifier, vector<int> just)
{
    for(int i=0;i<just.size();i++)
    {
        if(Identifier==just[i])
        {
            return false;
        }
    }
    return true;
}

bool ExactSame (vector<string> one, vector<string> two)
{
    int check=0;
    if(one.size()==two.size())
    {
        for(int i=0;i<one.size();i++)
        {
            for(int j=0;j<one.size();j++)
            {
                if(one[i]==two[j])
                {
                    check++;
                }
            }
        }
    }
    if(check==one.size())
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main()
{
    
    int StudentNumber, DataPairs;
    SDetail Details[2001];
    
    cin >> StudentNumber >> DataPairs;
    
    for(int i=0;i<DataPairs;i++)
    {
        cin >> Details[i].Language >> Details[i].Identifier;
    }
    
    // subtask 1
    vector<string> types;
    for(int i=0;i<DataPairs;i++)
    {
        if(typeCheck(Details[i].Language, types))
        {
            types.push_back(Details[i].Language);
        }
    }
    
    cout << "#" << endl;
    cout << types.size() << endl;
    // subtask 2
    vector<LangCounting> LangType;
    for(int i=0;i<DataPairs;i++)
    {
        int j= matchIndex(LangType, Details[i].Language);
        if(j==-1)
        {
            LangCounting collection;
            collection.Language=Details[i].Language;
            collection.count=0;
            LangType.push_back(collection);
            j=LangType.size()-1;
        }
        LangType[j].count++;
    }
    
    int onlyLanguage=-1;
    for(int i=0;i<LangType.size();i++)
    {
        if(LangType[i].count==1)
        {
            onlyLanguage=i;
        }
    }

    cout << "#" << endl;
    if(onlyLanguage==-1)
    {
        cout << "NONE" << endl;
    }
    else
    {
        cout << LangType[onlyLanguage].Language << endl;
    }
    cout << "#" << endl;
    // subtask 3
    for(int i=0;i<LangType.size();i++)
    {
        cout << LangType[i].Language << " " << LangType[i].count << endl;
    }
    cout << "#" << endl;
    // subtask 4
    vector<ForEach> Each;
    ForEach forpush;
    vector<string> typeForEach;
    for(int i=0;i<DataPairs;i++)
    {
        if(IdentifierCheck(Details[i].Identifier, Each))
        {
            for(int k=0;k<DataPairs;k++)
            {
                if(Details[i].Identifier==Details[k].Identifier)
                {
                    typeForEach.push_back(Details[k].Language);
                }
            }
            forpush.Identifier=Details[i].Identifier;
            forpush.type=typeForEach;
            Each.push_back(forpush);
            typeForEach.clear();
        }
    }

    int mostSpokenIndex=0;
    for(int i=1;i<Each.size();i++)
    {
        if(Each[i].type.size()>Each[mostSpokenIndex].type.size())
        {
            mostSpokenIndex=i;
        }
    }
    vector<int> mostSpokenGroup;
    for(int i=0;i<Each.size();i++)
    {
        if(Each[i].type.size()==Each[mostSpokenIndex].type.size())
        {
            mostSpokenGroup.push_back(Each[i].Identifier);
        }
    }

    int SMALL=mostSpokenGroup[0];
    for(int i=0;i<mostSpokenGroup.size();i++)
    {
        if(mostSpokenGroup[i]<SMALL)
        {
            SMALL=mostSpokenIndex;
        }
    }
    cout << SMALL << endl;
    cout << "#" << endl;
    
    // subtask 5
    int possiblegroups=0;
    int possiblegroupAddition=0;
    vector<int> Forpossiblegroups;
    for(int i=0;i<Each.size();i++)
    {
        for(int k=0;k<Each.size();k++)
        {
            if(ExactSame(Each[i].type, Each[k].type) && (i!=k))
            {
                Forpossiblegroups.push_back(Each[i].Identifier);
                Forpossiblegroups.push_back(Each[k].Identifier);
                possiblegroups++;
            }
        }
    }
    for(int i=1;i<=StudentNumber;i++)
    {
        if(checkForGroup(i, Forpossiblegroups) && (IdentifierCheck(i, Each)==false))
        {
            possiblegroupAddition++;
        }
    }
    cout << (possiblegroups/2)+possiblegroupAddition << endl;
}


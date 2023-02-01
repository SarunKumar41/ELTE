#include <iostream>
#include <vector>
#include <sstream>
#include "library/summation.hpp"
#include "library/stringstreamenumerator.hpp"
#include "library/maxsearch.hpp"
#include "library/linsearch.hpp"
#include "library/seqinfileenumerator.hpp"

using namespace std; //g++ -std=c++11  main.cpp for compiling on mac

/* At every competition of the National Angling Championship, the results of the competitors
were recorded and put into a text file. Every line of the file contains the name of the angler
the ID of the competition (string without spaces), and the species and the size of the caught
fishes (pair of a string without spaces and a natural number). Data is separated by space or tab.
The lines of the file are ordered by the name of the anglers. The file is assumed to be in the
correct form. Sample line in the file:
Peter LAC0512 carp 45 carp 53 catfish 96
(1) Give the biggest caught catfish with its size, the contest ID and the angler’s name.
(2) Has every angler caught a catfish bigger than 30 cm?
*/


struct Pair
{
    string fishName;
    int size;
};
struct Data
{
    string anglerName, id;
    Pair pairs;
};


istream &operator>>(istream &f, Pair &pf)
{
    f >> pf.fishName >>pf.size;
    return f;
}
class MyBiggestInpFish : public MaxSearch<Pair , int , Greater<int> >
{
    protected : 
    int func(const Pair &e) const override {return e.size;}
    bool cond(const Pair &e) const override { return e.fishName=="catfish"; }
};
istream &operator>>(istream &f, Data &df)
{
    string line;
    getline(f,line,'\n');
    stringstream ss(line);
    df.pairs.fishName=""; // initializing if the angler caught no fish
    df.pairs.size=0; //size 0 means no fish
    ss >> df.anglerName >> df.id;
    MyBiggestInpFish in;
    StringStreamEnumerator<Pair> enor(ss);
    in.addEnumerator(&enor);
    in.run();
    if(in.found())
    {
        df.pairs = in.optElem();
    }
    
    // ss >> df.pairs;
    // Pair temp;
    // while (ss >> temp)
    // {
    //     if(df.pairs.fishName!="catfish" && temp.fishName=="catfish")
    //     {
    //         df.pairs=temp;
    //     }
    //     if(df.pairs.size<temp.size )
    //     {
    //         df.pairs=temp;
    //     }
    // }
    return f;
}


class MyBiggestFish: public MaxSearch<Data ,int, Greater<int> >
{
    protected:
    int func(const Data &e) const override {return e.pairs.size;}
    bool cond(const Data &e) const override { return e.pairs.fishName=="catfish";}
};

struct forAll
{
    string nameAngler;
    bool bigger;

    forAll() { bigger=true;}

    forAll(const string &s, bool b):nameAngler(s),bigger(b) { }
};

class forAllHelp : public Summation<Data, forAll>
{
    public: 
    forAllHelp(const string &name) : _name(name) {}
    private:
    string _name;

    forAll func(const Data& d) const override
    {
        return forAll(d.anglerName,d.pairs.size>30 && d.pairs.fishName=="catfish");
    }
    forAll neutral() const override { return forAll();}
    forAll add(const forAll &a, const forAll &b) const override
    {
        return forAll(a.nameAngler,a.bigger && b.bigger);
    }
    void first() override { }
    bool whileCond(const Data &current) const override
    {
        return current.anglerName == _name;
    }
};

class DataEnumerator : public Enumerator<forAll>
{
    private:
    SeqInFileEnumerator<Data>* _f;
    forAll _current;
    bool _end;
    public:
    DataEnumerator(const string &fname) { _f = new SeqInFileEnumerator<Data> (fname);}
    ~DataEnumerator() { delete _f;}
    void first() override { _f->first(); next();}
    void next() override;
    forAll current() const override { return _current;}
    bool end() const override { return _end;}

};

void DataEnumerator::next()
{
    if (_end = _f->end()) return;
    _current.nameAngler = _f->current().anglerName;
    forAllHelp fh(_current.nameAngler);
    fh.addEnumerator(_f);
    fh.run();
    _current = fh.result();
}

class MyOptimisticSearch: public LinSearch<forAll,true>
{
    bool cond(const forAll &f) const override { return f.bigger;}
};




int main()
{
    try{
        MyBiggestFish biggestCheck;
        SeqInFileEnumerator<Data> enor1("input.txt");
        biggestCheck.addEnumerator(&enor1);
        biggestCheck.run();

        if (biggestCheck.found()){
            Data d = biggestCheck.optElem();
            cout << "The size of the biggest "<< d.pairs.fishName << " is " << d.pairs.size << ". The ID of the contest is " << d.id << " and the name of the angler is "   << d.anglerName << endl;
        }else cout << "There is no catfish caught." << endl;

        DataEnumerator enor2("input.txt");
        MyOptimisticSearch allCheck;
        allCheck.addEnumerator(&enor2);
        allCheck.run();
/*
        SeqInFileEnumerator<Data> enor2("input.txt");
        MyOptimisticSearch allCheck;
        allCheck.addEnumerator(&enor2);
        allCheck.run();
*/
        if(allCheck.found())
        {
            cout << "All the anglers caught a catfish bigger than 30 cm " << endl;
        }
        else
        {
            cout << "All the anglers did not catch a catfish bigger than 30 cm" << endl;
        }

    } catch(SeqInFileEnumerator<Data>::Exceptions ex ){
            cout << "File not found! " << endl;
            return 1;
    }
    return 0;
}



// int main() // 
// {
//     ifstream infile("input.txt");
//     vector<Data> data;
//     Data test;
//     while(infile >> test)
//     {
//         data.push_back(test);
//         cout << "Name of the Angler: " << test.anglerName  << "\nId of the competition: " << test.id << "\nName of the fish: " << test.pairs.fishName << "\nSize of the fish: " << test.pairs.size << endl;
//         cout << "------------------------------------------------------------------------------------------" << endl;
//     }


//     return 0;
// }

/*
For testing
Peter LAC0512 carp 45 carp 53 catfish 96
Tester1  LAC0513 carp 45 carp 53 catfish 96 catfish 108
Tester2 LAC0514 catfish 99 carp 45 carp 53 catfish 96
Tester3 LAC0515 carp 45 carp 53 catfish 196
*/


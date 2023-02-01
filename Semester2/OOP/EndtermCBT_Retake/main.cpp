#include <iostream>
#include "library/seqinfileenumerator.hpp"
#include "library/summation.hpp"
#include "library/stringstreamenumerator.hpp"
#include "library/linsearch.hpp"
#include "library/enumerator.hpp"
#include "library/procedure.hpp"



using namespace std;
struct InputData
{
    int round;
    string nick;
    int points;
};
istream &operator>> (istream &is,InputData &c)
    {
        is >> c.round >> c.nick >> c.points;
        return is;
    }

struct Answer
{
    int round;
    string nick;
    int points;

    Answer():round(0), nick(""), points(0) { }

    Answer(const int &r,const string &name,const int&p):round(r),nick(name),points(p) { }
};

class PlayerList : public Summation<InputData,Answer>
{
public:
    PlayerList(const int &roun,const string &nam) : _round(roun),_name(nam) { }
private:
    int _round;
    string _name;


    Answer func(const InputData& e) const  override
    {
        return Answer(e.round,e.nick,e.points);
    }
    Answer neutral() const override { return Answer(); }
    Answer add(const Answer& a, const Answer& b) const  override
    {
        return Answer(b.round,b.nick,a.points+b.points);
    }

    void first() override { }
    bool whileCond(const InputData& current) const override
    {
        return (current.round == _round && current.nick == _name);
    }
};

class AnswerEnumerator : public Enumerator<Answer>
{
private:
    SeqInFileEnumerator<InputData>* _f;
    Answer _current;
    bool _end;
public:
    AnswerEnumerator(const string &fname){ _f = new SeqInFileEnumerator<InputData>(fname); }
    ~AnswerEnumerator() { delete _f; }
    void first() override { _f->first(); next();}
    void next() override;
    Answer current() const override { return _current; }
    bool end() const override { return _end; }
};

void AnswerEnumerator::next()
{
    if (_end = _f->end()) return;


    _current.round = _f->current().round;
    _current.nick=_f->current().nick;
    PlayerList pr(_current.round,_current.nick);
    pr.addEnumerator(_f);
    pr.run();
    _current = pr.result();
}

class OptimisticL : public LinSearch<Answer,true>
{
    protected:
    bool cond(const Answer& e) const override
    {
        //cout << e.round << " " << e.nick << " " << e.points <<endl;
        return e.points==10;
    }
};

int main()
{
    try
    {
        AnswerEnumerator enor("input.txt");
        OptimisticL pr;
        pr.addEnumerator(&enor);
        pr.run();
        if (pr.found())
        {
            cout << "Yes" <<endl;
        }
        else
        {
            cout << "No" <<endl;
        }


    }
    catch (SeqInFileEnumerator<InputData>::Exceptions err)
    {
        cout<<"File not found!\n";
        return 1;
    }
    return 0;
}

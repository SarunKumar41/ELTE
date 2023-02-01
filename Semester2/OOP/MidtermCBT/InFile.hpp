#ifndef INFILE_H
#define INFILE_H

#include <iostream>
#include <fstream>
using namespace std;

enum Status { norm , abnorm };


struct Database
{
    string fName;
    string tName;
    int min,sec, milliSec;

    friend istream &operator>>(istream &is, Database &d)
    {
        is >> d.fName >> d.tName >> d.min >> d.sec >> d.milliSec;
        return is;
    }
};

struct Team
{
    string team;
    bool bTime;
};


class InFile
{
    public:


        enum Errors { OPEN_ERROR };

        InFile(const std::string &filename);
        ~InFile() {_x.close(); }

        void first () { read(); next(); }
        void next();
        Team current() const { return _cur;}
        bool end() const { return _end; }

    private:
        ///st, e, f : read
        Status _sx;
        Database _dx;
        ifstream _x;

        bool _end;

        Team _cur;

        void read();

};

#endif // INFILE_H
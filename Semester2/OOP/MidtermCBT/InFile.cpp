#include "InFile.hpp"

InFile::InFile(const std::string &filename)
{
    _x.open(filename.c_str());
    if (_x.fail()) throw OPEN_ERROR;
}

void InFile::read()
{
    _x >> _dx;
    if (_x.fail())
    {
        _sx = abnorm;
    }
    else
    {
        _sx = norm;
    }
}

void InFile::next()
{
    _end = (_sx == abnorm);
    if (!_end)
    {
        _cur.team=_dx.tName;
        _cur.bTime=false;

        for (; _sx == norm && _dx.tName == _cur.team ; read())
        {
            if(_dx.min<=1 && _dx.sec<17)
            {
                _cur.bTime=true;
            }
        }
    }
}
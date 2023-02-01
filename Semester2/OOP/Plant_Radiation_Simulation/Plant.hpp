//Author:        Sarun Kumar
//Date:          2022.04.23.
//Title:         Strongest plant on a planet
#ifndef PLANT_HPP
#define PLANT_HPP
#include <string>
#include "Radiation.hpp"

static int alphaDemSum;
static int deltaDemSum; 
//abstract Plant class
class Plant
{
    protected:
    std::string _name;
    int _level;
    //bool _alive;
    Plant(const std::string &str, int c=0) :_name(str), _level(c) {}

    public: 
    std::string name() const {return _name;}
    virtual bool alive() const {return _level > 0;}
    void changeLevel(int c) {_level +=c;}
    int getLevel() const {return _level; }
    virtual int getAlpha() const { return 0;}
    virtual int getDelta() const { return 0;}
    virtual void influence(Radiation* &rad) = 0;
    virtual ~Plant() {} 
};

// class of Wombleroot
class Wombleroot : public Plant
{
    public:
    Wombleroot(const std:: string &str, int c ): Plant(str,c) {}
    int getAlpha() const override {return 10;}
    void influence(Radiation* &rad) override
    { 
        rad = rad->influence(this);
    } 
    bool alive() const override{ return _level > 0 && _level <=10;}
};

//class of Wittentoot
class Wittentoot : public Plant
{
    public:
    Wittentoot(const std:: string &str, int c ): Plant(str,c) {}
    int getDelta() const override
    {
        if(_level <5) {return 4;}
        if(5<= _level && 10>= _level) {return 1;} 
        else { return 0;}
    }
    void influence(Radiation* &rad) override
    {
        rad = rad->influence(this);
    } 
};

//class of Woreroot
class Woreroot : public Plant
{
    public:
    Woreroot(const std:: string &str, int c ): Plant(str,c) {}
    void influence(Radiation* &rad) override
    {
        rad = rad->influence(this);
    } 
};
#endif
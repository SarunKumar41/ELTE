//Author:        Sarun Kumar
//Date:          2022.04.23.
//Title:         Strongest plant on a planet
#include "Radiation.hpp"
#include "Plant.hpp"
using namespace std;

// implementation of class No_rad
No_Rad* No_Rad::_instance = nullptr;
No_Rad* No_Rad::instance()
{
    if(_instance == nullptr)
    {
        _instance = new No_Rad();
    }
    return _instance;
}

Radiation* No_Rad::influence(Wombleroot *p)
{
    p->changeLevel(-1);
    /*
    if(p->alive())
    {
        if(alphaDemSum >= (3+deltaDemSum)) {return Alpha_Rad::instance();}
        if(deltaDemSum >= (3+alphaDemSum)) {return Delta_Rad::instance();}
    }    
    */
    return this;
}
Radiation* No_Rad::influence(Wittentoot *p)
{
    p->changeLevel(-1);
    /*
    if(p->alive() && p->getLevel()<=10)
    {
    if(alphaDemSum >= (3+deltaDemSum)) {return Alpha_Rad::instance();}
    if(deltaDemSum >= (3+alphaDemSum)) {return Delta_Rad::instance();}
    }
    */
    return this;
}
Radiation* No_Rad::influence(Woreroot *p)
{
    p->changeLevel(-1);
    return this;
}


// implementation of class Alpha_rad

Alpha_Rad* Alpha_Rad::_instance = nullptr;
Alpha_Rad* Alpha_Rad::instance()
{
    if(_instance == nullptr)
    {
        _instance = new Alpha_Rad();
    }
    return _instance;
}

Radiation* Alpha_Rad::influence(Wombleroot *p)
{
    p->changeLevel(2);
    /*
    if(p->alive())
    {
        if(alphaDemSum >= (3+deltaDemSum)) {return Alpha_Rad::instance();}
        if(deltaDemSum >= (3+alphaDemSum)) {return Delta_Rad::instance();}
    }
    */
    return this;//No_Rad::instance();
}

Radiation* Alpha_Rad::influence(Wittentoot *p)
{
    p->changeLevel(-3);
    /*
    if(p->alive() && p->getLevel()<=10)
    {
    if(alphaDemSum >= (3+deltaDemSum)) {return Alpha_Rad::instance();}
    if(deltaDemSum >= (3+alphaDemSum)) {return Delta_Rad::instance();}
    }
    */
    return this;//No_Rad::instance();
}

Radiation* Alpha_Rad::influence(Woreroot *p)
{
    p->changeLevel(1);
    return this;
}
// implementation of class Delta_rad

Delta_Rad* Delta_Rad::_instance = nullptr;
Delta_Rad* Delta_Rad::instance()
{
    if(_instance == nullptr)
    {
        _instance = new Delta_Rad();
    }
    return _instance;
}

Radiation* Delta_Rad::influence(Wombleroot *p)
{
    p->changeLevel(-2);
    /*
    if(p->alive())
    {
        if(alphaDemSum >= (3+deltaDemSum)) {return Alpha_Rad::instance();}
        if(deltaDemSum >= (3+alphaDemSum)) {return Delta_Rad::instance();}
    }
    */
    return this; // No_Rad::instance();
}

Radiation* Delta_Rad::influence(Wittentoot *p)
{
    p->changeLevel(4);
    /*
    if(p->alive() && p->getLevel()<=10)
    {
    if(alphaDemSum >= (3+deltaDemSum)) {return Alpha_Rad::instance();}
    if(deltaDemSum >= (3+alphaDemSum)) {return Delta_Rad::instance();}
    }
    */
    return this; //No_Rad::instance();
}

Radiation* Delta_Rad::influence(Woreroot *p)
{
    p->changeLevel(1);
    return this;
}


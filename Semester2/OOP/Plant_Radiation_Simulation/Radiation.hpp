//Author:        Sarun Kumar
//Date:          2022.04.23.
//Title:         Strongest plant on a planet
#ifndef RADIATION_HPP
#define RADIATION_HPP
#include <string>

class Wombleroot;
class Wittentoot;
class Woreroot;


class Radiation
{
    public:
    virtual Radiation* influence(Wombleroot *p) = 0;
    virtual Radiation* influence(Wittentoot *p) = 0;
    virtual Radiation* influence(Woreroot *p) = 0;
    virtual ~Radiation() {}
};

// class of no radiation
class No_Rad : public Radiation
{
    public:
    static No_Rad* instance();
    Radiation* influence(Wombleroot *p) override;
    Radiation* influence(Wittentoot *p) override;
    Radiation* influence(Woreroot *p) override;
    void static destroy() {if(nullptr!=_instance) {delete _instance; _instance=nullptr;}}
    protected:
    No_Rad(){}
    private:
    static No_Rad* _instance;
};

// class of alpha radiation
class Alpha_Rad : public Radiation
{
    public:
    static Alpha_Rad* instance();
    Radiation* influence(Wombleroot *p) override;
    Radiation* influence(Wittentoot *p) override;
    Radiation* influence(Woreroot *p) override;
    void static destroy() {if(nullptr!=_instance) {delete _instance; _instance=nullptr;}}
    protected:
    Alpha_Rad(){}
    private:
    static Alpha_Rad* _instance;
};

// class of delta radiation
class Delta_Rad : public Radiation
{
    public:
    static Delta_Rad* instance();
    Radiation* influence(Wombleroot *p) override;
    Radiation* influence(Wittentoot *p) override;
    Radiation* influence(Woreroot *p) override;
    void static destroy() {if(nullptr!=_instance) {delete _instance; _instance=nullptr;}}
    protected:
    Delta_Rad(){}
    private:
    static Delta_Rad* _instance;
};
#endif
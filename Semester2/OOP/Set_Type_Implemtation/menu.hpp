#ifndef MENU_H_INCLUDED
#define MENU_H_INCLUDED
#include "Set_Type.hpp"


class Menu
{
    public:
        Menu(){};
        void Run();
    private:
        int MenuPrint();
        void putIn();
        void takeOut();
        void isEmpty();
        void contains();
        void random();
        void largest();
        void print();
        //void loadTest();
        Set_Type mainSet;
};

#endif // MENU_H_INCLUDED
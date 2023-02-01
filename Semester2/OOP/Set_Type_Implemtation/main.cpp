#include "Set_Type.hpp"
#include "menu.hpp"


#define NORMAL_MODE
#ifdef NORMAL_MODE

int main()
{
    cout << "\n\n------------Set-------------" << endl;

    Menu menu;
    menu.Run();

    return 0;
}

#else
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Set_Type.hpp"
 


TEST_CASE("isEmpty()","[Set]")
{
    Set_Type testSet;

    CHECK(testSet.isEmpty() == TRUE);

    int a=5;
    testSet.setElem(a);
    CHECK( testSet.isEmpty() == FALSE ); 

    testSet.remElem(a);
    CHECK( testSet.isEmpty() == TRUE );
}

TEST_CASE("Put in","[Set]")
{
    Set_Type testSet;
    int a=6,b=3,c=7,d=10,e=19;
    {
        testSet.setElem(a);
        vector<int> vec =testSet.getElements();
        CHECK( 1 == testSet.getSize());
        CHECK( vec[0] == a);
    }

    {
        testSet.setElem(b);testSet.setElem(c);testSet.setElem(d);testSet.setElem(e);
        vector<int> vec =testSet.getElements();
        CHECK( 5 == testSet.getSize());
        CHECK( a == vec[0]); CHECK( b == vec[1]); CHECK( c == vec[2]); CHECK( d == vec[3]); CHECK( e == vec[4]);
    }
}

TEST_CASE("getRandElem LargeEntry"," [set]")
{
    ///checking getRandElem and LargeEntry
    SECTION("Exception Throws")
    {
        Set_Type testSet;
        CHECK_THROWS(testSet.getRandElem());
        CHECK_THROWS(testSet.LargeEntry());
        testSet.setElem(1);
        CHECK_THROWS(testSet.setElem(1));


    }

    ///Items for testing
    int a =0,b=1,c=2,d=3;
    //Item e1(1,"a"); Item e2(2,"b"); Item e3(3,"c"); Item e5(5,"a");
    SECTION("checking for maximum element, only one item")
    {
        Set_Type testSet;
        testSet.setElem(a);
        int LargeInd= testSet.getLargeInd();
        vector<int> vec =testSet.getElements();
        CHECK(vec[LargeInd] == 0);
        CHECK(0 == testSet.LargeEntry());
        
        testSet.remElem(vec[LargeInd]);
        CHECK( 0 == testSet.getSize());
        //CHECK( e == e1 );
    }

    SECTION("more items, first is maximal")
    {
        Set_Type testSet;
        testSet.setElem(d); testSet.setElem(c); testSet.setElem(b);testSet.setElem(a);
        CHECK(0 == testSet.getLargeInd());
        vector<int> vec =testSet.getElements();
        int e=testSet.LargeEntry();
        CHECK( e ==  vec[0]);
        testSet.remElem(e);
        CHECK( 3 == testSet.getSize());
        e=testSet.LargeEntry();
        CHECK( e ==  vec[1]);
        testSet.remElem(e);
        CHECK( 2 == testSet.getSize());
        vector<int> v =testSet.getElements();
        CHECK(v[0]==a); CHECK(v[1]==b);
    }

    SECTION("more items, last is maximal")
    {
        Set_Type testSet;
        int l=120, m=1,n=15,o=19;
        testSet.setElem(o); testSet.setElem(m); testSet.setElem(n);testSet.setElem(l);
        CHECK(3 == testSet.getLargeInd());
        vector<int> vec =testSet.getElements();
        int e=testSet.LargeEntry();
        CHECK( e ==  vec[3]);
        testSet.remElem(e);
        CHECK( 3 == testSet.getSize());
        e=testSet.LargeEntry();
        CHECK( e ==  vec[0]);
        testSet.remElem(e);
        CHECK( 2 == testSet.getSize());
        vector<int> v =testSet.getElements();
        CHECK(v[0]==n); CHECK(v[1]==m);
    }

    SECTION("more items, middle is maximal")
    {
        Set_Type testSet;
        int x=0,y=5,z=10;
        testSet.setElem(y); testSet.setElem(z); testSet.setElem(x);
        CHECK(1 == testSet.getLargeInd());
        vector<int> vec =testSet.getElements();
        int e=testSet.LargeEntry();
        CHECK( e ==  vec[1]);
        testSet.remElem(e);
        CHECK( 2 == testSet.getSize());
        e=testSet.LargeEntry();
        CHECK( e ==  vec[0]);
        testSet.remElem(e);
        CHECK( 1 == testSet.getSize());
        vector<int> v =testSet.getElements();
        CHECK(v[0]==x); 
    }

    SECTION("Testing getRandElem")
    {
        Set_Type testSet;
        CHECK(testSet.getSize() == 0);
        CHECK_THROWS(testSet.getRandElem());
        testSet.setElem(312);testSet.setElem(12);testSet.setElem(100);testSet.setElem(4646);
        CHECK(testSet.getSize() == 4);
        int e = testSet.getRandElem();
        CHECK(testSet.checksElement(e)==TRUE);
        e = testSet.getRandElem();
        CHECK(testSet.checksElement(e)==TRUE);

    }


}
#endif
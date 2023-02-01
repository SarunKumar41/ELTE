//Author:        Sarun Kumar
//Date:          2022.04.23.
//Title:         Strongest plant on a planet

#include <iostream>
#include <fstream>
#include <vector>
#include <exception>
#include "Plant.hpp"

using namespace std;

char transform(string a) // transforming string into unique char values
{
    if(a =="wom") {return 'M';}
    if(a=="wit") {return 'T';}
    if(a=="wor") {return 'R';}
}

//Task:          Filling the vector of Plant and Radiation from a file of a given name 
//Input:         string str	- name of the text file
//Output:        vector<Plant*> &plants  - vector of pointers of the Plant
//               vector<Radiation*> &radiation - vector of the radiations of the Radiation
//Activity:      creating the Plant and their pointers from the file
//               all alive plants under same radiation on particular day demanding radiation for next day (so radiation of next day can be calculated)
//               radiation  of first day is given i.e no radiation
//               filling the vector of the Plant
//               filling the vector of the Radiation by calculating the overall demand of radiation for next day 


void createAndComputeData(const string &str, vector<Plant*> &plants, vector<Radiation*> &radiations )
{
    ifstream f(str);
    if(f.fail()) {cout << "Wrong file name\n"; exit(1);}

    int n; f >> n;   // getting plants
    
    plants.resize(n);
    for(unsigned int i=0;i<n;++i)
    {
        string plantName, shortName; int plantLevel;
        f >> plantName >> shortName >> plantLevel;
        switch(transform(shortName))
        {
            case 'M' : plants[i] = new Wombleroot(plantName,plantLevel);break;
            case 'T' : plants[i] = new Wittentoot(plantName,plantLevel);break;
            case 'R' : plants[i] = new Woreroot(plantName,plantLevel);break;
        }
    }
    // preparing radiations
    int days; f >> days;
    radiations.resize(days);
    if(days>0) {radiations[0] = No_Rad::instance();}

    for(unsigned int j=0;j<days;j++)
    {    
        alphaDemSum = 0 , deltaDemSum = 0;
        cout << "---------------------------Day: " << j+1 << "--------------------------" << endl;
        for (unsigned int i = 0; i < n; i++) // summing up the alpha and delta demand
        {
            if(plants[i]->alive())
            {
                alphaDemSum+= plants[i]->getAlpha();
                deltaDemSum+= plants[i]->getDelta();
                plants[i]->influence(radiations[j]);
            }
            cout << plants[i] -> name() << " " << plants[i] -> getLevel() << endl;
        }
        
        if(j+1<days) // getting radiation of j+1(next day)th  day
        {
            if(alphaDemSum >= (3+deltaDemSum)) {radiations[j+1] =  Alpha_Rad::instance();}
            else if(deltaDemSum >= (3+alphaDemSum)) {radiations[j+1] =  Delta_Rad::instance();}
            else { radiations[j+1] = No_Rad::instance();}
        }
    }
}


//Task:       Collect the alive plants then get the strongest on among them(result)
//Input:      vector<Plant*> &plants  - vector of pointers of the plants
//            vector<Radiation*> &radiations - vector of the radiation
//Output:     vector<Plant*> &plants  - vector of pointers of the plants
//            vector<Radiation*> &radiations - vector of the radiation
//            vector<int> alivePlants - indexes of the alive plants with respect to vector of plants
//Activity:   taking all the alive plants from vecto of plants and putting it in vector of alivePlants
//            printing the name of the strongest plant ("No plant is alive" printed when size of vector of alivePlants is zero ) 
void result(vector<Plant*> &plants, vector<int> &alivePlants) // printing the result
{
    alivePlants.clear();
    try
    {
        int maxIndex;
        for(unsigned int i=0;i<plants.size();i++){if(plants[i]->alive()) alivePlants.push_back(i); }
        if(alivePlants.size()==0)
        {
            cout << "No plant is alive" << endl;
        }
        else
        {
            maxIndex = alivePlants[0];
            for(unsigned int i=0;i<alivePlants.size();i++)
            {
                if((plants[alivePlants[i]]->getLevel()>plants[maxIndex]->getLevel()) ) //&& plants[i]->alive()
                {
                    maxIndex=alivePlants[i];
                }
            }
            cout << "The strongest plant is \""<< plants[maxIndex]->name() <<"\"" << endl;
        }
    }
    catch(exception e)
    {
        cout << e.what() << endl;
    }
}

//Task:       Destruction of the plants
//Input:      vector<Plant*> &plants  - vector of pointers of the plants
//Activity:   destroys every dinamically allocated plant
void destroyPlants(vector<Plant*> &plants){for(int i=0;i<plants.size(); i++) delete plants[i];}

//Task:       Destruction of the radiations
//Input:      vector<Radiation*> &radiations - vector of the radiations
//Activity:   destroys every dinamically allocated radiations
void destroyRadiations()
{
    No_Rad::destroy();
    Alpha_Rad::destroy();
    Delta_Rad::destroy();
}

#define NORMAL_MODE // To change between the manual and the unit test mode
#ifdef NORMAL_MODE

//Task:       Getting the strongest plant that survived after n days(given in input file)
//Input:      text file
//Output:     names of plant written to the console
//Activity:   Creating the plants and the radiations based on the file
//            Simulation of the computation and writing the result
int main()
{
    vector<Plant*> plants; 
    vector<Radiation*> radiations;
    cout << "Enter the file name" << endl;
    string str; //filename
    cin >> str;
    createAndComputeData(str,plants,radiations);
    vector<int> alivePlants; //for testing
    result(plants,alivePlants);
        
    destroyPlants(plants); // destroying plants 
    destroyRadiations();   //destroying radiations
    return 0;
}

#else
#define CATCH_CONFIG_MAIN
#include "catch.hpp"

TEST_CASE("1", "Checking size/elements of alive plants")
{
    vector<Plant*> plants;
    vector<Radiation*> radiations;
    vector<int> alivePlants;

    createAndComputeData("inp11.txt", plants, radiations);
    result(plants, alivePlants);
    CHECK(alivePlants.size() == 0);
    destroyPlants(plants);

    createAndComputeData("inp12.txt", plants, radiations );
    result(plants, alivePlants);
    CHECK(alivePlants.size() == 1);
    destroyPlants(plants);

    createAndComputeData("inp14.txt", plants, radiations );
    result(plants, alivePlants);
    CHECK(alivePlants.size() == 1);
    destroyPlants(plants);

    createAndComputeData("inp13.txt", plants, radiations );
    result(plants, alivePlants);
    CHECK(alivePlants.size() == 3);
    Plant* p = plants[alivePlants[0]];
    CHECK(p->alive());
    p = plants[alivePlants[1]];
    CHECK(p->alive());
    p = plants[alivePlants[1]];
    CHECK(p->alive());
    destroyPlants(plants);

    createAndComputeData("inp21.txt", plants, radiations );
    result(plants, alivePlants);
    CHECK(alivePlants.size()==2);
    p = plants[alivePlants[0]];
    CHECK( p->name()== "Alily");
    p = plants[alivePlants[1]];
    CHECK(p->name() == "Big");
    destroyPlants(plants);

    createAndComputeData("inp22.txt", plants, radiations );
    result(plants, alivePlants);
    CHECK(alivePlants.size() == 1);
    
    destroyPlants(plants);
    destroyRadiations();
}

TEST_CASE("2", "Some more test on elements of alive plants")
{
    vector<Plant*> plants;
    vector<Radiation*> radiations;
    vector<int> alivePlants;

    plants.clear();
    radiations.clear();
    createAndComputeData("inp12.txt", plants, radiations );
    result(plants, alivePlants);

    Plant* p = plants[alivePlants[0]];
    CHECK( p->name()== "Lala");
    destroyPlants(plants);

    createAndComputeData("inp13.txt", plants, radiations );
    result(plants, alivePlants);

    p = plants[alivePlants[0]];
    CHECK( p->name()== "Alily");
    p = plants[alivePlants[1]];
    CHECK( p->name()== "Willbit");
    p = plants[alivePlants[2]];
    CHECK( p->name()== "Contrar");
    destroyPlants(plants);
    destroyRadiations();
}

TEST_CASE("3", "Checking the expected radiation") {

    vector<Plant*> plants;
    vector<Radiation*> radiations;
    vector<int> alivePlants;

    createAndComputeData("inp11.txt", plants, radiations); // No plants - 10 days
    CHECK(plants.size()==0);
    CHECK(radiations[0]== No_Rad::instance()); // Checking all 10 days and expected no changes because there is no plant 
    CHECK(radiations[1]== No_Rad::instance());
    CHECK(radiations[2]== No_Rad::instance());
    CHECK(radiations[3]== No_Rad::instance());
    CHECK(radiations[4]== No_Rad::instance());
    CHECK(radiations[5]== No_Rad::instance());
    CHECK(radiations[6]== No_Rad::instance());
    CHECK(radiations[7]== No_Rad::instance());
    CHECK(radiations[8]== No_Rad::instance());
    CHECK(radiations[9]== No_Rad::instance());


    destroyPlants(plants);


    createAndComputeData("inp12.txt", plants, radiations); // 1 plant -  5 days
    CHECK(plants.size()==1);
    CHECK(radiations[0]== No_Rad::instance()); 
    CHECK(radiations[1]== No_Rad::instance());
    CHECK(radiations[2]== No_Rad::instance());
    CHECK(radiations[3]== No_Rad::instance());
    CHECK(radiations[4]== No_Rad::instance());

    createAndComputeData("inp13.txt", plants, radiations); // 5 plants - 3 days
    CHECK(plants.size()==5);
    CHECK(radiations[0]== No_Rad::instance()); 
    CHECK(radiations[1]== Alpha_Rad::instance());
    CHECK(radiations[2]== Alpha_Rad::instance());

    createAndComputeData("inp21.txt", plants, radiations); // 6 plants - 10 days
    CHECK(plants.size()==6);
    CHECK(radiations[0]== No_Rad::instance());
    CHECK(radiations[1]== Alpha_Rad::instance());
    CHECK(radiations[2]== Alpha_Rad::instance());
    CHECK(radiations[3]== Alpha_Rad::instance());
    CHECK(radiations[4]== Alpha_Rad::instance());
    CHECK(radiations[5]== No_Rad::instance());
    CHECK(radiations[6]== No_Rad::instance());
    CHECK(radiations[7]== No_Rad::instance());
    CHECK(radiations[8]== No_Rad::instance());
    CHECK(radiations[9]== No_Rad::instance());

    createAndComputeData("inp22.txt", plants, radiations); // 3 plants - 5 days
    CHECK(plants.size()==3);
    CHECK(radiations[0]== No_Rad::instance());
    CHECK(radiations[1]== Alpha_Rad::instance());
    CHECK(radiations[2]== Alpha_Rad::instance());
    CHECK(radiations[3]== Alpha_Rad::instance());
    CHECK(radiations[4]== Alpha_Rad::instance());

    createAndComputeData("inputDelta.txt", plants, radiations); // 8 plants - 4 days
    CHECK(plants.size()==8);
    CHECK(radiations[0]== No_Rad::instance());
    CHECK(radiations[1]== No_Rad::instance());
    CHECK(radiations[2]== Delta_Rad::instance());
    CHECK(radiations[3]== Delta_Rad::instance());

    destroyRadiations();
}

#endif 

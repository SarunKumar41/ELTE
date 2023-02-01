 #include <iostream>
 #include <vector>
 using namespace std;

 struct  Schedule
 {
     int distance,arrival,departure;
 };

 bool checkNotStop(Schedule a)
 {
     if(a.departure == a.arrival)
     {
         return true;
     }
     return false;
 }


 int main()
 {
     int stop;
     do
     {
         cin >> stop;
         if(stop < 1 || stop > 100)
         {
             cerr << "Enter the correct value";
         }
     } while (stop < 1 || stop > 100 );
     
     vector <Schedule> Schedules(stop);

     for(int i=0; i<Schedules.size();i++)
     {
         do{
             cin >> Schedules[i].distance;
         }while(Schedules[i].distance<1 || Schedules[i].distance> 6000);
         do{
             cin >> Schedules[i].arrival;
         }while(Schedules[i].arrival<1 || Schedules[i].arrival > 2000);
         do{
             cin >> Schedules[i].departure;
         }while(Schedules[i].departure<Schedules[i].arrival || Schedules[i].departure > 2000);
     }
     
     int time;
     vector <int> helper;
     helper.push_back(Schedules[0].arrival);
     for(int i=1;i<Schedules.size();i++)
     {
         if(checkNotStop(Schedules[i]))
         {
             time= Schedules[i].arrival - Schedules[i-1].departure;
             helper.push_back(time);
         }
     }
     
     int ShortestTime=helper[0];
     for(int i=0; i<helper.size();i++)
     {
         if(helper[i] < ShortestTime)
         {
             ShortestTime=helper[i];
         }
     }
     
     cout << ShortestTime << endl;
     return 0;
 }


 

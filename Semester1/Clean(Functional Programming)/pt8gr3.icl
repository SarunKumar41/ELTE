module pt8gr3

import StdEnv

/* Create a structure `Student` with 3 fields: name (string), id (string)
 * grades (array of integers).
 * Write a function passedIDs that takes array of students and list of IDs
 * of those students, that passed the course. Student passed the course if
 * he/she has average grade greater than 50.0.
 */

:: Student = {name :: String, id :: String, grades :: {Int} }
passedIDs :: {Student} -> [String]
passedIDs {} = []
passedIDs p
| average>50 = [p.id : passedIDs p]
= passedIDs p
where average = foldr (+) 0 [x \\ x<-: p.grades] 

// Intended for tests. Do not remove!
student1 = {name="a",id="st1",grades={80,40,70}}
student2 = {name="b",id="st2",grades={120,30,80,40,70}}
student3 = {name="c",id="st3",grades={80,50,40,70}}
student4 = {name="d",id="st4",grades={}}

// Start = passedIDs {} // []
// Start = passedIDs {student1} // ["st1"]
// Start = passedIDs {student1, student2, student3, student4} // ["st1","st2","st3"]
// Start = passedIDs {student4} // []
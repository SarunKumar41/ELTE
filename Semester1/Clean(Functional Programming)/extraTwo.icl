module extraTwo
import StdEnv


:: Position = Electrician | Developer | Architect | Junior
:: Company = Ericsson | Microsoft | Nokia | Cloudera | None
:: Candidate = {name::String, position::Position, experience::Int, previous::Company}
 

MacMillan::Candidate
MacMillan = {name="MacMillan",position=Electrician, experience =10, previous=Ericsson}

Goodenough::Candidate
Goodenough = {name="Goodenough",position=Developer, experience =4, previous=Cloudera}

Frank::Candidate
Frank = {name="Frank",position=Developer, experience=10, previous=Microsoft}

Akira::Candidate
Akira = {name="Akira",position=Electrician, experience=30, previous=Nokia }

Feringa::Candidate
Feringa = {name="Feringa",position=Architect, experience=14, previous=Microsoft}

Modrich::Candidate
Modrich = {name="Modrich",position=Architect, experience=25, previous=Ericsson}

Osamu::Candidate
Osamu = {name="Osamu",position=Electrician, experience=7, previous=Nokia }

Ryoji::Candidate
Ryoji = {name="Ryoji",position=Junior, experience=1, previous=Ericsson}

John ::Candidate
John  = {name="John",position=Junior, experience=0, previous=None}

Rudolph ::Candidate
Rudolph  = {name="Rudolph ",position=Developer, experience=9, previous=Ericsson}


/* 1

 Create an instance for Candidate to sort them. (using built-in sort function, you need to create instance for < operator)
 
 Candidates supposed to be sorted by its experience weighted by previous company and position. (multiply)
 
 For positions : 	Junior weights 1
 					Developer weights 2
 					Electrician weights 1.2
 					Architect weights 3
 					
 For previous company:	None weights 1
 						Nokia weights 1.2
 						Ericsson weights 1.2
 						Cloudera weights 1.3
 						Microsoft weights 1.5
 						
 Point for Rudolph : 9 * 2 * 1.2 = 21.6
 
*/
instance == Position
where 
	== Electrician Electrician = True
	== Developer Developer = True
	== Architect Architect = True
	== Junior Junior = True
	== _ _ = False

instance == Company
where
	== Ericsson Ericsson = True 
	== Microsoft Microsoft = True 
	== Nokia Nokia = True 
	== Cloudera Cloudera = True
	== None None = True 
	== _ _ = False

post :: Position -> Real
post Electrician = 1.2
post Developer = 2.0
post Junior = 1.0
post Architect = 3.0

prev :: Company -> Real
prev Ericsson = 1.2
prev Nokia = 1.2
prev None = 1.0
prev Cloudera = 1.3
prev Microsoft = 1.5

instance < Candidate
where
	< a b = (toReal(a.experience) * post(a.position) * prev(a.previous)) < (toReal(b.experience) * post(b.position) * prev(b.previous))

instance == Candidate
where
	== a b = (toReal(a.experience) * post(a.position) * prev(a.previous)) == (toReal(b.experience) * post(b.position) * prev(b.previous))
//Start = map (\x = x.name) (sort [MacMillan,Goodenough,Frank,Akira,Feringa,Modrich,Osamu,Ryoji,John,Rudolph]) //["John","Ryoji","Osamu","Goodenough","MacMillan","Rudolph ","Frank","Akira","Feringa","Modrich"]



/* 2
 
 Given a binary tree of Candidates. Write a function which rearranges the tree and makes a balanced Binary search tree (BST)
 
 based on their points. In BST values in left subtree should be less than the current node's value and
 
 values in right subtree should be greater. 
 
 		3
 	   / \ 			For instance this tree is a BST, but not balanced.
 	  2   Leaf		 
 	 / \			If [3,1,2] is given, the BST you should return is :
 	1   Leaf
 	
 		2
 	   / \
 	  1   3
 	 / \ / \
 	L  L L  L
 */



:: BST a = BSTNode a (BST a) (BST a) | BSTLeaf

//sortcan :: [Candidate] -> [Candidate]
//sortcan [] = []
//sortcan list = sort[list]



makeBST :: [Candidate] -> (BST Candidate)
makeBST [] = BSTLeaf
makeBST [x:xs] = (BSTNode mid (makeBST (take (half)(sortedl))) (makeBST (drop (half+1)(sortedl))))  
where
    half = (length[x:xs])/2
    mid = (sortedl)!!(half)  
    sortedl = sort[x:xs]

//Start = makeBST [MacMillan,Goodenough,Frank,Akira,Feringa,Modrich,Osamu,Ryoji,John,Rudolph] 

// (BSTNode (Candidate "Rudolph " Developer 9 Ericsson) (BSTNode (Candidate "Osamu" Electrician 7 Nokia) (BSTNode (Candidate "Ryoji" Junior 1 Ericsson) (BSTNode (Candidate "John" Junior 0 None) BSTLeaf BSTLeaf) BSTLeaf) 
//														(BSTNode (Candidate "MacMillan" Electrician 10 Ericsson) (BSTNode (Candidate "Goodenough" Developer 4 Cloudera) BSTLeaf BSTLeaf) BSTLeaf)) 
// (BSTNode (Candidate "Feringa" Architect 14 Microsoft) (BSTNode (Candidate "Akira" Electrician 30 Nokia) (BSTNode (Candidate "Frank" Developer 10 Microsoft) BSTLeaf BSTLeaf) BSTLeaf) 
//														(BSTNode (Candidate "Modrich" Architect 25 Ericsson) BSTLeaf BSTLeaf)))


/* 3

 Recrutiers are discussing to hire for a position from shortlisted candidates.
 
 Given array of candidates, write a function which returns the most suitable candidates
 
 for every position appeared in the array. The most suitable candidate is someone who has
 
 the greatest point (calculated same as ex. 1)

*/



getposition :: {Candidate} -> [Position]
getposition arr = [x.position \\ x<-:arr]

bestcandid :: {Candidate} Position -> (Position, String)
bestcandid arr jhaant =  (jhaant, hd[x.name \\ x<-:arr | x == (maxList[a \\ a<-:arr | a.position == jhaant])] ) 

//Start = bestcandid {Feringa,Osamu,MacMillan} Electrician

wantedCandidates :: {Candidate} -> [(Position, String)]
wantedCandidates lund = [bestcandid lund x \\ x<-removeDup(getposition lund)]


//Start = wantedCandidates {MacMillan,Goodenough,Frank,Akira,Feringa,Modrich,Osamu,Ryoji,John,Rudolph} // [(Electrician,"Akira"),(Developer,"Frank"),(Architect,"Modrich"),(Junior,"Ryoji")]
//Start = wantedCandidates {MacMillan,Goodenough,Feringa,Osamu,John,Rudolph} // [(Electrician,"MacMillan"),(Developer,"Rudolph "),(Architect,"Feringa"),(Junior,"John")]
//Start = wantedCandidates {Feringa,Osamu,MacMillan} // [(Architect,"Feringa"),(Electrician,"MacMillan")]



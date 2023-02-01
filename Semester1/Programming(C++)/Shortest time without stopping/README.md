
# Shortest time without stopping

We know some information about a tram line: the distance of the stops from the previous stop, the arrival and departure times at a stop (only in one direction, the tram starts at time 0). If the arrival and departure times for a stop is the same, it means that the tram does not stop at that stop.
Write a program that gives the shortest interval of time in which the tram does not stop.

## Input
The frst line of the standard input contains the count of stops (1≤N≤100). The next N lines each contain the distance from the previous stop (1≤Di≤6000), and arrival (1≤Arri≤2000) and departure (Arri≤Depi≤2000) times at a stop.

## Output
The frst line of the standard output should contain the shortest interval of time in which the tram does not stop.
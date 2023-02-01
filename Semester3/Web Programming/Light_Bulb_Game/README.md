
# Light bulb placement (JavaScript assignment - home project)

**This is a mini board game implemented using JavaScript. [Click here to play the Game](http://webprogramming.inf.elte.hu/students/iwcyyd/Light_Bulb_Game/)**

## Game description

* The king's palace has rooms with square shaped floors that consist of black and white tiles only.
* Light bulbs can only be placed above white tiles.
* The light from the light bulbs does not spread diagonally, only straight along the given row and column.
* The black tiles have objects placed on them, which block the propagation of light.
* Black cells can optionally contain an integer from 0 to 4. This indicates how many adjacent (bottom, top, right, left) cells contain light bulbs. If there is such a number, the puzzle must be solved accordingly!
* Two light bulbs can NEVER illuminate each other!
* The goal of the game is to place the light bulbs so that all the white tiles are illuminated.
* The game is played by one player until he solves the puzzle, so there is no need to manage multiple players at the same time or divide into rounds.

## Gameplay example

1. The beginning of the game. The game board only contains the tiles (mostly white, some black with or without numbers) but no light bulbs.

2. Intermediate state. The player can place a new light bulb or remove previously placed bulbs by clicking. Notice that the light only spreads along the row and column of the light bulb and does not traverse through black tiles!

3. The end of the game. The player wins once every white tile is illuminated according to the rules.


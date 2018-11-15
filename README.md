# Minesweeper

Minesweeper is a classical single player puzzle game where the objective is to clear a board containing hidden mines without triggering any of them. The neighboring cells can give you clues on how many adjacent mines are around a particular block.
A particular board may contain three types of cells and different behaviour when they get exposed:
1. Mined Cell – exposing this will end the game.
2. Adjacent Cell – exposing this will display the number of mines adjacent to
this cell.
3. Empty Cell – exposing this will trigger an expose reaction on all its unsealed
neighbors.
An example of their behavior can be seen in ​Figure 1.1​​ below.
 
A few standard guidelines of how the game should be implemented:
- The grid should be at least 10 x 10.
- The user should have the possibility to seal (mark) cells so you do not accidently
expose them. You can represent sealed cells with the letter ‘S’ as shown in
Figure 1.1.
- A sealed cell cannot be exposed.
- Only an unsealed and unexposed cell can be exposed.
- Only an unexposed cell can be sealed.
- If a player exposes a mine cell, the game is over.
- Exposing an adjacent cell should display the count of mines adjacent to it (Look
at Figure 1,1).
- Exposing an empty cell should trigger an expose reaction exposing all unsealed
cells.
- The win condition is when all the mines have been sealed and the rest of the
cells are exposed. Refer to ​Figure 1.2
- The lose condition is if a player exposes a mined cell (OPTIONAL: You can also
implement a timer system to make it more challenging). Also, when the game is lost, the board should display the cells that contained the mine. You can use the symbol ‘X’ to represent the mines.

A few helpful hints:
- You can use JButton to implement each of the cells.
- It can be useful to separate the logic of the game with the UI implementation. As
this is a group project, you can divide each accordingly.
- Keep your code modular and test frequently.
- Start early!

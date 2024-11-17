### Documentation for `Mines` and `Board` Classes

#### `Mines` Class

The `Mines` class represents the main window of the Minesweeper game. It extends `JFrame` and sets up the game window, including the status bar and the game board.

**Fields:**

- `WIDTH`: The width of the game window.
- `HEIGHT`: The height of the game window.
- `statusbar`: A `JLabel` used to display the game status.

**Constructor:**

- `Mines()`: Initializes the game window, sets its properties, adds the status bar and the game board, and makes the window visible.

**Methods:**

- `main(String[] args)`: The main method to start the game.

#### `Board` Class

The `Board` class represents the game board of Minesweeper. It extends `JPanel` and handles the game logic, including initializing the game, handling mouse events, and painting the game board.

**Fields:**

- `NUM_IMAGES`: The number of images used in the game.
- `CELL_SIZE`: The size of each cell on the board.
- `COVER_FOR_CELL`, `MARK_FOR_CELL`, `EMPTY_CELL`, `MINE_CELL`, `COVERED_MINE_CELL`, `MARKED_MINE_CELL`: Constants representing different cell states.
- `DRAW_MINE`, `DRAW_COVER`, `DRAW_MARK`, `DRAW_WRONG_MARK`: Constants representing different drawing states.
- `field`: An array representing the state of each cell on the board.
- `inGame`: A boolean indicating whether the game is currently active.
- `mines_left`: The number of mines left to be marked.
- `img`: An array of images used for the cells.
- `mines`, `rows`, `cols`, `all_cells`: Game configuration parameters.
- `statusbar`: A `JLabel` used to display the game status.

**Constructor:**

- `Board(JLabel statusbar)`: Initializes the game board, loads images, sets up the mouse listener, and starts a new game.

**Methods:**

- `newGame()`: Initializes a new game by setting up the board and placing mines.
- `find_empty_cells(int j)`: Recursively reveals empty cells around a given cell.
- `paint(Graphics g)`: Paints the game board.
- `getMinesLeft()`: Returns the number of mines left to be marked.
- `isInGame()`: Returns whether the game is currently active.
- `setInGame(boolean inGame)`: Sets the game status.
- `getField()`: Returns the current state of the board.

**Inner Classes:**

- `MinesAdapter`: A `MouseAdapter` that handles mouse events for the game board.
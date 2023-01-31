//CS2336.0W1 Matthew Lai
/* Analysis
    Create a program that simulates Ultimate Tic-tac-toe, a tic-tac-toe game that consists of a 3x3 board of
    smaller tic-tac-toe games. Create a board class that will be used to contain a standard tic-tac-toe game.
    It should contain instance variables to hold information about whether the mini-board is full, has been
    won, and an array to hold input. Create a TTTGame class to operate the board, assign computer and human
    players, and determine a winner, loser, or a tie game. The TTGame class will have methods used for
    setting the board and players, switching players, starting the game and changing the turns based on the
    ruleset of Ultimate TTT, displaying the board, and checking for a winner. The first player should be
    able to place a piece wherever they want, but every subsequent move should be subject to evaluation on
    whether the position value that was chosen has a corresponding board that is not yet full for the
    subsequent player to be forced to play on. Create an APlayer abstract class to be subclassed by the
    HumanPlayer, and ComputerPlayer classes. The APlayer class should have variables used in the ComputerPlayer
     and HumanPlayer classes to hold the name and board piece the player will be using, as well as methods to
     get and set the names and board piece (mark) being used by the player. Lastly, their should be abstract
     methods for selecting a board and a position. The main class can be modified to test player vs player,
     AI vs AI, and Player vs AI by changing the created player objects in the setPlayers method call.
 */
/* Design
    In the Board class create variables to hold the full status of the board, the winner of the board if there
    is one, and an array to hold the characters of the board. The default board constructor should fill the
    board with '-' characters to signify an empty position. The board class has methods checkFull, isFull, whoWon,
    boardWin, getRow, makeMove, validMove, and moveList. The method checkFull iterates through the array holding
    the pieces in the board and counts the number of empty spaces. If there are empty spaces then the boolean
    variable holding the status of the mini-board remains false, otherwise the boolean will be changed to true.
    The isFull returns if the mini-board is full, and the whoWon method returns which piece won the board.
    The boardWin method checks if a winner for the mini-board has been determined, if one has not then it checks
    all possible winning scenarios to determine a winner. The getRow method is used for printing the array values
    row by row for board display. The makeMove method is used to make a move and calls on the validMove method
    to ensure the space being chosen is empty. It returns the position that is now occupied to be used for
    the following move. The moveList method returns a string that represents all open spaces in the mini-board.
    The TTTGame constructor calls setPlayers and setBoard to prepare a game. The setBoard method will add 9
    board objects to an ArrayList of boards, and the default setPlayers method creates two computer players.
    The switchPlayer method changes the current player index to change the player turn. The askMove method
    simulates a move where the player can choose the board and position, whereas the nextMove method uses
    a variable that stores the position of the last move as its board number for the makeMove method. The display
    method prints the boards row by row with 3 boards in each row. The isWinner method checks all possible
    scenarios for a win and returns false if there is not a winner. The gameOver method calls the isWinner method
    to determine if a winner has been found, otherwise it checks for a tie by using a for-each loop to check
    if any board is not full. The legalMoves method without parameters prints all legal moves given that any board
    is in play. The legalMoves method with parameters prints all legal moves at the chosen board. The ComputerPlayer
    class is a subclass of the APlayer class and uses the super call to store a player name and mark. It also uses
    a random integer generator for AI moves. The HumanPlayer class is also a subclass of the APlayer class. Unlike
    the ComputerPlayer class it does not have methods for random number generation and instead has the selectBoard
    and selectPos method to prompt human players to choose their board and position.
 */

public class Main {
    public static void main(String[] args) {
        TTTGame game = new TTTGame();

        game.setPlayers(new HumanPlayer("Player1",'X'),
                new HumanPlayer("Player2", 'O'));
        game.start();
    }
}


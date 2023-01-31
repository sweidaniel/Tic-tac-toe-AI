//CS2336.0W1 Matthew Lai

import java.util.ArrayList;

public class TTTGame {
    private final APlayer[] players = new APlayer[2];
    private final char[] marks = {'X', 'O'};
    int currentPlayerIndex = 0;
    final int numOfBoards = 9;
    int lastMove;
    ArrayList<Board> boards = new ArrayList<Board>();


    public TTTGame()  {
        setPlayers();
        setBoard();
    }

    private void setBoard()  {
        for (int i = 0; i < numOfBoards; i++)
            boards.add(new Board());
    }
    private void setPlayers()  {
        for(int i = 0; i < players.length; i++)  {
            ComputerPlayer p = new ComputerPlayer("player" + i+1 , marks[i]);
            players[i] = p ;
        }
    }

    public void setPlayers(APlayer player1, APlayer player2)  {
        players[0] = player1;
        players[1] = player2;
    }

    //Alternates the players
    private void switchPlayer()  {
        if(currentPlayerIndex == 1) currentPlayerIndex = 0;
        else if(currentPlayerIndex == 0) currentPlayerIndex = 1;
    }

    //Loop that starts and runs the game until a conclusion is reached
    public void start()  {
        System.out.println("Game start!");
        display();
        System.out.println("Current player is: " + players[this.currentPlayerIndex].getMark());
        askMove();
        display();
        System.out.println("Because of the previous players move, the next move must" +
                " be on board " + lastMove);
        do  {
            switchPlayer();
            System.out.println("Current player is: " + players[this.currentPlayerIndex].getMark());
            if(boards.get(lastMove).isFull())
                askMove();
            else
                nextMove();
            display();
            System.out.println("Because of the previous players move, the next move must" +
                    " be on board " + lastMove);
        }while(!gameOver());
    }

    //Method for move that does not have predetermined board
    public void askMove()  {
        legalMoves();
        System.out.println();
        do {
            lastMove = boards.get(players[this.currentPlayerIndex].selectBoard(numOfBoards - 1))
                    .makeMove(players[this.currentPlayerIndex].selectPos(numOfBoards - 1),
                            players[this.currentPlayerIndex].getMark());
        }while(lastMove == -1);
    }

    //Method for move that has predetermined board
    public void nextMove()  {
        int tempMove;
        legalMovesLimited(lastMove);
        do {
            tempMove = boards.get(lastMove)
                    .makeMove(players[this.currentPlayerIndex].selectPos(numOfBoards - 1),
                            players[this.currentPlayerIndex].getMark());
        }while(tempMove == -1);
        lastMove = tempMove;
    }

    //Prints the board by row
    public void display(){
        System.out.println("Printing board info....");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boards.get(j).getRow(i);
                if(j != 2)
                    System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println("---------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                boards.get(j).getRow(i);
                if(j != 5)
                    System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println("---------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                boards.get(j).getRow(i);
                if(j != 8)
                    System.out.print(" | ");
            }
            System.out.println();
        }

        System.out.println();
    }

    //Calls the isWinner method to check for a winner, otherwise checks if the board is full(tie)
    private boolean gameOver()  {
        if(isWinner()){
            System.out.println("Player " + players[this.currentPlayerIndex].getMark() + " wins!");
            return true;
        }
        else  {
            for (Board b: boards) {
                if(!b.isFull())
                    return false;
            }
        }
        System.out.println("There are no more spaces left, tie game!");
        return true;
    }

    //Calls all check methods to determine if there is a winner
    private boolean isWinner()  {
        if(checkRow()) return true;
        else if (checkCol()) return true;
        else if (checkDiagLR()) return true;
        else if (checkDiagRL()) return true;
        return false;
    }

    //Checks all rows for a winner
    private boolean checkRow() {
        for(int i = 0; i < 3; i++) {
            if (boards.get(i).whoWon() == '=')
                return false;
            else if (boards.get(i).whoWon() == boards.get(i + 1).whoWon()
            && boards.get(i + 1).whoWon() == boards.get(i + 2).whoWon())
                return true;
        }
        return false;
    }

    //Checks all columns for a winner
    private boolean checkCol() {
        for(int i = 0; i < 3; i++) {
            if (boards.get(i).whoWon() == '=')
                return false;
            else if (boards.get(i).whoWon() == boards.get(i + 3).whoWon()
                    && boards.get(i + 3).whoWon() == boards.get(i + 6).whoWon())
                return true;
        }
        return false;
    }

    //Checks the left to right diagonal for a winner
    private boolean checkDiagLR() {
        if (boards.get(0).whoWon() == '=')
                return false;
            else if (boards.get(0).whoWon() == boards.get(4).whoWon()
                    && boards.get(4).whoWon() == boards.get(8).whoWon())
                return true;
        return false;
    }

    //Checks the right to left diagonal for a winner
    private boolean checkDiagRL() {
        if (boards.get(2).whoWon() == '=')
            return false;
        else if (boards.get(2).whoWon() == boards.get(4).whoWon()
                && boards.get(4).whoWon() == boards.get(6).whoWon())
            return true;
        return false;
    }

    //Prints legal moves for all boards
    private void legalMoves()  {
        System.out.println("Legal Moves:");
        for(int i = 0; i < numOfBoards; i++){
            System.out.print("Board " + i + ": "
                    + boards.get(i).moveList());
            System.out.println();
        }
    }

    //Prints legal moves for a specific board
    private void legalMovesLimited(int num) {
        System.out.println("Legal Moves:");
        System.out.print("Board " + num + ": "
                    + boards.get(num).moveList());
        System.out.println();
    }
}


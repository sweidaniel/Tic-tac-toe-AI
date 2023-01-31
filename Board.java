//CS2336.0W1 Matthew Lai

import java.util.Arrays;

public class Board {
     boolean full = false;
     char winner = '=';
     char[] board = new char[9];

     //Fills the array representing the board
     public Board()  {
         Arrays.fill(board, '-');
     }

     //Checks if the board is full
     public void checkFull(){
         int count = 0;
         for (char c: board) {
             if (c == '-') {
                 count++;
             }
         }
         full = count < 1;
     }

     //Returns the full status of the board
     public boolean isFull(){
         return full;
     }

     //Returns the winner status of the board, '=' represents no winner
     public char whoWon(){
         return winner;
     }

     //Determines if there is a winning scenario reached
     public void boardWin(){
         if(winner == '=') {
             if (board[0] != '-' && board[0] == board[1] && board[1] == board[2])
                 winner = board[0];
             if (board[3] != '-' && board[3] == board[4] && board[4] == board[5])
                 winner = board[3];
             if (board[6] != '-' && board[6] == board[7] && board[7] == board[8])
                 winner = board[6];
             if (board[0] != '-' && board[0] == board[3] && board[3] == board[6])
                 winner = board[0];
             if (board[1] != '-' && board[1] == board[4] && board[4] == board[7])
                 winner = board[1];
             if (board[2] != '-' && board[2] == board[5] && board[5] == board[8])
                 winner = board[2];
             if (board[0] != '-' && board[0] == board[4] && board[4] == board[8])
                 winner = board[0];
             if (board[2] != '-' && board[2] == board[4] && board[4] == board[6])
                 winner = board[2];
        }
     }

     //Prints a desired row of the board
     public void getRow(int row){
         switch (row) {
             case 0 -> {
                 System.out.print(board[0]);
                 System.out.print(board[1]);
                 System.out.print(board[2]);
             }
             case 1 -> {
                 System.out.print(board[3]);
                 System.out.print(board[4]);
                 System.out.print(board[5]);
             }
             case 2 -> {
                 System.out.print(board[6]);
                 System.out.print(board[7]);
                 System.out.print(board[8]);
             }
         }
     }

     //Checks if a valid move was made and updates the full and winner status of the board
    //returns position for the board of the following move
     public int makeMove(int pos, char mark){
         if(validMove(pos)){
             board[pos] = mark;
             checkFull();
             boardWin();
             return pos;
         }
         System.out.println("Invalid move, please try again");
         return -1;
     }

     //Determines whether the move is valid by checking for a dash that represents empty space
     public boolean validMove(int pos){
         return board[pos] == '-';
     }

     //Provides a list of the open spaces in the mini-board
     public String moveList()  {
         StringBuilder moveList = new StringBuilder();
         for(int i = 0; i < board.length; i++) {
             if (board[i] == '-')
                 moveList.append(i).append(", ");
         }
         return moveList.toString();
     }
}

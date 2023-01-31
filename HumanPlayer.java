//Matthew CS2336.0W1

import java.util.Scanner;

public class HumanPlayer extends APlayer{
    Scanner input = new Scanner(System.in);
    public HumanPlayer(String name, char mark)  {
        super(name, mark);
    }
    @Override
    public int selectBoard(int num) {
        System.out.println("\nplease enter a valid board number (0 to " + num + ")");
        int boardNum;
        do  {
            boardNum = input.nextInt();
        }while(boardNum < 0 && boardNum > num);
        return boardNum;
    }

    @Override
    public int selectPos(int num) {
        System.out.println("\nplease enter a valid position number (0 to " + num + ")");
        int pos;
        do  {
            pos = input.nextInt();
        }while(pos < 0 && pos > num);
        return pos;
    }
}

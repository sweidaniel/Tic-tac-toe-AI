//Matthew CS2336.0W1

import java.util.Random;
public class ComputerPlayer extends APlayer {

    public ComputerPlayer(String name, char mark)  {
        super(name, mark);
    }

    private int randomNumber(int num){
        Random rand = new Random();
        return rand.nextInt(num + 1);
    }

    @Override
    public int selectBoard(int num) {
        return randomNumber(num);
    }

    @Override
    public int selectPos(int num) {
        return randomNumber(num);
    }
}

//Matthew Lai CS2336.0W1

public abstract class APlayer {
    private String name;
    private char mark;

    public APlayer(String name, char mark)  {
        setName(name);
        setMark(mark);
    }

    public String getName()  {
        return name;
    }

    public void setName(String name)  {
        this.name = name;
    }

    public char getMark()  {
        return mark;
    }

    public void setMark(char mark)  {
        this.mark = mark;
    }

    public abstract int selectBoard(int num);

    public abstract int selectPos(int num);
}
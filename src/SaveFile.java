import java.net.IDN;

public class SaveFile{
    private Player player;
    private int ID = 1000;
    private int IDNum;

    public SaveFile(Player player){
        this.player = player;
        IDNum = ID;
        ID++;
    }

    public Player getPlayer(){
        return player;
    }

    public int getIDNum(){
        return IDNum;
    }

    public boolean confirmIDNum(int IDNum){
        return this.IDNum == IDNum;
    }

    public String stats(){
        String str = "ID Number: " + IDNum;
        str += "\n" + player.toString();
        return str;

    }

}

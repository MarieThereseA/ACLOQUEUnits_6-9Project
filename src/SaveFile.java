import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveFile implements Serializable{
    public static int ID = 1000;
    public int IDNum;

    public SaveFile(String userName){
        IDNum = ID;
        try{
            FileWriter fw = new FileWriter("Data.txt",true);
            PrintWriter out = new PrintWriter(fw);
            out.println("uN:" + userName + "|" + "ID:" + IDNum + "|" + "b:" + "$500" + "|" + "blackC:"
                    + "1" + "|" + "blueC:" + "20" + "|" + "greenC" + "8" + "|" + "gP:" + "0" + "|" + "gW:" + "0"
                    + "|" + "gL:" + "0" + ";");
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        ID++;
    }

    public SaveFile(){

    }

    public int getIDNum(){
        return IDNum;
    }

    public boolean confirmIDNum(String userName, int num){
        File file = null;
        Scanner scanner = null;
        try{
            file = new File("src/Data.txt");
            scanner = new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        String line = "";
        while (!line.contains(userName)){
            line = scanner.nextLine();
        }

        if (line.contains(userName) && line.contains(num + "")){
            return true;
        }else {
            return false;
        }

        public void updateData(String x, int update)
    }

}

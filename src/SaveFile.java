import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveFile implements Serializable{
    private static int ID = 1000;
    private int IDNum;
    private File file;

    public SaveFile(String userName){
        IDNum = ID;
        FileWriter fw = null;
        file = new File("src/Data.txt");
        try{
            fw = new FileWriter(file,true);
        } catch (Exception e){
            e.printStackTrace();
        }
        PrintWriter out = new PrintWriter(fw);
        out.println("uN:" + userName + "|" + "ID:" + IDNum + "|" + "b:" + "$500" + "|" + "blackC:"
                + "1" + "|" + "blueC:" + "20" + "|" + "greenC" + "8" + "|" + "gP:" + "0" + "|" + "gW:" + "0"
                + "|" + "gL:" + "0" + ";");
        out.close();
        ID++;
        file = new File("src/Data.txt");
    }

    public SaveFile(){
        file = new File("src/Data.txt");
    }

    public int getIDNum(){
        return IDNum;
    }

    public String getData(String userName, int num){
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        String line = "";
        while(!(line.contains(userName) && line.equals(num + ""))){
            line = scanner.nextLine();
        }
        scanner.close();
        return line;
    }

    public boolean confirmIDNum(String userName, int num){
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        String line = "";
        while (!line.contains(userName)){
            line = scanner.nextLine();
        }
        scanner.close();

        if (line.contains(userName) && line.contains(num + "")){
            return true;
        }else {
            return false;
        }

    }

    public void updateData(int num,String dataType, int update){

    }

}

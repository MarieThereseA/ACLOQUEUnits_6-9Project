import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveFile implements Serializable{
    private int IDNum;
    private String data;
    private File file;
    private Scanner scanner;
    private FileWriter fw;
    private PrintWriter out;

    private FileReader fr;
    private BufferedReader br;

    public SaveFile(String userName){
        fw = null;
        file = new File("src/Data.txt");
        data = "";
        try{
            fw = new FileWriter(file,true);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            IDNum = Integer.parseInt(br.readLine());
        } catch (Exception e){
            e.printStackTrace();
        }
        out = new PrintWriter(fw);
        out.println("uN:" + userName + "|" + "ID:" + IDNum + "|" + "b:" + "$500" + "|" + "blackC:"
                + "1" + "|" + "blueC:" + "20" + "|" + "greenC:" + "8" + "|" + "gP:" + "0" + "|" + "gW:" + "0"
                + "|" + "gL:" + "0" + ";");
    }

    public SaveFile(){
        file = new File("src/Data.txt");
        fw = null;
        try{
            fw = new FileWriter(file,true);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            IDNum = Integer.parseInt(br.readLine());
        } catch (Exception e){
            e.printStackTrace();
        }
        out = new PrintWriter(fw);
    }

    public int getIDNum(){
        return IDNum;
    }

    public String getData(){
        return data;
    }

    public boolean confirmIDNum(String userName, int num) {
        String line = "";
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (Exception e){
            e.printStackTrace();
        }
        while (line != null && !(line.contains(userName) && line.contains(num + "")) ) {
            try {
                line = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (line == null){
            return false;
        }else {
            if (line.contains(userName) && line.contains(num + "")) {
                data = line;
                return true;
            } else {
                return false;
            }
        }
    }

//        while (!line.contains(userName)){
//            line = scanner.nextLine();
//        }
//
//        if (line.contains(userName) && line.contains(num + "")){
//            return true;
//        }else {
//            return false;
//        }


    public void updateData(int num,String dataType, int update){

    }

//    public String print(){
//        return scanner.toString();
//    }

}

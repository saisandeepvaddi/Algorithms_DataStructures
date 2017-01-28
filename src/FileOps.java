import java.io.*;

/**
 * Created by Sandeep on 10/25/2016.
 */

class MyException extends Exception{
    MyException(){
        System.out.println("This is your exception");
    }
    MyException(String msg){
        System.out.println(msg);
    }
}


public class FileOps{
    public static void main(String[] args) throws MyException{
//        FileInputStream in = new FileInputStream("C:\\Users\\Sandeep\\Desktop\\Programs\\DataStructures\\src\\readme.txt");
//        FileOutputStream out = new FileOutputStream("C:\\Users\\Sandeep\\Desktop\\Programs\\DataStructures\\src\\writeme.txt");
//        byte[] b = new byte[1024];
//        int r;
//        while((r = in.read(b))>=0){
//            out.write(b);
//        }
//        in.close();
//        out.close();

        try{
            File inFile = new File("C:\\Users\\Sandeep\\Desktop\\Programs\\DataStructures\\src\\readme.txt");
//            File outFile = new File("C:\\Users\\Sandeep\\Desktop\\Programs\\DataStructures\\src\\writeme.txt");
            File outFile = new File("C:\\Users\\Sandeep\\Desktop\\Programs\\DataStructures\\src\\writem.txt");
            outFile.setWritable(false);
            BufferedReader in = new BufferedReader(new FileReader(inFile));
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
            String line = "";
            while ((line = in.readLine()) != null){
                out.write(line);
                out.write("\n");
            }
            in.close();
            out.close();
        }
        catch (Exception e){
            throw new MyException();
        }




    }
}

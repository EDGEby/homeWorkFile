package HomeWorkFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        try(
                FileWriter fw = new FileWriter(fullNameResult, false);
                FileReader fr = new FileReader(fullNameTask);
        ){
            int cache;
            while ((cache = fr.read()) != -1){
                if (cache != ' '){
                    fw.append((char) cache);
                }
            }
            fw.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }


    static  final String fileNameTask = "task2";
    static final String fileNameResult = "result";
    static final String fileType = ".txt";
    static final String folderName = System.getProperty("user.dir");
    static final  String fullNameTask = folderName + File.separator + fileNameTask + fileType;
    static final String fullNameResult = folderName + File.separator + fileNameResult + fileType;
}

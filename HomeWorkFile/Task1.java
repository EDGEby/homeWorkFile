package HomeWorkFile;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name file by save : ");
        String fileName = in.next();
        String fileType = ".txt";
        String folderName = System.getProperty("user.dir");
        String fullName = folderName + File.separator + fileName + fileType;
        String stop = "stop";
        File file = new File(fullName);
        try {
            if (file.createNewFile()){
                System.out.println("File " + fileName + fileType + " create.");
            }
            else {
                System.out.println("You have a file " + fileName + fileType );
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        if (isEmptyFile(fullName)){
            System.out.println("Enter the text to save to a file: ");
        }
        else {
            System.out.println("The file already contains text. Enter the text to add to the file: ");
        }
        while (true){
            try(
                    FileWriter fileWriter = new FileWriter(fullName, true);
            ){
                String text = new BufferedReader(new InputStreamReader(System.in)).readLine();
                if (text.equals(stop)){
                    System.out.println("The recording is over. File contains: " + new BufferedReader(new FileReader(fullName)).readLine());
                    fileWriter.close();
                    break;
                }
                else {
                    fileWriter.write(text + " ");
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    static boolean isEmptyFile(String fullName){
        boolean result = false;
        try(
                FileReader fr = new FileReader(fullName);
                BufferedReader br = new BufferedReader(fr);
                ) {
            result = br.lines().toArray().length == 0;
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
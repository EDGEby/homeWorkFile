package HomeWorkFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        final String folderName = System.getProperty("user.dir") + File.separator + "users";
        File file = new File(folderName);
        List<String> pacKage;
        List<User> newUsers;
        List<User> users = new ArrayList<User>(Arrays.asList(new User("Don", "Kihot", 30),
                new User("Kai", "Sa", 20), new User("Pavel", "Durov", 50),
                new User("Bel", "Vet", 33), new User("Krosh", "Yuojik", 44),
                new User("Sami", "Ra", 25), new User("Jinks", "Powder", 22)));
        if (!file.exists()){
            if (file.mkdir()) System.err.println("Catalog " + folderName + " create");
            else System.err.println("Failed to create a directory.");
        } else
            System.err.println("The directory already exists");

        for(User user : users){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderName + File.separator + user.toString()+".txt"))){
                oos.writeObject(user);
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
        System.out.println();
        pacKage = new ArrayList<>(Arrays.asList(file.list()));
        newUsers = new ArrayList<>(pacKage.size());
        for (String str : pacKage){
            try(ObjectInputStream i = new ObjectInputStream(new FileInputStream(folderName + File.separator + str));) {
                newUsers.add((User) i.readObject());
            }catch (IOException e){
                System.err.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        for (User user : newUsers){
            System.out.println(user.get());
        }
    }
}

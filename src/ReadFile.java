import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner; // Import the Scanner class to read text files
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static void main(String[] args) {
        try{
            Path of = Path.of("Characters.txt");
            int fileLength = 0;
            ArrayList<String> allLines = (ArrayList<String>) Files.readAllLines(of);
            fileLength = allLines.size();
            for (int n = 0; n < fileLength; n+=2) {
                int type = Integer.parseInt(Files.readAllLines(of).get(n).substring(0, 1));
                String name = Files.readAllLines(of).get(n).substring(1);
                int[] stats = arrayRead(Files.readAllLines(of).get(n + 1));
                n += 2;
                Character test;
                if (type == 1) {
                    test = new Gunslinger(name, stats);
                } else if (type == 2) {
                    test = new Melee(name, stats);
                } else {
                    test = new Character(name, stats);
                }
                System.out.println(test);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] arrayRead (String s){
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(",")){
                count++;
            }
        }
        int[] array = new int[count];
        s = s.substring(1, s.length()-1);
        String[] temp = s.split(", ");
        for (int i = 0; i < temp.length; i++) {
            array[i] = Integer.parseInt(temp[i]);
        }
        return array;
    }
}
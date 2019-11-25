package assignments8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        System.out.println("Enter the directory of the file: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        System.out.println("Enter a word to find: ");
        String word = sc.nextLine();

        try {
            BufferedReader input = new BufferedReader(new FileReader(path));
            String line;
            try {
                while ((line = input.readLine()) != null){
                    if (line.contains(word)) System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
package com.rxy;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //Create input stream and scanner
        FileInputStream fin = new FileInputStream("sample_words.txt");
        String path = String.valueOf(FileSystems.getDefault().getPath("sample_words.txt"));
        Scanner fileInput = new Scanner(fin);

        countWord(fileInput);
        fileInput.close();
        fin.close();

        System.out.println("Would you like to replace any words? (Y/N)");
        Scanner userInput = new Scanner (System.in);

        if (userInput.next().equals("y")) {
            System.out.println("Type in the word inside the txt file that you would like to replace: ");
            String oldWord = new Scanner(System.in).nextLine();
            System.out.println("What word would you like to replace it with: ");
            String newWord = new Scanner(System.in).nextLine();

            replaceWord(path, oldWord, newWord);
        }
    }

    public static void countWord(Scanner fileInput) {
        //Creating two ArrayList to hold different words and occurrence of each word
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        //Read through file and find the words
        while (fileInput.hasNext()) {
            String nextWord = fileInput.next();

            //Determine if the word is already in ArrayList words, if not add it to the ArrayList and count + 1 for that word in Array
            if (words.contains(nextWord)) {
                int index = words.indexOf(nextWord);
                count.set(index, count.get(index) + 1);
            } else {
                words.add(nextWord);
                count.add(1);
            }
        }

        //Print occurrence
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + " occurred " + count.get(i) + " time(s)");
        }
        System.out.println("--------END OF WORD COUNT--------");
        System.out.println();
    }

    static void replaceWord(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();

            while (line != null){
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Using the \b regex command will match on a word boundary
            String regex = "\\b" + oldString + "\\b";
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(regex, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e){ e.printStackTrace();
        } finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
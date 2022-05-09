package com.rxy;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //Create input stream and scanner
        System.out.println("Enter the name of the txt file and press enter (Ex: 'test.txt'): ");
        String txtFileName = new Scanner(System.in).nextLine();
        FileInputStream fin = new FileInputStream(txtFileName);
        String path = String.valueOf(FileSystems.getDefault().getPath(txtFileName));
        Scanner fileInput = new Scanner(fin);

        //Main Menu select wordcount feature
        System.out.println("_______MAIN MENU_______");
        System.out.print("Please select one fo the following options:" +
                "\n(1) Count words in txt file" +
                "\n(2) Replace word in txt" +
                "\n(3) Use grepline feature" +
                "\nTYPE OPTION NUMBER AND PRESS ENTER: ");
        Scanner optionSelected = new Scanner (System.in);

        switch (optionSelected.nextInt()) {
            case 1:
                System.out.println("OPTION 1 SELECTED...\n");
                countWord(fileInput);
                fileInput.close();
                fin.close();
                System.out.println("***Program Exited. Close and run again for another option***");
                break;
            case 2:
                System.out.println("\nOPTION 2 SELECTED...\n");
                System.out.println("--WORD COUNT OF CURRENT FILE--");
                countWord(fileInput);
                System.out.println("Type in the word inside the txt file that you would like to replace: ");
                String oldWord = new Scanner(System.in).nextLine();
                System.out.println("What word would you like to replace it with: ");
                String newWord = new Scanner(System.in).nextLine();
                replaceWord(path, oldWord, newWord);
                System.out.println("--WORD COUNT OF NEW FILE--");
                countWord(fileInput);
                System.out.println("***Program Exited. Close and run again for another option***");
                break;
            case 3:
                System.out.println("\nOPTION 3 SELECTED...\n");
                System.out.println("Type in the word you would like to find:");
                String findWord = new Scanner(System.in).nextLine();
                grepline(fileInput, findWord);
                System.out.println("***Program Exited. Close and run again for another option***");
                break;
            default:
                System.out.println("Incorrect/No option selected. Run program again to use a word count feature.");
                fileInput.close();
                fin.close();
                break;
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

    static void replaceWord(String filePath, String oldString, String newString) {
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

    static void grepline(Scanner fileInput, String findWord) throws FileNotFoundException {

        // Let's loop through each line of the file
        while (fileInput.hasNext()) {
            String line = fileInput.nextLine();

            // Now, check if this line contains our keyword. If it does, print the line
            if (line.contains(findWord)) {
                System.out.println(line);
            }
        }
    }
}
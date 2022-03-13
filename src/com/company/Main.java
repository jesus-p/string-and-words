package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    //Create input stream and scanner
        FileInputStream fin = new FileInputStream("sample_words.txt");
        Scanner fileInput = new Scanner(fin);

        //Create the ArrayLists
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        
        //Read through file and find the words
        while(fileInput.hasNext()) {
            //Get the next word
            String nextWord = fileInput.next();
            //Determine if the word is in the ArrayList, if not add it to the ArrayList and count + 1
            if (words.contains(nextWord)) {
                int index = words.indexOf(nextWord);
                count.set(index, count.get(index) + 1);
            } else {
                words.add(nextWord);
                count.add(1);
            }
        }

        fileInput.close();
        fin.close();

        //Print out the results
        for(int i = 0; i < words.size(); i++){
            System.out.println(words.get(i) + " occurred " + count.get(i) + " time(s)");
        }
    }
}

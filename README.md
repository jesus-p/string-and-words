# Course Project: String-and-Words

This program performs various word statistics of a given document (as a string). The current program was designed to satisfy current checkpoint requirements.

**Included:**
- This README
- Source files
- Test files
- Project Requirement files

## Dev Enviroment
The current submission is a standalone Java program. The project was built using the IntellijIdea IDE  
  

## Running Program
The program can be compiled and executed with Java in Linux  

1. Go to the Main folder (/string-and-words/src/com/rxy/Main.java) 
  
2. Compile each Java file producing ClassName.class files  
`$ javac Main.java`
  
3. Execute the class while in the src folder  
`$ java com.rxy.Main`



## User Stories
### 1st Requirement
The initial requirement was to count the frequency of each unique word. The code should support combinations of space, tab, and newline characters as separators.

The program was developed to count the frequency of words in a given document (txt file). The user of the program will input a .txt file and get an out of unique words and their occurrences, where the words are separated by space/tab/newline characters.
  
**Example**  
Input (via .txt file):  
>Hello world this is a test text file  
Hello world  
hello World  
    
    
Output (via system ouput):  
>Hello occurred 2 time(s)  
world occurred 2 time(s)  
this occurred 1 time(s)  
is occurred 1 time(s)  
a occurred 1 time(s)  
test occurred 1 time(s)  
text occurred 1 time(s)  
file occurred 1 time(s)  
hello occurred 1 time(s)  
World occurred 1 time(s)  
--------END OF WORD COUNT--------  
  
  
### 2nd Requirement
The second requirement change is to allow replacement of all occurrences of a given word to a given replacement word. Note that the replacement happens only when the given pattern word matches with a whole word. For example, for text “ab cd ef”, replace “a” with “b” will result in no change, while replace “ab” with “cd” will result in “cd cd ef”.

The user of the program will input a .txt file and get an out of unique words and their occurrences, as before. After, the user will have the option to replace any word in the user's input file. For this example the user wants to change all the occurrences of "Hello" to "Hi".  

**Example**  
Input (via .txt file):  
>Hello world this is a test text file  
Hello world  
hello World 
  
    
Output (via system ouput):  
>Hello occurred 2 time(s)  
world occurred 2 time(s)  
this occurred 1 time(s)  
is occurred 1 time(s)  
a occurred 1 time(s)  
test occurred 1 time(s)  
text occurred 1 time(s)  
file occurred 1 time(s)  
hello occurred 1 time(s)  
World occurred 1 time(s)  
--------END OF WORD COUNT--------  
Would you like to replace any words? (Y/N)  
y  
Type in the word inside the txt file that you would like to replace:   
Hello  
What word would you like to replace it with:   
Hi   
Process finished with exit code 0    
  
  
Output (via edited .txt file):  
>Hi world this is a test text file  
Hi world  
hello World  
  

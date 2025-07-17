# String and Words

This program lets you analyze and make changes to the words in a text file. It tells you how often each word appears, lets you replace words, and can show you lines that contain a certain word.

## What's Included

- This README file
- Program files (the code)
- Files for testing the program
- Project guidelines/requirements
- Results from code similarity checker (NiCad 6.2)

## Development Environment

- This project is a self-contained Java program.
- It was created using the IntelliJ IDEA application.

## How to Run the Program

1. Find the Main.java file here:  
   `/string-and-words/src/com/rxy/Main.java`
2. Open a terminal and move to the folder with Main.java.
3. Compile the program with:
   ```bash
   javac Main.java
   ```
4. Go to the `src` folder and run the program with:
   ```bash
   java com.rxy.Main
   ```
5. Make sure your text file is in the main folder where the program is located.

## What the Program Does

### 1. Count Word Frequency

- The program reads a text file and tells you how many times each word appears.
- It treats spaces, tabs, and new lines as ways to separate words.

**Example:**  
If your file contains:
```
Hello world this is a test text file
Hello world
hello World
```
The output will be:
```
Hello occurred 2 time(s)
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
```

### 2. Replace Specific Words

- After counting the words, you have the option to replace any word with another one.
- Replacements only happen for whole words (for example, "cat" will not replace "catnap").
- For instance, you can change every "Hello" in the file to "Hi".

**Example:**  
You choose to replace "Hello" with "Hi", then the file changes to:
```
Hi world this is a test text file
Hi world
hello World
```

### 3. Find Lines with a Specific Word (Grepline Feature)

- The program can show you all lines from your file that contain a specific word.
- Again, it only matches whole words (for example, "cat" matches "cat", but not "catalog").

Feel free to let me know if you need help running the program or using any of its features!

package com.rxy;
import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void countWord() {
        var main = new Main();
        String expectedString = "Hi occurred 2 time(s)\n" +
                "this occurred 1 time(s)\n" +
                "is occurred 2 time(s)\n" +
                "test occurred 2 time(s)\n" +
                "txt occurred 2 time(s)\n" +
                "line occurred 4 time(s)\n" +
                "2 occurred 1 time(s)\n" +
                "This occurred 1 time(s)\n" +
                "the occurred 2 time(s)\n" +
                "second occurred 1 time(s)\n" +
                "3 occurred 1 time(s)\n" +
                "from occurred 1 time(s)\n" +
                "third occurred 1 time(s)\n" +
                "End occurred 1 time(s)\n" +
                "of occurred 1 time(s)\n" +
                "--------END OF WORD COUNT--------\n";
        String txtFileName = "test.txt";
    }

    @org.junit.jupiter.api.Test
    void grepline() {
        String expectedString = "Hi this is test txt\n" +
                "line 3 Hi from the third line";

    }
}
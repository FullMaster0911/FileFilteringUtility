package com.example;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileRecording {
    public void writeFile(String output, String prefix, boolean append, List<Integer> integers, List<Float> floats,
                          List<String> strings) {
        writeToFile(new File(output,prefix + "integers.txt"), append, integers);
        writeToFile(new File(output,prefix + "floats.txt"), append, floats);
        writeToFile(new File(output,prefix + "strings.txt"), append, strings);
    }

    private <T> void writeToFile(File file, boolean append, @NotNull List<T> data) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(file, append))){
            for(T element : data) {
                pw.println(element);
            }
        }catch(IOException e) {
            System.out.println("Write error!");
        }
    }
}

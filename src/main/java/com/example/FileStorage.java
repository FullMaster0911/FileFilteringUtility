package com.example;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileStorage {
    public void saveFile(String inputFile, List<Integer> integers, List<Float> floats, List<String> strings) {
        try(BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while((line = br.readLine()) != null) {
                saveLine(line, integers, floats, strings);
            }
        }catch(IOException e) {
            System.out.println("File reading error!");
        }
    }

    private void saveLine(String line, @NotNull List<Integer> integers, List<Float> floats, List<String> strings) {
        try{
            integers.add(Integer.parseInt(line));
        }catch(NumberFormatException e) {
            try{
                floats.add(Float.parseFloat(line));
            }catch(NumberFormatException e1) {
                strings.add(line);
            }
        }
    }
}

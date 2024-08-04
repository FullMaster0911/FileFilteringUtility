package com.example;

import org.apache.commons.cli.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FileFilterUtil {
    public static void main(String[] args) {
        Options options = createNewOptions();
        CommandLine cmd = parseCmdLine(options, args);

        if(cmd == null) {
            return;
        }

        String output = cmd.getOptionValue("o", ".");
        String prefix = cmd.getOptionValue("p", "");
        boolean append = cmd.hasOption("a");
        boolean shortStat = cmd.hasOption("s");
        boolean fullStat = cmd.hasOption("f");
        List<String> inputFiles = cmd.getArgList();

        List<Integer> integers = new ArrayList<>();
        List<Float> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();


        FileStorage fileStorage = new FileStorage();
        for(String inputFile : inputFiles) {
            fileStorage.saveFile(inputFile, integers, floats, strings);
        }

        FileRecording fileRecording = new FileRecording();
        fileRecording.writeFile(output, prefix, append, integers, floats, strings);

        FileStatistics fileStatistics = new FileStatistics();
        if (shortStat) {
            fileStatistics.printShortStatistics(integers, floats, strings);
        }
        if (fullStat) {
            fileStatistics.printFullStatistics(integers, floats, strings);
        }
    }

    private static @NotNull Options createNewOptions() {
        Options options = new Options();

        options.addOption("o", "output", true, "Output directory");
        options.addOption("p", "prefix", true, "Output files prefix");
        options.addOption("a", "append", false, "Append to existing file");
        options.addOption("s", "shortStat", false, "Short statistics");
        options.addOption("f", "fullStat", false, "Full statistics");
        return options;
    }

    private static @Nullable CommandLine parseCmdLine(Options options, String[] args) {
        CommandLineParser parser = new DefaultParser();

        try{
            return parser.parse(options, args);
        }catch (ParseException e) {
            System.out.println("Parsing error!");
            return null;
        }
    }
}
package io.not2excel.logging;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * Copyright (C) 2011-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 *
 * This file is part of GuildCore.
 *
 * errors can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

public class FileLogger {

    private static final JavaPlugin PLUGIN = JavaPlugin.getProvidingPlugin(FileLogger.class);

    protected static void logToFile(Throwable thrown, String pluginName)
            throws IOException {

        //Get the path to the folder using the plugin's name
        String folderpath = PLUGIN.getDataFolder() + File.separator + pluginName;

        //Create the folder
        File folder = new File(folderpath);

        //Crate folder if it doesn't exist
        if (!folder.exists())
            folder.mkdir();


        //Create the file to the .log using the date from above
        File file = new File(folderpath
                + File.separator
                + new SimpleDateFormat("dd-MM-yyyy").format(new Date())
                + ".log");

        //Create file if it doesn't exist
        if (!file.exists())
            file.createNewFile();

        String alternateReport = getAlternateReport(file, ExceptionUtils.getStackTrace(thrown));

        FileWriter fileWriter = new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("");
        printWriter.println(new SimpleDateFormat("HH:mm:ss @ MM-dd-yyyy").format(new Date()));
        if(alternateReport == null){
            thrown.printStackTrace(printWriter);
        }else{
            printWriter.println(alternateReport);
        }
        printWriter.close();
        fileWriter.close();
    }

    private static String getAlternateReport(File file, String message) throws IOException {
        //If the file contains the second line of the stack tract.
        String[] stackStrings = message.split("\n", 4);

        if (FileUtils.readFileToString(file).contains(message)) {
            System.out.println(true);
            List<String> fileLines = FileUtils.readLines(file);
            //System.out.println(Pattern.quote(fileLines.get(0)));

            for (int i = 0; i < fileLines.size() - 5; i++) {
                String line1 = fileLines.get(i);
                if (line1.equals("")) {
                    if(!fileLines.get(i+2).contains("Same error as line")){
                        if (stackStrings[0].contains(fileLines.get(i+2))) {
                            boolean equals = true;
                            for (int c = 1; c < 4; c++) {
                                if (!stackStrings[c].contains(fileLines.get(i + 2 + c))) {
                                    equals = false;
                                    break;
                                }
                            }
                            if (equals) {
                                return "Same error as line " + String.valueOf(i+2);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

}

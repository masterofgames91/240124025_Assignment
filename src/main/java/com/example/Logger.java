package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Logger {

OutputStream output;

Logger(String folder, String file){
    // Check to see if the output folder exists and if does not then make it
    File folderHandle = new File(folder);
    if (!folderHandle.exists())
    {
        folderHandle.mkdirs();
    }

    // create/open the file for logging
    try {
        output = new FileOutputStream(file,true); // true to append, false/missing to create new blank file"
    }
    catch (IOException e)
    {
        // exit if we fail
        throw new RuntimeException(e);
    }

}

public void tidyUp(){
    // close the file safely
    try {
    output.close();
    }
    catch (IOException e)
    {
    throw new RuntimeException(e);
    }
}

public void log(String logString){

    // write safely to file or crash gracefully(ish)
    try {
    LocalTime now = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
    String timeStamp = "["+now.format(formatter)+"] ";
    output.write(timeStamp.getBytes());
    output.write(logString.getBytes());
    output.write(System.lineSeparator().getBytes());
    }
    catch (IOException e)
    {
    throw new RuntimeException(e);      
    }
}
}
package com.murata.utility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FolderUtility {

    //move files to Archive folder
    public static void moveFiles(Path folderPath, String folderName, ArrayList<Path> allPaths){

        Path path= Paths.get(folderPath.toString().concat("\\"+folderName));

        IOFileFilter datFilter= FileFilterUtils.suffixFileFilter("dat");

        try {
            FileUtils.copyDirectory(FileUtils.getFile(folderPath.toString()),FileUtils.getFile(path.toString()),datFilter);
            allPaths.stream().forEach(path1 -> {
                try {
                    FileUtils.delete(new File(String.valueOf(path1)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

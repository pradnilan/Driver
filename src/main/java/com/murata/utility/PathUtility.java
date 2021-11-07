package com.murata.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

//read file paths in a given folder, read the sensor id and time stamp for a given path (C:\\x\\y\\ts.sensorID.dat)
public class PathUtility {

    //read the file paths in a given folder
    public static ArrayList<Path> allPaths(Path folderPath) {
        try (Stream<Path> paths = Files.list(folderPath)) {
        ArrayList<Path> arrayList=  paths.filter(path -> path.toString().contains(".dat")).
                    collect(Collectors.toCollection(ArrayList::new));

        return arrayList;

        } catch (IOException e) {
            e.printStackTrace();
         }
        return null;
    }


    // read the latest file paths in a given folder
    public static ArrayList<Path> latestPaths(Path folderPath){

        ArrayList<Path> paths= PathUtility.allPaths(folderPath);
        Map<Integer,List<Path>> map1= paths.stream().collect(groupingBy(e-> PathUtility.readID(e)));

        map1.forEach((id,list)->{list.sort(Comparator.naturalOrder());});

        ArrayList<Path> arrayList= map1.values().stream().map(l->l.get(l.size()-1)).
                collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Only " + arrayList.size() + " latest files are to read");

        return arrayList;
    }

    //read TS from file path
    public static int readTS(Path path){
        String[] str1=path.toString().split("\\\\");
        String[] str2=str1[str1.length-1].split("\\.");
        return Integer.parseInt(str2[0]);
    }

    //read Sensor ID from file path
    public static int readID(Path path){
        String[] str1=path.toString().split("\\\\");
        String[] str2=str1[str1.length-1].split("\\.",-1);
        int id=Integer.parseInt(str2[1]);
        return id;
    }

}

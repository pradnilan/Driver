package com.murata.utility;

import com.murata.model.SensorRaw;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class FileUtility {


    // read lines for a given file/path
    public static String readLine(Path path){

        try {
            return Files.readAllLines(path).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // read all lines of files/paths given as a list
    public static ArrayList<String> allLinesList(ArrayList<Path> paths){

       ArrayList<String> lines= paths.stream().
               map(path -> FileUtility.readLine(path)).collect(Collectors.toCollection(ArrayList::new));

        return lines;
    }

    // read all the lines of files/paths given as a list and return map<sensorID,content of the file as a string>
    public static Map<Integer,String> allLinesMap(ArrayList<Path> paths){

        Map<Integer,String> map= paths.stream().collect(Collectors.
                toMap(p-> PathUtility.readID(p), p-> FileUtility.readLine(p)));

        return map;
    }

    //return list of SensorRaw object (sensorId,ts from file,data string) with latest fileTS for a given list of paths
    public static List<SensorRaw> latestSensorRaw(ArrayList<Path> paths){

        List<SensorRaw> list1=new ArrayList<>();
        List<List<SensorRaw>> list2=new ArrayList<>();
        List<SensorRaw> list3=new ArrayList<>();
        paths.stream().forEach(p -> {

            String sensorId=StringUtils.substring(FileUtility.readLine(p),9,13);
            int fileTs=PathUtility.readTS(p);
            String line=FileUtility.readLine(p);

            SensorRaw sensorRaw=new SensorRaw(sensorId,fileTs,line, LocalDateTime.now());
            list1.add(sensorRaw);

        });

        Map<String,List<SensorRaw>> map1=list1.stream().collect(groupingBy(s->s.getSensorId()));

        map1.forEach((k,v)->{list2.add(v);});

        list2.forEach(l->{
            l.sort(Comparator.naturalOrder());
            list3.add(l.get(l.size()-1));
        });

        return list3;

    }
}

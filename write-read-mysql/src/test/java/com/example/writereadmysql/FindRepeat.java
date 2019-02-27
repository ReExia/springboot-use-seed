package com.example.writereadmysql;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindRepeat {

    public static List<Integer> getRepeatRecord() throws IOException {
        String path1 = "C:\\Users\\admin\\Desktop\\1.txt";
        String path2 = "C:\\Users\\admin\\Desktop\\2.txt";

        Set<Integer> set1 = readFileToSet(path1);
        Set<Integer> set2 = readFileToSet(path2);
        List<Integer> collect = set1.stream().filter(item -> !set2.contains(item)).collect(Collectors.toList());
        System.out.println(collect.size());
        return collect;
//        if (set1.size() > set2.size()){
//            List<Integer> collect = set1.stream().filter(item -> !set2.contains(item)).collect(Collectors.toList());
//            System.out.println(collect.size());
//            return collect;
//        }else {
//            List<Integer> collect = set2.stream().filter(item -> !set1.contains(item)).collect(Collectors.toList());
//            //System.out.println(collect.size());
//            return collect;
//        }
    }

    public static Set<Integer> readFileToSet(String path) throws IOException {
        Set<Integer> result = new HashSet<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            result.add(Integer.valueOf(line));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> repeatRecord = getRepeatRecord();
        repeatRecord.forEach(value -> System.out.println(value));
    }


}



package com.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Point1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Выполняем первое задание");
        System.out.println("Введите пожалуйста плечо квадратной матрицы ");
        BufferedReader reader1 = new BufferedReader( new InputStreamReader( System.in));
        int linecount = 0;
        try {
            linecount = Integer.parseInt(reader1.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<Integer,HashMap<Integer,Integer>> matricaUnsorted = Matrixbilder(linecount);
        MatrixPrinter(matricaUnsorted);
        System.out.println("отсортируем по первой строке");
        HashMap<Integer,HashMap<Integer,Integer>> matrixSortedByFirstLine = MatrixByFirstLineSorter(matricaUnsorted);
        MatrixPrinter(matrixSortedByFirstLine);
        System.out.println("отсортируем каждую третью строку");
        HashMap<Integer,HashMap<Integer,Integer>> matrixWithThrirdLinesortedByMin = MatrixEveryThirdLineSorter(matrixSortedByFirstLine);
        MatrixPrinter(matrixWithThrirdLinesortedByMin);

    }

    public Point1() {
    }



    private HashMap<Integer,HashMap<Integer,Integer>> Matrixbilder(int matrixSize){
        HashMap<Integer,HashMap<Integer,Integer>> matrixx = new HashMap<>();
        Random rn = new Random();
        for (int i = 0; i < matrixSize; i++){
           // System.out.println("создаем столбец " + i);
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for ( int b = 0; b < matrixSize; b++){
                //System.out.println("создаем строку " + b);
                int rndomValue = rn.nextInt(200)-100;
             //   System.out.println("putting in cell " + i + " " + b + " " + rndomValue);
               hashMap.put(b,rndomValue);
            }
          //  System.out.println("putting column "+ i + " " + hashMap);
            matrixx.put(i,hashMap);
        }
        return matrixx;
    }
    private void MatrixPrinter(HashMap<Integer,HashMap<Integer,Integer>> matrixToPrint) {
        for (Integer s : matrixToPrint.keySet()) {
            HashMap<Integer, Integer> column = matrixToPrint.get(s);
         //   System.out.print("получаем столбец " + s);
            for (Integer b : column.values()) {
                // System.out.println(column.keySet());
              //  System.out.print("печатаем элемент столбца " + s);
                System.out.print(b + " ");

            }
            System.out.println();
        }
    }
        private HashMap<Integer,HashMap<Integer,Integer>> MatrixByFirstLineSorter(HashMap<Integer,HashMap<Integer,Integer>> unsortedMatrix){

          //  int max = Integer.MIN_VALUE;

            HashMap<Integer,HashMap<Integer,Integer>> sortedMatrix = new HashMap<>();


                HashMap<Integer,Integer> numLine = sortByValue(unsortedMatrix.get(0));
                sortedMatrix.put(0,numLine);
            //    System.out.println(numLine);
            ArrayList <Integer> wayOfsorting = new ArrayList<>(numLine.keySet());
            System.out.println(wayOfsorting);

            for (int i = 1; i < unsortedMatrix.size(); i++) {
                HashMap<Integer,Integer> unsortedSHash = unsortedMatrix.get(i);
                HashMap<Integer,Integer> sortedSHash = new HashMap<>();
                int b = 0;
                for (Integer s : wayOfsorting){
                sortedSHash.put(b,unsortedSHash.get(s));
                b++;
                }
               // System.out.println("print hash before put");
               // System.out.println(sortedSHash);
                sortedMatrix.put(i,sortedSHash);
                sortedSHash = null;
            }

            return sortedMatrix;
        }
    private HashMap<Integer,HashMap<Integer,Integer>> MatrixEveryThirdLineSorter(HashMap<Integer,HashMap<Integer,Integer>> unsortedMatrix){
        HashMap<Integer,HashMap<Integer,Integer>> sortedMatrix = new HashMap<>(unsortedMatrix);

        for (int i = 2; i < unsortedMatrix.size();){

             //   System.out.println("сортируем строчку" + i);
             //   System.out.println(unsortedMatrix.get(i));
              //  System.out.println();
             //   System.out.println(sortByValueDecent(unsortedMatrix.get(i)));
                sortedMatrix.put(i,sortByValueDecent(unsortedMatrix.get(i)));
            i+=3;
        }


        return sortedMatrix;
    }
    private  <K, V extends Comparable<? super Integer>> HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    private  <K, V extends Comparable<? super Integer>> HashMap<Integer, Integer> sortByValueDecent(HashMap<Integer, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }


    }


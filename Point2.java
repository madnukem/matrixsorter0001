package com.matrix;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Point2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Выполняем второе задание");
        Integer[] arr = new Integer[100001];
        Random rn = new Random();
        for (int i = 0; i <arr.length; i++){
            arr[i] = rn.nextInt(200) - 100;
            }
        System.out.println("массив создан и заполнен");
        Date date = new Date();
        ArraysSorting(arr);
        Date date1 = new Date();
        BubbleSorting(arr);
        Date date2 = new Date();
        SortedByHands(arr);
        Date date3 = new Date();

        System.out.println("Время сортировки средствами Java Arrays составило " + (date1.getTime()-date.getTime()) + "ms" );
        System.out.println("Время сортировки пузырьком составило " + (date2.getTime()-date1.getTime()) + "ms" );
        System.out.println("Время сортировки алгоритмом составило " + (date3.getTime()-date2.getTime()) + "ms" );
    }

    public Point2() {
    }

    private Integer[] ArraysSorting(Integer[] arr){
        Integer[] sortedByArrays = arr;
        Arrays.sort(sortedByArrays);


        return sortedByArrays;
    }
    private  Integer[] SortedByHands(Integer[] arr) {
        Integer[] sorted = arr;
        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int imin = i;

            for (int j = i+1; j < arr.length; j++) {

                if (arr[j] < min) {
                    min = arr[j];
                    imin = j;
                }
            }

            if (i != imin) {
                int temp = arr[i];
                arr[i] = arr[imin];
                arr[imin] = temp;
            }
        }
        return sorted;
    }

    private  Integer[] BubbleSorting(Integer[] arr){
        Integer[] sorted = arr;
        int i;
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for (i = 0; i <sorted.length-1;i++){
                if (sorted[i]<sorted[i+1]){
                    temp=sorted[i];
                    sorted[i] = sorted[i+1];
                    sorted[i+1] = temp;
                    flag = true;
                }
            }
        }


        return  sorted;
    }





}

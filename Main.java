package com.matrix;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("what case you interesting? 1? 2? 3? or q");
        System.out.println("1: задача на матрицы");
        System.out.println("2: задача на сортировку");
        System.out.println("3: доп вопросы");
        System.out.println("q: выход");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String caser = "0";
        while (true){
           try{
              caser = reader.readLine();
              if (caser.equals("1")||caser.equals("2")||caser.equals("q")||caser.equals("3")) break;
           }
           catch (IOException e){
               e.printStackTrace();
           }

        }

        switch (caser){
            case "1" :
                System.out.println("выполняем задачу №1");
                System.out.println();
                Point1 point1 = new Point1();
                point1.run();
                break;

            case "2" :
                System.out.println("выполняем задачу №2");
                System.out.println();
                Point2 point2 = new Point2();
                point2.run();
                break;

            case "3" :
                System.out.println("выполняем текстовое задание");
                System.out.println();
                Additional additional = new Additional();
                additional.run();
                break;

            case "q" :

                try {
                    reader.close();
                    System.out.println("Теперь питание компьютера можно отключить");
                    Thread.currentThread().sleep(1000);
                    } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


        }


    }
}

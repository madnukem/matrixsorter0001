package com.matrix;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Additional implements Runnable {
    @Override
    public void run() {
        System.out.println("различия примитивных и ссылочных типов данных");
        try {
          URI uri = new URI("http://proglang.su/java/datatypes-and-literals?category=java&alias=31");
            java.awt.Desktop.getDesktop().browse(uri);

        } catch (IOException ex) {
            ex.printStackTrace();
        }  catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        System.out.println();
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("инкапсуляция");
        System.out.println();
        System.out.println("Нормальной статьи не нашел, но по факту это модульность построения - корректное использование\n" +
                "приватных переменных, использование get set, отсутвие прямого доступа внутрь класса или библиотеки,\n" +
                "что дает возможность исправлять или изменять класса не руша весь проект т.к. запрещает использовать \n" +
                "внутренние переменные или методы класса.");

    }

    public Additional() {
    }
}

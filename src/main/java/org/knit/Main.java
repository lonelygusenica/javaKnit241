package org.knit;

import org.knit.lab1.Task1;
import org.knit.lab1.Task2;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.execute();

        String url = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        Task2 task2 = new Task2(url);
        System.out.println(task2);
    }
}

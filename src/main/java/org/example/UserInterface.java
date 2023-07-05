package org.example;

import java.util.Scanner;

public class UserInterface {
    public static void dataInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные в строку через пробел: Фамилия Имя Отчетсво дата рождения (dd.mm.yyyy) " +
                "номер телефона (79999999999) пол (f или m), либо 0 для выхода");
        boolean continuation = true;
        while (continuation) {
            String[] arr = in.nextLine().split(" ");
            if (arr[0].equalsIgnoreCase("0")) {
                break;
            }
            MessageHandler.arrayInputData(arr);
        }
    }
}

package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreatingFile {
    public static void createFile(String text, String name) {
        boolean indicator = false;
        String str = "";
        if (Files.exists(Path.of(name + ".txt"))) {
            str = readFile(name);
            if (!str.contains(text)) {
                indicator = true;
                writeFile(name, text, indicator);
                System.out.println("Данные успешно добавлены");
            } else {
                System.out.println("Данные существуют");
            }
        } else {
            writeFile(name, text, indicator);
            System.out.println("Файл " + name + ".txt успешно создан");
        }
    }

    public static String readFile(String name) {
        try (FileReader reader = new FileReader(name + ".txt")) {
            int c;
            StringBuilder str = new StringBuilder();
            while ((c = reader.read()) != -1) {
                str.append((char) c);
            }
            return str.toString();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла " + e);
        }
    }

    public static void writeFile(String name, String text, boolean indicator) {
        try (FileWriter writer = new FileWriter(name + ".txt", indicator)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла" + e);
        }
    }
}

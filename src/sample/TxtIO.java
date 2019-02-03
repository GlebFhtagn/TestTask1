package sample;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

public class TxtIO {
    private static FileChooser fileChooser;
    private static File file;

    public static String[] loadData(Node node) {
        try {
            fileChooser = new FileChooser();                                //выбираем файл, из которого будет производиться чтение
            file = fileChooser.showOpenDialog(node.getScene().getWindow()); //при создании диалога выбора файла задаем окно, заранее переданное из конструктора
        //(чтение лучше производить из ранее записанных файлов с условиями)
            String[] output = new String[2];    // переменная для сбора данных из файла

            BufferedReader reader = new BufferedReader(new FileReader(file));   //потоковое символьное чтение из файла
            output[0] = reader.readLine();  //внезависимости от типа задачи считываем две строки
            output[1] = reader.readLine();
            reader.close();                 //после окончания считывания задачи закрываем поток чтения
            return output;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода\\вывода при чтении");
        }   catch (NullPointerException e){
            System.out.println("Отмена выбора файла");
        }
        return null;
    }

    public static void saveData(Node node, String[] data) {
        try {
            fileChooser = new FileChooser();                                //аналогичный механизм выбора файла
            file = fileChooser.showOpenDialog(node.getScene().getWindow());

            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //потоковая запись в файл условий задачи
            writer.write(data[0]);
            writer.newLine();            //добавляем табуляцию
            writer.write(data[1]);
            writer.flush();              //освобождаем память и закрываем поток
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода\\вывода при записи");
        } catch (NullPointerException e){
            System.out.println("Отмена выбора файла");
        }
    }
}

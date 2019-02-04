package sample;

import java.util.*;

public class Logic {
    public static String findSubString(String[] conditions){
        String[] ar1 = conditions[0].split(" ");           //разделение строки строки с помощью паттерна регулярноо выражения
        String[] ar2 = conditions[1].split(" ");

        Set<String> result = new HashSet<String>();            // размер результата динамический, поэтому используем множество
        for(String str1: ar1){                                 // так же избавляемся от повторений
           for(String str2: ar2)
            if(str2.contains(str1)){                              //проверяем для каждого слова из первого массива вхождение в слово из второго массива
                result.add(str1);
                break;
            }
        }
        List list = new ArrayList(result);                     // для упорядочивания результата изпользуем список
        Collections.sort(list, new SortByValue());
        return list.toString();
    }

    public static String decompose(String[] conditions) {
        char[] digits = conditions[0].toCharArray();            //выбираем число только из первого условия для декомпозиции
        String rank = "";                                       //начальный разряд пустой (идем в порядке нарастания разряда)
        StringBuilder result = new StringBuilder();             //для эффективной работы с памятью используем StringBuilder для сбора результата
        for(int i = digits.length-1; i >= 0; i--) {
            if (digits[i] != '0') {                                                                 //игнорируем цифры, которые не добавляют разряд в результат
                result.insert(0, digits[i]).insert(1, rank).insert(0,'+');   //добавляем значащее число в начало строки(первый аргумент), количество нулей разряда
            }                                                                                       //добавляем после самого значения(второй параметр), и знак плюс(третий)
            rank += "0";                                                                            // увеличиваем значение разряда
        }

        return result.toString().substring(1);
    }

    static class SortByValue implements Comparator<String>  //определили класс сравнения для сортировки в коллекциях
    {
        public int compare(String a, String b)
        {
            return a.compareTo(b);
        }
    }
}

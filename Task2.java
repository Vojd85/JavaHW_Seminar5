/*
 * Пусть дан список сотрудников:
 * Иван Иванов 
 * Светлана Петрова 
 * Кристина Белова 
 * Анна Мусина 
 * Анна Крутова 
 * Иван Юрин 
 * Петр Лыков 
 * Павел Чернов 
 * Петр Чернышов 
 * Мария Федорова 
 * Марина Светлова 
 * Мария Савина 
 * Мария Рыкова 
 * Марина Лугова 
 * Анна Владимирова 
 * Иван Мечников 
 * Петр Петин 
 * Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности.
 */

package HomeWorks.Seminar5;


import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.SortedMap;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> sp = new ArrayList<>();
        sp.add("Иван Иванов");
        sp.add("Светлана Петрова");
        sp.add("Кристина Белова");
        sp.add("Анна Мусина");
        sp.add("Анна Крутова");
        sp.add("Иван Юрин");
        sp.add("Петр Лыков");
        sp.add("Павел Чернов");
        sp.add("Петр Чернышов");
        sp.add("Мария Федорова");
        sp.add("Марина Светлова");
        sp.add("Мария Савина");
        sp.add("Мария Рыкова");
        sp.add("Марина Лугова");
        sp.add("Анна Владимирова");
        sp.add("Иван Мечников");
        sp.add("Петр Петин");
        sp.add("Иван Ежов");
        System.out.println(sp);
        
        HashMap<String, Integer> repeatNames = getDoubleNames(sp);
        System.out.printf("Список повторяющихся имен " + repeatNames);
        System.out.println();
        System.out.println(SortNamesByValue(sp, repeatNames));
    }
    static String getName(String arr){
        String[] temp = arr.split(" ");
        return temp[0];
    }
    
    static HashMap<String, Integer> getDoubleNames(ArrayList<String> arr){
        HashMap<String, Integer> mapNames = new HashMap<>();
        for (String n: arr){
            if (!mapNames.containsKey(getName(n))){
                mapNames.put(getName(n), 0);
            }
            else {
                mapNames.put(getName(n), mapNames.get(getName(n))+1);
            }
        }
        return mapNames;
    }

    static LinkedList<String> SortNamesByValue(ArrayList<String> arr, HashMap<String, Integer> map){
        SortedMap <String, Integer> temp = new TreeMap<>();
        for (String x: arr){
            if (map.containsKey(getName(x))){
                temp.put(x, map.get(getName(x))+1);
            }
            else{
                temp.put(x, 0);
            }
        }
        int max = Collections.max(temp.values());
        LinkedList<String> sortedList = new LinkedList<>();
        while (!temp.isEmpty()){
            if (temp.containsValue(max)){
                for (String x: temp.keySet()){
                    if ((int)temp.get(x) == max){
                        sortedList.add(x);
                        temp.remove(x);
                        break;
                    }
                }
            }
            else {max--;}
        }
        return sortedList;
    }
}

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package HomeWorks.Seminar5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> phones = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5647);
        nums.add(78645765);
        phones.put("Petrov", nums);
        System.out.println(phones);
        addContact(phones, scan);
        System.out.println(phones);
        addContact(phones,scan);
        System.out.println(phones);
        delContact(phones, scan);
        System.err.println(phones);
        scan.close();
    }
    static void addContact(HashMap<String, ArrayList<Integer>> map, Scanner scanner){
        System.out.println("Введите ФИО: ");
        String name = scanner.next();
        System.out.println("Введите номер телефона: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (map.containsKey(name)){
            map.get(name).add(num);
        }
        else {
        ArrayList<Integer> arrList = new ArrayList<Integer>(1);
        arrList.add(num);
        map.put(name, arrList);
        }
    }
    static void delContact(HashMap<String, ArrayList<Integer>> map, Scanner scanner){
        System.out.println("Введите контакт для удаления: ");
        String name = scanner.nextLine();
        if (map.containsKey(name)){
            map.remove(name);
        }
        else {System.out.println("Такого контакта нет");}
    }
}

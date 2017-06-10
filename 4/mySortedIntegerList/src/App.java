/*
* Напишите класс SortedIntegerList, который хранит отсортированный
* в порядке возрастания список целых чисел. Внутри класса список
* должен храниться с помощью LinkedList. У SortedInteger List должны
* быть определены:

* Конструктор   с булевским параметром; если этот параметр принимает
* значение true, то в создаваемом списке разрешены повторяющиеся
* элементы, иначе --- нет; Методы add(int) и remove(int), которые,
* соответственно, добавляют число в список и удаляют число из списка;
* если добавление (удаление) невозможно --- метод не делает ничего;
* Метод   equals();

* Напишите программу, проверяющую работу класса SortedIntegerList.

* Постарайтесь реализовать возможно полный набор проверок.
*/


package mySortedIntegerList.src;

import mySortedIntegerList.src.SortedIntegerList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    SortedIntegerList list1 = new SortedIntegerList(true);
    SortedIntegerList list2 = new SortedIntegerList(true);
    SortedIntegerList list3 = new SortedIntegerList(false);

    Scanner in = new Scanner(System.in);

    log("Test 1: adding and sorting:");
    log("Enter 10 elements:");
    for (int i = 0; i < 10; i++) {
      list1.add(in.nextInt());
      // list1.add(i);
      list1.log();
    }

    log("\nTest 2: remove elements");
    list1.log();
    for(int i = 0; i < 3; i++) {
      log("Select element to remove:");
      list1.remove(in.nextInt());
      list1.log();
    }

    log("\nTest 3: allowEqualElements:");
    log("Add [ 1, 1, 2, 2 ] to the lists with different parameters");
    list2.add(1);
    list2.add(1);
    list2.add(2);
    list2.add(2);

    list3.add(1);
    list3.add(1);
    list3.add(2);
    list3.add(2);

    list2.log();
    list3.log();
    /* Additional task */
    log("Additonal task:");
    SortedIntegerList aList = new SortedIntegerList(true);
    SortedIntegerList aList2 = new SortedIntegerList(true);

    aList.add(1);
    aList.add(2);
    aList.add(3);
    aList.add(4);
    aList.add(5);

    aList2.add(1);
    aList2.add(3);
    aList2.add(5);

    SortedIntegerList result = aList.remove(aList2);
    log(result.toString());
  }

  public static void log(String msg) {
    System.out.println(msg);
  }
}

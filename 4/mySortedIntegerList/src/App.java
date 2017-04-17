package mySortedIntegerList.src;

import mySortedIntegerList.src.SortedIntegerList;

public class App {
  public static void main(String[] args) {
    SortedIntegerList list = new SortedIntegerList(true);
    SortedIntegerList list2 = new SortedIntegerList(true);
    list.add(1);
    list2.add(2);
    list.add(3);
    list2.add(3);
    System.out.println(list.equals(list2));
  }
}
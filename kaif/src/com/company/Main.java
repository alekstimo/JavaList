package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java!");
        ListTemplate <Integer> list=new ListTemplate<Integer>();
        for(int i=0;i<5;i++){
            list.addToHead(i);
            list.addToTail(i+1);
        }
        System.out.println("List:");
        list.print();
        list.deleteFromHead();
        list.deleteByIndex(2);
        list.deleteElem(4);
        list.deleteFromTail();
        list.addByIndex(1,10);
        list.addAfterElem(0,13);
        System.out.println("New List:");
        list.print();
        ListTemplate<Integer> list2=new ListTemplate<Integer>();
        for (int i=20;i<24;i++){
            list2.addToHead(i);
        }
        list.addList(list2);
        System.out.println("New List:");
        list.print();
    }
}

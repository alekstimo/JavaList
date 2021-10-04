package com.company;

public class Node<T> {
    private Node next;
    //private Node previous;
    private T data;

    public Node(){ //конструктор по умолчанию для элемента
        this.next=null;
        //this.previous=null;
    }
    public Node(T e){
        this.next=null;
      //  this.previous=null;
        this.data=e;
    }
    /* public Node(Node previous){ //конструктор с добавлением после
        this.next=null;
        this.previous=previous;
    }*/
    public Node getNext(){ //получение указателя на следующий
        return next;
    }
   /* public Node getPrevious(){
        return previous;
    } */
    public void setNext(Node next){ //добавление после элемента
        this.next=next;
    }
  /*  public void setPrevious(Node previous){
        this.previous=previous;
    }*/
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data=data;
    }
    public boolean equals(Object obj) {
        return data.equals(obj);
    }
}

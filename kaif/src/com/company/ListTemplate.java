package com.company;

/**
 * This class allows you to work with data by structuring it into a unidirectional list
 * @param <E>
 *     type of val stored in the list
 */
public class ListTemplate<E> {
    //дописать слияние двух списков

    private Node<E> head;
    private  int size=0;

    /**
     * default constructor
     */
    public ListTemplate(){
       this.head=null;
    }
    /**
     * constructor with data
     */
    public ListTemplate(E e){
        this.head=new Node<E>();
        head.setData(e);
        size++;
    }

    /**
     *
     * @return
     * size of list
     */
    public int size(){
        return this.size;
    }

    /**
     * check for emptiness
     * @return
     * 1 if empty
     * 0 if not empty
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     * print list on one line
     */
    public void print(){
        Node<E> node= head;
        while(node!=null){
            System.out.print(node.getData()+" ");
            node=node.getNext();
        }
        System.out.println();
    }
    private Node<E> getHead(){
        return head;
    }
    //добавление элемента

    /**
     * concatenates two lists into one
     * @param list
     * list appended to the end;
     */
    public void addList(ListTemplate list){
        if(isEmpty()){
            head=list.getHead();
        }
        else{
            Node<E> tail= head;
            while(tail.getNext()!=null)
            {
                tail=tail.getNext();
            }
            tail.setNext(list.getHead());
        }
        size+=list.size;
    }

    /**
     * add elem to the beginning
     * @param e
     * added element
     */
    public void addToHead(E e){ //добавление в начало
        Node<E> node= new Node<E>(e);
        node.setNext(head);
        head=node;
        size++;
    }

    /**
     * add elem after another elem
     * @param elem
     * elem after which will be added
     * @param e
     * added element
     */
    public void addAfterElem(E elem,E e){ //добавление после определенного элемента
        Node<E> node= new Node<E>(e);
        Node<E> ptr = head;
        while (ptr.getNext() != null) {
            if (ptr.equals(elem)) {
                node.setNext(ptr.getNext());
                ptr.setNext(node);
                size++;
                break;
            }
            ptr=ptr.getNext();
        }
    }

    /**
     * add elem to end
     * @param e
     * added element
     */
    public void addToTail(E e){ //добавление в конец
        Node<E> tail = head;
        Node<E> node= new Node<E>(e);
        if(isEmpty()){
            head=node;
        }
        else{
            while(tail.getNext()!=null)
            {
                tail=tail.getNext();
            }
            tail.setNext(node);
        }
        size++;
    }

    /**
     * add elem after elem with index
     * @param index
     * remember that the indexes start from 0
     * @param e
     * added element
     */
    public void addByIndex(int index, E e){ //добавление по индексу
        if(index==0){
            addToHead(e);
        }
        else if(index==size-1){
            addToTail(e);
        }
        else if(index>0 && index<size){
            Node<E> node= new Node<E>(e);
            Node<E> ptr=getByIndex(index-1);
            node.setNext(ptr.getNext());
            ptr.setNext(node);
            size++;
        }
    }
    //извлечение элемента


    private Node<E> getByIndex(int index) {
        Node<E> node = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            node = head;
            for(int i=1; i<=index; i++){
                node = node.getNext();
            }
        }
        return node;
    }
    /**
     *
     * @param index
     * element index (start from 0)
     * @return elem type E
     */
    public E get(int index) {  //извлечение по индексу
        E element;
        if (index >= 0 && index < size()) {
            element = getByIndex(index).getData();
        } else throw new IndexOutOfBoundsException();
        return element;
    }
    //удаление элемента

    /**
     * delete elem by index
     * @param index
     * index of elem (begin with 0)
     */
    public void deleteByIndex(int index){ //удаление по индексу
        if(index==0){
            deleteFromHead();
        }
        if(index>0 && index<size()){
            Node<E> node = getByIndex(index-1);
            node.setNext(node.getNext().getNext());
            size--;
        }
    }

    /**
     * delete element from the beginning
     */
    public void deleteFromHead(){ //удаление из начала
        Node<E> node = head;
        head=head.getNext();
        node.setNext(null);
        node=null;
        size--;
    }

    /**
     * delete element from the end
     */
    public void deleteFromTail(){ //удаление последнего
        Node<E> node = head;
        while(node.getNext().getNext()!=null){
            node=node.getNext();
        }
        node.setNext(null);
    }

    /**
     * delete all elem
     */
    public void clear(){
        while(head!=null){
            deleteFromHead();
        }
    }

    /**
     * delete element
     * @param e
     * the elem you want to delete
     */
    public void deleteElem(E e){ //удаление по элементу
        Node<E> node = head;
        if(node.equals(e)){
            deleteFromHead();
            size--;
        }
        else {
            while (node.getNext() != null) {
                if (node.getNext().equals(e)) {
                    node.setNext(node.getNext().getNext());
                    size--;
                    break;
                }
                node=node.getNext();
            }
        }
    }
}


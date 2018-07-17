package io.github.anwyho.linkedlist;

import java.lang.Comparable;

public class ListNode<T extends Comparable<T>> {

  public static void main(String[] args) {
    ListNode<Integer> n1 = new ListNode<Integer>(3);
    n1.data(7);
    ListNode<Integer> n2 = new ListNode<Integer>(7);
    System.out.println(n2.compareTo(n1));
    System.out.println("Helloworld");
  }


  private T _data;
  private ListNode<T> _next;
  private ListNode<T> _prev;

  public ListNode() {
    _data = null;
    _next = null;
    _prev = null;
  }

  public ListNode(T element) {
    _data = element;
    _next = null;
    _prev = null;
  }

  public void prev(ListNode<T> n) { _prev = n; }
  public void next(ListNode<T> n) { _next = n; }
  public void data(T d) { _data = d; }
  public ListNode<T> prev() { return _prev; }
  public ListNode<T> next() { return _next; }
  public T data() { return _data; }

  public int compareTo(ListNode<T> n) {
    return _data.compareTo(n.data());
  }
}
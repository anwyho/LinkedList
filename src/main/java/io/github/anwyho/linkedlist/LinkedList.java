package io.github.anwyho.linkedlist;

import java.lang.Comparable;

public class LinkedList<T extends Comparable<? super T>> {

  private ListNode<T> _head;
  private ListNode<T> _tail;
  private int _size;

  public LinkedList() {
    _head = null;
    _tail = null;
    _size = 0;
  }

  public void append(ListNode<T> node) {
    if (_size == 0) {
      _head = node;
      _tail = node;
    } else if (_tail != null) {
      _tail.insertMeBeforeNode(node);
      _tail = node;
    }
    _size += 1;
  }

  public void append(T object) {
    append(new ListNode<T>(object));
  }

  // TODO: implement this in LinkedList.java
  // public void insertAtIndex(int i) {
  //   negative int means from tail
  //   Math.abs(i) < _size
  // }

  // public T remove(T object) {

  // }
}
package io.github.anwyho.linkedlist;

import java.lang.Comparable;

public class ListNode<T extends Comparable<? super T>> {

  private T _data;
  private ListNode<T> _next;
  private ListNode<T> _prev;

  public ListNode() {
    _data = null;
    _next = null;
    _prev = null;
  }

  public ListNode(T e) {
    _data = e;
    _next = null;
    _prev = null;
  }

  // Setters
  final void prev(ListNode<T> n) { _prev = n; }
  final void next(ListNode<T> n) { _next = n; }
  void data(T d) { _data = d; }

  // Getters
  public final ListNode<T> prev() { return _prev; }
  public final ListNode<T> next() { return _next; }
  public T data() { return _data; }


  public int compareTo(ListNode<T> n) {
    return _data.compareTo(n.data());
  }

  public void insertMeBeforeNode(ListNode<T> head) {
    if (head.prev() != null) {
      _prev = head.prev();
      head.prev().next(this);
    }
    _next = head;
    head.prev(this);
  }

  public void insertMeAfterNode(ListNode<T> tail) {
    if (tail.next() != null) {
      _next = tail.next();
      tail.next().prev(this);
    }
    _prev = tail;
    tail.next(this);
  }

  public T removeMe() {
    if (_next != null) _next.prev(_prev);
    if (_prev != null) _prev.next(_next);
    return _data;
  }

  @Override
  public int hashCode() {
    return _data.hashCode();
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (this.getClass() != o.getClass()) return false;
    @SuppressWarnings("unchecked")
    ListNode<T> oNode = (ListNode<T>) o;
    return nodesEqual(oNode);
  }

  // can be overridden by subclass
  boolean nodesEqual(ListNode<T> n) {
    return _data == n.data();
  }

}
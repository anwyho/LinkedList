package io.github.anwyho.linkedlist;

import java.lang.Comparable;

public class LinkedList<T extends Comparable<? super T>> {

  private ListNode<T> _head;
  private ListNode<T> _tail;
  private int _size;


  /** 
   * Class constructor.
   */
  public LinkedList() {
    _head = null;
    _tail = null;
    _size = 0;
  }

  /**
   * Returns the head node
   * @return ListNode<T> head
   * @see    io.github.anwyho.linkedlist.ListNode
   */
  public ListNode<T> head() { return _head; }

  /**
   * Returns the tail node
   * @return tail ListNode
   * @see    io.github.anwyho.linkedlist.ListNode
   */
  public ListNode<T> tail() { return _tail; }

  /**
   * Returns the head node
   * @return head ListNode
   * @see    io.github.anwyho.linkedlist.ListNode
   */
  public int size() { return _size; }

  /**
   * Inserts a node at a given index. Index can be positive or negative 
   * as long as the absolute value of the index is between 0 and the size
   * of the LinkedList. 
   *
   * @param  index  index at which to insert node
   * @param  node   node to be inserted
   */
  public void insertAtIndex(int index, ListNode<T> node) {

    // index conversion for post-insertion
    // inserting at index -1 inserts in the end of the LinkedLists
    // range [ -(_size), _size )
    if (index < 0) index = (_size+1) + index;

    if (node == null) throw new 
        IllegalArgumentException("Node cannot be null.");
    if (index > _size || index < 0) throw new 
        IndexOutOfBoundsException(String.format(
        "Index must be between or equal to -%s and %s", _size));

    // empty insertion or head insertion
    else if (index == 0) {
      if (index == _size) {
        insertIntoEmptyList(node);
      } else {
        node.insertMeBeforeNode(_head);
        _head = node;
      }
    }
    // tail insertion
    else if (index == _size) {
      node.insertMeAfterNode(_tail);
      _tail = node;
    } 
    // index closer to head
    else if (index <= _size/2) {
      ListNode<T> n = _head;
      for (int i = 0; i < index; n = n.next(), i++) {}  
      node.insertMeAfterNode(n);
    // index closer to tail
    } else {
      ListNode<T> n = _tail;
      for (int i = index; i < _size; n = n.prev(), i++) {}
      node.insertMeBeforeNode(n);
    }

    // this is the ONLY place size is incremented
    _size += 1;
  }

  public void append(ListNode<T> node) { insertAtIndex(_size, node); }
  public void append(T object)         { insertAtIndex(_size, new ListNode<T>(object)); }
  public void push  (ListNode<T> node) { insertAtIndex(0, node); }
  public void push  (T object)         { insertAtIndex(0, new ListNode<T>(object)); }

  void insertIntoEmptyList(ListNode<T> node) {
    if (_size != 0 || _head != null || _tail != null) throw new 
        IllegalStateException(
        "List is not empty. Cannot insert node into empty list.");
    _head = node;
    _tail = node;
  }

  // public T remove(T object) {

  // }
}
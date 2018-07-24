// import java.util.ArrayList;  // for testCreateNodeWithInvalidType
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import io.github.anwyho.linkedlist.*;

@DisplayName("LinkedList Test")
public class LinkedListTest {

  // Helper method - compares a char List to 
  boolean checkStringToList(final String pattern, final ListNode<Character> HEAD) {
    ListNode<Character> head = HEAD;
    for (int i = 0; i < pattern.length(); i++) {
      if (head == null) {
        return false;
      }
      if (pattern.charAt(i) == head.data()) {
        System.out.println(head.data());
        head = head.next();
      } else {
        return false;
      }
    }
    return true;
  }

  boolean checkStringToList(final String pattern, final LinkedList<Character> list) {
    return checkStringToList(pattern, list.head());
  }

  @Nested
  @DisplayName("Test ListNodes")
  class NodeTests {

    @Test
    @DisplayName("Creating nodes")
    void testCreateListNode() {
      ListNode<Integer> n = new ListNode<Integer>(3);
      assertNotNull(n);
    }

    @Test
    @DisplayName("Invalid element type -- this test does not compile.")
    @Disabled
    void testCreateNodeWithInvalidType() {
      // // Compiler will catch error because of ListNode declaration
      // // Doesn't compile because ArrayList does not extend Comparable
      // ListNode<ArrayList<Integer>> a = new ListNode<ArrayList<Integer>>();
    }

    @Nested
    @DisplayName("Test String Nodes")
    class StringNodes {

      ListNode<String> na1;
      ListNode<String> na2;
      ListNode<String> nb1;

      @BeforeEach
      void initiateNodes() {
        na1 = new ListNode<String>("Hello, world");
        na2 = new ListNode<String>("Hello, world");
        nb1 = new ListNode<String>("Node 2");
      }


      @Test
      @DisplayName("Comparable types")
      void testComparingListNodes() {
        assertEquals(na1.compareTo(na2), 0);
        assertNotEquals(na1.compareTo(nb1), 0);
      }

      @Test
      @DisplayName("Node equality")
      void testNodeEquality() {
        assertTrue(na1.equals(na1));
        assertFalse(na1.equals(null));
        assertTrue(na1.equals(na2));
        assertFalse(na1.equals(nb1));
      }
    }

    @Nested
    @DisplayName("Test Node Insertions and Deletions")
    class InsertionsAndDeletions {

      ListNode<Character> na;
      ListNode<Character> nb;
      ListNode<Character> nc;
      ListNode<Character> nd;
      ListNode<Character> ne;

      @BeforeEach
      void initiateNodes() {
        na = new ListNode<Character>('A');
        nb = new ListNode<Character>('B');
        nc = new ListNode<Character>('C');
        nd = new ListNode<Character>('D');
        ne = new ListNode<Character>('E');
      }

      @Test
      @DisplayName("Inserting to nodes")
      void testInsertingBeforeAndAfter() {
        na.insertMeBeforeNode(nc);
        nb.insertMeBeforeNode(nc);
        assertTrue(checkStringToList("ABC",na));
        nd.insertMeAfterNode(nc);
        ne.insertMeAfterNode(na);
        assertTrue(checkStringToList("ACB",na));
      }

      @Test
      @DisplayName("Removing nodes")
      void testRemovingNodes() {
        assertEquals((char) na.removeMe(),'A');
        na.insertMeBeforeNode(nb);
        nb.insertMeBeforeNode(nc);
        nc.insertMeBeforeNode(nd);
        nd.insertMeBeforeNode(ne);
        nb.removeMe();
        assertTrue(checkStringToList("ACDE",na));
        na.removeMe();
        assertTrue(checkStringToList("CDE",nc));
        nd.removeMe();
        assertTrue(checkStringToList("CE",nd));
        ne.removeMe();
        assertTrue(checkStringToList("C",nc));
        nc.insertMeAfterNode(na);
        assertTrue(checkStringToList("AC",na));
        na.removeMe();
        assertTrue(checkStringToList("C",nd));
      }
    }
  }

  @Nested
  @DisplayName("Testing LinkedLists")
  class ListTests {

    @Test
    @DisplayName("Creating LinkedLists")
    void testCreateList() {
      LinkedList<Integer> l = new LinkedList<Integer>();
      assertNotNull(l);
    }

    @Nested
    @DisplayName("Test different LinkedList operations")
    class ListOperations {
      LinkedList<Character> l;
      ListNode<Character> na;
      ListNode<Character> nb;
      ListNode<Character> nc;
      ListNode<Character> nd;
      ListNode<Character> ne;

      @BeforeEach
      void initiateNodes() {
        l = new LinkedList<Character>();
        na = new ListNode<Character>('A');
        nb = new ListNode<Character>('B');
        nc = new ListNode<Character>('C');
        nd = new ListNode<Character>('D');
        ne = new ListNode<Character>('E');
      }

      @Test
      @DisplayName("Appending to lists")
      void testAppend() {
        assertEquals(l.size(), 0);
        l.append(na);
        assertEquals(l.size(), 1);
        l.append(nb);
        assertEquals(l.size(), 2);
        l.append(nc);
        assertEquals(l.size(), 3);
        assertTrue(checkStringToList("ABC",l));
      }

      @Test
      @DisplayName("Inserting to lists")
      void testInsertAtIndex() {
        // insert into empty list
        assertEquals(l.size(), 0);
        
        l.insertAtIndex(0, na);
        assertEquals(l.size(), 1);
        assertTrue(checkStringToList("A",l));

        l.insertAtIndex(0, nb);
        assertEquals(l.size(), 2);
        assertTrue(checkStringToList("BA",l));

        l.insertAtIndex(2, nc);
        assertEquals(l.size(), 3);
        assertTrue(checkStringToList("BAC",l));

        l.insertAtIndex(2, nd);
        assertEquals(l.size(), 4);
        assertTrue(checkStringToList("BADC",l));

        l.insertAtIndex(2, ne);
        assertEquals(l.size(), 5);
        assertTrue(checkStringToList("BAEDC", l));
      }

      @Test
      @DisplayName("Inserting to lists using negative indices")
      void testInsertAtIndexWithNegativeIndex() {
        // insert into empty list
        assertEquals(l.size(), 0);
        
        l.insertAtIndex(0, na);
        assertEquals(l.size(), 1);
        assertTrue(checkStringToList("A",l));

        l.insertAtIndex(-2, nb);
        assertEquals(l.size(), 2);
        assertTrue(checkStringToList("BA",l));

        l.insertAtIndex(-1, nc);
        assertEquals(l.size(), 3);
        assertTrue(checkStringToList("BAC",l));

        l.insertAtIndex(0, nd);
        assertEquals(l.size(), 4);
        assertTrue(checkStringToList("BADC",l));

        l.insertAtIndex(-4, ne);
        assertEquals(l.size(), 5);
        assertTrue(checkStringToList("BAEDC", l));
      }
    }



    @Test
    @DisplayName("Test for circular list checking")
    void testCircularList() {
      // TODO: implement
    }
  }
  
    
  

  // @Test
  // @Disabled
  // void FailingTest() {
  //   fail("failed");
  // }
}
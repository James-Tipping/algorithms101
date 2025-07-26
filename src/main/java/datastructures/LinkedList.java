package datastructures;

public class LinkedList {

  private static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  private Node head;

  public void addFront(int data) {
    Node newNode = new Node(data);

    // if no head, make this new node the head
    if (head == null) {
      head = newNode;
      return;
    }

    // otherwise, make the new node's next equal to the current head
    newNode.next = head;

    // As before, make new head the newNode
    head = newNode;
  }

  public int getFirst() {
    return head.data;
  }

  private Node getLastNode() {
    if (head == null) {
      throw new IllegalStateException("Head is null - list is empty!");
    }

    Node currentNode = head;
    while (currentNode.next != null) {
      System.out.println("current node data: " + currentNode.data);
      System.out.println("next node data: " + currentNode.next.data);
      currentNode = currentNode.next;
    }
    System.out.println("Going to return value");

    return currentNode;
  }

  public int getLast() {
    Node lastNode = getLastNode();
    System.out.println("Lastnode Value: " + lastNode.data);
    return lastNode.data;
  }

  public void addBack(int data) {

    Node newLastNode = new Node(data);

    if (head == null) {
      head = newLastNode;
    } else {
      Node currentLastNode = getLastNode();

      currentLastNode.next = newLastNode;
    }
  }

  public int size() {
    if (head == null) {
      return 0;
    }

    Node currentNode = head;
    int sizeCounter = 1;

    while (currentNode.next != null) {
      currentNode = currentNode.next;
      sizeCounter++;
    }

    return sizeCounter;
  }

  public void clear() {
    // GC will remove all nodes as references broken when head removed
    head = null;
  }

  public void deleteValue(int value) {

    if (head.data == value) {
      head = head.next;
      return;
    }

    Node currentNode = head;

    while (currentNode.next != null) {
      if (currentNode.next.data == value) {
        currentNode.next = currentNode.next.next;
        // originally missed this, should be added to prevent unncecessary computation
        // LLM pointed me to this function
        return;
      }
      // originally missed this, not adding results in infinite loop
      // LLM pointed me to this function
      currentNode = currentNode.next;
    }

    // My original implementation (with error)
    // Node previousNode;
    // while (currentNode != null) {
    // if (currentNode.data == value) {
    // if (previousNode == null) {
    // // GC will remove current head as reference to it removed
    // head = currentNode.next;
    // } else {
    // // GC will remove currentNode.
    // // Previous node next contains reference to currentNode's next value
    // previousNode.next = currentNode.next;
    // }
    // }
    // }
  }

}

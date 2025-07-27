package algorithms;

public class BinarySearchTree {

  Node root;

  class Node {
    Node left;
    Node right;
    String value;
    int id;

    Node(int id, String value) {
      this.id = id;
      this.value = value;
    }

    Node findMin() {
      if (this.left == null) {
        return this;
      }
      return this.left.findMin();
    }
  }

  public BinarySearchTree() {
  }

  public void insert(int id, String value) {
    Node node = new Node(id, value);

    root = insertNode(root, node);
  }

  private Node insertNode(Node node, Node newNode) {
    if (node == null) {
      return newNode;
    } else if (newNode.id < node.id) {
      node.left = insertNode(node.left, newNode);
    } else if (newNode.id > node.id) {
      node.right = insertNode(node.right, newNode);
    }
    return node;
  }

  public String find(int id) {
    Node node = findNode(root, id);
    if (node == null) {
      return null;
    }
    return node.value;
  }

  private Node findNode(Node node, int id) {
    if (node.id == id) {
      return node;
    } else if (id < node.id && node.left instanceof Node) {
      return findNode(node.left, id);
    } else if (id > node.id && node.right instanceof Node) {
      return findNode(node.right, id);
    } else {
      return null;
    }
  }

  public void delete(int id) {
    root = delete(root, id);
  }

  private Node delete(Node node, int id) {

    if (node == null) {
      return null;
    } else if (id < node.id) {
      node.left = delete(node.left, id);
    } else if (id > node.id) {
      node.right = delete(node.right, id);
    } else if (id == node.id) {

      if (node.left == null && node.right == null) {
        node = null;
      } else if (node.left != null ^ node.right != null) {
        node = node.left == null ? node.right : node.left;
      } else {
        Node minNodeSuccessor = node.findMin();
        node.id = minNodeSuccessor.id;
        node.id = minNodeSuccessor.id;

        // Cannot just set to null as we only have reference to object
        // Must call delete function on copied node
        node.right = delete(node.right, id);
      }

    }
    return node;
  }

}

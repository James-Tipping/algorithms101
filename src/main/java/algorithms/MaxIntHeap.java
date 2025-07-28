package algorithms;

public class MaxIntHeap {

  int[] items;
  int size;
  int capacity;

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private boolean hasOneChild(int index) {
    return (2 * index + 1) == size - 1;
  }

  private boolean hasTwoChildren(int index) {
    return (2 * index + 2) <= size - 1;
  }

  private int firstChild(int index) {
    return items[2 * index + 1];
  }

  private int firstChildIndex(int index) {
    return 2 * index + 1;
  }

  private int secondChild(int index) {
    return items[2 * index + 1];
  }

  private int secondChildIndex(int index) {
    return 2 * index + 1;
  }

  // private int secondChild(index)

  public MaxIntHeap() {
    items = new int[1];
    size = 0;
    capacity = 1;
  }

  public void insert(int key) {
    increaseCapacityIfNecessary();

    items[size] = key;
    size++;
    heapifyUp();
  }

  private void increaseCapacityIfNecessary() {
    if (size == capacity) {
      int[] temporaryArray = new int[capacity * 2];

      for (int i = 0; i < size; i++) {
        temporaryArray[i] = items[i];
      }
      items = temporaryArray;
      capacity = capacity * 2;
    }
  }

  private void heapifyUp() {
    int currentIndex = size;

    while (currentIndex > 0 && items[getParentIndex(currentIndex)] < items[currentIndex]) {
      swap(currentIndex, getParentIndex(currentIndex));
      currentIndex = getParentIndex(currentIndex);
    }
  }

  public int extractMax() {
    if (items.length == 0) {
      throw new IllegalAccessError();
    }

    int maxItem = items[0];
    // cannot assign as null for int array in Java
    items[size] = 0;
    size--;
    heapifyDown();
    return maxItem;

  }

  private void heapifyDown() {
    int currentIndex = 0;

    while (hasTwoChildren(currentIndex) || hasOneChild(currentIndex)) {
      if (hasTwoChildren(currentIndex)) {
        if (firstChild(currentIndex) > secondChild(currentIndex)) {
          swap(currentIndex, firstChildIndex(currentIndex));
          currentIndex = firstChildIndex(currentIndex);
        } else {
          swap(currentIndex, secondChildIndex(currentIndex));
          currentIndex = secondChildIndex(currentIndex);
        }

      } else {
        swap(currentIndex, firstChildIndex(currentIndex));
        return;
      }
    }

  }

  private void swap(int index1, int index2) {
    int key1 = items[index1];
    int key2 = items[index2];

    items[index2] = key1;
    items[index1] = key2;
  }

}

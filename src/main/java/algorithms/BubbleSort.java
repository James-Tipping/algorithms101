package algorithms;

public class BubbleSort {

  public int[] sort(int[] array) {

    // need n - 1 passes through the array for bubble sort
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        // System.out.println("i: " + String.valueOf(i) + "; j: " + String.valueOf(j));
        if (array[j] > array[j + 1]) {
          int arrayJPlusOne = array[j + 1];
          array[j + 1] = array[j];
          array[j] = arrayJPlusOne;
        }
      }
    }

    return array;
  }

}

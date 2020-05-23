public class MyIterator {
  public static void main(String[] args) {
    int[][] arrays = {
      {1, 5, 7},
      {2, 3, 10},
      {4, 6, 9}
    };
    MyIterator it = new MyIterator(arrays);
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
  }

  static class MyIterator {
    int[][] arrays;
    int[] pointers;

    MyIterator(int[][] arrays) {
      this.arrays = arrays;
      this.pointers = new int[arrays.length];
    }

    int next() {
      int arrayWithMinValue = -1;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < this.pointers.length; i++) {
        if (this.pointers[i] < this.arrays[i].length && this.arrays[i][this.pointers[i]] < min) {
          arrayWithMinValue = i;
          min = this.arrays[i][this.pointers[i]];
        }
      }
      return this.arrays[arrayWithMinValue][this.pointers[arrayWithMinValue]++];
    };

    boolean hasNext() {
      for (int i = 0; i < this.pointers.length; i++) {
        if (this.pointers[i] < this.arrays[i].length) return true;
      }
      return false;
    };
  }
}

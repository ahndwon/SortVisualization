public class BubbleSort extends Thread {
    private int[] arr;

    public BubbleSort(int[] data) {
        arr = data;
    }

    @Override
    public void run() {
        Program.setData1(sort(arr));
    }

    public int[] sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return arr;
    }
}

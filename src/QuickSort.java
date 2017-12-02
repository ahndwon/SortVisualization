public class QuickSort extends Thread {
    private int[] arr;

    public QuickSort(int[] data) {
        arr = data;
    }

    @Override
    public void run() {
//        sort(arr, 0, arr.length - 1);
        Program.setData3(sort(arr, 0, arr.length - 1));

    }

    public int[] sort(int[] arr, int left, int right) {
        int i, j, pivot, tmp;

        if (left < right) {
            i = left;
            j = right;
            pivot = arr[left];
            //분할 과정
            while (i < j) {
                while (arr[j] > pivot)
                    j--;
                // 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함
                while (i < j && arr[i] <= pivot)
                    i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            arr[left] = arr[i];
            arr[i] = pivot;

            //정렬 과정
            sort(arr, left, i - 1);
            sort(arr, i + 1, right);
        }
        return arr;
    }
}

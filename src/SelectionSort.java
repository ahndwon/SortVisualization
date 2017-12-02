public class SelectionSort extends Thread{
    private int[] arr;

    public SelectionSort(int[] data) {
        arr = data;
    }

    @Override
    public void run() {
//        sort(arr);
        Program.setData4(sort(arr));
    }
    public int[] sort(int[] list) {
        int indexMin, temp;

        for (int i = 0; i < list.length - 1; i++) {
            indexMin = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[indexMin]) {
                    indexMin = j;
                }
            }
            temp = list[indexMin];
            list[indexMin] = list[i];
            list[i] = temp;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

import processing.core.PApplet;

import java.util.Random;

public class Program extends PApplet {
    private static final int BAR_WIDTH = 5;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 640;
    private static int[] data1 = new int[100];
    private static int[] data2 = new int[100];
    private static int[] data3 = new int[100];
    private static int[] data4 = new int[100];

    public static void setData1(int[] data1) {
        Program.data1 = data1;
    }

    public static void setData2(int[] data2) {
        Program.data2 = data2;
    }

    public static void setData3(int[] data3) {
        Program.data3 = data3;
    }

    public static void setData4(int[] data4) {
        Program.data4 = data4;
    }

    private BubbleSort bubble;
    private QuickSort quick;
    private MergeSort merge;
    private SelectionSort selection;
    private boolean isClicked = false;


    public static void main(String[] args) {
        PApplet.main("Program");
    }

    @Override
    public void settings() {
        size(WIDTH, 640);
    }

    @Override
    public void setup() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            data1[i] = random.nextInt(HEIGHT / 2);
            data2[i] = random.nextInt(HEIGHT / 2);
            data3[i] = random.nextInt(HEIGHT / 2);
            data4[i] = random.nextInt(HEIGHT / 2);
        }

        bubble = new BubbleSort(data1);
        merge = new MergeSort(data2);
        quick = new QuickSort(data3);
        selection = new SelectionSort(data4);
    }

    @Override
    public void mousePressed() {
        if (!isClicked) {
            bubble.start();
            merge.start();
            quick.start();
            selection.start();
            isClicked = true;
        }
    }

    @Override
    public void draw() {
        background(255);
        textSize(32);
        fill(0, 102, 153);
        text("Bubble", 10, 30);
        text("Merge", WIDTH / 2 + 25, 30);
        text("Quick", 10, HEIGHT / 2 + 50);
        text("Selection", WIDTH / 2 + 25, HEIGHT / 2 + 50);


        for (int i = 0; i < 100; i++) {
            fill(100);
            rect(i * BAR_WIDTH, HEIGHT / 2, BAR_WIDTH, -data1[i]);
            rect(500 + i * BAR_WIDTH, HEIGHT / 2, BAR_WIDTH, -data2[i]);
            rect(i * BAR_WIDTH, HEIGHT, BAR_WIDTH, -data3[i]);
            rect(500 + i * BAR_WIDTH, HEIGHT, BAR_WIDTH, -data4[i]);
        }
        fill(255, 0, 0);
        rect(WIDTH / 2, HEIGHT, 10, -HEIGHT);
        rect(0, HEIGHT / 2, WIDTH, 10);
    }
}

package sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array, int begin, int end) {
        if (end<=begin) return;
        int pivot = partition(array,begin,end);
        quickSort(array,begin,pivot-1);
        quickSort(array,pivot+1,end);
    }

    static int partition(int[] a, int begin, int end) {
        // pivot 标杆位置  counter 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i];  a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 25, 13, 56, 15, 555, 156, 1, 0, 3, 6, 9, 4, 2, 13, 57, 56, 1, 5, 8, 2, 4, 6, 9, 8, 4, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

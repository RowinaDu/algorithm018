package sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];
        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }

        System.arraycopy(temp, 0, array, left + 0, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 25, 13, 56, 15, 555, 156, 1, 0, 3, 6, 9, 4, 2, 13, 57, 56, 1, 5, 8, 2, 4, 6, 9, 8, 4, 2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}

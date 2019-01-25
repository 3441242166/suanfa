package main.leetcode;

public class binarySearch {

    public static void main(String[] ars){
        System.out.print(binarySearch(new int[]{1,2,3,4,5},5));
    }

    static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }

}

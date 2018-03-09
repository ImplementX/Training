package algorithm.binary_search;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;

            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,74,5,6,1,2,83,48,96,45,};
       int result =  binarySearch(nums,96);
        System.out.println(result);
    }
}

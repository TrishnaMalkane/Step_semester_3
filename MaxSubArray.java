public class MaxSubArray {
    static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            maxSoFar = Math.max(maxSoFar, current);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums)); // 6
    }
}

class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];
        for (int num : nums) {
            if (num % k == 0)
                present[num] = true;
        }
        for (int i = k; ; i += k) {
            if (i > 100 || !present[i])
                return i;
        }
    }
}
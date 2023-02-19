import java.util.HashSet;
import java.util.Set;

/**
 * 面试题3：数组中无重复的数字
 *
    针对这道题目有常见的几种思路：
    1. 暴力双重循环，拿着每一个元素去和其他元素比较；
    2. 排序后，顺序比较；
    3. 使用set集合；
    4. 交换元素；
    显然暴力解法时间复杂度是最高的，排序解法针对本题也不好，
    使用快排时间复杂度也得是O(nlogn)，排完序后还要遍历一遍
    所以主要介绍后两种解法
 */
public class FindRepeatNumber {
    /**
     * set方法最容易想到
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; ++i) {
            int num = nums[i];
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 交换元素
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            while(nums[i] != i) {
                if(nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i , int j) {
        int x = nums[j];
        nums[j] = nums[i];
        nums[i] = x;
    }

}

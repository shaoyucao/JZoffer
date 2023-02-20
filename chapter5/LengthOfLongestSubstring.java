import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 面试题48：最长不含重复字符的子字符串
 */
public class LengthOfLongestSubstring {
    /**
     * 动态规划
     *
     设f(i)表示以第i个字符为结尾的不含重复字符的最长长度，可以得到状态转换方程：
     f(i)={
        f(i-1)+1; 第i个字符之前没出现过
        d; 之前出现过，但和之前出现的字符距离差d小于等于f(i-1)，即d<f(i-1)
        f(i-1)+1; 之前出现过，且d>f(i-1)
     }

     // 以arabcacfr为例，在计算最后一个r，即f(8)的时候，出现d>f(7)的情况，可以把r追加到f(7)的后面

     这个思路是最通俗易懂的，但代码和时间上不是最优的

     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        if(n == 1)
            return 1;
        int[] mem = new int[n];
        Map<Character, Integer> map = new HashMap<>();

        //初始化
        mem[0] = 1;
        map.put(s.charAt(0), 0);

        for(int i = 1; i < n; ++i) {
            char c = s.charAt(i);
            //之前没有出现过，则f(i) = f(i-1)+1
            if(!map.containsKey(c)) {
                map.put(c, i);
                mem[i] = mem[i-1] + 1;
            }else{
                //之前出现过，记录差值d，并比较差值和f(i-1)的大小
                int before = map.get(c);
                int d = i - before;
                if(d <= mem[i-1]) {
                    mem[i] = d;
                }else {
                    mem[i] = mem[i-1]+1;
                }
                //最后记得更新这个值
                map.put(c, i);
            }
        }

        int maxLen = 0;
        for(int i = 0; i < n; ++i) {
            maxLen = Math.max(maxLen, mem[i]);
        }
        return maxLen;
    }

    /**
     * 滑动窗口（或者就左右指针）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        //abcabcbb
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        if(n == 1)
            return 1;
        Set<Character> set = new HashSet<>();
        int i = 0;
        set.add(s.charAt(0));

        int j = 1;
        int maxLen = 0;

        while(i < n) {
            while(j < n) {
                char c = s.charAt(j);
                if(set.contains(c)){
                    break;
                }
                set.add(c);
                j++;
            }
            maxLen = Math.max(maxLen, j-i);
            set.remove(s.charAt(i));
            i++;
        }

        return maxLen;
    }

    /**
     * 左右指针，j表示以第j个字符为结尾的不含重复字符的最长子串
     * 这里必须要注意一种情况，就是左边界需要取原左边界和当前元素在map中保存的值的最大值
     * 防止类似于abba这种字符串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int i = -1;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}

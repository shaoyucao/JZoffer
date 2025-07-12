import java.util.Arrays;

/**
 * 面试题4：二维数组中的查找
 *
 */
public class FindNumberIn2DArray {

    /**
     * 右上角法
     *
     * 利用数组的规律，从右上角出发：
     * 如果当前值小于目标值，则需要在当前值下方找，因为左边的值会更小；
     * 如果当前值大于目标值，则需要在当前值左边找，因为下方的值会更大；
     * 如果找到目标值，则返回true；
     * 如果超出左边界和下边界，则说明不存在目标值，返回false。
     *
     * @param matrix 二维数组
     * @param target 目标数字
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            int val = matrix[i][j];
            if (val == target) {
                return true;
            }
            if (val < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3,1,5,6};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

    }
}

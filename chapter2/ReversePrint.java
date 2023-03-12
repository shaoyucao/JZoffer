import java.util.*;

/**
 * 面试题6：从尾到头打印链表
 */
public class ReversePrint {
    /**
     * 方法1：集合反转
     *
     * 正向添加到集合中，将集合反转后输出数组，时间复杂度O(n)
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 方法2：栈
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int n = stack.size();
        int[] ret = new int[n];
        for (int i = 0; i < n; ++i) {
            ret[i] = stack.pop();
        }
        return ret;
    }

    /**
     * 方法3：两次遍历，向前填充数组
     *
     * @param head
     * @return
     */
    public int[] reversePrint3(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] ret = new int[count];
        cur = head;
        int i = count-1;
        while (cur != null) {
            ret[i] = cur.val;
            i--;
            cur = cur.next;
        }
        return ret;
    }

    /**
     * 方法4： 双端队列
     *
     * @param head
     * @return
     */
    public int[] reversePrint4(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        LinkedList<Integer> list = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            list.addFirst(cur.val);
            cur = cur.next;
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    /**
     * 方法5：递归
     *
     * @param head
     * @return
     */
    public int[] reversePrint5(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        recursive(head, list);
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void recursive(ListNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        }
        recursive(cur.next, list);
        list.add(cur.val);
    }


}

/**
 * 面试题5：替换空格
 */
public class ReplaceSpace {
    /**
     * 可变字符串
     *
     * Java 中采用可变字符串StringBuilder实现接口
     * 有一点需要注意：当输入的字符串为空字符串或者长度为0时，原样输出即可
     *
     * @param s 输入的字符串
     * @return
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

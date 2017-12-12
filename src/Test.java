import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * Created by lixiangwei2 on 2017/11/6.
 */
public class Test {

    // 返回中文的首字母
    public static String getPinYinHeadChar(String str) {

        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    public static void main(String[] args) {
        System.out.println(getPinYinHeadChar("重庆"));
    }
}

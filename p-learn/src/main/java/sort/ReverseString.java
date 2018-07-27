package sort;

/**
 * created by qinwanxin on 2018/7/18 14:41
 */
public class ReverseString {
    /**
     *翻转字符串
     */
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString("hellokitty"));
        System.out.println(reverseString("hello好了是kitty"));
        for(char c :"hello好了是kitty".toCharArray()){
            System.out.println(c);
        }
        for(char c :reverseString("hello好了是kitty").toCharArray()){
            System.out.println(c);
        }
    }

    public static String reverseString(String org){
        StringBuilder stringBuilder = new StringBuilder(org);
        for(int i=0;i<stringBuilder.length()/2;i++){
            char tem = stringBuilder.charAt(i);
            int reposition = stringBuilder.length()-1-i;
            stringBuilder.setCharAt(i,stringBuilder.charAt(reposition));
            stringBuilder.setCharAt(reposition,tem);

        }
        return stringBuilder.toString();
    }
}

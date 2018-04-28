package time;

/**
 * Created by qinwanxin on 2018/2/27.
 */
public class TimeTest {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String s = TimeTest.createIndices(1, "", 1536, false)[666];
            System.out.println(s);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("createIndices const " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String s = TimeTest.createIndices2("", 1536, false, 666);
            System.out.println(s);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("createIndices2 const " + (end2 - start2));
    }

    protected static String[] createIndices(int startWith, String prefix, int count, boolean needPadToAlign) {
        String[] indices = new String[count];
        int indexNumberSize = String.valueOf(count).length();
        int dbNum = startWith;
        for (int i = 0; i < count; i++) {
            String index = String.valueOf(dbNum++);
            if (needPadToAlign) {
                int padCount = indexNumberSize - index.length();
                while (padCount-- > 0) {
                    index = "0" + index;
                }
            }
            indices[i] = prefix + index;
        }
        return indices;
    }

    protected static String createIndices2(String prefix, int count, boolean needPadToAlign, int targetIndex) {
        int indexNumberSize = String.valueOf(count).length();

        String tarStr = String.valueOf(targetIndex);
        StringBuilder stringBuilder = new StringBuilder();
        if (needPadToAlign) {
            int padCount = indexNumberSize - tarStr.length();
            while (padCount-- > 0) {
                stringBuilder.append("0");
            }
        }

        return prefix + stringBuilder.toString() + tarStr;
    }

}

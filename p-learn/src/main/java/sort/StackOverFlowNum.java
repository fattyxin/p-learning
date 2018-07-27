package sort;

/**
 * created by qinwanxin on 2018/7/19 14:35
 */
public class StackOverFlowNum {
    /**
     * stack 深度太多会
     */

    public static void main(String[] args) {
        try {
//            int i=0;
//            String [] ss = new String[500];
//            while(i<500){
//                ss[i]=i+"";
//                i++;
//            }
            callMethod();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("num="+num);
        }
    }
    public static void callMethod(){
        num++;

        callMethod();
       String [] ss = new String[1024];
        String [] sss = new String[1024];
    }

    private static int num = 0;
}

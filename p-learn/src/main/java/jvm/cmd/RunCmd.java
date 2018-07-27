package jvm.cmd;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by qinwanxin on 2018/7/26 14:23
 */
public class RunCmd {
    public static void main(String[] args) {
//        String cmd = "jps -ml";
        String cmd = "jstat -gc";
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            int exitcode = process.waitFor();
            System.out.println("exitcode = " + exitcode);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
            byte[] buffer = new byte[1024];
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
//            while(bufferedInputStream.read(buffer)!=-1){
//                System.out.println(buffer);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

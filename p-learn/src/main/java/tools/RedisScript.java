package tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinwanxin on 2016/10/9.
 */
public class
        RedisScript {
    public static void main(String[] args) {
        String masterIp = "172.28.66.84";
        int masterPortStart = 6380;
        int masterPortEnd = 6399;
        String slaveIp = "172.20.115.51";
        int slavePortStart = 6380;
        int slavePortEnd = 6399;

        /**
         *
         * {"instruction":"SlaveOfNoOne","host":"172.28.66.90","port":6380}(从ip:port) 断开复制关系
         * {"instruction":"SlaveOfNoOneInDB","host":"172.28.66.90","port":6389} (从ip:port) 断开主从关系
         * {"instruction":"SlaveOfInDB","slaveHost":"172.28.66.92","slavePort":6387,"masterHost":"172.28.66.88","masterPort":6387} 建立主从关系
         * {"instruction":"SlaveOf","slaveHost":"172.28.66.92","slavePort":6390,"masterHost":"172.28.66.88","masterPort":6390} 建立复制关系
         */

        List<Integer> slavePorts = new ArrayList<Integer>();
        for(int portStart=slavePortStart;portStart<=slavePortEnd;portStart++){
            slavePorts.add(portStart);
        }

        List<Integer> masterPorts = new ArrayList<Integer>();
        for(int portStart=masterPortStart;portStart<=masterPortEnd;portStart++){
            masterPorts.add(portStart);
        }

        if(slavePorts.size()!=masterPorts.size()){
            System.out.println("param error");
            return;
        }

        System.out.println("===============断开主从关系===============");
        for(Integer port : slavePorts){
            System.out.println("{\"instruction\":\"SlaveOfNoOneInDB\",\"host\":\""+slaveIp+"\",\"port\":"+port+"}");
        }

        System.out.println("===============断开复制关系===============");
        for(Integer port : slavePorts){
           System.out.println("{\"instruction\":\"SlaveOfNoOne\",\"host\":\""+slaveIp+"\",\"port\":"+port+",\"waitSync\":false}");
        }

        System.out.println("===============建立主从关系===============");
        for(int i=0;i<slavePorts.size();i++){
            System.out.println("{\"instruction\":\"SlaveOfInDB\",\"slaveHost\":\""+slaveIp+"\",\"slavePort\":"+slavePorts.get(i)
                    +",\"masterHost\":\""+masterIp+"\",\"masterPort\":"+masterPorts.get(i)+"}");
        }

        System.out.println("===============建立复制关系===============");
        for(int i=0;i<slavePorts.size();i++){
            System.out.println("{\"instruction\":\"SlaveOf\",\"slaveHost\":\""+slaveIp+"\",\"slavePort\":"+slavePorts.get(i)
                    +",\"masterHost\":\""+masterIp+"\",\"masterPort\":"+masterPorts.get(i)+",\"waitSync\":false}");
        }

    }

    private void slaveOfNoOne(String slaveIp,int port){

    }
}

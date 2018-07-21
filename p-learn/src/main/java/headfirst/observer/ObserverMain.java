package headfirst.observer;

public class ObserverMain {
    /**
     * 观察者模式
     * 观察者模式定义了对象之前的一对多以来，这样以来，
     * 当一个对象改变状态时，它的所有依赖者都会收到通知并自动跟新。
     *
     *
     * 火车站 广播 检票
     * 候车乘客 听到通知 查看是否为自己车次
     * 是的前往检票  不是则继续等待
     */

    public static void main(String[] args) {
        Subject trainSubject = new TrainVoiceSubject();
        Passenger p1 = new Passenger(trainSubject);
        p1.setTrainNum2Take("t66");

        Passenger p2 = new Passenger(trainSubject);
        p2.setTrainNum2Take("t109");
        ((TrainVoiceSubject)trainSubject).setTrainNum("t66");
        trainSubject.notifyObservers(trainSubject);
    }
}

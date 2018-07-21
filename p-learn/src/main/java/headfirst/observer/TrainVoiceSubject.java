package headfirst.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class TrainVoiceSubject implements Subject {
    private LinkedList<Observer> observers;
//    private static ThreadPoolExecutor executor =
//            new ThreadPoolExecutor(10,10,
//                    1, TimeUnit.SECONDS,
//                    new ArrayBlockingQueue<Runnable>(50),new ThreadPoolExecutor.CallerRunsPolicy());
    private static ThreadPoolExecutor executor =
        new ThreadPoolExecutor(10,10,
                1, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());

    private String trainNum;

    public TrainVoiceSubject(){
        observers = new LinkedList<Observer>();
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Subject subject) {
        for(Observer observer:observers){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observer.update(subject);
                }
            });

        }
    }


    public void voiceTrain(String trainNum){
        this.trainNum = trainNum;
        notifyObservers(this);
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }
}

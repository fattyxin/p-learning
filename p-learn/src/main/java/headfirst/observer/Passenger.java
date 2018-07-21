package headfirst.observer;

/**
 *
 */
public class Passenger implements Observer{
   private String trainNum2Take;
    public Passenger(Subject subject){
        subject.addObserver(this);
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof TrainVoiceSubject){
            if(this.getTrainNum2Take().equalsIgnoreCase(((TrainVoiceSubject)subject).getTrainNum())){
                System.out.println("oh it is my train "+this.getTrainNum2Take());
            } else {
                System.out.println("ai~ it is not my train,it is "+((TrainVoiceSubject) subject).getTrainNum()+" i am waiting to the "+this.getTrainNum2Take());
            }
        }
    }

    public String getTrainNum2Take() {
        return trainNum2Take;
    }

    public void setTrainNum2Take(String trainNum2Take) {
        this.trainNum2Take = trainNum2Take;
    }
}

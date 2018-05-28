package headfirst.observer;

/**
 * passenger one goto T65
 */
public class Passenger implements Observer{
   private String trainNum2Take;
    public Passenger(Subject subject){
//        subject.addObserver(this);
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof TrainVoiceSubject){
//            if(trainNum2Take.equalsIgnoreCase()){
//
//            }
        }
    }


    
}

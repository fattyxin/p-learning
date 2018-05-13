package headfirst.observer;

/**
 * passenger one goto T65
 */
public class PassengerOne implements Observer{
   private String trainNum2Take;
    public PassengerOne(Subject subject){
        subject.addObserver(this);
    }

    @Override
    public void update(Subject subject) {
        if(subject instanceof TrainVoiceSubject){
            if(trainNum2Take.equalsIgnoreCase()){

            }
        }
    }


    
}

package headfirst.state;

/**
 * created by qinwanxin on 2018/6/20 10:17
 */
public class OrderStateMachine {
    private OrderState waitPayState;
    private OrderState waitSendState;
    private OrderState doneState;

    private OrderState concurrentState;

    public OrderStateMachine() {
        waitPayState = new WaitPayState(this);
        waitSendState = new WaitSendState(this);
        doneState = new DoneState(this);
        concurrentState = waitPayState;
    }

    public OrderStateMachine(OrderState concurrentState) {
        this();
        this.concurrentState = concurrentState;
    }

    public void changeOrderState(OrderState orderState){
        this.concurrentState = orderState;
    }


    public void payOrder(){
        concurrentState.payOrder();
    }
    public void sendOrder(){
        concurrentState.sendOrder();
    }
    public void cancleOrder(){
        concurrentState.cancelOrder();
    }

    public OrderState getWaitPayState() {
        return waitPayState;
    }

    public OrderState getWaitSendState() {
        return waitSendState;
    }

    public OrderState getDoneState() {
        return doneState;
    }

    public OrderState getConcurrentState() {
        return concurrentState;
    }
}

package headfirst.state;

/**
 * created by qinwanxin on 2018/6/20 14:03
 */
public class WaitSendState implements OrderState {
    private OrderStateMachine orderStateMachine;

    public WaitSendState(OrderStateMachine orderStateMachine) {
        this.orderStateMachine = orderStateMachine;
    }

    @Override
    public void payOrder() {
        System.out.println("you has payed!");
    }

    @Override
    public void sendOrder() {
        System.out.println("your order begin to send!");
        orderStateMachine.changeOrderState(orderStateMachine.getDoneState());
    }

    @Override
    public void cancelOrder() {
        System.out.println("your order can not be cancel!");
    }
}

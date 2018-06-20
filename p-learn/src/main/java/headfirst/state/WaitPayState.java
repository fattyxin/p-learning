package headfirst.state;

/**
 * created by qinwanxin on 2018/6/20 11:12
 */
public class WaitPayState implements OrderState {
    private OrderStateMachine orderStateMachine;

    public WaitPayState(OrderStateMachine orderStateMachine) {
        this.orderStateMachine = orderStateMachine;
    }

    @Override
    public void payOrder() {
        System.out.println("pay successfully!");
        orderStateMachine.changeOrderState(orderStateMachine.getWaitSendState());
    }

    @Override
    public void sendOrder() {
        System.out.println("please pay order before send!");
    }

    @Override
    public void cancelOrder() {
        System.out.println("cancel successfully!");
        orderStateMachine.changeOrderState(orderStateMachine.getDoneState());
    }
}

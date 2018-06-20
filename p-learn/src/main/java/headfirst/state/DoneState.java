package headfirst.state;

/**
 * created by qinwanxin on 2018/6/20 14:08
 */
public class DoneState implements OrderState {
    private OrderStateMachine orderStateMachine;

    public DoneState(OrderStateMachine orderStateMachine) {
        this.orderStateMachine = orderStateMachine;
    }

    @Override
    public void payOrder() {
        System.out.println("your order has be done!can not pay!");
    }

    @Override
    public void sendOrder() {
        System.out.println("your order has be done!can not send!");
    }

    @Override
    public void cancelOrder() {
        System.out.println("your order has be done!can not cancel");
    }
}

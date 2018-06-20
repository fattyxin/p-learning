package headfirst.state;

import java.io.Serializable;

/**
 * created by qinwanxin on 2018/6/20 14:18
 */
public class Order implements Serializable {
    private String orderId;
    private OrderStateMachine orderStateMachine;

    public Order(String orderId) {
        this.orderId = orderId;
        this.orderStateMachine = new OrderStateMachine();
    }

    @Override
    public String toString() {
        return "order "+orderId +" concurrentState is "+orderStateMachine.getConcurrentState().getClass().getSimpleName();
    }

    public OrderStateMachine getOrderStateMachine() {
        return orderStateMachine;
    }
}

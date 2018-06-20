package headfirst.state;

/**
 * created by qinwanxin on 2018/6/20 9:56
 */
public interface OrderState {
    void payOrder();

    void sendOrder();

    void cancelOrder();
}

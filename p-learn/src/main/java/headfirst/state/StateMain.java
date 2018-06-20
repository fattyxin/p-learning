package headfirst.state;

/**
 * created by qinwanxin on 2018/6/15 18:31
 */
public class StateMain {

    /**
     *
     * 状态模式
     * 状态模式允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。
     *
     *
     * 订单状态。
     * 待支付-->待配送-->完成。
     * 待支付-->取消-->完成。
     * 动作：提交订单、支付、配送、取消
     */
    public static void main(String[] args) {
        Order order1 = new Order("1111");
        Order order2 = new Order("2222");
        System.out.println(order1);
        order1.getOrderStateMachine().payOrder();
        System.out.println(order1);
        order1.getOrderStateMachine().payOrder();
        System.out.println(order1);
        order1.getOrderStateMachine().sendOrder();
        System.out.println(order1);
        System.out.println(order2);
        order2.getOrderStateMachine().payOrder();
        System.out.println(order2);
        order2.getOrderStateMachine().cancleOrder();
        System.out.println(order2);
    }
}

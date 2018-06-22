package headfirst.proxy;

/**
 * created by qinwanxin on 2018/6/21 10:16
 */
public class ProxyMain {
    /**
     *
     * 代理模式
     * 代理模式为另一个对象提供一个替身或占位符以控制对这个对象的访问。
     *
     * 经理 有 开会 和 审批 两个动作
     * 助理可以代经理审批 但是不能代经理 开会
     *
     */
    public static void main(String[] args) {

        Manager manager = ManagerProxyFactory.getManagerProxy("manager",new ManageImpl());
        Manager assistant = ManagerProxyFactory.getManagerProxy("assistant",new ManageImpl());

        manager.approve("休假申请");
        manager.approve("特朗普");

        assistant.approve("休假申请");
        assistant.meeting("奥巴马");

    }
}

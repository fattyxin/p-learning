package headfirst.proxy;

import java.lang.reflect.Proxy;

/**
 * created by qinwanxin on 2018/6/22 14:06
 */
public class ManagerProxyFactory {
    public static Manager getManagerProxy(String type, Manager manager){
        if("manager".equals(type)){
            return (Manager) Proxy.newProxyInstance(manager.getClass().getClassLoader(),manager.getClass().getInterfaces(),new ManagerInvocationHandler(manager));
        }
        if("assistant".equals(type)){
            return (Manager) Proxy.newProxyInstance(manager.getClass().getClassLoader(),manager.getClass().getInterfaces(),new AssistantInvocationHandler(manager));
        }
        return null;
    }
}

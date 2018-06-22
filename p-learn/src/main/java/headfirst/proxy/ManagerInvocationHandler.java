package headfirst.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created by qinwanxin on 2018/6/22 14:10
 */
public class ManagerInvocationHandler implements InvocationHandler {
    private Manager manager;

    public ManagerInvocationHandler(Manager manager) {
        this.manager = manager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("manager invoke "+method.getName());

        return method.invoke(manager,args);
    }
}

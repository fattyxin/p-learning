package headfirst.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created by qinwanxin on 2018/6/22 14:31
 */
public class AssistantInvocationHandler implements InvocationHandler {
    private Manager manager;

    public AssistantInvocationHandler(Manager manager) {
        this.manager = manager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(!"approve".equals(method.getName())){
            throw new  UnsupportedOperationException("assistant can meet");
        }
        System.out.println("assistant invoke "+method.getName());
        return method.invoke(manager,args);
    }
}

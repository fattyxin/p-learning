package spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by qinwanxin on 2017/8/1.
 */
public class PeopleNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("people",new PeopleDefinitionParser());
    }
}

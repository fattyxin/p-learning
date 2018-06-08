package headfirst.methodtemplate;

/**
 * created by qinwanxin on 2018/6/8 9:19
 */
public class MethodTemplateMain {

    /**
     *
     * 模板方法模式
     * 模板方法模式在一个方法中定义一个算法的骨架，而将一下步骤延迟到子类中。
     * 模板方法使得子类可以在不改变算法机构的情况下，重新定义算法中的某些步骤。
     *
     * Programmer 的一天
     * commonProgrammer 上班、干活、吃饭、下班
     * kubiProgrammer 上班、干活、吃饭、加班、下班
     *
     * 可以看出 共性的 上班 、干活、吃饭、下班  可选的加班。。。
     * 流程在父类中定义，子类可以实现自己个性化的东西
     * 做什么 和吃什么 可以自己确定  但是 每天 要有 上班、干活、吃饭、下班 的步骤
     */

    public static void main(String[] args) {
        Programmer cp = new CommonProgrammer();
        Programmer kubi = new KubiProgrammer();
        cp.onDay();
        kubi.onDay();
    }
}

package sort;

import org.springframework.util.Assert;

import java.lang.reflect.Field;

/**
 * created by qinwanxin on 2018/7/19 10:12
 */
public class ReflectModifier {
    public static void main(String[] args) {
        ReflectModifier rflectModifier = new ReflectModifier("nnnnnn");

        Assert.isTrue("nnnnnn".equals(rflectModifier.getName()));
        Assert.isTrue("99".equals(rflectModifier.getAge()));
        Assert.isTrue(rflectModifier.getInteger().equals(999));
        try {
            Field nameFiled = rflectModifier.getClass().getDeclaredField("name");
            Field ageFiled = rflectModifier.getClass().getDeclaredField("age");
            Field integerFiled = rflectModifier.getClass().getDeclaredField("integer");

            nameFiled.setAccessible(true);
            nameFiled.set(rflectModifier,"kitty");
            Assert.isTrue("kitty".equals(rflectModifier.getName()));

            ageFiled.setAccessible(true);
            ageFiled.set(rflectModifier,"88");
            System.out.println(rflectModifier.getAge());
//            Assert.isTrue("88".equals(rflectModifier.getAge()));

            integerFiled.setAccessible(true);
            integerFiled.set(rflectModifier,666);
            System.out.println(rflectModifier.getInteger());
            Assert.isTrue(rflectModifier.getInteger().equals(666));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReflectModifier(String name) {
        this.name = name;
    }

    private String name;
    private final String age="99";
    private final Integer integer=999;
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public Integer getInteger() {
        return integer;
    }
}

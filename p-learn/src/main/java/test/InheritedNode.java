package test;

import java.util.List;

/**
 * Created by xueyanlei on 2016/10/18.
 */
public interface InheritedNode<T> {
    boolean isChildFrom(T node);
    boolean isBrother(T node);
    void addChildNode(T node);
    List<T> getChildNodes();
}

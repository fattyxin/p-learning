package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xueyanlei on 2016/10/18.
 */
public class SimpleNode implements InheritedNode<SimpleNode>{
    private String id;
    private String fid;
    private String name;
    private int sum;
    private List<SimpleNode> subSimpleNodeList;
    private String url;
    private String icon;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleNode(String id, String fid,String name,int sum,String url,String icon) {
        this.id = id;
        this.fid = fid;
        this.name = name;
        this.sum = sum;
        this.url = url;
        this.icon = icon;
    }

    public void addSubSimpleNode(SimpleNode subSimpleNode) {
    }

    public String toString() {
        //return id+","+name+","+fid;
        return id;
    }

    @Override
    public void addChildNode(SimpleNode node) {
        if(subSimpleNodeList == null) {
            subSimpleNodeList = new ArrayList<SimpleNode>();
        }
        subSimpleNodeList.add(node);
    }

    @Override
    public List<SimpleNode> getChildNodes() {
        return subSimpleNodeList;
    }

    @Override
    public boolean isBrother(SimpleNode node) {
        return this.fid.equals(((SimpleNode)node).getFid());
    }

    @Override
    public boolean isChildFrom(SimpleNode node) {
		/*
		boolean flag = this.fid.equals(node.getId());
		if(flag){
			node.setSum(sum+1);
		}
		*/
        return this.fid.equals(node.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}

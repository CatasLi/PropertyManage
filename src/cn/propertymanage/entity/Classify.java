package cn.propertymanage.entity;
/**
 * 资产类别类
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-13
 */
public class Classify {
    private String name;
    private String parent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
}

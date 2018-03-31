package cn.propertymanage.entity;
/**
 * 员工类
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-13
 */
public class Man {
    private int id;            //用户id
    private String name;       //用户名
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}	
	public void setPosition(String position) {
		this.position = position;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	private String position;   //用户职务
    private String others;     //备注
}

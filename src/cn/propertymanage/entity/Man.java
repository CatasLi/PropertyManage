package cn.propertymanage.entity;
/**
 * Ա����
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-13
 */
public class Man {
    private int id;            //�û�id
    private String name;       //�û���
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
	private String position;   //�û�ְ��
    private String others;     //��ע
}

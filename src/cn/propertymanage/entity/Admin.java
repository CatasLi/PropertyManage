package cn.propertymanage.entity;
/**
 * 管理员账户类
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-13
 */
public class Admin {
	private String name;       //管理员用户名
    private String password;   //管理员密码
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

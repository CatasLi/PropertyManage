package cn.propertymanage.entity;
/**
 * 固定资产类
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-13
 */
public class Property {
    private int id;           //资产id
    private String name;      //名称
    private String classify;  //类别
    private String model;     //型号
    private int value;        //价值
    private String buyDate;   //购买日期
    private String status;    //状态
    private String iuser;     //使用者
    private String others;    //备注
    private String useDate;   //借用日期
    private String admin;     //借用时的管理员
    private String usefor;    //用途
    private String useOthers; //借用的备注
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
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIuser() {
		return iuser;
	}
	public void setIuser(String iuser) {
		this.iuser = iuser;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getUsefor() {
		return usefor;
	}
	public void setUsefor(String usefor) {
		this.usefor = usefor;
	}
	public String getUseOthers() {
		return useOthers;
	}
	public void setUseOthers(String useOthers) {
		this.useOthers = useOthers;
	}
}

package cn.propertymanage.entity;
/**
 * �̶��ʲ���
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-13
 */
public class Property {
    private int id;           //�ʲ�id
    private String name;      //����
    private String classify;  //���
    private String model;     //�ͺ�
    private int value;        //��ֵ
    private String buyDate;   //��������
    private String status;    //״̬
    private String iuser;     //ʹ����
    private String others;    //��ע
    private String useDate;   //��������
    private String admin;     //����ʱ�Ĺ���Ա
    private String usefor;    //��;
    private String useOthers; //���õı�ע
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

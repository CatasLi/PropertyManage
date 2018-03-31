package cn.propertymanage.dao;
import java.util.List;
import cn.propertymanage.entity.Property;

public class PropertyDaoImpl extends BaseDao implements PropertyDao{

	@Override
	public int Add(Property pro) {
		String sql="insert into property (name,class,model,value,buydate,[status],iuser,others)values(?,?,?,?,?,?,?,?)";
	    Object[]param={pro.getName(),pro.getClassify(),pro.getModel(),pro.getValue(),pro.getBuyDate(),pro.getStatus(),pro.getIuser(),pro.getOthers()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}

	@Override
	public void Show(Property pro) {
		System.out.println(pro.getId()+"\t"+pro.getName()+"\t"+pro.getClassify()+"\t"+pro.getModel()+"\t"+pro.getValue()+"\t"+pro.getBuyDate()+"\t"+pro.getStatus()+"\t"+pro.getIuser()+"\t"+pro.getOthers());
	}

	@Override
	public int Del(Property pro) {
		String sql="delete from property where name=?";
	    Object[]param={pro.getName()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}
	@Override
	public List<Property> FindbyUser(String user) {
		String sql="select * from property where iuser=?";
	    Object[]param={user};
	    return this.FindbyClass(sql, param);   
	}

	@Override
	public int Update(Property pro) {
		String sql="update  property set (name,class,model,value,buydate,status,iuser,others)values(?,?,?,?,?,?,?,?)where name=?";
		Object[]param={pro.getName(),pro.getClassify(),pro.getModel(),pro.getValue(),pro.getBuyDate(),pro.getStatus(),pro.getIuser(),pro.getOthers(),pro.getName()}; 
		return this.executeUpdate(sql,param);
	}

	@Override
	public int UpdateforUse(Property pro) {
		String sql="update property set iuser=?,usedate=?,admin=?,usefor=?,useothers=? where name=?";
		Object[]param={pro.getIuser(),pro.getUseDate(),pro.getAdmin(),pro.getUsefor(),pro.getUseOthers(),pro.getName()}; 
		return this.executeUpdate(sql,param);
	}

	@Override
	public void ShowAll() {
		this.ShowPro();
	}

	@Override
	public Property FindbyName(String name) {
		String sql="select * from property where name=?";
		Object[]param={name}; 
		Property pro=this.executePro(sql,param);
		return pro;
	}

	@Override
	public Property FindbyId(int id) {
		String sql="select * from property where id=?";
		Object[]param={id}; 
		Property pro=this.executePro(sql,param);
		return pro;
	}

	@Override
	public boolean isLend(String name) {
		String sql="select * from property where name=?";
		Object[]param={name}; 
		Property pro=this.executePro(sql,param);
		if(pro.getIuser().equals("无")&&pro.getStatus().equals("正常")){	
			return true;
		}
		else{
			System.out.println("213");
			return false;
		}
	}

	@Override
	public boolean isBack(String name) {
		String sql="select * from property where name=?";
		Object[]param={name}; 
		Property pro=this.executePro(sql,param);
		if(!pro.getIuser().equals("无")){
			return true;
		}
		else{
			return false;
		}
	}

}

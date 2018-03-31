package cn.propertymanage.dao;
/**
 * AdminDaoµÄÊµÏÖ
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-14
 */
import cn.propertymanage.entity.Admin;

public class AdminDaoImpl extends BaseDao implements AdminDao{

	@Override
	public int Add(Admin ad) {
		String sql="insert into admin(adname,adpassword)values(?,?)";
	    Object[]param={ad.getName(),ad.getPassword()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}

	@Override
	public int Del(Admin ad) {
		String sql="delete from admin where adname=?";
	    Object[]param={ad.getName()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}

	@Override
	public Admin FindbyName(Admin ad) {
		String sql="select * from admin where adname=?";
		Object[]param={ad.getName()};    
	    return this.executeAd(sql,param);
	}

	@Override
	public int Update(Admin ad) {
		String sql="Update  Admin set adname=?,adpassword=? where adname=?";
	    Object[]param={ad.getName(),ad.getPassword(),ad.getName()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}
    	
	@Override
	public void Show(Admin ad) {
		String sql="select * from admin where adname=?";
		Object[]param={ad.getName()}; 
		Admin adtemp=this.executeAd(sql,param);
		System.out.println(adtemp.getName()+"\t"+adtemp.getPassword());
	}
}

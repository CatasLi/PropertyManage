package cn.propertymanage.dao;

import java.util.List;
import cn.propertymanage.entity.Classify;
import cn.propertymanage.entity.Property;

public class ClassifyDaoImpl extends BaseDao implements ClassifyDao{

	@Override
	public int Add(Classify cl) {
		String sql="insert into class(name,parent)values(?,?)";
	    Object[]param={cl.getName(),cl.getParent()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}

	@Override
	public int Del(Classify cl) {
		String sql="delete from class where name=?";
		String sql2="delete from class where parent=?";		
	    Object[]param={cl.getName()};
	    Object[]param2={cl.getName()};
	    int result=this.executeUpdate(sql, param)+this.executeUpdate(sql2, param2);
	    return result;
	}

	@Override
	public List<Property> FindbyClass(Classify cl) {
		String sql="select * from property where class=?";
	    Object[]param={cl.getName()};
	    return this.FindbyClass(sql, param);  
	}

}

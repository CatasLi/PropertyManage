package cn.propertymanage.dao;
/**
 * man类的dao实现接口
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-13
 */
import cn.propertymanage.entity.Man;

public class ManDaoImpl extends BaseDao implements ManDao{


	@Override
	public Man FindbyName(String name) {
		String sql="select * from man where name='"+name+"'";
		Object[]param={}; 
		Man man=new Man();
		man=this.executeMan(sql,param);
		return man;
	}

	@Override
	public void ShowAll() {
		this.ShowMan();
	}

	@Override
	public int Add(Man man) {	
		String sql="insert into man(name,position,others)values(?,?,?)";
	    Object[]param={man.getName(),man.getPosition(),man.getPosition()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}

	@Override
	public int Del(Man man) {
		String sql="delete from man where name=?";
	    Object[]param={man.getName()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}

	@Override
	public void Show(Man man) {
		System.out.println(man.getName()+"\t"+man.getPosition()+"\t"+man.getOthers());
	}

	@Override
	public int Update(Man man) {
		String sql="Update  man set name=?,position=?,others=? where name=?";
	    Object[]param={man.getName(),man.getPosition(),man.getPosition(),man.getName()};
	    int result=this.executeUpdate(sql, param);
	    return result;
	}
}

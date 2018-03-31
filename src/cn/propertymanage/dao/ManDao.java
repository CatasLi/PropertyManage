package cn.propertymanage.dao;
/**
 * man类的dao接口
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-13
 */
import cn.propertymanage.entity.Man;

public interface ManDao {
	 int Add(Man man);  //增加员工
	 int Del(Man man);  //删除员工
	 int Update(Man man);
	 Man FindbyName(String name);
	 void ShowAll();
	 void Show(Man man);
}

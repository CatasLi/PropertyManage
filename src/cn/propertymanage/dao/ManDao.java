package cn.propertymanage.dao;
/**
 * man���dao�ӿ�
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-13
 */
import cn.propertymanage.entity.Man;

public interface ManDao {
	 int Add(Man man);  //����Ա��
	 int Del(Man man);  //ɾ��Ա��
	 int Update(Man man);
	 Man FindbyName(String name);
	 void ShowAll();
	 void Show(Man man);
}

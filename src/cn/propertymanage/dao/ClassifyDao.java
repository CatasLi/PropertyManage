package cn.propertymanage.dao;

import java.util.List;
import cn.propertymanage.entity.Classify;
import cn.propertymanage.entity.Property;
public interface ClassifyDao {
	int Add(Classify cl);  //ɾ��Ա��
	int Del(Classify cl);
	List<Property> FindbyClass(Classify cl);
}

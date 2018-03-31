package cn.propertymanage.dao;
/**
 * Property���dao�ӿ�
 * @author CatasLi
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-13
 */
import java.util.List;

import cn.propertymanage.entity.Property;

public interface PropertyDao {
    int Add(Property pro);
    int Del(Property pro);
    Property FindbyName(String name);
    Property FindbyId(int id);
    int Update(Property pro);               //�ʲ���Ϣ�ĸ���
    int UpdateforUse(Property pro);         //���ʱ���޸�
    List<Property> FindbyUser(String user);
    void ShowAll();
    void Show(Property pro);
    boolean isLend(String name);             //�Ƿ���Խ�������Է���TRUE
    boolean isBack(String name);              //�Ƿ���Թ黹�����Է���TRUE
}

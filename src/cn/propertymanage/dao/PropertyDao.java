package cn.propertymanage.dao;
/**
 * Property类的dao接口
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
    int Update(Property pro);               //资产信息的更新
    int UpdateforUse(Property pro);         //借出时的修改
    List<Property> FindbyUser(String user);
    void ShowAll();
    void Show(Property pro);
    boolean isLend(String name);             //是否可以借出，可以返回TRUE
    boolean isBack(String name);              //是否可以归还，可以返回TRUE
}

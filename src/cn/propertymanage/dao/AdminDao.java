package cn.propertymanage.dao;
/**
 * Admin类的dao接口
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-14
 */
import cn.propertymanage.entity.Admin;

public interface AdminDao {
	int Add(Admin ad);                  //增加管理员
    int Del(Admin ad);                  //删除管理员
    Admin FindbyName(Admin ad);         //按名字查找
    int Update(Admin ad);        //修改密码
    void Show(Admin ad);                //显示管理员信息
}

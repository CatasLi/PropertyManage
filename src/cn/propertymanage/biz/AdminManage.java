package cn.propertymanage.biz;
/**
 * Admin类Manage接口
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-17
 */
public interface AdminManage {
     boolean Login();     //管理登陆
     void Add();          //添加
     void Del();   //删除
     void UpdatePassword();
}

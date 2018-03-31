package cn.propertymanage.biz;
/**
 * Man类Manage接口
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-17
 */
public interface ManManage {
    void Add();
    void Del();
    void Update();                 //修改
    void FindbyName();             //按名字查找
    void ShowAll();                //显示全部
    void ViewbyUser();             //按使用者查看资产
}

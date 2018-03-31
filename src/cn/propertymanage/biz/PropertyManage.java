package cn.propertymanage.biz;
/**
 * Property类的Manage接口
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-14
 */
import cn.propertymanage.entity.Property;

public interface PropertyManage {
    void Add();
    void Del();
    Property FindbyName();             //按资产名称查找
    Property FindbyId();               //按资产编号查找     
    void ShowAll();                    //显示全部资产
    void Update();                     //修改
    void Lend();                       //资产借出
    void Back();                       //资产归还
}

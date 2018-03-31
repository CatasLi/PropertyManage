package cn.propertymanage.biz;
/**
 * Property���Manage�ӿ�
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-14
 */
import cn.propertymanage.entity.Property;

public interface PropertyManage {
    void Add();
    void Del();
    Property FindbyName();             //���ʲ����Ʋ���
    Property FindbyId();               //���ʲ���Ų���     
    void ShowAll();                    //��ʾȫ���ʲ�
    void Update();                     //�޸�
    void Lend();                       //�ʲ����
    void Back();                       //�ʲ��黹
}

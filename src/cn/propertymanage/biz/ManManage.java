package cn.propertymanage.biz;
/**
 * Man��Manage�ӿ�
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-17
 */
public interface ManManage {
    void Add();
    void Del();
    void Update();                 //�޸�
    void FindbyName();             //�����ֲ���
    void ShowAll();                //��ʾȫ��
    void ViewbyUser();             //��ʹ���߲鿴�ʲ�
}

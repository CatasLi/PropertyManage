package cn.propertymanage.dao;
/**
 * Admin���dao�ӿ�
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-14
 */
import cn.propertymanage.entity.Admin;

public interface AdminDao {
	int Add(Admin ad);                  //���ӹ���Ա
    int Del(Admin ad);                  //ɾ������Ա
    Admin FindbyName(Admin ad);         //�����ֲ���
    int Update(Admin ad);        //�޸�����
    void Show(Admin ad);                //��ʾ����Ա��Ϣ
}

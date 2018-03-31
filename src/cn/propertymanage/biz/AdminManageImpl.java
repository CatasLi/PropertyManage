package cn.propertymanage.biz;
/**
 * Admin��Manage�ӿڵ�ʵ��
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-17
 */
import java.util.Scanner;
import cn.propertymanage.dao.AdminDao;
import cn.propertymanage.dao.AdminDaoImpl;
import cn.propertymanage.entity.Admin;

public class AdminManageImpl implements AdminManage{

	@Override
	public boolean Login() {
		Admin ad=new Admin();
		boolean isLogin=false;
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		boolean conn;
		do{
			AdminDao admindao=new AdminDaoImpl();
		    conn=false;
		    System.out.print("�������Ա�û�����");
		    String userName=input.next();
		    System.out.print("�������Ա���룺");
		    String passWord=input.next();	
		    ad.setName(userName);
		    if(admindao.FindbyName(ad).getPassword().equals(passWord)){		    	
			    System.out.println(userName+" �Թ���Ա��ݵ�½�ɹ���");
			    ad.setPassword(passWord);	
			    isLogin=true;		    
		    }else{
			    System.out.println("�û������������");	
			    conn=true;
		    }
		}while(conn);
		return isLogin;
	}

	@Override
	public void Add() {
		Admin ad=new Admin();
		AdminDao admin=new AdminDaoImpl();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("����Ҫ��ӵĹ���Ա��Ϣ��");
		System.out.print("������");
		String name=input.next();
		System.out.print("���룺");
		String password=input.next();
		ad.setName(name);
		ad.setPassword(password);
		if (admin.Add(ad)!=0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܡ�");
		}
	}

	@Override
	public void UpdatePassword() {
		Admin ad=new Admin();
		AdminDao admin=new AdminDaoImpl();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.print("����Ҫ�޸�����Ĺ���Ա������");
		String name=input.next();
		boolean conn;
		do{
		    conn=false;		    
		    System.out.print("����Ҫ�µ����룺");
		    String pwd1=input.next();
		    System.out.print("������һ�Σ�");
		    String pwd2=input.next();
		    if(pwd1.equals(pwd2)){
		    	ad.setName(name);
			    ad.setPassword(pwd1);
			    if (admin.Update(ad)!=0){
				    System.out.println("�޸ĳɹ���");
			    }else{
				    System.out.println("�޸�ʧ�ܡ�");
			    }
		    }else{
		    	System.out.println("�����������벻һ�£�");
		    	conn=true;
		    }		    
		}while(conn);
	}

	@Override
	public void Del() {
		System.out.print("����Ҫɾ���Ĺ���Ա���ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Admin ad=new Admin();
		ad.setName(input.next());
		AdminDao admin=new AdminDaoImpl();
		if (admin.Del(ad)!=0){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܡ�");
		}
	}

}

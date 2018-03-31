package cn.propertymanage.biz;
/**
 * Admin类Manage接口的实现
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
		    System.out.print("输入管理员用户名：");
		    String userName=input.next();
		    System.out.print("输入管理员密码：");
		    String passWord=input.next();	
		    ad.setName(userName);
		    if(admindao.FindbyName(ad).getPassword().equals(passWord)){		    	
			    System.out.println(userName+" 以管理员身份登陆成功。");
			    ad.setPassword(passWord);	
			    isLogin=true;		    
		    }else{
			    System.out.println("用户名或密码错误。");	
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
		System.out.println("输入要添加的管理员信息：");
		System.out.print("姓名：");
		String name=input.next();
		System.out.print("密码：");
		String password=input.next();
		ad.setName(name);
		ad.setPassword(password);
		if (admin.Add(ad)!=0){
			System.out.println("添加成功。");
		}else{
			System.out.println("添加失败。");
		}
	}

	@Override
	public void UpdatePassword() {
		Admin ad=new Admin();
		AdminDao admin=new AdminDaoImpl();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.print("输入要修改密码的管理员姓名：");
		String name=input.next();
		boolean conn;
		do{
		    conn=false;		    
		    System.out.print("输入要新的密码：");
		    String pwd1=input.next();
		    System.out.print("请再输一次：");
		    String pwd2=input.next();
		    if(pwd1.equals(pwd2)){
		    	ad.setName(name);
			    ad.setPassword(pwd1);
			    if (admin.Update(ad)!=0){
				    System.out.println("修改成功。");
			    }else{
				    System.out.println("修改失败。");
			    }
		    }else{
		    	System.out.println("两次输入密码不一致！");
		    	conn=true;
		    }		    
		}while(conn);
	}

	@Override
	public void Del() {
		System.out.print("输入要删除的管理员名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Admin ad=new Admin();
		ad.setName(input.next());
		AdminDao admin=new AdminDaoImpl();
		if (admin.Del(ad)!=0){
			System.out.println("删除成功。");
		}else{
			System.out.println("删除失败。");
		}
	}

}

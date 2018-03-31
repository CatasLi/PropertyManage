package cn.propertymanage.menu;
/**
 * 菜单类
 * @author admin
 *created by CatasLi on 2016-7-13
 *modified by CatasLi on 2016-7-17
 */
import java.util.Scanner;
import cn.propertymanage.biz.AdminManage;
import cn.propertymanage.biz.AdminManageImpl;
import cn.propertymanage.biz.ClassifyManage;
import cn.propertymanage.biz.ClassifyManageImpl;
import cn.propertymanage.biz.ManManage;
import cn.propertymanage.biz.ManManageImpl;
import cn.propertymanage.biz.PropertyManage;
import cn.propertymanage.biz.PropertyManageImpl;
public class Menu {
	/**
	 * 开始界面
	 */
    public void ShowStartMenu(){                                 
    	System.out.println(">>>>>>>>>>>>固定资产管理系统<<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>>>    1.登陆       <<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>>>    2.退出       <<<<<<<<<<<<<<");
    	System.out.print("请选择：");
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	boolean conn;
    	do{
    		conn=false;
    	    int i=input.nextInt();
    	    if(i==1){
    	    	ShowLoginMenu();
    	    }else if(i==2){
    	    	System.out.print("谢谢使用。");
    	    	break;
    	    }else if(i==-1){
    	    	ShowAbout();
    	    	input.next();
	    		ShowStartMenu();
    	    }else{
    	    	System.out.print("输入数字错误，请重新输入：");
    	    	conn=true;
    	    	}
    	    }while(conn);
    }
    /**
     * 
     */
    public void ShowAbout(){
    	System.out.println(">>>>>>>>>>>>固定资产管理系统<<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>> Created by<<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>>Hatsune Miku<<<<<<<<<<<<<");
    }
    /**
     * 登陆界面
     */
    public void ShowLoginMenu(){
    	System.out.println("登陆:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    	AdminManage admin=new AdminManageImpl();
    	boolean flag=admin.Login();
    	if(flag){
    		ShowMainMenu();
    	}
    }
    /**
     * 主菜单
     */
    public void ShowMainMenu(){
    	System.out.println(">>>>>>>>>>欢迎进入固定资产管理系统<<<<<<<<<<<< ");
    	System.out.println("\t   1.固定资产信息管理");
    	System.out.println("\t   2.人员信息管理");
    	System.out.println("\t   3.管理员信息管理");
    	System.out.print("请选择，0退出登录：");  	
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	boolean conn;
    	do{   		
    		conn=false;
    	    int i=input.nextInt();
    	    switch(i){
    	    	case 1:
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 2:
    	    		ShowManMenu();
    	    		break;
    	    	case 3:
    	    		ShowAdminMenu();
    	    	case 0:
    	    		ShowStartMenu();
    	    		break;
    	    	default:
    	    		System.out.print("输入数字错误，请重新输入：");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
    /**
     * 固定资产操作菜单
     */
    public void ShowPropertyMenu(){
    	System.out.println(">>>>>>>>>>>固定资产管理菜单<<<<<<<<<<<");
    	System.out.print("\t 1.添加\t  ");
    	System.out.println("2.删除");
    	System.out.print("\t 3.修改\t  ");
    	System.out.println("4.查找");
    	System.out.print("\t 5.一览\t  ");
    	System.out.println("6.借出");
    	System.out.print("\t 7.归还\t  ");
    	System.out.println("8.类别");
    	System.out.print("请选择，0返回上级菜单：");
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	PropertyManage pro=new PropertyManageImpl();
    	boolean conn;
    	do{
    		conn=false;
    	    int i=input.nextInt();
    	    switch(i){
    	    	case 1:
    	    		pro.Add();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 2:
    	    		pro.Del();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 3:
    	    		pro.Update();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 4:
    	    		pro.FindbyName();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 5:
    	    		pro.ShowAll();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 6:
    	    		pro.Lend();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 7:
    	    		pro.Back();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 8:
    	    		ShowClassMenu();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 0:
    	    		ShowMainMenu();
    	    		break;
    	    	default:
    	    		System.out.print("输入数字错误，请重新输入：");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
	}
    /**
     * 人员操作菜单
     */
    public void ShowManMenu(){
    	System.out.println(">>>>>>>>>>>>人员管理菜单<<<<<<<<<<<<");
    	System.out.println("\t     1.添加");
    	System.out.println("\t     2.删除");
    	System.out.println("\t     3.修改");
    	System.out.println("\t     4.查找");
    	System.out.println("\t     5.一览");
    	System.out.println("\t     6.查看拥有资源");
    	System.out.print("请选择，0返回上级菜单：");
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	ManManage man=new ManManageImpl();
    	boolean conn;
    	do{
    		conn=false;
    	    int i=input.nextInt();
    	    switch(i){
    	    	case 1:
    	    		man.Add();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 2:
    	    		man.Del();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 3:
    	    		man.Update();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 4:
    	    		man.FindbyName();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 5:
    	    		man.ShowAll();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 6:
    	    		man.ViewbyUser();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 0:
    	    		ShowMainMenu();
    	    		break;
    	    	default:
    	    		System.out.print("输入数字错误，请重新输入：");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
    /**
     * 管理员操作菜单
     */
    public void ShowAdminMenu(){
    	System.out.println(">>>>>>>>>>>>>管理员信息管理 <<<<<<<<<<<<<");
    	System.out.println("1.添加管理员");
    	System.out.println("2.删除管理员");
    	System.out.println("3.修改密码");
    	System.out.print("请选择，0返回上级菜单：");
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	boolean conn;
    	do{
    		AdminManage admin=new AdminManageImpl();
    		conn=false;
    	    int i=input.nextInt();
    	    switch(i){
    	    	case 1:    	    		
    	    		admin.Add();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowAdminMenu();
    	    		break;
    	    	case 2:
    	    		admin.Del();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowAdminMenu();
    	    		break;
    	    	case 3:
    	    		admin.UpdatePassword();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowAdminMenu();
    	    		break;
    	    	case 0:
    	    		ShowMainMenu();
    	    		break;
    	    	default:
    	    		System.out.print("输入数字错误，请重新输入：");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
    /**
     * 类别操作菜单
     */
    public void ShowClassMenu(){
    	System.out.println("类别菜单 ");
    	System.out.println("1.添加");
    	System.out.println("2.删除");
    	System.out.println("3.按类别浏览");
    	System.out.print("请选择，0返回上级菜单：");
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	boolean conn;
    	do{
    		ClassifyManage clm=new ClassifyManageImpl();
    		conn=false;
    	    int i=input.nextInt();
    	    switch(i){
    	    	case 1:    	    		
    	    		clm.Add();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowClassMenu();
    	    		break;
    	    	case 2:
    	    		clm.Del();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowClassMenu();
    	    		break;
    	    	case 3:
    	    		clm.ViewbyClass();
    	    		System.out.print("按任意键返回上级菜单：");
    	    		input.next();
    	    		ShowClassMenu();
    	    		break;
    	    	case 0:
    	    		ShowPropertyMenu();
    	    		break;
    	    	default:
    	    		System.out.print("输入数字错误，请重新输入：");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
}

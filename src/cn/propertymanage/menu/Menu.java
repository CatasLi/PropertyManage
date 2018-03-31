package cn.propertymanage.menu;
/**
 * �˵���
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
	 * ��ʼ����
	 */
    public void ShowStartMenu(){                                 
    	System.out.println(">>>>>>>>>>>>�̶��ʲ�����ϵͳ<<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>>>    1.��½       <<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>>>    2.�˳�       <<<<<<<<<<<<<<");
    	System.out.print("��ѡ��");
    	@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
    	boolean conn;
    	do{
    		conn=false;
    	    int i=input.nextInt();
    	    if(i==1){
    	    	ShowLoginMenu();
    	    }else if(i==2){
    	    	System.out.print("ллʹ�á�");
    	    	break;
    	    }else if(i==-1){
    	    	ShowAbout();
    	    	input.next();
	    		ShowStartMenu();
    	    }else{
    	    	System.out.print("�������ִ������������룺");
    	    	conn=true;
    	    	}
    	    }while(conn);
    }
    /**
     * 
     */
    public void ShowAbout(){
    	System.out.println(">>>>>>>>>>>>�̶��ʲ�����ϵͳ<<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>> Created by<<<<<<<<<<<<<<");
    	System.out.println(">>>>>>>>>>>Hatsune Miku<<<<<<<<<<<<<");
    }
    /**
     * ��½����
     */
    public void ShowLoginMenu(){
    	System.out.println("��½:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    	AdminManage admin=new AdminManageImpl();
    	boolean flag=admin.Login();
    	if(flag){
    		ShowMainMenu();
    	}
    }
    /**
     * ���˵�
     */
    public void ShowMainMenu(){
    	System.out.println(">>>>>>>>>>��ӭ����̶��ʲ�����ϵͳ<<<<<<<<<<<< ");
    	System.out.println("\t   1.�̶��ʲ���Ϣ����");
    	System.out.println("\t   2.��Ա��Ϣ����");
    	System.out.println("\t   3.����Ա��Ϣ����");
    	System.out.print("��ѡ��0�˳���¼��");  	
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
    	    		System.out.print("�������ִ������������룺");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
    /**
     * �̶��ʲ������˵�
     */
    public void ShowPropertyMenu(){
    	System.out.println(">>>>>>>>>>>�̶��ʲ�����˵�<<<<<<<<<<<");
    	System.out.print("\t 1.���\t  ");
    	System.out.println("2.ɾ��");
    	System.out.print("\t 3.�޸�\t  ");
    	System.out.println("4.����");
    	System.out.print("\t 5.һ��\t  ");
    	System.out.println("6.���");
    	System.out.print("\t 7.�黹\t  ");
    	System.out.println("8.���");
    	System.out.print("��ѡ��0�����ϼ��˵���");
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
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 2:
    	    		pro.Del();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 3:
    	    		pro.Update();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 4:
    	    		pro.FindbyName();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 5:
    	    		pro.ShowAll();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 6:
    	    		pro.Lend();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 7:
    	    		pro.Back();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 8:
    	    		ShowClassMenu();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowPropertyMenu();
    	    		break;
    	    	case 0:
    	    		ShowMainMenu();
    	    		break;
    	    	default:
    	    		System.out.print("�������ִ������������룺");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
	}
    /**
     * ��Ա�����˵�
     */
    public void ShowManMenu(){
    	System.out.println(">>>>>>>>>>>>��Ա����˵�<<<<<<<<<<<<");
    	System.out.println("\t     1.���");
    	System.out.println("\t     2.ɾ��");
    	System.out.println("\t     3.�޸�");
    	System.out.println("\t     4.����");
    	System.out.println("\t     5.һ��");
    	System.out.println("\t     6.�鿴ӵ����Դ");
    	System.out.print("��ѡ��0�����ϼ��˵���");
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
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 2:
    	    		man.Del();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 3:
    	    		man.Update();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 4:
    	    		man.FindbyName();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 5:
    	    		man.ShowAll();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 6:
    	    		man.ViewbyUser();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowManMenu();
    	    		break;
    	    	case 0:
    	    		ShowMainMenu();
    	    		break;
    	    	default:
    	    		System.out.print("�������ִ������������룺");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
    /**
     * ����Ա�����˵�
     */
    public void ShowAdminMenu(){
    	System.out.println(">>>>>>>>>>>>>����Ա��Ϣ���� <<<<<<<<<<<<<");
    	System.out.println("1.��ӹ���Ա");
    	System.out.println("2.ɾ������Ա");
    	System.out.println("3.�޸�����");
    	System.out.print("��ѡ��0�����ϼ��˵���");
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
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowAdminMenu();
    	    		break;
    	    	case 2:
    	    		admin.Del();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowAdminMenu();
    	    		break;
    	    	case 3:
    	    		admin.UpdatePassword();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowAdminMenu();
    	    		break;
    	    	case 0:
    	    		ShowMainMenu();
    	    		break;
    	    	default:
    	    		System.out.print("�������ִ������������룺");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
    /**
     * �������˵�
     */
    public void ShowClassMenu(){
    	System.out.println("���˵� ");
    	System.out.println("1.���");
    	System.out.println("2.ɾ��");
    	System.out.println("3.��������");
    	System.out.print("��ѡ��0�����ϼ��˵���");
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
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowClassMenu();
    	    		break;
    	    	case 2:
    	    		clm.Del();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowClassMenu();
    	    		break;
    	    	case 3:
    	    		clm.ViewbyClass();
    	    		System.out.print("������������ϼ��˵���");
    	    		input.next();
    	    		ShowClassMenu();
    	    		break;
    	    	case 0:
    	    		ShowPropertyMenu();
    	    		break;
    	    	default:
    	    		System.out.print("�������ִ������������룺");
    	    		conn=true;
    	    		break;
    	    	 }
    	    }while(conn);
    }
}

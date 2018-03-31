package cn.propertymanage.biz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Man类的Manage接口的实现
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-14
 */
import java.util.Scanner;
import cn.propertymanage.dao.ManDao;
import cn.propertymanage.dao.ManDaoImpl;
import cn.propertymanage.dao.PropertyDao;
import cn.propertymanage.dao.PropertyDaoImpl;
import cn.propertymanage.entity.Man;
import cn.propertymanage.entity.Property;

public class ManManageImpl implements ManManage{

	@Override
	public void Add() {
		Man man=new Man();
		ManDao mandao=new ManDaoImpl();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("输入要添加的人员信息：");
		System.out.print("姓名：");
		String name=input.next();
		System.out.print("职务：");
		String position=input.next();
		System.out.print("备注：");
		String others=input.next();	
		man.setName(name);
		man.setPosition(position);
		man.setOthers(others);
		if (mandao.Add(man)!=0){
			System.out.println("添加成功。");
		}else{
			System.out.println("添加失败。");
		}
	}

	@Override
	public void Del() {
		System.out.print("输入要删除的人员名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Man man=new Man();
		man.setName(input.next());
		ManDao mandao=new ManDaoImpl();		
		if (mandao.Del(man)!=0){
			System.out.println("删除成功。");
		}else{
			System.out.println("删除失败。");
		}
	}

	@Override
	public void FindbyName() {
		System.out.print("输入要查找的人员名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		ManDao mandao=new ManDaoImpl();
		String name=input.next();
	    mandao.Show(mandao.FindbyName(name)); 
	}

	@Override
	public void ViewbyUser() {
		System.out.print("输入要查询的人员名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		PropertyDao pro=new PropertyDaoImpl();
		String user=input.next();
		List<Property> l=new ArrayList<Property>();
		l=pro.FindbyUser(user);
		System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
		for(Iterator<Property> iter=l.iterator();iter.hasNext();){
			pro.Show(iter.next());
		}
	}

	@Override
	public void Update() {
		Man man=new Man();
		ManDao mandao=new ManDaoImpl();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("输入要修改的人员信息：");
		System.out.print("姓名：");
		String name=input.next();
		System.out.print("职务：");
		String position=input.next();
		System.out.print("备注：");
		String others=input.next();	
		man.setName(name);
		man.setPosition(position);
		man.setOthers(others);
		if (mandao.Update(man)!=0){
			System.out.println("添加成功。");
		}else{
			System.out.println("添加失败。");
		}
	}

	@Override
	public void ShowAll() {
		ManDao mandao=new ManDaoImpl();
		mandao.ShowAll();
	}


}

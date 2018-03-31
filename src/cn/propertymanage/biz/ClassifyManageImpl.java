package cn.propertymanage.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import cn.propertymanage.dao.ClassifyDao;
import cn.propertymanage.dao.ClassifyDaoImpl;
import cn.propertymanage.dao.PropertyDao;
import cn.propertymanage.dao.PropertyDaoImpl;
import cn.propertymanage.entity.Classify;
import cn.propertymanage.entity.Property;

public class ClassifyManageImpl implements ClassifyManage{

	@Override
	public void Add() {
		ClassifyDao cl=new ClassifyDaoImpl();
		Classify c=new Classify();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("输入要添加的类别信息：");
		System.out.print("类别：");
		String name=input.next();
		System.out.print("母类：");
		String parent=input.next();
		c.setName(name);
		c.setParent(parent);
		if(cl.Add(c)==1){
			System.out.println("添加成功。");
		}else{
			System.out.println("添加失败。");
		}
	}

	@Override
	public void Del() {
		ClassifyDao cl=new ClassifyDaoImpl();
		Classify c=new Classify();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("输入要添加的类别信息：");
		System.out.print("类别：");
		String name=input.next();
		c.setName(name);
		if(cl.Del(c)!=0){
			System.out.println("删除成功。");
		}else{
			System.out.println("删除失败。");
		}
	}

	@Override
	public void ViewbyClass() {
		List<Property> l=new ArrayList<Property>();
		ClassifyDao cl=new ClassifyDaoImpl();
		PropertyDao pro=new PropertyDaoImpl();
		Classify c=new Classify();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("输入要查询的类别信息：");
		String name=input.next();
		c.setName(name);
		l=cl.FindbyClass(c);
		System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
		for(Iterator<Property> iter=l.iterator();iter.hasNext();){
			pro.Show(iter.next());
		}
	}
}

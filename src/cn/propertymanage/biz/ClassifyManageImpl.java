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
		System.out.println("����Ҫ��ӵ������Ϣ��");
		System.out.print("���");
		String name=input.next();
		System.out.print("ĸ�ࣺ");
		String parent=input.next();
		c.setName(name);
		c.setParent(parent);
		if(cl.Add(c)==1){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܡ�");
		}
	}

	@Override
	public void Del() {
		ClassifyDao cl=new ClassifyDaoImpl();
		Classify c=new Classify();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("����Ҫ��ӵ������Ϣ��");
		System.out.print("���");
		String name=input.next();
		c.setName(name);
		if(cl.Del(c)!=0){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܡ�");
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
		System.out.println("����Ҫ��ѯ�������Ϣ��");
		String name=input.next();
		c.setName(name);
		l=cl.FindbyClass(c);
		System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
		for(Iterator<Property> iter=l.iterator();iter.hasNext();){
			pro.Show(iter.next());
		}
	}
}

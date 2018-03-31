package cn.propertymanage.biz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Man���Manage�ӿڵ�ʵ��
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
		System.out.println("����Ҫ��ӵ���Ա��Ϣ��");
		System.out.print("������");
		String name=input.next();
		System.out.print("ְ��");
		String position=input.next();
		System.out.print("��ע��");
		String others=input.next();	
		man.setName(name);
		man.setPosition(position);
		man.setOthers(others);
		if (mandao.Add(man)!=0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܡ�");
		}
	}

	@Override
	public void Del() {
		System.out.print("����Ҫɾ������Ա���ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Man man=new Man();
		man.setName(input.next());
		ManDao mandao=new ManDaoImpl();		
		if (mandao.Del(man)!=0){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܡ�");
		}
	}

	@Override
	public void FindbyName() {
		System.out.print("����Ҫ���ҵ���Ա���ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		ManDao mandao=new ManDaoImpl();
		String name=input.next();
	    mandao.Show(mandao.FindbyName(name)); 
	}

	@Override
	public void ViewbyUser() {
		System.out.print("����Ҫ��ѯ����Ա���ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		PropertyDao pro=new PropertyDaoImpl();
		String user=input.next();
		List<Property> l=new ArrayList<Property>();
		l=pro.FindbyUser(user);
		System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
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
		System.out.println("����Ҫ�޸ĵ���Ա��Ϣ��");
		System.out.print("������");
		String name=input.next();
		System.out.print("ְ��");
		String position=input.next();
		System.out.print("��ע��");
		String others=input.next();	
		man.setName(name);
		man.setPosition(position);
		man.setOthers(others);
		if (mandao.Update(man)!=0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܡ�");
		}
	}

	@Override
	public void ShowAll() {
		ManDao mandao=new ManDaoImpl();
		mandao.ShowAll();
	}


}

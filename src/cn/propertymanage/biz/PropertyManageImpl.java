package cn.propertymanage.biz;
/**
 * Property��Manage�ӿڵ�ʵ��
 * @author admin
 * created by CatasLi on 2016-7-13
 * modified by CatasLi on 2016-7-17
 */
import java.util.Scanner;
import cn.propertymanage.dao.PropertyDao;
import cn.propertymanage.dao.PropertyDaoImpl;
import cn.propertymanage.entity.Property;

public class PropertyManageImpl implements PropertyManage{

	@Override
	public void ShowAll() {
		PropertyDao pro=new PropertyDaoImpl();
		System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
		pro.ShowAll();
	}

	@Override
	public void Add() {
		Property pro=new Property();
		PropertyDao prodao=new PropertyDaoImpl();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("����Ҫ��ӵĹ̶��ʲ���Ϣ��");
		System.out.print("���ƣ�");
		String name=input.next();
		System.out.print("���");
		String classify=input.next();
		System.out.print("�ͺţ�");
		String model=input.next();	
		System.out.print("��ֵ��");
		int value=input.nextInt();
		System.out.print("�������ڣ�");
		String buyDate=input.next();
		System.out.print("״̬��");
		String status=input.next();
		System.out.print("ʹ���ߣ�");
		String iuser=input.next();
		System.out.print("��ע��");
		String others=input.next();
		pro.setName(name);
		pro.setClassify(classify);
		pro.setModel(model);
		pro.setValue(value);
		pro.setBuyDate(buyDate);
		pro.setStatus(status);
		pro.setIuser(iuser);
		pro.setOthers(others);
		if (prodao.Add(pro)!=0){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܡ�");
		}
	}

	@Override
	public void Del() {
        System.out.print("����Ҫɾ�����ʲ����ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();		
		if (prodao.Del(pro)!=0){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܡ�");
		}
	}

	@Override
	public Property FindbyName() {
		PropertyDao pro=new PropertyDaoImpl();
		System.out.print("����Ҫ��ѯ���ʲ����ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);	
		return pro.FindbyName(input.next());
	}

	@Override
	public Property FindbyId() {
		PropertyDao pro=new PropertyDaoImpl();
		System.out.print("����Ҫ��ѯ���ʲ���ţ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);	
		return pro.FindbyId(input.nextInt());
	}

	@Override
	public void Update() {
		System.out.print("����Ҫ�޸ĵ��ʲ����ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();
		System.out.print("���ƣ�");
		String name=input.next();
		System.out.print("���");
		String classify=input.next();
		System.out.print("�ͺţ�");
		String model=input.next();	
		System.out.print("��ֵ��");
		int value=input.nextInt();
		System.out.print("�������ڣ�");
		String buyDate=input.next();
		System.out.print("״̬��");
		String status=input.next();
		System.out.print("ʹ���ߣ�");
		String iuser=input.next();
		System.out.print("��ע��");
		String others=input.next();
		pro.setName(name);
		pro.setClassify(classify);
		pro.setModel(model);
		pro.setValue(value);
		pro.setBuyDate(buyDate);
		pro.setStatus(status);
		pro.setIuser(iuser);
		pro.setOthers(others);
		if (prodao.Update(pro)!=0){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܡ�");
		}
	}

	@Override
	public void Lend() {
		System.out.print("����Ҫ������ʲ����ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();
		boolean flag = prodao.isLend(pro.getName());
		if(flag==true){
			System.out.print("����������Ա������");
			pro.setIuser(input.next());
			System.out.print("���������ڣ�");
			pro.setUseDate(input.next());
			System.out.print("�������Ա��");
			pro.setAdmin(input.next());
			System.out.print("������;��");
			pro.setUsefor(input.next());
			System.out.print("���뱸ע��");
			pro.setUseOthers(input.next());
			PropertyDao prodao1=new PropertyDaoImpl();
			if (prodao1.UpdateforUse(pro)!=0){
				System.out.println("����ɹ���");
			}else{
				System.out.println("���ʧ�ܡ�");
			}
		}else{
			System.out.println("�����ʲ�Ŀǰ�����ã�");
		}
	}

	@Override
	public void Back() {
		System.out.print("����Ҫ�黹���ʲ����ƣ�");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();
		if(prodao.isBack(pro.getName())){
			pro.setIuser("��");
			pro.setUseDate(null);
			pro.setAdmin(null);
			pro.setUsefor(null);
			pro.setUseOthers(null);
			PropertyDao prodao1=new PropertyDaoImpl();
			if (prodao1.UpdateforUse(pro)!=0){
				System.out.println("�黹�ɹ���");
			}else{
				System.out.println("�黹ʧ�ܡ�");
			}
		}else{
			System.out.println("�����ʲ�Ŀǰδ�������");
		}
	}

}

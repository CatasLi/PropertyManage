package cn.propertymanage.biz;
/**
 * Property类Manage接口的实现
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
		System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
		pro.ShowAll();
	}

	@Override
	public void Add() {
		Property pro=new Property();
		PropertyDao prodao=new PropertyDaoImpl();
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("输入要添加的固定资产信息：");
		System.out.print("名称：");
		String name=input.next();
		System.out.print("类别：");
		String classify=input.next();
		System.out.print("型号：");
		String model=input.next();	
		System.out.print("价值：");
		int value=input.nextInt();
		System.out.print("购买日期：");
		String buyDate=input.next();
		System.out.print("状态：");
		String status=input.next();
		System.out.print("使用者：");
		String iuser=input.next();
		System.out.print("备注：");
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
			System.out.println("添加成功。");
		}else{
			System.out.println("添加失败。");
		}
	}

	@Override
	public void Del() {
        System.out.print("输入要删除的资产名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();		
		if (prodao.Del(pro)!=0){
			System.out.println("删除成功。");
		}else{
			System.out.println("删除失败。");
		}
	}

	@Override
	public Property FindbyName() {
		PropertyDao pro=new PropertyDaoImpl();
		System.out.print("输入要查询的资产名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);	
		return pro.FindbyName(input.next());
	}

	@Override
	public Property FindbyId() {
		PropertyDao pro=new PropertyDaoImpl();
		System.out.print("输入要查询的资产编号：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);	
		return pro.FindbyId(input.nextInt());
	}

	@Override
	public void Update() {
		System.out.print("输入要修改的资产名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();
		System.out.print("名称：");
		String name=input.next();
		System.out.print("类别：");
		String classify=input.next();
		System.out.print("型号：");
		String model=input.next();	
		System.out.print("价值：");
		int value=input.nextInt();
		System.out.print("购买日期：");
		String buyDate=input.next();
		System.out.print("状态：");
		String status=input.next();
		System.out.print("使用者：");
		String iuser=input.next();
		System.out.print("备注：");
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
			System.out.println("删除成功。");
		}else{
			System.out.println("删除失败。");
		}
	}

	@Override
	public void Lend() {
		System.out.print("输入要借出的资产名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();
		boolean flag = prodao.isLend(pro.getName());
		if(flag==true){
			System.out.print("输入请求人员姓名：");
			pro.setIuser(input.next());
			System.out.print("输入借出日期：");
			pro.setUseDate(input.next());
			System.out.print("输入管理员：");
			pro.setAdmin(input.next());
			System.out.print("输入用途：");
			pro.setUsefor(input.next());
			System.out.print("输入备注：");
			pro.setUseOthers(input.next());
			PropertyDao prodao1=new PropertyDaoImpl();
			if (prodao1.UpdateforUse(pro)!=0){
				System.out.println("借出成功。");
			}else{
				System.out.println("借出失败。");
			}
		}else{
			System.out.println("请求资产目前不可用！");
		}
	}

	@Override
	public void Back() {
		System.out.print("输入要归还的资产名称：");
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		Property pro=new Property();
		pro.setName(input.next());
		PropertyDao prodao=new PropertyDaoImpl();
		if(prodao.isBack(pro.getName())){
			pro.setIuser("无");
			pro.setUseDate(null);
			pro.setAdmin(null);
			pro.setUsefor(null);
			pro.setUseOthers(null);
			PropertyDao prodao1=new PropertyDaoImpl();
			if (prodao1.UpdateforUse(pro)!=0){
				System.out.println("归还成功。");
			}else{
				System.out.println("归还失败。");
			}
		}else{
			System.out.println("请求资产目前未被借出！");
		}
	}

}

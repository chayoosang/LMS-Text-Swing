package textView;

import java.util.Scanner;

import control.CHwewon;
import valueObject.OHwewon;

public class VFind {
	private Scanner sc;
	private CHwewon cHwewon;
	private OHwewon oHwewon;

	public VFind(Scanner sc) {
		this.sc = sc;
		this.cHwewon = new CHwewon();
		this.oHwewon = new OHwewon();
	}
	
	public void show(String choice) {
		if(choice.equals("id")) {
			System.out.println();
			System.out.println("====���̵� ã��====");
			System.out.println();
			System.out.println("������ �Է����ּ���.");
			
			System.out.print("�̸� : ");
			String name = sc.next();
			this.oHwewon.setName(name);
			
			System.out.print("�ּ� : ");
			String address = sc.next();
			this.oHwewon.setAddress(address);
			
			OHwewon findHwewon = this.cHwewon.validate(this.oHwewon);
			if(findHwewon!=null)
			System.out.println("ã���ô� ���̵�� "+findHwewon.getId()+"�Դϴ�.");
		}
		
		else if(choice.equals("pw")) {
			System.out.println();
			System.out.println("====��й�ȣ ã��====");
			System.out.println();
			System.out.println("������ �Է����ּ���.");
			
			System.out.print("���̵� : ");
			String id = sc.next();
			this.oHwewon.setId(id);
			
			System.out.print("�̸� : ");
			String name = sc.next();
			this.oHwewon.setName(name);		
			
			OHwewon findHwewon = this.cHwewon.validate(this.oHwewon);
			if(findHwewon!=null)
			System.out.println("ã���ô� ��й�ȣ�� "+findHwewon.getPassword()+"�Դϴ�.");
		}
	}

}

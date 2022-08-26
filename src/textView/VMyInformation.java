package textView;

import java.util.Scanner;

import javax.swing.JOptionPane;

import control.CHwewon;
import valueObject.OHwewon;

public class VMyInformation {
	private Scanner sc;
	private OHwewon oHwewon;
	private CHwewon cHwewon;
	
	public VMyInformation(Scanner sc, OHwewon oHwewon) {
		this.sc = sc;
		this.oHwewon = oHwewon;
	}

	public OHwewon show() {
		while(true) {
		System.out.println("======== ��й�ȣ�� �Է����ּ���. ========");
		System.out.print("��й�ȣ : ");
		String next = this.sc.next();
		
		if(next.equals(this.oHwewon.getPassword())) {
			System.out.println("========"+this.oHwewon.getName()+"���� ���� ========");
			System.out.println();
			
			System.out.print("ID : ");
			System.out.println(this.oHwewon.getId());
			
			System.out.print("PW : ");
			System.out.println(this.oHwewon.getPassword());
			
			System.out.print("�̸� : ");
			System.out.println(this.oHwewon.getName());
			
			System.out.print("�ּ� : ");
			System.out.println(this.oHwewon.getAddress());
			
			System.out.print("�а� : ");
			System.out.println(this.oHwewon.getHwakgwa());
			System.out.println();
			
			while(true) {
			System.out.println("========���� ����� ���� �ϼ���========");
			System.out.println("��������(1), ������(2)");
			String choice = this.sc.next();
			
			if(choice.equals("1")) {
				
				OHwewon hwewon = new OHwewon();
				cHwewon = new CHwewon();
				
				System.out.print("ID : ");
				System.out.println(this.oHwewon.getId());
				hwewon.setId(this.oHwewon.getId());
				
				System.out.print("PW : ");
				String password = sc.next();
				hwewon.setPassword(password);
				
				System.out.print("�̸� : ");
				String name = sc.next();
				hwewon.setName(name);
				
				System.out.print("�ּ� : ");
				String address = sc.next();
				hwewon.setAddress(address);
				
				System.out.print("�а� : ");
				String hwakgwa = sc.next();
				hwewon.setHwakgwa(hwakgwa);
				
				if(cHwewon.change(hwewon)==true) {
					System.out.println("ȸ������ ������ �Ϸ��߽��ϴ�.");
					return hwewon;
				}
					
				else
					System.out.println("ȸ������ ������ �����߽��ϴ�.");
				return null;
				
			}
			else if(choice.equals("2")) {
				return null;
			}
		}
			
	}
		
		else
			System.out.println("�߸��� �����Դϴ�. �ٽ� �õ����ּ���.");
		}
	}
		}


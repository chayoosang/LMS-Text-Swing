package textView;
import java.util.Scanner;
import control.CHweonDeungrok;
import valueObject.OHwewon;


public class VHweonDeungrok {
	
	private Scanner sc;
	private CHweonDeungrok cHweonDeungrok;
	
	public VHweonDeungrok(Scanner sc) {
		this.sc = sc;
		this.cHweonDeungrok = new CHweonDeungrok();
	}

	public void show() {
		OHwewon oHweown = new OHwewon();
		//����� ���� �Է� �޾�
		System.out.println("������ �Է����ּ���.");
		
		System.out.print("ID : ");
		String id = sc.next();
		oHweown.setId(id);
		
		System.out.print("PW : ");
		String password = sc.next();
		oHweown.setPassword(password);
		
		System.out.print("�̸� : ");
		String name = sc.next();
		oHweown.setName(name);
		
		System.out.print("�ּ� : ");
		String address = sc.next();
		oHweown.setAddress(address);
		
		System.out.print("�а� : ");
		String hwakgwa = sc.next();
		oHweown.setHwakgwa(hwakgwa);
		
		this.cHweonDeungrok.saveHwewon(oHweown);

		
		
		

	}


	

}

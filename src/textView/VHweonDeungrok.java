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
		//사용자 정보 입력 받아
		System.out.println("정보를 입력해주세요.");
		
		System.out.print("ID : ");
		String id = sc.next();
		oHweown.setId(id);
		
		System.out.print("PW : ");
		String password = sc.next();
		oHweown.setPassword(password);
		
		System.out.print("이름 : ");
		String name = sc.next();
		oHweown.setName(name);
		
		System.out.print("주소 : ");
		String address = sc.next();
		oHweown.setAddress(address);
		
		System.out.print("학과 : ");
		String hwakgwa = sc.next();
		oHweown.setHwakgwa(hwakgwa);
		
		this.cHweonDeungrok.saveHwewon(oHweown);

		
		
		

	}


	

}

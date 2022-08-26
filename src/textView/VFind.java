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
			System.out.println("====아이디 찾기====");
			System.out.println();
			System.out.println("정보를 입력해주세요.");
			
			System.out.print("이름 : ");
			String name = sc.next();
			this.oHwewon.setName(name);
			
			System.out.print("주소 : ");
			String address = sc.next();
			this.oHwewon.setAddress(address);
			
			OHwewon findHwewon = this.cHwewon.validate(this.oHwewon);
			if(findHwewon!=null)
			System.out.println("찾으시는 아이디는 "+findHwewon.getId()+"입니다.");
		}
		
		else if(choice.equals("pw")) {
			System.out.println();
			System.out.println("====비밀번호 찾기====");
			System.out.println();
			System.out.println("정보를 입력해주세요.");
			
			System.out.print("아이디 : ");
			String id = sc.next();
			this.oHwewon.setId(id);
			
			System.out.print("이름 : ");
			String name = sc.next();
			this.oHwewon.setName(name);		
			
			OHwewon findHwewon = this.cHwewon.validate(this.oHwewon);
			if(findHwewon!=null)
			System.out.println("찾으시는 비밀번호는 "+findHwewon.getPassword()+"입니다.");
		}
	}

}

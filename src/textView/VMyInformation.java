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
		System.out.println("======== 비밀번호를 입력해주세요. ========");
		System.out.print("비밀번호 : ");
		String next = this.sc.next();
		
		if(next.equals(this.oHwewon.getPassword())) {
			System.out.println("========"+this.oHwewon.getName()+"님의 정보 ========");
			System.out.println();
			
			System.out.print("ID : ");
			System.out.println(this.oHwewon.getId());
			
			System.out.print("PW : ");
			System.out.println(this.oHwewon.getPassword());
			
			System.out.print("이름 : ");
			System.out.println(this.oHwewon.getName());
			
			System.out.print("주소 : ");
			System.out.println(this.oHwewon.getAddress());
			
			System.out.print("학과 : ");
			System.out.println(this.oHwewon.getHwakgwa());
			System.out.println();
			
			while(true) {
			System.out.println("========다음 기능을 선택 하세요========");
			System.out.println("정보수정(1), 나가기(2)");
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
				
				System.out.print("이름 : ");
				String name = sc.next();
				hwewon.setName(name);
				
				System.out.print("주소 : ");
				String address = sc.next();
				hwewon.setAddress(address);
				
				System.out.print("학과 : ");
				String hwakgwa = sc.next();
				hwewon.setHwakgwa(hwakgwa);
				
				if(cHwewon.change(hwewon)==true) {
					System.out.println("회원정보 수정을 완료했습니다.");
					return hwewon;
				}
					
				else
					System.out.println("회원정보 수정을 실패했습니다.");
				return null;
				
			}
			else if(choice.equals("2")) {
				return null;
			}
		}
			
	}
		
		else
			System.out.println("잘못된 정보입니다. 다시 시도해주세요.");
		}
	}
		}


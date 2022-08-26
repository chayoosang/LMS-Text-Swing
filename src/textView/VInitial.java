package textView;


import java.util.Scanner;

import control.CLecture;
import valueObject.OHwewon;


public class VInitial {
	private Scanner sc;
	
	private VHweonDeungrok vhweonDeungrok;
	private VLogin vlogin;
	private VFind vFind;
	private VSugangsincheong vSugangsincheong;
	private VMysincheong vMysincheong;
	private VMyInformation vMyInformation;
	
	private CLecture cLecture;
	public VInitial(Scanner sc) {
	    this.sc = sc;
		this.vhweonDeungrok = new VHweonDeungrok(this.sc);
		this.vlogin = new VLogin(this.sc);
		this.vFind = new VFind(this.sc);
		this.cLecture = new CLecture();
	}

	public void show() {
		
		while(true) {
			System.out.println();
			System.out.println("========다음 기능을 선택 하세요========");
			System.out.println("로그인(1), 회원등록(2), 아이디 찾기(3), 비밀번호 찾기(4), 종료하기(5)");

			String input = sc.next();
			if(input.equals("1")) {
				OHwewon oHwewon = this.vlogin.login();
				if(oHwewon != null) {
					this.cLecture.checkFile(oHwewon);
					while(true) {
					System.out.println("========"+oHwewon.getName()+"님 환영합니다."+"========");
					System.out.println("========다음 기능을 선택 하세요========");
					System.out.println("강좌검색(1), 책가방(2), 신청현황(3), 내정보 수정(4), 로그아웃(5)");
					String input2 = sc.next();
					if(input2.equals("1")) {
						this.vSugangsincheong = new VSugangsincheong(this.sc);
						this.vSugangsincheong.show(oHwewon);
					}
					else if(input2.equals("2")) {
						this.vMysincheong = new VMysincheong(this.sc, oHwewon);
						this.vMysincheong.show("책가방");
					}
					else if(input2.equals("3")) {
						this.vMysincheong = new VMysincheong(this.sc, oHwewon);
						this.vMysincheong.show("신청 현황");
					}
					else if(input2.equals("4")) {
						this.vMyInformation = new VMyInformation(this.sc, oHwewon);
						oHwewon = this.vMyInformation.show();
					}
					else if(input2.equals("5")) {
						break;
					}
					else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요!");
					}
					}
				}
				}	else if(input.equals("2")) {
					this.vhweonDeungrok.show();
					}
				else if(input.equals("3")) {
					this.vFind.show("id");
					}
				else if(input.equals("4")) {
					this.vFind.show("pw");
					}
				else if(input.equals("5")) {
					System.out.println("프로그램을 종료합니다.");
					break;
					}
				else {
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요!");
					}
			}
		}
	}

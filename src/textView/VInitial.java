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
			System.out.println("========���� ����� ���� �ϼ���========");
			System.out.println("�α���(1), ȸ�����(2), ���̵� ã��(3), ��й�ȣ ã��(4), �����ϱ�(5)");

			String input = sc.next();
			if(input.equals("1")) {
				OHwewon oHwewon = this.vlogin.login();
				if(oHwewon != null) {
					this.cLecture.checkFile(oHwewon);
					while(true) {
					System.out.println("========"+oHwewon.getName()+"�� ȯ���մϴ�."+"========");
					System.out.println("========���� ����� ���� �ϼ���========");
					System.out.println("���°˻�(1), å����(2), ��û��Ȳ(3), ������ ����(4), �α׾ƿ�(5)");
					String input2 = sc.next();
					if(input2.equals("1")) {
						this.vSugangsincheong = new VSugangsincheong(this.sc);
						this.vSugangsincheong.show(oHwewon);
					}
					else if(input2.equals("2")) {
						this.vMysincheong = new VMysincheong(this.sc, oHwewon);
						this.vMysincheong.show("å����");
					}
					else if(input2.equals("3")) {
						this.vMysincheong = new VMysincheong(this.sc, oHwewon);
						this.vMysincheong.show("��û ��Ȳ");
					}
					else if(input2.equals("4")) {
						this.vMyInformation = new VMyInformation(this.sc, oHwewon);
						oHwewon = this.vMyInformation.show();
					}
					else if(input2.equals("5")) {
						break;
					}
					else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���!");
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
					System.out.println("���α׷��� �����մϴ�.");
					break;
					}
				else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���!");
					}
			}
		}
	}

package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VMysincheong {
	private Scanner sc;
	private CLecture cLecture;
	private OHwewon oHwewon;
	private int totalGradepoint = 18;
	private int gradepoint;
	public VMysincheong(Scanner sc, OHwewon oHwewon) {
		this.sc = sc;
		this.oHwewon = oHwewon;
		this.cLecture = new CLecture();
	}
	
	private int getGradepoint() {
		int gradepoint =0;
		Vector<OLecture> lectures = this.cLecture.getSincheong(oHwewon.getId());
		for(OLecture oLecture : lectures) {
			gradepoint+= Integer.parseInt(oLecture.getGradePoint());
		}
		return (this.totalGradepoint - gradepoint);
		
	}

	public void show(String choice) {
		if(choice.equals("å����")) {
			System.out.println("======== "+this.oHwewon.getName()+"���� å���� ========");

			
				while(true) {
					Vector<OLecture> lectures = this.cLecture.getMiri(this.oHwewon.getId());
					if(lectures.size()==0) {
						System.out.println("å������ ����ֽ��ϴ�.");
						break;
					}
					for(OLecture oLecture : lectures) {
						System.out.println(oLecture.getId() +" "+ oLecture.getName() +" "+oLecture.getProfessor()+" "+oLecture.getGradePoint()+" "+oLecture.getTime());
				}
					System.out.println("========���� ����� ���� �ϼ���========");
					System.out.println("������û(1), ����(2), ������(3)");
					String input = sc.next();
					
				if(input.equals("1")) {
					while(true) {
						System.out.print("���¹�ȣ : ");
						String id = sc.next();
						for(OLecture oLecture : lectures) {
							if(oLecture.getId().equals(id)) {
								this.gradepoint = getGradepoint();
								if(this.gradepoint>Integer.parseInt(oLecture.getGradePoint())) {
								this.cLecture.saveLecture(oLecture, this.oHwewon, "sincheong");
								}
								else {
									System.out.println("���������� ������ �ʰ��ϼ̽��ϴ�.");
									break;
								}
								}
						}
						break;
					}
				}
				
				else if(input.equals("2")) {
					while(true) {
						System.out.print("���¹�ȣ : ");
						String id = sc.next();
						for(OLecture oLecture : lectures) {
							if(oLecture.getId().equals(id)) {
								this.cLecture.deleteLecture(oLecture, this.oHwewon, "å����");
								
						}
						}
						break;
					}
				}
				
				else if(input.equals("3")) {
					break;
				}
				else
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���!");
				}
		}
		else if(choice.equals("��û ��Ȳ")) {
			System.out.println("======== "+this.oHwewon.getName()+"���� ��û ��Ȳ========");

		
			while(true) {
				Vector<OLecture> lectures = this.cLecture.getSincheong(this.oHwewon.getId());
				if(lectures.size()==0) {
					System.out.println("��û�Ͻ� ���ǰ� �����ϴ�.");
					break;
				}
				for(OLecture oLecture : lectures) {
					System.out.println(oLecture.getId() +" "+ oLecture.getName() +" "+oLecture.getProfessor()+" "+oLecture.getGradePoint()+" "+oLecture.getTime());
			}
				this.gradepoint = getGradepoint();
				System.out.println(this.oHwewon.getName()+"���� ���� ���� :  "+this.gradepoint+"����\n");
				System.out.println("========���� ����� ���� �ϼ���========");
				System.out.println("öȸ(1), ������(2)");
				String input = sc.next();
				
			if(input.equals("1")) {
				while(true) {
					System.out.print("���¹�ȣ : ");
					String id = sc.next();
					for(OLecture oLecture : lectures) {
						if(oLecture.getId().equals(id)) {
							this.cLecture.deleteLecture(oLecture, this.oHwewon, "��û ��Ȳ");
							}
						}
							
					break;
				}
			}
			
			else if(input.equals("2")) {
				
					break;
				}
			
			else
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���!");
			}
		}
}

}

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
		if(choice.equals("책가방")) {
			System.out.println("======== "+this.oHwewon.getName()+"님의 책가방 ========");

			
				while(true) {
					Vector<OLecture> lectures = this.cLecture.getMiri(this.oHwewon.getId());
					if(lectures.size()==0) {
						System.out.println("책가방이 비어있습니다.");
						break;
					}
					for(OLecture oLecture : lectures) {
						System.out.println(oLecture.getId() +" "+ oLecture.getName() +" "+oLecture.getProfessor()+" "+oLecture.getGradePoint()+" "+oLecture.getTime());
				}
					System.out.println("========다음 기능을 선택 하세요========");
					System.out.println("수강신청(1), 삭제(2), 나가기(3)");
					String input = sc.next();
					
				if(input.equals("1")) {
					while(true) {
						System.out.print("강좌번호 : ");
						String id = sc.next();
						for(OLecture oLecture : lectures) {
							if(oLecture.getId().equals(id)) {
								this.gradepoint = getGradepoint();
								if(this.gradepoint>Integer.parseInt(oLecture.getGradePoint())) {
								this.cLecture.saveLecture(oLecture, this.oHwewon, "sincheong");
								}
								else {
									System.out.println("수강가능한 학점을 초과하셨습니다.");
									break;
								}
								}
						}
						break;
					}
				}
				
				else if(input.equals("2")) {
					while(true) {
						System.out.print("강좌번호 : ");
						String id = sc.next();
						for(OLecture oLecture : lectures) {
							if(oLecture.getId().equals(id)) {
								this.cLecture.deleteLecture(oLecture, this.oHwewon, "책가방");
								
						}
						}
						break;
					}
				}
				
				else if(input.equals("3")) {
					break;
				}
				else
					System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요!");
				}
		}
		else if(choice.equals("신청 현황")) {
			System.out.println("======== "+this.oHwewon.getName()+"님의 신청 현황========");

		
			while(true) {
				Vector<OLecture> lectures = this.cLecture.getSincheong(this.oHwewon.getId());
				if(lectures.size()==0) {
					System.out.println("신청하신 강의가 없습니다.");
					break;
				}
				for(OLecture oLecture : lectures) {
					System.out.println(oLecture.getId() +" "+ oLecture.getName() +" "+oLecture.getProfessor()+" "+oLecture.getGradePoint()+" "+oLecture.getTime());
			}
				this.gradepoint = getGradepoint();
				System.out.println(this.oHwewon.getName()+"님의 남은 학점 :  "+this.gradepoint+"학점\n");
				System.out.println("========다음 기능을 선택 하세요========");
				System.out.println("철회(1), 나가기(2)");
				String input = sc.next();
				
			if(input.equals("1")) {
				while(true) {
					System.out.print("강좌번호 : ");
					String id = sc.next();
					for(OLecture oLecture : lectures) {
						if(oLecture.getId().equals(id)) {
							this.cLecture.deleteLecture(oLecture, this.oHwewon, "신청 현황");
							}
						}
							
					break;
				}
			}
			
			else if(input.equals("2")) {
				
					break;
				}
			
			else
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요!");
			}
		}
}

}

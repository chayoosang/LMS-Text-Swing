package textView;

import java.util.Scanner;

import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheong {


	private Scanner sc;

	
	
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	private VDamgi vDamgi;
	private VSincheong vSincheong;
	public VSugangsincheong(Scanner sc) {
		this.sc = sc;
		this.vCampus = new VIndex(this.sc);
		this.vCollege = new VIndex(this.sc);
		this.vDepartment = new VIndex(this.sc);
		this.vLecture = new VLecture(this.sc);
		this.vDamgi = new VDamgi(this.sc);
		this.vSincheong = new VSincheong(this.sc);
	}

	public void show(OHwewon oHwewon) {
			System.out.println("========강좌 검색을 시작합니다.========");
			//코드안에 상수 및 한글이 있으면 안됨.
			//constant 한쪽으로 모아야함
			
			
			
			String campusFileName = this.vCampus.show("root", "캠퍼스");
			if(campusFileName != null) {
				String collegeFileName = this.vCollege.show(campusFileName,"대학을");
					if(collegeFileName !=null) {
						 String departmentFileName = this.vDepartment.show(collegeFileName,"학과를");
						     if(departmentFileName!= null) {
						    	 OLecture oLecture = this.vLecture.show(departmentFileName);
						    	 if(oLecture!= null) {
						    		 System.out.println(oLecture.getName()+"에 대한 다음 기능을 선택 하세요");
						    		 System.out.println("수강신청(1), 미리담기(2)");
						    		 String choice = sc.next();
						    		 if(choice.equals("1")) {       
						    			 vSincheong.show(oLecture, oHwewon);
						    		 }
						    		 else if(choice.equals("2")) {
						    			 vDamgi.show(oLecture, oHwewon);
						    		 }
						    	 
						     }
					}
			}
		
			
			}			

}
}

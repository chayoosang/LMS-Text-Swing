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
			System.out.println("========���� �˻��� �����մϴ�.========");
			//�ڵ�ȿ� ��� �� �ѱ��� ������ �ȵ�.
			//constant �������� ��ƾ���
			
			
			
			String campusFileName = this.vCampus.show("root", "ķ�۽�");
			if(campusFileName != null) {
				String collegeFileName = this.vCollege.show(campusFileName,"������");
					if(collegeFileName !=null) {
						 String departmentFileName = this.vDepartment.show(collegeFileName,"�а���");
						     if(departmentFileName!= null) {
						    	 OLecture oLecture = this.vLecture.show(departmentFileName);
						    	 if(oLecture!= null) {
						    		 System.out.println(oLecture.getName()+"�� ���� ���� ����� ���� �ϼ���");
						    		 System.out.println("������û(1), �̸����(2)");
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

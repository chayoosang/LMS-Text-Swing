package textView;

import java.util.Scanner;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VDamgi {

	private Scanner sc;
	private CLecture cLecture;
	public VDamgi(Scanner sc) {
		this.sc = sc;
		this.cLecture = new CLecture();
	}
	public void show(OLecture oLecture, OHwewon oHwewon) {
		cLecture.saveLecture(oLecture, oHwewon,"damgi");
		
	}

}

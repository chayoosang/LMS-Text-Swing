package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import valueObject.OIndex;





public class VIndex {

	private CIndex cIndex;
	private Scanner sc;
	public VIndex(Scanner sc) {
		this.sc = sc;
		this.cIndex = new CIndex();
	}

	public String show(String string, String message) {
		System.out.println(message + " 선택해주세요.");
		Vector<OIndex> indices = cIndex.getAll(string);
		for(OIndex index : indices) {
			System.out.println(index.getId() +" "+ index.getName());
		}
		String id = this.sc.next();
		for(OIndex index : indices) {
			if(index.getId().equals(id)) {
				return index.getFileName();
			}
		}
		return null;
	}

}

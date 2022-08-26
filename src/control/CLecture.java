package control;

import java.util.Vector;

import dataAccessObject.DLecture;
import valueObject.OHwewon;
import valueObject.OLecture;


public class CLecture {

	private DLecture dLecture;
	public CLecture() {
			this.dLecture = new DLecture();
		}

	public void checkFile(OHwewon oHwewon) {
		this.dLecture.createFile(oHwewon);
	}

	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readAll(fileName);
		return lectures;
	}

	public Vector<OLecture> getSincheong(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readSincheong(fileName);
		return lectures;
	}

	public Vector<OLecture> getMiri(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readMiri(fileName);
		return lectures;
	}


	public boolean saveLecture(OLecture oLecture, OHwewon oHwewon, String select) {
		if(select.equals("sincheong")) {
			Vector<OLecture> lectures = this.getSincheong(oHwewon.getId());
			for(OLecture lecture : lectures) {
				if(lecture.getId().equals(oLecture.getId())) {
					return false;
				}
			}
			this.dLecture.save_s(oLecture, oHwewon);
			return true;
		}

	    else if(select.equals("damgi")) {
	    	Vector<OLecture> lectures =this.getMiri(oHwewon.getId());
	    	for(OLecture lecture : lectures) {
				if(lecture.getId().equals(oLecture.getId())) {
					return false;
				}
			}
		this.dLecture.save_d(oLecture, oHwewon);
		return true;
		}
	    else {
	    	return false;
	    }
	}

	public void deleteLecture(OLecture oLecture, OHwewon oHwewon, String select) {
		if(select.equals("å����")) {
			Vector<OLecture> lectures = this.getMiri(oHwewon.getId());
			int size = lectures.size();
			for(int i = 0; i<size; i++) {
				OLecture lecture = lectures.get(i);
				if(lecture.getId().equals(oLecture.getId())) {
					lectures.remove(i);
					size--;
					i--;
				}
			}
			this.dLecture.save_d(lectures, oHwewon);
			System.out.println("å���濡�� ���� �Ϸ�Ǿ����ϴ�.");
		}else if(select.equals("��û ��Ȳ")) {
			Vector<OLecture> lectures = this.getSincheong(oHwewon.getId());
			int size = lectures.size();
			for(int i = 0; i<size; i++) {
				OLecture lecture = lectures.get(i);
				if(lecture.getId().equals(oLecture.getId())) {
					lectures.remove(i);
					size--;
					i--;
				}
			}
			this.dLecture.save_s(lectures, oHwewon);
			System.out.println("���� öȸ�� �Ϸ�Ǿ����ϴ�.");
		}
	}



}

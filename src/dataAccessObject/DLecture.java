package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class DLecture {
	
	
	private static final String PATHNAME = "data/";
	private static final String SINCHEONG = "user_s/";
	private static final String DAMGI = "user_d/";
	private MLecture mLecture;
	
	public void createFile(OHwewon oHwewon) {
		
		try {
			File file1 = new File(SINCHEONG + oHwewon.getId());
			File file2 = new File(DAMGI + oHwewon.getId());
			FileWriter fileWriter1= new FileWriter(file1, true);
			FileWriter fileWriter2 = new FileWriter(file2, true); 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Vector<OLecture> readAll(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File(PATHNAME+fileName);
			Scanner sc = new Scanner(file);
			this.mLecture =new MLecture();
			while(mLecture.read(sc)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				lectures.add(oLecture);
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectures;
	}
	
	public Vector<OLecture> readSincheong(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File(SINCHEONG+fileName);
			Scanner sc = new Scanner(file);
			this.mLecture =new MLecture();
			while(mLecture.read(sc)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				lectures.add(oLecture);
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectures;
	}
	
	public Vector<OLecture> readMiri(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File(DAMGI+fileName);
			Scanner sc = new Scanner(file);
			this.mLecture =new MLecture();
			while(mLecture.read(sc)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				lectures.add(oLecture);
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectures;
	}
	
	
public void save_d(OLecture oLecture, OHwewon oHwewon) {
		
		try {
			File file = new File(DAMGI + oHwewon.getId());
			FileWriter fileWriter = new FileWriter(file, true);
			this.mLecture = new MLecture();
			
			mLecture.save(fileWriter, oLecture);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


public void save_s(OLecture oLecture, OHwewon oHwewon) {
	
	try {
		File file = new File(SINCHEONG + oHwewon.getId());
		FileWriter fileWriter = new FileWriter(file, true);
		this.mLecture = new MLecture();
		
		mLecture.save(fileWriter, oLecture);
		fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


public void save_d(Vector<OLecture> lectures, OHwewon oHwewon) {
	try {
	File file = new File(DAMGI + oHwewon.getId());
	FileWriter fileWriter = new FileWriter(file);
	for(OLecture oLecture : lectures) {
		this.mLecture = new MLecture();
		mLecture.save(fileWriter, oLecture);
		}
	fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void save_s(Vector<OLecture> lectures, OHwewon oHwewon) {
	try {
	File file = new File(SINCHEONG + oHwewon.getId());
	FileWriter fileWriter = new FileWriter(file);
	for(OLecture oLecture : lectures) {
		this.mLecture = new MLecture();
		mLecture.save(fileWriter, oLecture);
		}
	fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

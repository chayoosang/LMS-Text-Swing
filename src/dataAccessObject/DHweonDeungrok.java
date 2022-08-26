package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import model.MHwewon;
import model.MLecture;
import valueObject.OHwewon;
import valueObject.OLecture;


public class DHweonDeungrok {

	private MHwewon mHwewon;
	public DHweonDeungrok() {

	}
	public void save(OHwewon oHweown) {
		try {
		File file = new File("hwewon.txt");
		FileWriter fileWriter = new FileWriter(file,true);
		this.mHwewon =new MHwewon();

		mHwewon.save(fileWriter, oHweown);
		fileWriter.close();
		} catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean changeSave(Vector<OHwewon> hwewons) {
		try {
		File file = new File("hwewon.txt");
		FileWriter fileWriter = new FileWriter(file);
		for(OHwewon oHwewon : hwewons) {
		this.mHwewon =new MHwewon();
		mHwewon.save(fileWriter, oHwewon);
		}
		fileWriter.close();
		return true;
		} catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public OHwewon read(String id) {
		try {
			File file = new File("hwewon.txt");
			Scanner sc = new Scanner(file);
			this. mHwewon =new MHwewon();
			while(mHwewon.read(sc)) {
				if(mHwewon.getId().equals(id)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					return oHwewon;
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		return null;
		}

	public OHwewon findHwewon(String a, String b) {
		try {
			File file = new File("hwewon.txt");
			Scanner sc = new Scanner(file);
			this. mHwewon =new MHwewon();
			while(mHwewon.read(sc)) {
				if(mHwewon.getName().equals(a)&&mHwewon.getAddress().equals(b)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					return oHwewon;
					}
				else if(mHwewon.getId().equals(a)&&mHwewon.getName().equals(b)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					return oHwewon;
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		return null;
		}

	public Vector<OHwewon> readAll(){
		Vector<OHwewon> hwewons = new Vector<OHwewon>();
		try {
			File file = new File("hwewon.txt");
			Scanner sc = new Scanner(file);
			this.mHwewon =new MHwewon();
			while(mHwewon.read(sc)) {
				OHwewon oHwewon = new OHwewon();
				oHwewon.set(mHwewon);
				hwewons.add(oHwewon);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
    			e.printStackTrace();
    			}
		return hwewons;
		}
	}


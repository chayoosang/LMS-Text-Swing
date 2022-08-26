package control;

import dataAccessObject.DIndex;
import valueObject.OIndex;
import java.util.Vector;

import control.CIndex;


public class CIndex {

	private DIndex dIndex;
	public CIndex() {
			this.dIndex = new DIndex();
		}
	
	public Vector<OIndex> getAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		indices =	this.dIndex.readAll(fileName);
		return indices;
	}
		

}

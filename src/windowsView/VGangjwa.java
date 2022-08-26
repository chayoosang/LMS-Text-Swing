package windowsView;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import valueObject.OLecture;

public class VGangjwa extends JTable {

	private static final long serialVersionUID = 1L;
	
	//associations
	private CLecture cLecture;
	private DefaultTableModel model;
	//구조만 잡음
	public VGangjwa() {
		super();
		// attributes
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("강좌번호");
		model.addColumn("강좌명");
		model.addColumn("강사명");
		model.addColumn("학점");
		model.addColumn("시간");

		// associations

	}

	//data 추가
	public void initialize() {
		this.model.setNumRows(0);
	}
	
		public void getData(String fileName, String select) {
		this.cLecture = new CLecture();
		Vector<OLecture> oLectures = new Vector<OLecture>();
		if(select.equals("강좌")) {
			oLectures = this.cLecture.getAll(fileName);
		}
		else if(select.equals("신청 현황")) {
			oLectures = this.cLecture.getSincheong(fileName);
		}
		else oLectures = this.cLecture.getMiri(fileName);
		
		String[] row = new String[model.getColumnCount()];
		for(OLecture oLecture : oLectures) {
			row[0] = oLecture.getId();
			row[1] = oLecture.getName();
			row[2] = oLecture.getProfessor();
			row[3] = oLecture.getGradePoint();
			row[4] = oLecture.getTime();		
			model.addRow(row);
		}
		this.updateUI();
	}
		public void refresh(String fileName, String select) {
			this.model.setNumRows(0);
			this.getData(fileName, select);
			this.model.fireTableDataChanged();
			this.updateUI();
		}


}

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
	//������ ����
	public VGangjwa() {
		super();
		// attributes
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("���¹�ȣ");
		model.addColumn("���¸�");
		model.addColumn("�����");
		model.addColumn("����");
		model.addColumn("�ð�");

		// associations

	}

	//data �߰�
	public void initialize() {
		this.model.setNumRows(0);
	}
	
		public void getData(String fileName, String select) {
		this.cLecture = new CLecture();
		Vector<OLecture> oLectures = new Vector<OLecture>();
		if(select.equals("����")) {
			oLectures = this.cLecture.getAll(fileName);
		}
		else if(select.equals("��û ��Ȳ")) {
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

package windowsView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.CIndex;
import control.CLecture;
import valueObject.OHwewon;
import valueObject.OIndex;
import valueObject.OLecture;

public class VSugangSincheongPanel extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	

	private VGangjwa vGangjwa;
	private JButton miridamgi;
	private JButton sincheong;
	private JLabel gradepointText;
	
	private String[] campusFile;
	private String[] collegeFile;
	private String[] departmentFile;
	private int totalGradepoint = 18;
	private String point ="��û ������ ���� : ";
	
	private ActionHandler action;
	private JComboBox<String>  campus;
	private JComboBox<String>  college;
	private JComboBox<String> department;
	private CIndex cIndex;
	private CLecture cLecture;
	private OLecture oLecture;
	private OHwewon oHwewon;

	
	
	
	public VSugangSincheongPanel(OHwewon oHwewon,ActionListener parentAction) {
		super();
		
		this.action = new ActionHandler();
		
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
		this.oHwewon = oHwewon;
		this.oLecture = new OLecture();
		
		this.setLayout(null);
		
		Font font = new Font("���� ���",Font.BOLD, 15);
		
		JLabel sugang = new JLabel("������û");
		sugang.setBounds(10,10,300,40);
		sugang.setFont(new Font("���� ���",Font.BOLD, 30));
		this.add(sugang);
		
		
		
		
		this.campus= new JComboBox<String> ();
		this.college= new JComboBox<String> ();
		this.department= new JComboBox<String> ();
		
		this.campus.addItem("=ķ�۽�=");
		this.college.addItem("=�к�=");
		this.department.addItem( "=�а�=");
		
		this.campus.setBounds(100,100,200,30);
		this.college.setBounds(400,100,200,30);
		this.department.setBounds(700,100,200,30);
		this.campus.setFont(font);
		this.college.setFont(font);
		this.department.setFont(font);
		
		this.getIndex(campus, "root");
		
		
		this.add(campus);
		this.add(college);
		this.add(department);
		
		
		this.gradepointText = new JLabel(this.point+this.getGradepoint());
		this.gradepointText.setBounds(430,620,300,50);
		this.gradepointText.setFont(font);
		this.add(this.gradepointText);
		
		this.vGangjwa = new VGangjwa();
		this.vGangjwa.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(this.vGangjwa);
		scrollPane.setBounds(150,160,700,450);
	   
		
		this.miridamgi = new JButton("�̸� ���");
		this.miridamgi.setActionCommand("�̸����");
		this.miridamgi.addActionListener(this.action);
		this.miridamgi.setBounds(350,680,100,50);
		this.sincheong = new JButton("������û");
		this.sincheong.setActionCommand("������û");
		this.sincheong.addActionListener(this.action);
		this.sincheong.setBounds(550,680,100,50);
		
		 JButton back = new JButton("�ڷΰ���");
		 back.setActionCommand("�ڷΰ���");
		 back.addActionListener(parentAction);
		 back.setBounds(880,10,100,50);
		 this.add(back);
		
		
		this.add(scrollPane);
		this.add(miridamgi);
		this.add(sincheong);
		
	}
	
	private int getGradepoint() {
		int gradepoint =0;
		Vector<OLecture> lectures = this.cLecture.getSincheong(oHwewon.getId());
		for(OLecture oLecture : lectures) {
			gradepoint+= Integer.parseInt(oLecture.getGradePoint());
		}
		return (this.totalGradepoint - gradepoint);
		
	}

	private void getIndex(JComboBox<String> box, String fileName) {
		
		
		int i = 1;

		Vector<OIndex> indices = this.cIndex.getAll(fileName);
		if(box==this.campus) {
			this.campusFile = new String[indices.size()+1]; 
			
			for(OIndex oIndex : indices) {
				box.addItem(oIndex.getName());
				campusFile[i++] = oIndex.getFileName();
			}
			
			box.setActionCommand("college");
			box.addActionListener(this.action);
		}
		else if(box==this.college) {
			this.collegeFile = new String[indices.size()+1]; 
			
			for(OIndex oIndex : indices) {
				box.addItem(oIndex.getName());
				collegeFile[i++] = oIndex.getFileName();
			}
			
			box.setActionCommand("department");
			box.addActionListener(this.action);
		}
		else if(box==this.department) {
			this.departmentFile = new String[indices.size()+1]; 
			
			for(OIndex oIndex : indices) {
				box.addItem(oIndex.getName());
				departmentFile[i++] = oIndex.getFileName();
			}
			
			box.setActionCommand("lecture");
			box.addActionListener(this.action);
		}
		box.setSelectedIndex(0);
		
	}
	
	public void setData() {
		this.oLecture = new OLecture();
		int row = this.vGangjwa.getSelectedRow();
		
		this.oLecture.setId((String)this.vGangjwa.getValueAt(row, 0));
		this.oLecture.setName((String)this.vGangjwa.getValueAt(row, 1));
		this.oLecture.setProfessor((String)this.vGangjwa.getValueAt(row, 2));
		this.oLecture.setGradePoint((String)this.vGangjwa.getValueAt(row, 3));
		this.oLecture.setTime((String)this.vGangjwa.getValueAt(row, 4));
		
	}
	
	public void saveData(String choice) {
		if(this.oLecture!=null) {
		if(choice.equals("�̸����")) {
			if(this.cLecture.saveLecture(this.oLecture, this.oHwewon, "damgi")) {
				JOptionPane.showMessageDialog(null, "���������� å���濡 �����ϴ�.");
			}
			else 
				JOptionPane.showMessageDialog(null, "�ߺ��� �����Դϴ�.");
		}
		else if(choice.equals("������û")) {
			if(this.getGradepoint()>= Integer.parseInt(this.oLecture.getGradePoint())) {
			if(this.cLecture.saveLecture(this.oLecture, this.oHwewon, "sincheong")) {
				JOptionPane.showMessageDialog(null, "���������� ���� ��û�߽��ϴ�.");
				this.gradepointText.setText(this.point+this.getGradepoint());
			}
			else 
				JOptionPane.showMessageDialog(null, "�ߺ��� �����Դϴ�.");
		}
			else
				JOptionPane.showMessageDialog(null, "��û ������ ������ �ʰ��Ͽ����ϴ�.");
		}
		}else
			JOptionPane.showMessageDialog(null, "���¸� �������ּ���.");
	}
	

	public void initialize() {
		this.vGangjwa.initialize();
	}
	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("college")) {
				college.removeAllItems();
				department.removeAllItems();
				college.addItem("=�к�=");
				department.addItem( "=�а�=");
				String fileName = campusFile[campus.getSelectedIndex()];
				if(fileName!=null)
				getIndex(college, fileName);

			}
			else if(e.getActionCommand().equals("department")) {
				department.removeAllItems();
				department.addItem( "=�а�=");
				if(college.getItemCount()!=0) {
				String fileName =collegeFile[college.getSelectedIndex()];
				if(fileName!=null)
				getIndex(department, fileName);
				}
			}
			else if(e.getActionCommand().equals("lecture")) {
				if(department.getItemCount()!=0) {
				String fileName = departmentFile[department.getSelectedIndex()];
				if(fileName!=null)
				vGangjwa.refresh(fileName, "����");
				}
			}
			else  {
				saveData(e.getActionCommand());
			}
			}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		setData();
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

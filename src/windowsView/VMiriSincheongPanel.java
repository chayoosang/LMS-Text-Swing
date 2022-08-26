package windowsView;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VMiriSincheongPanel extends JPanel implements MouseListener{


	private static final long serialVersionUID = 1L;
	private JLabel info;
	private JLabel gradepointText;
	private JButton sincheong;
	private JButton sakje;
	private VGangjwa vMySincheong;
	
	private int totalGradepoint = 18;
	private String point ="��û ������ ���� : ";
	
	private ActionHandler action;
	private OHwewon oHwewon;
	private OLecture oLecture;
	private String choice;
	private CLecture cLecture;

	
	public VMiriSincheongPanel(String choice, OHwewon oHwewon, ActionListener parentAction) {
		super();
		
		this.action = new ActionHandler();
		
		this.setLayout(null);
		this.oHwewon = oHwewon;
		this.cLecture = new CLecture();
		
		Font font = new Font("���� ���",Font.BOLD, 15);
		
		this.choice = choice;
		String str = this.oHwewon.getName() + "�� " + choice;
		
		this.info = new JLabel(str);
		this.info.setBounds(10,10,300,40);
		this.info.setFont(new Font("���� ���",Font.BOLD, 30));
		this.add(info);
		
		this.gradepointText = new JLabel(this.point+this.getGradepoint());
		this.gradepointText.setBounds(430,600,300,50);
		this.gradepointText.setFont(font);
		this.add(this.gradepointText);
		
		this.vMySincheong = new VGangjwa();
		this.vMySincheong.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(this.vMySincheong );
		scrollPane.setBounds(150,130,700,450);
	    this.add(scrollPane);
	    
	    JButton back = new JButton("�ڷΰ���");
	    back.setActionCommand("�ڷΰ���");
	    back.addActionListener(parentAction);
	    back.setBounds(880,10,100,50);
	    this.add(back);
	    
	    this.addButton();

	}
	

	
	private void addButton() {
	
		if(this.choice.equals("å����")) {
			this.sincheong = new JButton("��û");
			this.sakje = new JButton("����");
			
			this.sincheong.setActionCommand("��û");
			this.sincheong.addActionListener(action);
			this.sincheong.setBounds(350,680,100,50);
			this.add(this.sincheong);
			
			this.sakje.setActionCommand("å����");
			this.sakje.addActionListener(action);
			this.sakje.setBounds(550,680,100,50);
			this.add(this.sakje);
		}
		else if(this.choice.equals("��û ��Ȳ")) {
			this.sakje = new JButton("���� öȸ");
			
			this.sakje.setActionCommand("��û ��Ȳ");
			this.sakje.addActionListener(action);
			this.sakje.setBounds(450,680,100,50);
			this.add(this.sakje);
		}
	}
	
	private int getGradepoint() {
		int gradepoint =0;
		Vector<OLecture> lectures = this.cLecture.getSincheong(oHwewon.getId());
		for(OLecture oLecture : lectures) {
			gradepoint+= Integer.parseInt(oLecture.getGradePoint());
		}
		return (this.totalGradepoint - gradepoint);
		
	}
	
	public void initialize() {
		this.vMySincheong.initialize();
		this.vMySincheong.getData(this.oHwewon.getId(), this.choice);
	}
	
	public void setData() {
		this.oLecture = new OLecture();
		int row = this.vMySincheong.getSelectedRow();
		
		this.oLecture.setId((String)this.vMySincheong.getValueAt(row, 0));
		this.oLecture.setName((String)this.vMySincheong.getValueAt(row, 1));
		this.oLecture.setProfessor((String)this.vMySincheong.getValueAt(row, 2));
		this.oLecture.setGradePoint((String)this.vMySincheong.getValueAt(row, 3));
		this.oLecture.setTime((String)this.vMySincheong.getValueAt(row, 4));
		
	}
	
	public void deleteData(String choice) {
		this.cLecture.deleteLecture(this.oLecture, this.oHwewon, choice);
		this.vMySincheong.refresh(oHwewon.getId(), choice);
		if(choice.equals("��û ��Ȳ"))
		this.gradepointText.setText(this.point+this.getGradepoint());
	}
	
	public void saveData() {
		if(this.getGradepoint()>= Integer.parseInt(this.oLecture.getGradePoint())) {
			if(this.cLecture.saveLecture(this.oLecture, this.oHwewon, "sincheong")) {
				JOptionPane.showMessageDialog(null, "���������� ���� ��û�߽��ϴ�.");
				this.gradepointText.setText(this.point+this.getGradepoint());
			}else 
				JOptionPane.showMessageDialog(null, "�ߺ��� �����Դϴ�.");
		}else
				JOptionPane.showMessageDialog(null, "��û ������ ������ �ʰ��Ͽ����ϴ�.");
		}

	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("��û")) {
				saveData();
			}
			else if(e.getActionCommand().equals("å����")) {
				deleteData("å����");
			}
			else if(e.getActionCommand().equals("��û ��Ȳ")) {
				deleteData("��û ��Ȳ");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		setData();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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



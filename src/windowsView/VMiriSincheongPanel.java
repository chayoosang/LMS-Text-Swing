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
	private String point ="신청 가능한 학점 : ";
	
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
		
		Font font = new Font("맑은 고딕",Font.BOLD, 15);
		
		this.choice = choice;
		String str = this.oHwewon.getName() + "의 " + choice;
		
		this.info = new JLabel(str);
		this.info.setBounds(10,10,300,40);
		this.info.setFont(new Font("맑은 고딕",Font.BOLD, 30));
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
	    
	    JButton back = new JButton("뒤로가기");
	    back.setActionCommand("뒤로가기");
	    back.addActionListener(parentAction);
	    back.setBounds(880,10,100,50);
	    this.add(back);
	    
	    this.addButton();

	}
	

	
	private void addButton() {
	
		if(this.choice.equals("책가방")) {
			this.sincheong = new JButton("신청");
			this.sakje = new JButton("삭제");
			
			this.sincheong.setActionCommand("신청");
			this.sincheong.addActionListener(action);
			this.sincheong.setBounds(350,680,100,50);
			this.add(this.sincheong);
			
			this.sakje.setActionCommand("책가방");
			this.sakje.addActionListener(action);
			this.sakje.setBounds(550,680,100,50);
			this.add(this.sakje);
		}
		else if(this.choice.equals("신청 현황")) {
			this.sakje = new JButton("수강 철회");
			
			this.sakje.setActionCommand("신청 현황");
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
		if(choice.equals("신청 현황"))
		this.gradepointText.setText(this.point+this.getGradepoint());
	}
	
	public void saveData() {
		if(this.getGradepoint()>= Integer.parseInt(this.oLecture.getGradePoint())) {
			if(this.cLecture.saveLecture(this.oLecture, this.oHwewon, "sincheong")) {
				JOptionPane.showMessageDialog(null, "성공적으로 수강 신청했습니다.");
				this.gradepointText.setText(this.point+this.getGradepoint());
			}else 
				JOptionPane.showMessageDialog(null, "중복된 강좌입니다.");
		}else
				JOptionPane.showMessageDialog(null, "신청 가능한 학점을 초과하였습니다.");
		}

	
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("신청")) {
				saveData();
			}
			else if(e.getActionCommand().equals("책가방")) {
				deleteData("책가방");
			}
			else if(e.getActionCommand().equals("신청 현황")) {
				deleteData("신청 현황");
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



package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Config.FVIdFindFrame;
import control.CHwewon;
import valueObject.OHwewon;

public class VIdFindFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField nameText;
	private JTextField addressText;
	private JButton findBt;
	private CHwewon cHwewon;
	private ActionHandler action;
	
	public  VIdFindFrame() {
		super();
		
		this.setLayout(null);
		this.setSize(FVIdFindFrame.size);
		
		this.action = new ActionHandler();
		
		JLabel name = new JLabel("�̸�");
		name.setBounds(10, 30, 80, 25);
		this.add(name);
		
		JLabel address = new JLabel("�ּ�");
		address.setBounds(10,70 , 80, 25);
		this.add(address);
		
		nameText = new JTextField(10);
		nameText.setBounds(100, 30, 160, 25);
		this.add(nameText);
		
		addressText = new JTextField(11);
		addressText.setBounds(100, 70, 160, 25);
		this.add(addressText);
		
		findBt = new JButton("���̵� ã��");
		findBt.setBounds(100, 120, 100, 30);
		findBt.addActionListener(this.action);
		this.add(findBt);
		

	}
	public void initialize() {
		
	}
	
	private void find() {
		if(nameText.getText()!=null&&addressText.getText()!=null) {
		OHwewon oHwewon = new OHwewon();
		 cHwewon = new CHwewon();
		
		oHwewon.setName(nameText.getText());
		oHwewon.setAddress(addressText.getText());
		
		OHwewon find = cHwewon.validate(oHwewon);
		
		if(find!=null) {
			JOptionPane.showMessageDialog(null, find.getName()+"���� ���̵�� "+find.getId()+"�Դϴ�.");
		}
		else {
			JOptionPane.showMessageDialog(null, "ã���ô� ���̵� �������� �ʽ��ϴ�.");
		}
	}
		else
			JOptionPane.showMessageDialog(null, "�Է¶��� ä���ּ���.");
	}
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			find();
			}
		}
}
	







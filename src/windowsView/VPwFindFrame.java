package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Config.FVPwFindFrame;
import control.CHwewon;
import valueObject.OHwewon;

public class VPwFindFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField idText;
	private JTextField nameText;
	private JButton findBt;
	private CHwewon cHwewon;
	private ActionHandler action;
	public  VPwFindFrame( ) {
		super();
		this.setLayout(null);
		this.setSize(FVPwFindFrame.size);
		
		this.action = new ActionHandler();
		
		
		JLabel id = new JLabel("���̵�");
		id.setBounds(10, 30, 80, 25);	
		this.add(id);
		
		JLabel name = new JLabel("�̸�");
		name.setBounds(10,70 , 80, 25);
		this.add(name);
		
		idText = new JTextField(10);
		idText.setBounds(100, 30, 160, 25);
		this.add(idText);
		
		nameText = new JTextField(11);
		nameText.setBounds(100, 70, 160, 25);
		this.add(nameText);
		
		findBt = new JButton("PW ã��");
		findBt.setBounds(100, 120, 100, 30);
		findBt.addActionListener(action);
		this.add(findBt);
		

	}
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	private void find() {
		if(idText.getText()!=null&&nameText.getText()!=null) {
		OHwewon oHwewon = new OHwewon();
		 cHwewon = new CHwewon();
		
		oHwewon.setId(idText.getText());
		oHwewon.setName(nameText.getText());
		
		OHwewon find = cHwewon.validate(oHwewon);
		
		if(find!=null) {
			JOptionPane.showMessageDialog(null, find.getName()+"���� ��й�ȣ�� "+find.getPassword()+"�Դϴ�.");
		}
		else {
			JOptionPane.showMessageDialog(null, "�Է��Ͻ� ������ ȸ���� �����ϴ�.");
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
package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Config.FVHweonDeungrokFrame;
import control.CHweonDeungrok;
import control.CHwewon;
import control.CLogin;
import valueObject.OHwewon;

public class VHweonDeungrokFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private boolean idcheck = false;
	private boolean pwcheck = false;
	
	private JTextField idText;
	private JPasswordField pwText;
	private JPasswordField pwReText;
	private JTextField addressText;
	private JTextField nameText;
	private JTextField hakgwaText;
	private JButton logincheck;
	private JButton deungrokBt;
	private CLogin cLogin;
	private CHweonDeungrok cHweonDeungrok;
	private ActionHandler action;
	
	
	public VHweonDeungrokFrame() {
		super();
		
		this.setLayout(null);
		this.setSize(FVHweonDeungrokFrame.size);
		
		action = new ActionHandler();
		
		
		JLabel Id = new JLabel("���̵�");
		idText = new JTextField();
		Id.setHorizontalAlignment(JLabel.CENTER);
		Id.setBounds(10, 10, 120, 30);
		this.add(Id);
		idText.setBounds(150,10,200, 30);
		this.add(idText);
		logincheck = new JButton("�ߺ�Ȯ��");
		logincheck.setBounds(370,10,100, 30);
		logincheck.setActionCommand("�ߺ�Ȯ��");
		logincheck.addActionListener(action);
		this.add(logincheck);
		
		
		JLabel Password = new JLabel("��й�ȣ");
		pwText = new JPasswordField();
		Password.setHorizontalAlignment(JLabel.CENTER);
		Password.setBounds(10, 60, 120, 30);
		this.add(Password);
		pwText.setBounds(150,60,200, 30);
		this.add(pwText);
		
		JLabel PasswordRe = new JLabel("��й�ȣ ���Է�");
		pwReText = new JPasswordField();
		PasswordRe.setHorizontalAlignment(JLabel.CENTER);
		PasswordRe.setBounds(10, 110, 120, 30);
		this.add(PasswordRe);
		pwReText.setBounds(150,110,200, 30);
		this.add(pwReText);


		
		
		JLabel Name = new JLabel("�̸�");
		nameText = new JTextField();
		Name.setHorizontalAlignment(JLabel.CENTER);
		Name.setBounds(10, 160, 120, 30);
		this.add(Name);
		nameText.setBounds(150,160,200, 30);
		this.add(nameText);
		
		
		
		JLabel Address = new JLabel("�ּ�");
		addressText = new JTextField();
		Address.setHorizontalAlignment(JLabel.CENTER);
		Address.setBounds(10, 210, 120, 30);
		this.add(Address);
		addressText.setBounds(150,210,200, 30);
		this.add(addressText);
		
		
		JLabel Hakgwa = new JLabel("�а�");
		hakgwaText = new JTextField();
		Hakgwa.setHorizontalAlignment(JLabel.CENTER);
		Hakgwa.setBounds(10, 260, 120, 30);
		this.add(Hakgwa);
		hakgwaText.setBounds(150,260,200, 30);
		this.add(hakgwaText);
		
		
		deungrokBt = new JButton("ȸ������");
		deungrokBt.setBounds(200, 300, 100, 50);
		deungrokBt.setActionCommand("ȸ������");
		deungrokBt.addActionListener(action);
		this.add(deungrokBt);
		

	}
	
	public void initialize() {
		
	}
	
	private void idCheck() {
		OHwewon oHwewon = new OHwewon();
		cLogin = new CLogin();
		oHwewon.setId(idText.getText());
		
		if(cLogin.check(oHwewon)) {
			JOptionPane.showMessageDialog(null, "����ϽǼ� �ִ� ���̵� �Դϴ�.");
			idcheck = true;
		}
		else {
			JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�.");
			idcheck = false;
		}
	}
	
	private void pwCheck() {
			String pw = "";
			String pwre = "";
			for(int i=0; i<pwText.getPassword().length; i++) {
				pw += pwText.getPassword()[i]; 
			}
			for(int j=0; j<pwReText.getPassword().length; j++) {
				pwre += pwReText.getPassword()[j]; 
			}
			if(pw.equals(pwre)) pwcheck =  true;
			else pwcheck = false;
}
	
	private void hwewondeungrok() {
		OHwewon oHwewon = new OHwewon();
		 cHweonDeungrok = new CHweonDeungrok(); 
		oHwewon.setId(idText.getText());
		oHwewon.setPassword(pwText.getPassword());
		oHwewon.setName(nameText.getText());
		oHwewon.setAddress(addressText.getText());
		oHwewon.setHwakgwa(hakgwaText.getText());
		
		cHweonDeungrok.saveHwewon(oHwewon);
		JOptionPane.showMessageDialog(null, "���������� ȸ�������� �Ǽ̽��ϴ�.");
		this.dispose();
	}
	
	
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("�ߺ�Ȯ��")) {
				idCheck();
			}else if(e.getActionCommand().equals("ȸ������")) {
				if(idText.getText()!=null&&pwText.getPassword()!=null&&nameText.getText()!=null
						&&pwReText.getPassword()!=null&&addressText.getText()!=null&&hakgwaText.getText()!=null) {
				pwCheck();
				
				if(idcheck==true&&pwcheck==true) {
					hwewondeungrok();
				}
				else if(idcheck==false&&pwcheck==true) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ�Ȯ���� ���ּ���.");
				}
				else if(idcheck==true&&pwcheck==false) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� �Է����ּ���.");
				}
			}
				else
					JOptionPane.showMessageDialog(null, "�Է¶��� ä���ּ���.");
			}
			}
		}
}

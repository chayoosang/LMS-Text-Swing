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
		
		
		JLabel Id = new JLabel("아이디");
		idText = new JTextField();
		Id.setHorizontalAlignment(JLabel.CENTER);
		Id.setBounds(10, 10, 120, 30);
		this.add(Id);
		idText.setBounds(150,10,200, 30);
		this.add(idText);
		logincheck = new JButton("중복확인");
		logincheck.setBounds(370,10,100, 30);
		logincheck.setActionCommand("중복확인");
		logincheck.addActionListener(action);
		this.add(logincheck);
		
		
		JLabel Password = new JLabel("비밀번호");
		pwText = new JPasswordField();
		Password.setHorizontalAlignment(JLabel.CENTER);
		Password.setBounds(10, 60, 120, 30);
		this.add(Password);
		pwText.setBounds(150,60,200, 30);
		this.add(pwText);
		
		JLabel PasswordRe = new JLabel("비밀번호 재입력");
		pwReText = new JPasswordField();
		PasswordRe.setHorizontalAlignment(JLabel.CENTER);
		PasswordRe.setBounds(10, 110, 120, 30);
		this.add(PasswordRe);
		pwReText.setBounds(150,110,200, 30);
		this.add(pwReText);


		
		
		JLabel Name = new JLabel("이름");
		nameText = new JTextField();
		Name.setHorizontalAlignment(JLabel.CENTER);
		Name.setBounds(10, 160, 120, 30);
		this.add(Name);
		nameText.setBounds(150,160,200, 30);
		this.add(nameText);
		
		
		
		JLabel Address = new JLabel("주소");
		addressText = new JTextField();
		Address.setHorizontalAlignment(JLabel.CENTER);
		Address.setBounds(10, 210, 120, 30);
		this.add(Address);
		addressText.setBounds(150,210,200, 30);
		this.add(addressText);
		
		
		JLabel Hakgwa = new JLabel("학과");
		hakgwaText = new JTextField();
		Hakgwa.setHorizontalAlignment(JLabel.CENTER);
		Hakgwa.setBounds(10, 260, 120, 30);
		this.add(Hakgwa);
		hakgwaText.setBounds(150,260,200, 30);
		this.add(hakgwaText);
		
		
		deungrokBt = new JButton("회원가입");
		deungrokBt.setBounds(200, 300, 100, 50);
		deungrokBt.setActionCommand("회원가입");
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
			JOptionPane.showMessageDialog(null, "사용하실수 있는 아이디 입니다.");
			idcheck = true;
		}
		else {
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
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
		JOptionPane.showMessageDialog(null, "성공적으로 회원가입이 되셨습니다.");
		this.dispose();
	}
	
	
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("중복확인")) {
				idCheck();
			}else if(e.getActionCommand().equals("회원가입")) {
				if(idText.getText()!=null&&pwText.getPassword()!=null&&nameText.getText()!=null
						&&pwReText.getPassword()!=null&&addressText.getText()!=null&&hakgwaText.getText()!=null) {
				pwCheck();
				
				if(idcheck==true&&pwcheck==true) {
					hwewondeungrok();
				}
				else if(idcheck==false&&pwcheck==true) {
					JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요.");
				}
				else if(idcheck==true&&pwcheck==false) {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.");
				}
			}
				else
					JOptionPane.showMessageDialog(null, "입력란을 채워주세요.");
			}
			}
		}
}

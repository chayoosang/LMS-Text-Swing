package windowsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Config.FVMyInformationFrame;
import control.CHwewon;
import valueObject.OHwewon;

public class VMyInformationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel password;
	private JPasswordField passwordfield;
	private JButton check;
	private JPanel panel;
	private CHwewon cHwewon;
	private JPasswordField pwText;
	private JPasswordField pwReText;
	private JTextField addressText;
	private JTextField nameText;
	private JTextField hakgwaText;
	private boolean pwcheck = false;
	private ActionHandler action;
	private OHwewon oHwewon;
	private ActionListener parentAction;
	
	public VMyInformationFrame(OHwewon oHwewon, ActionListener parentAction){
		super();
		
		this.parentAction = parentAction;
		this.oHwewon = oHwewon;
		this.action = new ActionHandler();
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.setSize(FVMyInformationFrame.size);
		
		JLabel info = new JLabel("정보 확인");
		info.setBounds(200,20,100,20);
		
		
		this.password = new JLabel("비밀번호");
		this.password.setBounds(110, 100, 80, 25);
		
		this.passwordfield = new JPasswordField();
		this.passwordfield.setBounds(180, 100, 160, 25);
		this.passwordfield.addActionListener(action);
		
		this.check = new JButton("확인");
		this.check.setBounds(200,200,100,50);
		this.check.setActionCommand("확인");
		this.check.addActionListener(action);
		
		panel.add(info);
		panel.add(password);
		panel.add(passwordfield);
		panel.add(check);
		
		this.add(panel);
		
	}

	private void informationShow() {
		
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		
		JLabel Id = new JLabel("아이디");
		JTextField idText = new JTextField(this.oHwewon.getId());
		Id.setHorizontalAlignment(JLabel.CENTER);
		Id.setBounds(10, 10, 120, 30);
		panel.add(Id);
		idText.setBounds(150,10,200, 30);
		panel.add(idText);
		
		
		JLabel Password = new JLabel("비밀번호");
		 pwText = new JPasswordField(this.oHwewon.getPassword());
		Password.setHorizontalAlignment(JLabel.CENTER);
		Password.setBounds(10, 60, 120, 30);
		panel.add(Password);
		pwText.setBounds(150,60,200, 30);
		panel.add(pwText);
		
		JLabel PasswordRe = new JLabel("비밀번호 재입력");
		 pwReText = new JPasswordField(this.oHwewon.getPassword());
		PasswordRe.setHorizontalAlignment(JLabel.CENTER);
		PasswordRe.setBounds(10, 110, 120, 30);
		panel.add(PasswordRe);
		pwReText.setBounds(150,110,200, 30);
		panel.add(pwReText);

		
		JLabel Name = new JLabel("이름");
		 nameText = new JTextField(this.oHwewon.getName());
		Name.setHorizontalAlignment(JLabel.CENTER);
		Name.setBounds(10, 160, 120, 30);
		panel.add(Name);
		nameText.setBounds(150,160,200, 30);
		panel.add(nameText);
		
		
		
		JLabel Address = new JLabel("주소");
		 addressText = new JTextField(this.oHwewon.getAddress());
		Address.setHorizontalAlignment(JLabel.CENTER);
		Address.setBounds(10, 210, 120, 30);
		panel.add(Address);
		addressText.setBounds(150,210,200, 30);
		panel.add(addressText);
		
		
		JLabel Hakgwa = new JLabel("학과");
		 hakgwaText = new JTextField(this.oHwewon.getHwakgwa());
		Hakgwa.setHorizontalAlignment(JLabel.CENTER);
		Hakgwa.setBounds(10, 260, 120, 30);
		panel.add(Hakgwa);
		hakgwaText.setBounds(150,260,200, 30);
		panel.add(hakgwaText);
		
		
		JButton changeBt = new JButton("수정");
		changeBt.setBounds(100, 300, 100, 50);
		changeBt.setActionCommand("수정");
		changeBt.addActionListener(action);
		panel.add(changeBt);
		
		JButton closeBt = new JButton("닫기");
		closeBt.setBounds(300, 300, 100, 50);
		closeBt.setActionCommand("닫기");
		closeBt.addActionListener(this.parentAction);
		panel.add(closeBt);
				
	}
	
	private void loginCheck() {
		
		String pw= "";
		for(int i=0; i<passwordfield.getPassword().length; i++) {
			pw += passwordfield.getPassword()[i];
		}
		
		if(this.oHwewon.getPassword().equals(pw)) {
			JOptionPane.showMessageDialog(null, "인증 성공");
			informationShow();
		}
		else
			JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.");
	}
	
	private void passwordCheck() {
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
	
	private void changeInfo() {
		OHwewon hwewon = new OHwewon();
		 cHwewon = new CHwewon();
		
		hwewon.setId(this.oHwewon.getId());
		hwewon.setPassword(pwText.getPassword());
		hwewon.setName(nameText.getText());
		hwewon.setAddress(addressText.getText());
		hwewon.setHwakgwa(hakgwaText.getText());
		
		if(cHwewon.change(hwewon)==true) {
			JOptionPane.showMessageDialog(null, "회원정보 수정을 완료했습니다.");
			this.oHwewon = hwewon;
		}
		else
			JOptionPane.showMessageDialog(null, "회원정보 수정을 실패했습니다.");
	}
	
	public OHwewon refresh() {
		return this.oHwewon;
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("확인"))
				loginCheck();
			else if(e.getActionCommand().equals("수정")) {
				if(pwText.getPassword()!=null&&nameText.getText()!=null&&pwReText.getPassword()!=null
						&&addressText.getText()!=null&&hakgwaText.getText()!=null) {
					passwordCheck();
					if(pwcheck == true) 
						changeInfo();
					else
						JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.");
				}
				else {
					JOptionPane.showMessageDialog(null, "입력란을 채워주세요.");
				}
			}
		}
		
	}

	public void initialize() {
		
	}



}

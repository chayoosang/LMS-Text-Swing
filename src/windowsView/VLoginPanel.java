package windowsView;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLoginPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	private JButton loginbt;
	private JButton idFindbt;
	private JButton pwFindbt;
	private JButton hwewonbt;
	private JTextField idText;
	private JPasswordField passwordText;
	private VIdFindFrame vIdFind;
	private VPwFindFrame vPwFind;
	private VHweonDeungrokFrame vHweonDeungrok;
	private CLogin cLogin;

	
	public VLoginPanel(ActionListener action) {
		super();
		
		cLogin = new CLogin();
		this.vIdFind = new VIdFindFrame();
		this.vPwFind = new VPwFindFrame();
		this.vHweonDeungrok = new VHweonDeungrokFrame();
		
		this.setLayout(null);
		
		ImageIcon titleimg = new ImageIcon("media\\9_8.gif");
		JLabel img = new JLabel(titleimg);
		JLabel title = new JLabel("������û ���α׷�");
		
		Font font = new Font("���� ���",Font.BOLD, 30);
		img.setBounds(0,10, 400, 100);
		this.add(img);
		title.setBounds(30,120,400,50);
		title.setFont(font);
		this.add(title);
		
	
		
		JLabel id = new JLabel("���̵�");
		id.setBounds(660, 630, 80, 25);
		this.add(id);
		
		JLabel password = new JLabel("��й�ȣ");
		password.setBounds(660, 660, 80, 25);
		this.add(password);
		
		idText = new JTextField(20);
		idText.setBounds(730,630,160,25);
		this.add(idText);
		
		passwordText = new JPasswordField(20);
		passwordText.setBounds(730, 660, 160, 25);
		passwordText.setActionCommand("�α���");
		passwordText.addActionListener(action);
		this.add(passwordText);
		
		loginbt = new JButton("�α���");
		loginbt.setActionCommand("�α���");
		loginbt.addActionListener(action);
		loginbt.setBounds(900, 630, 80, 55);
		this.add(loginbt);
	
		
		JPanel btPanel = new JPanel();
		
		idFindbt = new JButton("���̵� ã��");
		this.idFindbt.setActionCommand("���̵� ã��");
		this.idFindbt.addActionListener(action);

		pwFindbt = new JButton("��й�ȣ ã��");
		pwFindbt.setActionCommand("��й�ȣ ã��");
		this.pwFindbt.addActionListener(action);
		
		hwewonbt = new JButton("ȸ�����");
		hwewonbt.setActionCommand("ȸ�����");
	
		this.hwewonbt.addActionListener(action);
		
		FlowLayout flow = new FlowLayout();
		
		btPanel.setLayout(flow);
		
		btPanel.add(idFindbt);
		btPanel.add(pwFindbt);
		btPanel.add(hwewonbt);
		
		btPanel.setBounds(630, 700, 400, 40);
		
		this.add(btPanel);
		


	}


	public OHwewon loginCheck() {
		OLogin oLogin = new OLogin();
		OHwewon oHwewon = new OHwewon();
		oLogin.setId(idText.getText());
		oLogin.setPassword(passwordText.getPassword());
		oHwewon = this.cLogin.validate(oLogin);
		
		
		if(oHwewon != null) {
			JOptionPane.showMessageDialog(null, "�α��ο� �����ϼ̽��ϴ�.");
			return oHwewon;
		}
		else {
			JOptionPane.showMessageDialog(null, "�α��ο� �����ϼ̽��ϴ�.");
			return null;
		}
	}
	
	public void createIdFind() {
		this.vIdFind.setVisible(true);
	}
	
	public void createPwFind() {
		this.vPwFind.setVisible(true);
	}
	
	public void createHwewonDeungrok() {
		this.vHweonDeungrok.setVisible(true);
	}



	public void initialize() {		
		this.vIdFind.initialize();
		this.vPwFind.initialize();
		this.vHweonDeungrok.initialize();
	}



	

		
	
	





}

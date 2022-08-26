package windowsView;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VSelectPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton sincheong;
	private JButton checkgabang;
	private JButton mysincheong;
	private JButton information;
	private JButton logout;
	public VSelectPanel(ActionListener action) {
		super();
		this.setLayout(null);
		
		Font font = new Font("���� ���",Font.BOLD, 30);
		
		ImageIcon sugangicon1 = new ImageIcon("media\\sugang1.png");
		ImageIcon sugangicon2 = new ImageIcon("media\\sugang2.png");
		ImageIcon checkgabangicon1 = new ImageIcon("media\\gabang1.png");
		ImageIcon checkgabangicon2 = new ImageIcon("media\\gabang2.png");
		ImageIcon sincheongicon1 = new ImageIcon("media\\sincheong1.png");
		ImageIcon sincheongicon2 = new ImageIcon("media\\sincheong2.png");
		ImageIcon myinfo1 = new ImageIcon("media\\info1.png");
		ImageIcon myinfo2 = new ImageIcon("media\\info2.png");
		
		this.sincheong = new JButton("���� ��û", sugangicon1);
		this.sincheong.setRolloverIcon(sugangicon2);
		this.sincheong.setActionCommand("���� ��û");
		this.sincheong.addActionListener(action);
		this.sincheong.setBounds(100,70,350,300);
		this.sincheong.setFont(font);
		
		this.checkgabang = new JButton("å����" ,checkgabangicon1);
		this.checkgabang.setRolloverIcon(checkgabangicon2);
		this.checkgabang.setActionCommand("å����");
		this.checkgabang.addActionListener(action);
		this.checkgabang.setBounds(500,70,350,300);
		this.checkgabang.setFont(font);
		
		this.mysincheong = new JButton("��û ��Ȳ", sincheongicon1);
		this.mysincheong.setRolloverIcon(sincheongicon2);
		this.mysincheong.setActionCommand("��û ��Ȳ");
		this.mysincheong.addActionListener(action);
		this.mysincheong.setBounds(100,390,350,300);
		this.mysincheong.setFont(font);
		
		this.information = new JButton("�� ����", myinfo1);
		this.information.setRolloverIcon(myinfo2);
		this.information.setActionCommand("�� ����");
		this.information.addActionListener(action);
		this.information.setBounds(500,390,350,300);
		this.information.setFont(font);
		
		this.logout = new JButton("�α׾ƿ�");
		logout.setActionCommand("�α׾ƿ�");
		logout.addActionListener(action);
		this.logout.setBounds(880,10,100,50);
		this.logout.setFont(new Font("���� ���",Font.BOLD, 15));
		
		this.add(sincheong);
		this.add(checkgabang);
	
		this.add(mysincheong);
		this.add(information);
		this.add(logout);
	}



}

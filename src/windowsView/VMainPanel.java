package windowsView;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constants.Config.FVMainPanel;
import control.CLecture;
import valueObject.OHwewon;

public class VMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private VLoginPanel vLogin;
	private VSelectPanel vSelectPanel;
	private VSugangSincheongPanel vSugangSincheongPanel;
	private VMyInformationFrame vMyInformationFrame;
	private VMiriSincheongPanel vSincheongi;
	private VMiriSincheongPanel vMiri;
	private ActionHandler action;
	private CardLayout card;

	public VMainPanel() {
		super();
		
		
		this.action = new ActionHandler();
		this.card = new CardLayout();
		
		this.setLayout(card);
		this.setBackground(FVMainPanel.background);
		
		this.vLogin = new VLoginPanel(this.action);
		this.vSelectPanel = new VSelectPanel(this.action);
		
		
		
		this.add("login",vLogin);
		this.add("select",vSelectPanel);
		card.show(this, "login");

	}
	

	private void loginShow( ) {
		card.show(this, "login");
	}
	private void selectShow( ) {
		card.show(this, "select");
	}
	private void miriShow() {
		card.show(this, "miri");
	}
	private void sincheongShow() {
		card.show(this, "sinchoeng");
	}
	private void sigangsincheongShow() {
		card.show(this, "sugangsincheong");
	}
	
	private void addPanel(OHwewon oHwewon) {
		this.vMiri = new VMiriSincheongPanel("책가방", oHwewon, this.action);
		this.vSincheongi = new VMiriSincheongPanel("신청 현황",oHwewon, this.action);
		this.vMyInformationFrame = new VMyInformationFrame(oHwewon, this.action);
		this.vSugangSincheongPanel = new VSugangSincheongPanel(oHwewon,this.action);
		
		this.vMiri.initialize();
		this.vSincheongi.initialize();
		this.vMyInformationFrame.initialize();
		this.vSugangSincheongPanel.initialize();
		
		add("miri", vMiri);
		add("sinchoeng", vSincheongi);
		add("sugangsincheong", vSugangSincheongPanel);
	}
	
	private void refreshPanel() {
		vMiri.revalidate();
		vMiri.repaint();
		 
		vSincheongi.revalidate();
		vSincheongi.repaint();
		 
		vMyInformationFrame.revalidate();
		vMyInformationFrame.repaint();
		
		vSugangSincheongPanel.revalidate();
		vSugangSincheongPanel.repaint();
	}
	
	private boolean gettime() {
		Calendar calendar = Calendar .getInstance();
		int ap = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		if(ap==1) hour+=12;
		if(hour>=9&&hour<19)
			return true;
		else
			return false;
	}


	public void initialize() {
		this.vLogin.initialize();
	}

	private class ActionHandler implements ActionListener {
		 OHwewon oHwewon = new OHwewon();
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("아이디 찾기")) {
				vLogin.createIdFind();
			} 
			else if (e.getActionCommand().equals("비밀번호 찾기")) {
				vLogin.createPwFind();
			} 
			else if (e.getActionCommand().equals("회원등록")) {
				vLogin.createHwewonDeungrok();
			} 
			else if (e.getActionCommand().equals("로그인")) {
				if(gettime()==true) {
				 oHwewon = vLogin.loginCheck();
				if(oHwewon!=null) {
					CLecture cLecture = new CLecture();
					cLecture.checkFile(oHwewon);
					addPanel(oHwewon);
					selectShow();
				}
				}else
					JOptionPane.showMessageDialog(null, "로그인 가능한 시간이 아닙니다.");
			}
			else if (e.getActionCommand().equals("책가방")) {
				miriShow();
			}
			else if (e.getActionCommand().equals("신청 현황")) {
				sincheongShow();
			}
			else if (e.getActionCommand().equals("수강 신청")) {
				sigangsincheongShow();
			}
			else if (e.getActionCommand().equals("내 정보")) {
				vMyInformationFrame.setVisible(true);
			}
			else if(e.getActionCommand().equals("뒤로가기")) {
				addPanel(oHwewon);
				refreshPanel();
				selectShow();
			}
			else if(e.getActionCommand().equals("로그아웃")) {
				int result = JOptionPane.showConfirmDialog(null,"로그아웃 하시겠습니까?","로그아웃",
						JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_NO_OPTION) {
				loginShow();
				}
			}else if(e.getActionCommand().equals("닫기")) {
				vMyInformationFrame.dispose();
				oHwewon = vMyInformationFrame.refresh();
				addPanel(oHwewon);
				refreshPanel();
			}
		}
		
		
		}
}

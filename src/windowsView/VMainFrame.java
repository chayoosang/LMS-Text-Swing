package windowsView;

import javax.swing.JFrame;

import constants.Config.FVMainFrame;

public class VMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private VMainPanel vMainPanel;
	public VMainFrame() {
		super("������û ���α׷�");
		this.setSize(FVMainFrame.size);
		this.setLocation(FVMainFrame.Location);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		vMainPanel = new VMainPanel();
		this.add(vMainPanel);
		this.setVisible(true);
	}

	public void initialize() {
		//variable attributes

		// components initialize
		this.vMainPanel.initialize();
	}

	public static void main(String[] args) {
		VMainFrame  vMainFrame = new VMainFrame();
		vMainFrame.initialize();

	}



}

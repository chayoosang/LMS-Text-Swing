package control;

import dataAccessObject.DHweonDeungrok;
import valueObject.OHwewon;

public class CHweonDeungrok {
	
	
	private DHweonDeungrok dHweonDeungrok;
	public CHweonDeungrok() {
		this.dHweonDeungrok = new DHweonDeungrok();
	}
	
	
	public void saveHwewon(OHwewon oHweown) {
		this.dHweonDeungrok.save(oHweown);
	}

	
	

}

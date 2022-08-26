package control;

import java.util.Vector;

import dataAccessObject.DHweonDeungrok;
import valueObject.OHwewon;

public class CHwewon {

	private DHweonDeungrok dHweonDeungrok;
	public CHwewon() {
		this.dHweonDeungrok = new DHweonDeungrok();
	}
		public OHwewon validate(OHwewon o) {
			if(o.getId()==null) {
			OHwewon oHwewon = this.dHweonDeungrok.findHwewon(o.getName(), o.getAddress());
			if(oHwewon != null) {
					return oHwewon;
		}
			return null;
	}	else {
			OHwewon oHwewon = this.dHweonDeungrok.findHwewon(o.getId(), o.getName());
			if(oHwewon != null) {
					return oHwewon;
		}
			return null;
		}
			
}
	public boolean change(OHwewon oHwewon){
			Vector<OHwewon> hwewons = this.dHweonDeungrok.readAll();
			for(OHwewon hwewon : hwewons) {
				if(hwewon.getId().equals(oHwewon.getId())) {
					hwewon.setPassword(oHwewon.getPassword());
					hwewon.setName(oHwewon.getName());
					hwewon.setAddress(oHwewon.getAddress());
					hwewon.setHwakgwa(oHwewon.getHwakgwa());
				}
			}			
			return this.dHweonDeungrok.changeSave(hwewons);
		}
}




package control;

import dataAccessObject.DHweonDeungrok;
import valueObject.OHwewon;
import valueObject.OLogin;

public class CLogin {
	
	
	private DHweonDeungrok dHweonDeungrok;
	public CLogin() {
		this.dHweonDeungrok = new DHweonDeungrok();
	}
	
	public OHwewon validate(OLogin oLogin) {
		OHwewon oHwewon = this.dHweonDeungrok.read(oLogin.getId());
		if(oHwewon != null) {
			if(oLogin.getPassword().equals(oHwewon.getPassword())) {
				return oHwewon;
			}
		}
		System.out.println("로그인 정보가 틀립니다.");
		return null;
	}
	
	
	public boolean check(OHwewon oHwewon) {
		if(this.dHweonDeungrok.read(oHwewon.getId())==null)
			return true;
		else
			return false;
	}

	
	

}

package textView;

import java.util.Scanner;

import control.CHweonDeungrok;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {
	private Scanner sc;
	private CLogin cLogin;
	public VLogin(Scanner sc) {
		this.sc = sc;
		this.cLogin = new CLogin();
	}

	public OHwewon login() {
		OHwewon oHwewon = new OHwewon();		
		OLogin oLogin = new OLogin();
	
		System.out.print("ID : ");
		String id =sc.next();
		oLogin.setId(id);
		
		System.out.print("PW : ");
		String password =sc.next();
		oLogin.setPassword(password);
		
		
		oHwewon = this.cLogin.validate(oLogin);
		if(oHwewon != null) {
			return oHwewon;
		}
		else {		
			return null;
		}
		
	}

}

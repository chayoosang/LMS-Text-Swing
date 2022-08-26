package valueObject;

public class OLogin {
	/**
	 * 이 클래스의 내장으로 노출되면 안됨
	 * 직접 노출 해서 하지 마라
	 * pbulic 금지
	 * 
	 */
	private String id;
	private String password;

	
	
	public OLogin() {
	}

	// setters & getters
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public void setPassword(char[] password) {
		String passwordSt="";
		for(int i =0; i<password.length; i++) {
			passwordSt+=password[i];
		}
		this.password=passwordSt;
		
	}
	
	
	// 위 값들을 가져와서 바로쓰는건 굉장히 안좋은 방법
	


}

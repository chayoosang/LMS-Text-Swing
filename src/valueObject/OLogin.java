package valueObject;

public class OLogin {
	/**
	 * �� Ŭ������ �������� ����Ǹ� �ȵ�
	 * ���� ���� �ؼ� ���� ����
	 * pbulic ����
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
	
	
	// �� ������ �����ͼ� �ٷξ��°� ������ ������ ���
	


}

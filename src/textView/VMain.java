package textView;

import java.util.Scanner;

public class VMain {
	
	private Scanner sc;
	private VInitial initial;
	
	public VMain(Scanner sc) {
		this.sc = sc;
		this.initial = new VInitial(sc);
		
	}
	public void run() {
		System.out.println("========���� ��û ���α׷� ����========");
		this.initial.show();
	}
     //static => new�� �Ƚᵵ �޸𸮰� �Ҵ��̵ȴ�.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VMain main = new VMain(sc);
		main.run();
		sc.close();
	}

}

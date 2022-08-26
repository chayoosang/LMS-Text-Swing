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
		System.out.println("========수강 신청 프로그램 실행========");
		this.initial.show();
	}
     //static => new를 안써도 메모리가 할당이된다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VMain main = new VMain(sc);
		main.run();
		sc.close();
	}

}

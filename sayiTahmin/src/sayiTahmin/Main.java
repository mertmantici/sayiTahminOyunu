package sayiTahmin;
import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	static int sayac=0;
	static Boolean dongu=true;
	
	public static void main(String[] args) {
		int[] sayilar=new int[100];
		for(int i=1;i<=100;i++) {
			sayilar[i-1]=i;
		}
		/*for(int i=0;i<100;i++) {
		System.out.println(sayilar[i]);}*/

		
		Timer timer=new Timer();
		TimerTask gorev=new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Kalan süre "+(20-sayac)+" saniye");
				sayac++;
				if(sayac==20) {
					timer.cancel();
					System.out.println("Süreniz doldu.");
					dongu=false;
				}
				
			}
		};
		timer.schedule(gorev, 0,1000);
		
		Random r=new Random();
		int random=r.nextInt(101);
		Scanner input=new Scanner(System.in);
		int tahmin;
		
		System.out.println("Bir sayı tahmin ediniz");
		tahmin=input.nextInt();
		
		
		while(dongu) {
		if(tahmin==random) {
			System.out.println("Tahmininiz doğru sayı = "+tahmin);
			timer.cancel();
			dongu=false;
			
		}else if(tahmin<random) {
			System.out.println("Lütfen DAHA BÜYÜK bir sayı giriniz.");
			tahmin=input.nextInt();
		}else {
			System.out.println("Lütfen DAHA KÜÇÜK bir sayı giriniz.");
			tahmin=input.nextInt();
		}
		}
	}

}

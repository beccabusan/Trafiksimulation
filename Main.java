import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String [] args){
	Scanner A = new Scanner(System.in);
	System.out.println("Ankomstintensitet: ");
	Double ankomst = A.nextDouble();
	Scanner P = new Scanner(System.in);
	System.out.println("Period: ");
	int period = P.nextInt();
	Scanner G1 = new Scanner(System.in);
	System.out.println("Grönperiod rakt fram: ");
	int green1 = G1.nextInt();	
	Scanner G2 = new Scanner(System.in);
	System.out.println("Grönperiod sväng: ");
	int green2 = G2.nextInt();
	Scanner V = new Scanner(System.in);
	System.out.println("Väglängd: ");
	int r0_ = V.nextInt();
	Scanner T = new Scanner(System.in);
	System.out.println("Svängfilens längd: ");
	int r1_r2 = T.nextInt();
	Lane r0 = new Lane(r0_);
	Lane r1 = new Lane(r1_r2);
	Light s1 = new Light(period, green1);
	Light s2 = new Light(period, green2);

	TrafficSystem newsystem = new TrafficSystem(r0, r1, s1, s2, ankomst);
	System.out.println(newsystem.toString());
    }
    


}

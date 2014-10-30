import java.util.Scanner;

public class TrafficSystem {
    // Definierar de vägar och signaler som ingår i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver beståndsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;
    private double A;
    private int P;

    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling  
    
    private int time = 0;

    public TrafficSystem(Lane r0, Lane r1, Light s1, Light s2, Double A) {
	this.r0 = r0;
	this.r1 = r1;
	this.r2 = r1;
	this.s1 = s1;
	this.s2 = s2;
	this.A = A;


    }

    /* public TrafficSystem readParameters(){
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
	return newsystem;
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta. 
	}*/

    public void step() {
	s1.step();
	s2.step();

	if (s1.isGreen()){
	    r1.getFirst(); 
	    r1.step(); 
	}
	else{
	    r1.step();
	}
	if (s2.isGreen()){
	    r2.getFirst(); 
	    r2.step(); 
	}
	else{
	    r2.step();
	}

	if (r0.firstCar().getdest() == 0){
	    if (r1.lastFree()){
		r1.putLast(r0.firstCar());
		r0.step();
	    }
	    else {
		r0.step();

	    }
	}
	else if (r0.firstCar().getdest() == 1){
	    if (r2.lastFree()){
		r2.putLast(r0.firstCar());
		r0.step();
	    }
	    else {
		r0.step();

	    }
	}
	else { System.out.println("incorrect destination");
	}
	this.time = (this.time +1);
	
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
    }
    
    public String toString(){
	return "TrafficSystem(" + this.r0 + ", " + this.r1 + ", " + this.s1 + ", " + this.s2 + ", " + "Bilar/sekund: " + this.A + ", " + "Period: " + this.P +  ")";

    }

    public void printStatistics() {
	// Skriv statistiken samlad så här långt
    }

    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }

}

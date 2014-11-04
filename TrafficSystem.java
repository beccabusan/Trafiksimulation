import java.util.Scanner;
import java.util.Random;
import java.lang.*;


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

    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling  
    
    private int time = 0;

    public TrafficSystem(Lane r0, Lane r1, Lane r2, Light s1, Light s2, Double A) {
	this.r0 = r0;
	this.r1 = r1;
	this.r2 = r2;
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

    public int getTime(){
	return this.time;
    }

    double a = 0;
    int numberOfCars = 0; 
    int numberOfTurners = 0;
    int numberOfStraight = 0;
    int timeToGoS;
    int timeToGoT;
    int timeMaxS;
    int timeMaxT;
    int full;
    public void step() {
	this.time = (this.time +1);
	s1.step();
	s2.step();

	if (s1.isGreen()){
	    Car b = r1.getFirst(); 
	    r1.step(); 
	    if (b != null){
		numberOfStraight++;
		timeToGoS += (this.time - b.getbornTime());
		if (timeMaxS < (this.time - (b.getbornTime()))){
		    timeMaxS = (this.time - (b.getbornTime()));
		    }
		    
	    }
	}
	else{
	    r1.step();
	}
	if (s2.isGreen()){
	    Car b = r2.getFirst(); 
	    r2.step();
	    if ( b != null){
		numberOfTurners++;
		timeToGoS += (this.time - b.getbornTime());
		if (timeMaxT < (this.time - (b.getbornTime()))){
		    timeMaxT = (this.time - (b.getbornTime()));
		    }
		
	    }
	}
	else{
	    r2.step();
	}

	if (r0.firstCar() != null && r0.firstCar().getdest() == 1){
	    if (r1.lastFree()){
		r1.putLast(r0.getFirst());
		r0.step();  
	   
		if (a >= 1 && r0.lastFree()){
		    Random ran = new Random();
  		    r0.putLast(new Car(this.time, ran.nextInt(2) +1));
		    a = a-1;
		    numberOfCars++;
		}
		    else {a = a + this.A;}
		}
	    else if (!r0.lastFree()) {
		int i = 0;
		int n = r0.getLength();
		while(i < n){
		    if (r0.getCar(i) != null){
			i++;
		    }
		
		    else if(r0.getCar(i) == null && i != (n-1)){
			i++;
		    }	
		    else{
			a = a-1;
			full++;
		    }
		}	    
	    }
	}

	else if (r0.firstCar() != null && r0.firstCar().getdest() == 2){
	    if (r2.lastFree()){
		r2.putLast(r0.getFirst());
		r0.step();
		if (a >= 1 && r0.lastFree()){
		    Random ran = new Random();
		    r0.putLast( new Car(this.time, ran.nextInt(2) +1));
		    a = a-1;
		    numberOfCars++;
		}
		else {a = a + this.A;}
	    }
	    else if (!r0.lastFree()) {
		int i = 0;
		int n = r0.getLength();
		while(i < n){
		    if (r0.getCar(i) != null){
			i++;
		    }
		
		    else if(r0.getCar(i) == null && i != (n -1)){
			i++;
		    }
		    else{
			a = a-1;
			full++;

		    }
		}
	    }

	}
	else {
	    r0.step();
	    if(r0.lastFree()){		
		if (a >= 1){
		    Random ran = new Random();
		    r0.putLast(new Car(this.time, ran.nextInt(2) +1));
		    a = a-1;
		    numberOfCars++;
		}
		else {a = a + this.A;}
	    }
	    else if (!r0.lastFree()) {
		int i = 0;
		int n = r0.getLength();
		while(i < n){ 
		    if (r0.getCar(i) != null){
			i++;
		    }
		
		    else if(r0.getCar(i) == null && i != (n -1)){
			i++;
		    }
		    else{
			a = a-1;
			full++;

		    }
		}
		    
        
	    }

		
	}
	    
    }
	

	
    // Stega systemet ett tidssteg m h a komponenternas step-metoder
    // Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
    
    
    public String toString(){
	return "TrafficSystem(Lane0: "   + this.r0 + ", Lane1: " + this.r1 + ", Lane2: " + this.r2 + "," + this.s1 + ", " + this.s2 + ", " + "Bilar/sekund: " + this.A +  ")";

    }

    public void printStatistics() {
	int total = numberOfTurners + numberOfStraight;
	int timeMax = Math.max(timeMaxS, timeMaxT);

	System.out.println("Maximum time:" + timeMax);
	System.out.println("Number of Cars passing through:" + total);
	System.out.println("Number of times the lanes where full:" + full);
	System.out.println("Cars total inside system:"+ numberOfCars);
	if (total != 0){
       	int avarage = (timeToGoS + timeToGoT) / (total);
       	System.out.println("Avarage time:" + avarage);
	}
	else{System.out.println("No avarage time could be calculated because no car got through");}
	// Skriv statistiken samlad så här långt
    }

    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }

}
/*
 *Totala antalet bilar som åker igenom   x 
 *antalet bilar som kommer in i systemet  x
 *antalet som svänger  x
 *antalet som kör rakt fram x
*tiden det tar för en bil att åka igenom genomsnitt  (tiden för alla bilar/tot bilar)
*maximala tiden för en bil att åka igenom
* tiden för att svänga
*tiden för att köra rakt fram
* antalet gånger det blir fullt

*/

/*
2014-11-04
Lyckas inte beräkna antalet gånger det blir fullt. Går alltså inte genom looparna där
variabeln full ökar.

*/

public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }

    private Car[] theLane;

    public Lane(int n) {
	Car theLane[] = new Car [n]; //Array av längden n
	this.theLane = theLane;
	// Konstruerar ett Lane-objekt med plats för n fordon
    }
    




    public void step(){
	int full = 0;
	int j = 0;
	int n = this.theLane.length; 
	while(this.theLane[j] != null){
	    j++;
	}
	if (j == n-1){
	    full++;
	}
	else if (this.theLane[j] == null){
		for (int i = j; i<n; i++){
		    if(i == n-1){
			this.theLane[i] = null;
		    }
		    else{
			this.theLane[i] = this.getCar(i+1);
		    }
		} 
	    }


	// Stega fram alla fordon (utom det på plats 0) ett steg 
	// (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    }

    public Car getFirst() {
	Car a = this.theLane[0];
	this.theLane[0] = null;
	return a;
	// Returnera och tag bort bilen som står först
    }

    public Car firstCar() {
	return this.theLane[0];
	// Returnera bilen som står först utan att ta bort den
    }
    
    public Car getCar(int n){
	return this.theLane[n];
    }

    public boolean lastFree() {
	int n = (this.theLane.length - 1);
	if (this.theLane[n] == null){
	    return true;
	}
	return false;
	// Returnera true om sista platsen ledig, annars false
    }

	public void putLast(Car c) throws OverflowException {
	    int n = this.theLane.length;
	    if (this.theLane[(n-1)] == null){
		this.theLane[(n-1)] = c;
	    }
	    // Ställ en bil på sista platsen på vägen
	    // (om det går).
	}
    
	public Car[] getLane(){
	    return this.theLane;
	}

    public String toString() {
	String result = "[";
	int n = this.getLane().length;
	System.out.println(n);
	for (int i = 0; i<n; i++){
	    if (this.getCar(i) != null){
		result += this.getCar(i);
		if (i == n-1){
		    result = result;		    	     
		}
		else if  (this.getCar(i+1) != null){
		    result += ", ";
		}
	    }

	}
	return "Lane(" + result + "]" + ")";
    }       
	
		    
   
}


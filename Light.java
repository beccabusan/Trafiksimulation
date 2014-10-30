public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    public Light(int period, int green) {
	this.period = period;
	this.green  = green;
	this.time = 0;

    }

    public int getPeriod(){
	return this.period;

    }
    
    public int getTime(){
	return this.time;
    }
    
    public int getGreen(){
	return this.green;
    }
    public void step() {
	int a = this.getTime();
	this.time = (a + 1);
    }

    public boolean isGreen()  {
	if (this.getTime() < this.getGreen()){
		return true;
	    }
	return false;
	// Returnerar true om time<green, annars false
    }
   
    public String  toString()  {
	return "Light(period = " + this.getPeriod() + "," +  " green = " + this.getGreen() + ")";

}
	
}

public class Car {

    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng

    public Car(int bornTime, int dest){
	this.bornTime = bornTime;
	this.dest = dest;
	
    }

    public int getbornTime(){
	return this.bornTime;
    }
    public int getdest(){
	return this.dest;
    }

    // konstruktor och get-metoder
   

    /* public String toString() {
       string result = "";
       result += this.getbornTime.toString();
       result += ","
       result += this.getdest.toString();
       return result;

       }
    */

    public String toString(){
	return "Car(bornTime = " + this.getbornTime() +", dest = " + this.getdest() + ")";
    }
}

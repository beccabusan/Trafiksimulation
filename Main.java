public class Main{
    public static void main(String [] args){
	Car a = new Car(5,0);
	System.out.println(a.toString());
	Light b = new Light(10,3);
	System.out.println(b.toString());
	if (b.isGreen()){
	    System.out.println("green!");
	}
	else if (!b.isGreen()){
	    System.out.println("red!");
}
	b.step();
	b.step();
	b.step();
	b.step();

	if (b.isGreen()){
	    System.out.println("green!");
	}
	else if (!b.isGreen()){
	    System.out.println("red!");
}	
	System.out.println(b.toString());
    }



}

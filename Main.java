import java.util.Arrays;

public class Main{
    public static void main(String [] args){
	Car a = new Car(5,0);
	Car d = new Car(0,1);
	Car e = new Car(2,0);
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
	Lane c = new Lane(5);
	c.putLast(a);
	c.step();
	c.putLast(d);
	c.step();
	c.putLast(e);
	System.out.println(" " + c.getLane().length);
	System.out.println(c.toString());
	System.out.println("" + c.getCar(4));
        System.out.println("" + c.getCar(3));
	System.out.println("" + c.getCar(2));
    }
    


}

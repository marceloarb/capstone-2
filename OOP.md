Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation
Encapsulation is the mechanism that binds together code and the data it manipulates.Technically in encapsulation, the variables are hidden from other classes, which is achieved by making the members or methods of a class as private.
We can use setter and getter methods to use the data.


public class Encapsulate 
{ 
    These can only be accessed by public methods of class:
    private String name; 
    private int age; 
  
    getters:
    public int getAge()  
    { 
      return age; 
    } 
    public String getName()  
    { 
      return name; 
    } 
   
    setters:
    public void setAge( int newAge) 
    { 
      age = newAge; 
    } 
    public void setName(String newName) 
    { 
      name = newName; 
    } 
} 
Citations:

1.https://www.javatpoint.com/encapsulation#:~:text=%E2%86%92%20%E2%86%90%20prev-,Encapsulation%20in%20Java,is%20mixed%20of%20several%20medicines.&text=Now%20we%20can%20use%20setter,of%20a%20fully%20encapsulated%20class.
2.https://www.geeksforgeeks.org/encapsulation-in-java/



********************
2. Inheritance
Inheritance is the mechanism that allow one class inherit from another class. 
Super class is the parent class it inherits all features.
Sub class is the child that inherits from the parent, it can add its own fields and methods and still have the super class fields.

class Parent

    private String name;
    private int age;

    public Parent(String name,int age){
        this.name = name;
        this.age = age;
    }
     getters:
    public int getAge()  
    { 
      return age; 
    } 
    public String getName()  
    { 
      return name; 
    } 
   
    setters:
    public void setAge( int newAge) 
    { 
      age = newAge; 
    } 
    public void setName(String newName) 
    { 
      name = newName; 
    } 

}

class Child extends Parent{
    
    private String car;

    public Child(String car,String name,int age){
        super(name,age);
        this.car = car;
    }
     getters:
    public int getCar()  
    { 
      return car; 
    } 
   
    setters:
    public void setCar( int newCar) 
    { 
      car = newCar; 
    } 
    

}
Citations:
1.https://www.geeksforgeeks.org/inheritance-in-java/





********************
1. Abstraction
Abstraction is defined as the process of hiding certain details and showing only the essential information. Ex: People view a car as a car rather than its individual components.
In java abstraction can be achieved as ABSTRACT CLASSES or INTERFACES.

I am using this class in my game:

public abstract class GameCharacter {
	protected int WIDTH = 28;
	protected int HEIGHT = 28;
	
	protected boolean canMove(int nextX, int nextY) {
        Rectangle nextPosition = new Rectangle(nextX, nextY, WIDTH, HEIGHT);
        return Board.getInstance().isOpen(nextPosition);
    }
}
public class Player extends GameCharacter {

    private static final long serialVersionUID = 1L;
    private final int resetX;
    private final int resetY;
    private final Board board = Board.getInstance();
    public boolean right, left, up, down;
    private int speed = 6;
    private Rectangle rectangle;

    public Player(int x, int y) {
        this.rectangle = new Rectangle(x, y, WIDTH, HEIGHT);
        resetX = x;
        resetY = y;
        reset();
    }

    public void tick() {
    }


    public void render(Graphics g) {
        g.drawImage(Texture.player[0], (int)rectangle.getX(), (int)rectangle.getY(), WIDTH, HEIGHT, null);
    }

    public void reset() {
//        setBounds(resetX, resetY, WIDTH, HEIGHT);
    }

    public boolean intersects(Rectangle gameObject) {
        return rectangle.intersects(gameObject);
    }

    public Point getLocation() {
        return rectangle.getLocation();
    }

	public void moveRight() {
		if (canMove((int)rectangle.getX() + speed,(int) rectangle.getY())) {
			rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
		}
	}
 

	public void moveLeft() {
		if (canMove((int)rectangle.getX() - speed,(int) rectangle.getY())) {
			rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
		}
		
	}

	public void moveUp() {
		if (canMove((int)rectangle.getX(),(int) rectangle.getY() - speed)) {
			rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()- speed); 
		}
		
	}

	public void moveDown() {
		if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
			rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY() + speed); 
		}
		
	}
}
    


Citations:
1.https://www.w3schools.com/java/java_abstract.asp
2.https://www.geeksforgeeks.org/abstraction-in-java-2/



********************
1. Polymorphism
Polymorphism means having many forms. In other words, polymorphism allow a subclass to define their own unique behaviors.
Overloading is also a polymorphism technic used,where there are multiple functions using the same name, but different parameters.
 
Some Override and overloading:

public class DeluxeBurger extends Burger{
	private double deluxePrice = 7.99;

	public DeluxeBurger(String name, String breadType, String meat) {
		super("Deluxe", breadType, meat);
		
	}
	@Override
	public double hamburguerPrice(double One,String top1) {
		this.deluxePrice = this.deluxePrice+One;
		System.out.println("Hamburguer price: $" + this.deluxePrice);
		return this.deluxePrice;
		
	}
	@Override
	public double hamburguerPrice(double One,double Two,String top1,String top2) {
		this.deluxePrice = this.deluxePrice+One+Two;
		System.out.println("Hamburguer price: $" + this.deluxePrice);
		return this.deluxePrice;
		
	}
	@Override
	public double hamburguerPrice(double One,double Two,double Three,String top1,String top2,String top3) {
		this.deluxePrice = this.deluxePrice+One+Two+Three;
		System.out.println("Hamburguer price: $" + this.deluxePrice);
		return this.deluxePrice;
		
	}
	@Override
	public double hamburguerPrice(double One,double Two,double Three,double Four,String top1,String top2,String top3,String top4) {
		this.deluxePrice = this.deluxePrice+One+Two+Three+Four;
		System.out.println("Hamburguer price: $" + this.deluxePrice);
		return this.deluxePrice;
		
	}
	@Override
	public double hamburguerPrice(double One,double Two,double Three,double Four,double Five,String top1,String top2,String top3,String top4,String top5) {
		this.deluxePrice = this.deluxePrice+One+Two+Three+Four+Five;
		System.out.println("Hamburguer price: $" + this.deluxePrice);
		return this.deluxePrice;
		
	}
	@Override
	public double hamburguerPrice(double One,double Two,double Three,double Four,double Five,double Six,String top1,String top2,String top3,String top4,String top5,String top6) {
		this.deluxePrice = this.deluxePrice+One+Two+Three+Four+Five+Six;
		System.out.println("Hamburguer price: $" + this.deluxePrice);
		return this.deluxePrice;
		
	}
	public double hamburguerPrice(double One,double Two,double Three,double Four,double Five,double Six,double Seven,String top1,String top2,String top3,String top4,String top5,String top6,String top7) {
		if(getName().contains("Deluxe")) {
			System.out.println("You can only have 6 toppings for a Deluxe hamburguer");
		}
		
		this.deluxePrice = this.deluxePrice+One+Two+Three+Four+Five+Six;
		System.out.println("Hamburguer price: $" + this.deluxePrice);
		return this.deluxePrice;
		
	}
}







Please write a 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  




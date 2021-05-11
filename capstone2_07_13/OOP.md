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

Citations:
1.https://www.w3schools.com/java/java_polymorphism.asp
2.https://www.geeksforgeeks.org/polymorphism-in-java/
3.https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html

OOD Patterns:
Singleton:
The Singleton Pattern has a private constructor and defines a getInstance operation which exposes the unique instance which is accessed by the clients.
Ex:
public class Board {

    private volatile static Board board;
    private final ArrayList<Block> walls = new ArrayList<>();
    private final ArrayList<Point> coinsLocations = new ArrayList<>();
    private final ArrayList<Point> ghostsLocations = new ArrayList<>();
    private int width;
    private int height;
    private Point playerLocation;
    private Board() {
        try {
            BufferedImage map = ImageIO.read(getClass().getResource("/Image/maze.png"));
            this.width = map.getWidth();
            this.height = map.getHeight();
            int[] pixels = new int[width * height];
            map.getRGB(0, 0, width, height, pixels, 0, width);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int val = pixels[x + (y * width)];
                    if (val == 0xFF000000) {
                        this.walls.add(new Block(new Point(x * 32, y * 32)));
                    } else if (val == 0xff4800ff) {
                        playerLocation = new Point(x * 32, y * 32);
                    } else if (val == 0xFFFF0000) {
                        ghostsLocations.add(new Point(x * 32, y * 32));
                    } else {
                        coinsLocations.add(new Point(x * 32, y * 32));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    public Point getLocationPlayer() {
        return playerLocation;
    }

    public ArrayList<Point> getLocationGhosts() {

        return ghostsLocations;
    }

    public ArrayList<Point> getLocationCoins() {
        return coinsLocations;
    }

    public ArrayList<Block> getWalls() {
        return walls;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public boolean isOpen(Rectangle nextPosition) {
        for (Block wall : walls) {
            if (nextPosition.intersects(wall)) {
                return false;
            }
        }
        return true;
    }
}
Decorator:

Decorators provide a flexible alternative to subclassing for extending functionality.

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


public class Ghost extends GameCharacter {

    private static final long serialVersionUID = 1L;
    private static final int random = 0;
    private static final int findPath = 2;
    private static final int right = 0;
    private static final int left = 1;
    private static final int up = 2;
    private static final int down = 3;
    private static final int targetTime = 40 * 4;
    private static final int speed = 3;
    private static final Random randomGen = new Random();
    private final Board board = Board.getInstance();
    private int state = random;
    private int direction;
    private int time = 0;
    private int lastDirection = -1;
    private Point playerLocation;
    private Rectangle rectangle;
    

    public Ghost(Point ghostLocation, Point playerLocation) {
        this.playerLocation = playerLocation;
        this.rectangle = new Rectangle(ghostLocation.x, ghostLocation.y, WIDTH, HEIGHT);
        direction = randomGen.nextInt(4);
    }

    public void tick() {
        int smart = 1;
        if (state == random) {
            if (direction == right) {
                if (canMove((int)rectangle.getX() + speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == left) {
            	if (canMove((int)rectangle.getX() - speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == up) {
            	if (canMove((int)rectangle.getX(), (int)rectangle.getY() - speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()- speed); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            } else if (direction == down) {
            	if (canMove((int)rectangle.getX(), (int)rectangle.getY() + speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+ speed); 
                } else {
                    direction = randomGen.nextInt(4);
                }
            }

            time++;
            if (time == targetTime) {
                state = smart;
                time = 0;
            }

        } else if (state == smart) {
            boolean move = false;
            if (rectangle.getX() < playerLocation.getX()) {
                if (canMove((int)rectangle.getX() + speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                    move = true;
                    lastDirection = right;
                }
            }
            if (rectangle.getX() > playerLocation.getX()) {
                if (canMove((int)rectangle.getX() - speed, (int)rectangle.getY())) {
                	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                    move = true;
                    lastDirection = left;
                }
            }
            if (rectangle.getY() < playerLocation.getY()) {
                if (canMove((int)rectangle.getX() , (int)rectangle.getY() + speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    move = true;
                    lastDirection = down;
                }
            }
            if (rectangle.getY() > playerLocation.getY()) {
                if (canMove((int)rectangle.getX() , (int)rectangle.getY() - speed)) {
                	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()-speed); 
                    move = true;
                    lastDirection = up;
                }
            }
            if (!move) {
                state = findPath;
            }
            time++;
            if (time == targetTime) {
                state = random;
                time = 0;
            } else if (state == findPath) {
                if (lastDirection == right) {
                    if (rectangle.getY() < playerLocation.getY()) {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() + speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() - speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()-speed); 
                            state = smart;
                        }
                    }
                    if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
               		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    }

                } else if (lastDirection == left) {
                	if (rectangle.getY() > playerLocation.getY()) {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() - speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX(), (int)rectangle.getY() + speed)) {
                        	rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()-speed); 
                            state = smart;
                        }
                    }
                	if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
               		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    }

                } else if (lastDirection == up) {
                	if (rectangle.getX() > playerLocation.getX()) {
                        if (canMove((int)rectangle.getX()- speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX()+ speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                            state = smart;
                        }
                    }
                	if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
               		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                    }

                } else if (lastDirection == down) {
                	if (rectangle.getX() < playerLocation.getX()) {
                        if (canMove((int)rectangle.getX()+ speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()-speed, (int)rectangle.getY()); 
                            state = smart;
                        }

                    } else {
                        if (canMove((int)rectangle.getX()- speed, (int)rectangle.getY() )) {
                        	rectangle.setLocation((int)rectangle.getX()+speed, (int)rectangle.getY()); 
                            state = smart;
                        }
                    }
                	 if (canMove((int)rectangle.getX(),(int) rectangle.getY() + speed)) {
                		 rectangle.setLocation((int)rectangle.getX(), (int)rectangle.getY()+speed); 
                     }

            }

            time++;
            

            }
        }

    }




Please write a 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  




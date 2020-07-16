<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
*Create a cmd game and implement frontend later(in case I do not have time to finish the frontend, I will have the cmd game, which is the requirement).
*Choose a game.
*Research the game.
*How to create a command line game.
*Pacman movements.
*Pacman keep score and delete coin.
*Render image.
*Random movements for the ghost with some AI to follow Pacman.
*Implement collision.
<h2>
    2. Planning the Solution
</h2>
*Choose the game to be developed.
*Research game and code.
*Study researched code and get a better understand.
*research libraries(Runnable,KeyListener,MouseListener,etc).
*Build UML Class Diagram (UML is an app where you can create your class diagram, so you can have a better understand on how you classes should look like when building the game. I saved an image of my diagram in the folder called Uper_images.).
*Build a schedule on Trello (Trello is an app where you can add how many boards you want, tasks and set a date for each assignment.I saved an image of my shedule in the folder called Uper_images.).
*Make a variable to keep the score everytime a coin is removed.To remove a coin we need to know pacman next movement and check if it is a coin.
*
<h2>
    3. Executing the Plan
</h2>
*After creating my schedule on trello,I started coding following my UML diagram.
*I had to make all the images for my game.
*Created a controller to handle all the functionallity.
*Followed the requiremets impleting OOP,lambda,abrastact,etc.
*Singleton OOD pattern used to instantiate board class just one time.
*3rd party Java library implemented.
<h2>
    4. Reflection / Refactor
</h2>
*Finish replacing inherited getLocation() method by calling Rectangle member of player.
*Replaced inherited getLocation() method by calling Rectangle member of player.
*Took inicial step of adding player location as a component rather than an inheritance state.
*Replaced Player's direct use of Controller.walls with call to Controller.isOpen() to improve cohesion of the player class.
*Moved the checked for a coin collision from the player to the controller. 
*Encapsulated player location as a Point passed during Ghost construction, removing tight coupling  of ghost to controller.
*The class diagram had to be refactor during development.
*Moved responsability for initial Player location clearly from controller to board.
*Walls are showing up and singleton were implemented to one board class.
*Resize image to fit board.
*
*
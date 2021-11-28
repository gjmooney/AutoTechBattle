# ser316-assignment5

# Screencast
https://youtu.be/s4S7KC4ZyJE

# Design Patterns
I used the Startegy pattern to implement the attacks of the start-ups. 
I used the State pattern to implement the odd/even quarters. 
Within the odd quarters I used the strategy pattern to implement the possible choices the player has.
I used the decorator pattern to implent evolutions of the start-ups. Each time an evolution happens a start-up gains stat bonus's and a new attack. 
I used the Singleton pattern to implement the GameLogic class.

# Program Details
The program is designed as a single player game where the player controls a tech giant that owns start-ups.  
Each odd quarter the player can choose to raise the market share of their start-ups or choose to catch a wild start up and add to their portfolio.  
If the player choose to catch a new start-up then in the following even quarter they will battle a wild start-up. If they chose to raise their market share, then in the following even quarter they will do battle with another tech giant.  
If the player wins the battle they will have the option of acquiring the defeated start-up.  
When a tech giant has no more start-ups they are removed from the game.  
In consideration of the graders time I made it so the program will automatically choose an option whenever a choice arises.  
The choices the program makes are randomly generated and will differ from run to run.  
I also raised the attack stat and lowered the max health in order for the battles to finish quickly. I also set some starts up to evolve upon winning the next battle so those events could be viewed in the output.  

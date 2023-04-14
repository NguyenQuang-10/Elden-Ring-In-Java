# Design Rationale

## Requirement 01: Environment and Enemies

### Environments
+ Because all three environments described in the specification have similar functionalities, every environment 
is extended from a "Environment" abstract parent class. Each environment is depended on the enemy type that it will
spawn.
+ The description of these environment best suit Ground, so "Environment" class will extend the "Ground" class 
given by the game engine
+ Environment is associated with a "SpawnBehaviour", which will decide whether the Environment should spawn the enemy 
associated with the environment
+ The SpawnBehaviour getAction() will return null if it isn't suitable to spawn an enemy, else it should return
a SpawnEnemyAction instance. Therefore, SpawnBehaviour will be depended on SpawnEnemyAction
+ SpawnEnemyAction extends from Action, it needs to know what kind of enemy to spawn therefore it is depended on the
Enemy class


### Trader
+ Trader is extended from Actor
+ Trader is associated with a Player
+ Trader has BuyBehaviour and SellBehaviour that implements Behaviour
+ When a Player interacts with the Trader, depending on whether the Player choose to buy or sell, the respective 
Behaviour will evaluate the trade
+ The behaviours' getAction will return their respective BuyAction or SellAction (extended from Action) if condition for 
a trade is met or null if not.
+ When BuyAction or SellAction is executed, they will make the modification to the Player's rune and inventory

## Requirement 04: Combat Archetypes
+ This diagram represents the implementation of the combat archetypes, a class of character roles that can be selected by the user.
+ These archetypes determine the starting hitpoint of the use and the starting weapons of the user. So user input would be required to set the user’s archetype. Hence, we have a class called ArchetypeManager that directly implements the process of asking for the user to select a number corresponding to the archetype, and from there directly sets the player's HP and weapon.
+ From there, the Application class can call on the ArchetypeManager to run and set up the Player instead of initialising the Player in the Application class. This follows the Single Responsibility Principle (SRP) whereby the Application class should focus on running the main code for the world, instead of also having to determine the Player’s archetype.
+ The user will be directly extended from the abstract class Actor (from the engine) as it has the similar features and attributes. This will reduce repetition of re-coding the attributes and methods (DRY).
+ The special skills, i.e. QuickStepAction and Unseathe Action,  which are associated with the weapons of the unique combat archetype, will be extended from Action (DRY). These skills will be accessible to the player via the getSkill() implementation within the weapon.
+ The unique weapon associated with each archetypy, i.e. Uchigatana, GreatKnife and Club, will be extended from the abstract Weapon class (DRY), and the special skill associated with these weapons will be implemented.

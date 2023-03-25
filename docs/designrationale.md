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


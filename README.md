# CS319 Spring 2020 Team 1J-TM 
## GROUP MEMBERS: </br>
1. Zeynep Korkunç, 21702571 </br>
2. Olcay Akman, 21702671 </br> 
3. İrem Seven, 21704269 </br>
4. Münevver Uslukılıç, 21602297  </br>
5. Hüseyin Ata Atasoy, 21702532 </br>
6. Can Mergenci, 21201252 </br>
### REPORTS: </br>
[Analysis Report 1st Iteration](https://docs.google.com/document/d/1pxnmEeJ-7SEgrIv9lMExya_Q0RhlCyWmTGyMsa1_hXc/edit?usp=sharing) </br>
[Design Report 1st Iteration](https://docs.google.com/document/d/1ZGXjXcl8CHVUXy_usIwl3_Qo4QjSRXGlqPNCUKrD1ao/edit?usp=sharing)</br>
[Analysis Report 2nd Iteration](https://docs.google.com/document/d/1hcgCMdkPRMcH-fD7-z9R7se89xK-yTWmeRqGaeXYW3U/edit?usp=sharing)</br>
[Design Report 2nd Iteration](https://docs.google.com/document/d/1YHCUOBTVpKgUYpDH7GwglOttWS45_VeIKK6YyrENRck/edit?usp=sharing)<br/>
[Final Report 2nd Iteration](https://docs.google.com/document/d/1YHCUOBTVpKgUYpDH7GwglOttWS45_VeIKK6YyrENRck/edit?usp=sharing)<hr/>


### DESCRIPTION OF THE PROJECT: </br>
The goal of this project is to create a digital version of the Terra Mystica boardgame, while practicing the principles of Object Oriented Programming. The project will be implemented in Java by using the JavaFX Library.

### DESCRIPTION OF THE GAME: </br>
In Terra Mystica, each player takes control of one of the 14 unique factions, trying to develop their faction better than their opponents. Each faction has a specific type of terrain, which are named the Plains, the Swamp, the Lakes, the Forest, the Mountains, the Wasteland or the Desert. Each player can control build structures on its Home terrain. Every player tries to improve his faction as much as possible and in the end, player with the most victory points win.

### GAMEPLAY: </br>
Terra Mystica takes place over 6 rounds, each consisting of 3 phases.</br> 
**Each round begins with Phase 1: "The Income Phase"**. In each income phase, a player can collect new Workers, Coins, Priests and Power based on their Faction board and Bonus card or Favor tiles. </br>
**The round continues with Phase 2: "The Action Phase"**, where players each do one action each from the available 8 choices, which consist of building dwellings on unoccupied terrain, facilitate building, upgrade structures, cult scoring, power actions, special actions, passing and starting player. The Action Phase continues until every single players refuses to make any move. </br>
**Then, the round ends with Phase 3: "Cult Bonuses and Clean-Up Phase"**, where each player earns the Cult bonuses. Then the round ends. 

### FINAL UPDATE </br>
The game remains unfinished, due to the limited amount of time we had as a group. Current demo supports Creating a game and executing "Terraform and Build" action for each player. The GUI needs a rework and re-design since there weren't enough time to work on the CSS and do design graphics. 

### To run
Clone the repo. </br>
```bash
$ cd tmDesktop 
$ gradle build
$ gradle run
```
_________________________________________________________________________________________________

### Extra feature(s) for the game: (Not implemented)</br>

**1- Victory map expansion.** Each player will earn certain amount of income bonuses, when the player will reach to certain amount of victory points. 

**2- When a player's terrain is surrounded by three adjacent territories of another player, the building on that terrain will be decreased by one level** and if it is a simple dwelling, it will be destroyed. The attacker earns the loss of the victim. This adds another aspect to the competitive side of the game among players.

### REFERENCES: </br>
Link for the manual of the game: http://www.feuerland-spiele.de/dateien/Terra_Mystica_EN_1.0_.pdf

package GameLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GameHandler {

	private Game game;
	private int numberOfPlayers;
	private ArrayList<Player> players;
	private ActionHandler actionHandler = ActionHandler.getInstance();
	private Queue<Player> turnQueue;
	private Random random; // Used to generate random numbers when needed.
	private static GameHandler instance = new GameHandler();

	private GameHandler() {
		players = new ArrayList<>();
		game = Game.getInstance();
		turnQueue = new LinkedList<>();
		random = new Random();
	}

	public static GameHandler getInstance(){
		return instance;
	}

	public ArrayList<Player> getPlayers(){
		return this.players;
	}

	/**
	 * 
	 * @param numberOfPlayers
	 * @param players
	 * @param factions
	 */
	public void createGame(int numberOfPlayers, ArrayList<Player> players, ArrayList<Faction> factions) {
		this.numberOfPlayers = numberOfPlayers;
		this.players = players;
		System.out.println("Stored the references of the parameters");

		game.setPlayers(players);
		System.out.println("Initiliazed the players of the game and the number of players");

		// Set the factions for each player
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.printf("Initialized the factions for each player");
			players.get(i).setFaction(factions.get(i));
			System.out.println(
					"Player: " + players.get(i).getName() + " controls " + players.get(i).getFaction().getName());
		}
		// Initialize TerraLand
		initializeTerraLand();

		// Put the players into the turnQueue for the action phase
		for (Player p : players) {
			turnQueue.add(p);
		}
	}

	public int getNumberOfPlayer(){
		return numberOfPlayers;
	}

	public void pauseGame() {
		// TODO - implement GameHandler.pauseGame
		throw new UnsupportedOperationException();
	}

	public void continueGame() {
		// TODO - implement GameHandler.continueGame
		throw new UnsupportedOperationException();
	}

	public void endGame() {

	}

	public ArrayList<Player> calculateScores() {
		// TODO - implement GameHandler.calculateScores
		throw new UnsupportedOperationException();
	}

	public Player declareWinner() {
		int current = 0;
		int maxVictoryPoint = Integer.MIN_VALUE;
		Player winner = null;
		for(Player p: players){
			current = p.getVictoryPoints();
			if (current > maxVictoryPoint){
				winner = p;
			}
		}
		return winner;
	}

	public void executeSetupPhase() {
		// Each player will build 2 dwellings on their home terrains
		// Find the possible locations that the player can build a dwelling on
		// Choose 2 of such locations and call buildStructure
		// Starting posiiton son cultboard
		game.setCurrentPhase(0);
		
		// Set the starting cult positions for the users
		for (int i = 0; i < numberOfPlayers; i++) {
			players.get(i).setPositionOnCultBoard(players.get(i).getFaction().getStartingCultBonus());
			// players.get(i).printPositionOnCultBoard();
		}

		// Clear out the list to save some memory
		actionHandler.getTerrainWithSameType().clear();
		// Fill in the card deck
		Game.getInstance().fillBonusCardDeck();
		
		// Players choose their bonus cards
		for (int j = numberOfPlayers - 1; j > -1; j--){
			int bonusCardId = random.nextInt(9);
			players.get(j).chooseBonusCard(bonusCardId);
		}
		// Put 1 coin to the cards that have not been chosen yet
		game.putChoosingBonus();
	}

	public void executeIncomePhase() {
		game.setCurrentPhase(1);
		for (Player p : players) {
			// Distributing Income from the Structures
			for (int i = 0; i < Structure.NUMBER_OF_STRUCTURE_TYPES; i++) {
				Structure currentSType = Structure.STRUCTURES_INDEXED[i];
				Asset incomeFromStructure = p.getFaction().getIncomePerStructure(currentSType);
				int numberOfStructures = p.getNumberOfStructures(currentSType);

				for (int j = 0; j < numberOfStructures; j++) {
					System.out.println(p.getName() + " gets " + incomeFromStructure + " as income");
					p.getFaction().asset.performIncrementalTransaction(incomeFromStructure);
				}

			}
			System.out.println(p.getName() + " has " + p.getFaction().asset);
		}
	}

	public void executeActionPhase() {
		game.setCurrentPhase(2);
		while (!turnQueue.isEmpty()) {
			Player currentPlayer = turnQueue.poll();
			actionHandler.setCurrentPlayer(currentPlayer);
			System.out.println("Current player is : " + currentPlayer.getName());

			Random random = new Random();
			int randomActionId = random.nextInt(8);
			actionHandler.setActionID(randomActionId);
			actionHandler.executeAction();
			if (!currentPlayer.isPassed()) {
				turnQueue.add(currentPlayer);
			}
		}
	}

	public void executeCleanupPhase() {
		game.setCurrentPhase(3);
		System.out.println("Give scoring tile bonus");
	}

	// Initializes the terrains for the TerraLand
	public void initializeTerraLand() {
		// ti = terrainIndex
		for (int ti = 0; ti < Game.getInstance().NUMBER_OF_TERRAINS; ti++) {
			if (ti == 0 || ti == 6 || ti == 16 || ti == 50 || ti == 53 || ti == 57 || ti == 74 || ti == 76 || ti == 93
					|| ti == 101 || ti == 111) {
				game.modifyTerraland(TerrainType.PLAINS, ti / 13, ti % 13);
			} else if (ti == 1 || ti == 30 || ti == 36 || ti == 58 || ti == 65 || ti == 75 || ti == 81 || ti == 100
					|| ti == 102 || ti == 106 || ti == 112) {
				game.modifyTerraland(TerrainType.MOUNTAINS, ti / 13, ti % 13);
			} else if (ti == 2 || ti == 9 || ti == 32 || ti == 34 || ti == 39 || ti == 62 || ti == 66 || ti == 70
					|| ti == 85 || ti == 109 || ti == 115) {
				game.modifyTerraland(TerrainType.FOREST, ti / 13, ti % 13);
			} else if (ti == 3 || ti == 10 || ti == 40 || ti == 45 || ti == 55 || ti == 65 || ti == 89 || ti == 92
					|| ti == 97 || ti == 107 || ti == 114) {
				game.modifyTerraland(TerrainType.LAKES, ti / 13, ti % 13);
			} else if (ti == 4 || ti == 13 || ti == 20 || ti == 24 || ti == 41 || ti == 59 || ti == 69 || ti == 87
					|| ti == 90 || ti == 91 || ti == 110) {
				game.modifyTerraland(TerrainType.DESERT, ti / 13, ti % 13);
			} else if (ti == 5 || ti == 8 || ti == 11 || ti == 44 || ti == 47 || ti == 49 || ti == 54 || ti == 83
					|| ti == 104 || ti == 108 || ti == 116) {
				game.modifyTerraland(TerrainType.WASTELAND, ti / 13, ti % 13);
			} else if (ti == 7 || ti == 12 || ti == 17 || ti == 21 || ti == 28 || ti == 52 || ti == 56 || ti == 63
					|| ti == 88 || ti == 98 || ti == 105) {
				game.modifyTerraland(TerrainType.SWAMP, ti / 13, ti % 13);
			} else {
				game.modifyTerraland(TerrainType.RIVER, ti / 13, ti % 13);
			}
		}
	}

	public void setPlayers(ArrayList<Player> players){
		this.players = players;
	}

	public void nextPlayer(){
		turnQueue.poll();
	}

	@Override
	public String toString() {
		return "";
	}
}
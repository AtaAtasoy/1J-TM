package GameLogic;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {

	private Faction faction;
	private int victoryPoints;
	private HashMap<Cult, Integer> positionOnCultBoard;
	private BonusCard bonusCard;
	private ArrayList<FavorTile> favorTiles;
	private ArrayList<TownTile> townTiles;
	private int remainingBridges;
	private String name;
	private int id;
	private boolean passed;
	private HashMap<Structure, Integer> numberOfStructures;
	private ArrayList<Terrain> controlledTerrains;
	private ArrayList<Boolean> townKeyUsed;

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		passed = false;
		victoryPoints = 0;
		positionOnCultBoard = new HashMap<Cult,Integer>();
		favorTiles = new ArrayList<FavorTile>();
		townTiles = new ArrayList<TownTile>();
		remainingBridges = 4; // Double check

		// Initialize the number of structures as 0 for each type
		numberOfStructures = new HashMap<>();
		for(int i = 0; i < Structure.NUMBER_OF_STRUCTURE_TYPES; i++){
			numberOfStructures.put(Structure.STRUCTURES_INDEXED[i], 0);
		}

		controlledTerrains = new ArrayList<Terrain>();
		townKeyUsed = new ArrayList<Boolean>();

		// Starting posiiton son cultboard
		positionOnCultBoard = faction.getStartingCultBonus();
	}

	public void chooseBonusCard() {
		// TODO - implement Player.chooseBonusCard
		throw new UnsupportedOperationException();
	}

	public void getVictoryPoints() {
		// TODO - implement Player.getVictoryPoints
		throw new UnsupportedOperationException();
	}

	public boolean isPassed(){
		return this.passed;
	}

	public void setPassed(boolean pass){
		this.passed = pass;
	}
	/**
	 * 
	 * @param point
	 */
	public void setVictoryPoints(int point) {
		this.victoryPoints = point;
	}

	public int getRemainingBridge() { 
		return this.remainingBridges;
	}

	public void setRemainingBridge() {}

	public String getName(){
		return this.name;
	}
	public Faction getFaction() {
		return this.faction;
	}

	/**
	 * 
	 * @param faction
	 */
	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public void setNoOfStructures() {
		// TODO - implement Player.setNoOfStructures
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param positionOnCultBoard
	 */
	public void setPositionOnCultBoard(HashMap<Cult, Integer> positionOnCultBoard) {
		this.positionOnCultBoard = positionOnCultBoard;
	}

	public HashMap<Cult, Integer> getPositionOnCultBoard() {
		return positionOnCultBoard;
	}

	public ArrayList<Terrain> getControlledTerrains() {
		return this.controlledTerrains;
	}

	/**
	 * 
	 * @param controlledTerrains
	 */
	public void setControlledTerrains(ArrayList<Terrain> controlledTerrains) {
		this.controlledTerrains = controlledTerrains;
	}

	public void incrementVictoryPoints(int point){
		victoryPoints += point;
	}

	public int getNumberOfStructures(Structure s){
		return numberOfStructures.get(s);
	}

	public void incrementNumberOfStructues(Structure s){
		numberOfStructures.put(s, numberOfStructures.get(s) + 1);
	}


	public ArrayList<Boolean> getTownKeyUsed() {
		return this.townKeyUsed;
	}

	public void setTownKeyUsed( ArrayList<Boolean> townKeyUsed ) {
		this.townKeyUsed = townKeyUsed;
	}


}
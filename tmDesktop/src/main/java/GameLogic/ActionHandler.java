package GameLogic;

import java.util.ArrayList;


public class ActionHandler {

	private Player currentPlayer;
	private static ActionHandler instance = new ActionHandler();

	/* These variables will be passed as arguments to the actions.*/
	private int terrainXPosition;
	private int terrainYPosition;
	private int terrainTypeIndex;
	private ArrayList<Terrain> terrainWithSameType = new ArrayList<>();
	private Structure structureToBuild;
	/* The controller will set the values of these variables with its setter methods. */

	public void setStructureToBuild(Structure s){
		structureToBuild = s;
	}

	public static ActionHandler getInstance() {
		return instance;
	}
	
	public int getTerrainXPosition(){
		return this.terrainXPosition;
	}

	public void setTerrainXPosition(int x){
		terrainXPosition = x;
	}

	public int getTerrainYPosition(){
		return this.terrainYPosition;
	}

	public void setTerrainYPosition(int y){
		terrainYPosition = y;
	}

	public int getTerrainTypeIndex(){
		return terrainTypeIndex;
	}

	public void setTerrainTypeIndex(int index){
		terrainTypeIndex = index;
	}
	
	public ArrayList<Terrain> getTerrainWithSameType(){
		return this.terrainWithSameType;
	}
	/**
	 * 
	 * @param targetTerrainType
	 */
	private boolean canTerraformTerrain(TerrainType targetTerrainType, int x, int y) {
		// Check if the player has enough assets to terraform
		return true;
	}

	/**
	 * 
	 * @param terrain
	 */
	private boolean canBuildStructure(Terrain terrain) {
		// TODO - implement ActionHandler.canBuildStructure
		throw new UnsupportedOperationException();
	}

	/** 
	 * 
	 * Case 1
	 * @param targetTerrainType
	 * @param x
	 * 
	 * @param y
	 */
	private void terraformAndBuild(TerrainType targetTerrainType, int terrainXPosition, int  terrainYPosition) {
		Terrain terrainToBeModified = Game.getInstance().getTerrain(terrainXPosition,terrainYPosition);
		if(targetTerrainType == terrainToBeModified.getType()){
			System.out.println("Cannot terraform to the same type");
		}
		else{
			// Modify the terraland
			Game.getInstance().modifyTerraland(targetTerrainType, terrainXPosition,terrainYPosition);

			// Perform transaction with the player's asset. Find the spadecCount, there might be need for more than 1 spade
			int spadeCount = currentPlayer.getFaction().getRequiredSpades(targetTerrainType);
			Asset terraformCost = currentPlayer.getFaction().getSpadeCost();
			for (int i = 0; i < spadeCount; i++) {
				currentPlayer.getFaction().getAsset().performTranscation(terraformCost);
			}

			System.out.println("Cost of the terraform :" + spadeCount + " x " + terraformCost);
			System.out.println("Player now has : " + currentPlayer.getFaction().asset);
		}
		buildStructure(Structure.DWELLING, terrainXPosition, terrainYPosition);
	}

	private void upgradeShipping() {
		// Find the shippingUpgrade cost
		Asset shippingUpgradeCost = currentPlayer.getFaction().shippingUpgradeCost;
		System.out.println("Cost of the shipping upgrade: " + shippingUpgradeCost);

		// Perform the transaction
		currentPlayer.getFaction().asset.performTranscation(shippingUpgradeCost);
		System.out.println("Player now has : " + currentPlayer.getFaction().asset);

		//Increment the shipping level
		currentPlayer.getFaction().shippingLevel++;
		System.out.println("Current shipping level : " + currentPlayer.getFaction().shippingLevel);

		// Increment player's victoryPoints
		currentPlayer.incrementVictoryPoints(currentPlayer.getFaction().getVictoryPointsEarnedWithShippingUpgrade());
	}

	private void upgradeSpades() {
		// Find the cost for spade upgrade
		Asset spadeUpgradeCost = currentPlayer.getFaction().getSpadeUpgradeCost();
		System.out.println("Cost of the spade upgrade: " + spadeUpgradeCost);

		//Perform the transaction
		currentPlayer.getFaction().getAsset().performTranscation(spadeUpgradeCost);
		System.out.println("Player now has : " + currentPlayer.getFaction().asset);

		//Increment the spade level
		currentPlayer.getFaction().spadeLevel++;
		System.out.println("Spade Level : " + currentPlayer.getFaction().spadeLevel);

		// Increment player's victoryPoints
		currentPlayer.incrementVictoryPoints(currentPlayer.getFaction().getVictoryPointsEarnedWithSpadeUpgrade());
	}

	private void upgradeStructure(int x, int y) {
		Structure structureOnTerrain = Game.getInstance().getTerrain(x,y).getStructureType();
		if (structureOnTerrain == Structure.DWELLING){
			// Get the upgrade cost for trading post depending on the adjacency
			// Make the transaction
			// Do the transaction
			// Update incomePerBuilding for the currentPlayer
			System.out.println("TODO: Implement upgradeStructure");
		}
		// Do the same for the other buildings.
	}

	/**
	 * 
	 * @param cultType
	 * @param priestPosition
	 */
	private void sendPriestToCultBoard(String cultType, int priestPosition) {
		// TODO - implement ActionHandler.sendPriestToCultBoard
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	private void powerAction(int id) {
		// TODO - implement ActionHandler.powerAction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	private void specialAction(int id) {
		// TODO - implement ActionHandler.specialAction
		throw new UnsupportedOperationException();
	}

	private void pass() {
		currentPlayer.setPassed(true);
		System.out.println(currentPlayer.getName() + " passed");
	}

	/**
	 * 
	 * @param structure
	 * @param terrain
	 */
	private void buildStructure(Structure structure, int terrainXPosition, int terrainYPosition) {
		// Find the terrain at the given location
		Terrain temp = Game.getInstance().getTerrain(terrainXPosition, terrainYPosition);
		// Build the structure
		temp.setStructureType(structure);
		// TODO: Perform transcation

		// Add the terrain to the controlled terrains list of the player.
		currentPlayer.getControlledTerrains().add(temp);
		// Set the owner attribute of the terrain
		temp.setOwner(currentPlayer);
		System.out.println("Built " + structure + " on " + temp);
	}

	private boolean canUpgradeShipping() {
		// TODO - implement ActionHandler.canUpgradeShipping
		throw new UnsupportedOperationException();
	}

	private boolean canUpgradeSpades() {
		// TODO - implement ActionHandler.canUpgradeSpades
		throw new UnsupportedOperationException();
	}

	private boolean canUpgradeStructure() {
		// TODO - implement ActionHandler.canUpgradeStructure
		throw new UnsupportedOperationException();
	}

	private boolean canSendPriestToCultBoard() {
		// TODO - implement ActionHandler.canSendPriestToCultBoard
		throw new UnsupportedOperationException();
	}

	private boolean hasEnoughPower() {
		// TODO - implement ActionHandler.hasEnoughPower
		throw new UnsupportedOperationException();
	}

	private boolean canPerformSpeacialAction() {
		// TODO - implement ActionHandler.canPerformSpeacialAction
		throw new UnsupportedOperationException();
	}

	public boolean[] showPlayAbleActions() {
		// TODO - implement ActionHandler.showPlayAbleActions
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 */
	public void setCurrentPlayer(Player p) {
		this.currentPlayer = p;
		System.out.println("Current Player is " + p.getName());
	}

	/**
	 * 
	 * @param actionID
	 */
	public void executeAction(int actionID) {
		System.out.println("Will execute the action with ID: " + actionID);
		switch (actionID) {
			case 1: // Terraform and build
				setTerrainTypeIndex(4);
				TerrainType t = TerrainType.TERRAINS_INDEXED[terrainTypeIndex];
				setTerrainXPosition(0);
				setTerrainYPosition(0);

				terraformAndBuild(t, terrainXPosition, terrainYPosition);
				break;
			case 2: // Upgrade Structure
				upgradeStructure(terrainXPosition, terrainYPosition);
				break;
			case 3: // Upgrade spade level
				upgradeSpades();
				break;
			case 4: // Upgrade shipping level
				upgradeShipping();
				break;
			case 7:
				pass();
				break;
			case 8: // build structure. will be used in the setup phase where each player places 1/2/3 dwellings.
				buildStructure(structureToBuild, terrainXPosition, terrainYPosition);
				break;
		}
	}

}
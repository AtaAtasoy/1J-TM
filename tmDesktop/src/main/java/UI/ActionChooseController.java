package UI;

import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static UI.GameplayController.*;

public class ActionChooseController implements Initializable {

    @FXML public AnchorPane shippingPane;
	@FXML public AnchorPane specialActionsPane;
	@FXML public AnchorPane spadePane;

	GameHandler gh = GameHandler.getInstance();
	ActionHandler ah = ActionHandler.getInstance();
	Game g = Game.getInstance();


	/**
	 *
	 * @param event
	 */
	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
	}



	/**
	 *
	 * @param event
	 */
	//action id 0
	@FXML
	public void terraformAndBuildButtonClicked(ActionEvent event) {

		GameplayController.actionChooseStage.close();
		for(int j = 0; j < g.getNumberOfTerrain(); j++) {
			// Highlight those terrains
			ah.setTerrainXPosition(j / 13);
			ah.setTerrainYPosition(j % 13);
			ah.setActionID(10); //canTerraformTerrain
			ah.setTargetTerrainType(gh.nextPlayer().getFaction().getTerrainType());
			ah.setActionIndex(0);
			ah.executeAction();
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[j / 13][j % 13].setGlow();
			}

		}
		for(int j = 0; j < g.getNumberOfTerrain(); j++) {
			if ( ah.getPerformableActionId() ) {
				final int jTemp = j;
				GameplayController.tileArr[j / 13][j % 13].setOnMouseClicked((e) -> {
					//set glow to false
					for (int k = 0; k < Game.getInstance().getNumberOfTerrain(); k++) {
						if (ah.getPerformableActionId()) {
							GameplayController.tileArr[k / 13][k % 13].setEffect(null);
						}
					}
					//set not clickable for tiles.
					for (int k = 0; k < Game.getInstance().getNumberOfTerrain(); k++) {
						if (ah.getPerformableActionId()) {
							GameplayController.tileArr[k / 13][k % 13].setOnMouseClicked(null);
						}
					}

					ah.setTerrainXPosition(jTemp/13);
					ah.setTerrainYPosition(jTemp%13);
					ah.setActionID(0); //canTerraformTerrain
					gh.executeActionPhase(0);
					adjustStructure(true, jTemp/13, jTemp%13, Structure.DWELLING);
				});
			}
		}



		gh.executeActionPhase(0);
	}

	//action id 4
	@FXML
	private void sendPriestToCultButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		cultBoardStage.show();
	}

	/**
	 *
	 * @param event
	 */
	//action id 5 -- powerAction id will be set.
	@FXML
	public void powerActionButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
		powerActionController.selectButton.setVisible(true);
		GameplayController.powerActionStage.show();
	}


	/**
	 *
	 * @param event
	 */
	@FXML
	public void bonusCardActionButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void favorTileActionButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		GameplayController.favorTileController.updateLabels();
		favorTileStage.show();
	}

	/**
	 *
	 * @param event
	 */
	//action id 1
	@FXML
	public void upgradeShippingButtonClicked (ActionEvent event) {
		spadePane.setVisible(false);
		specialActionsPane.setVisible(false);
		shippingPane.setVisible(true);
	}

	/**
	 *
	 * @param event
	 */
	//action id 2
	@FXML
	public void upgradeSpadeButtonClicked(ActionEvent event) {
		specialActionsPane.setVisible(false);
		shippingPane.setVisible(false);
		spadePane.setVisible(true);
	}

	/**
	 *
	 * @param event
	 */
	//action id 3
	@FXML
	public void upgradeStructureButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();

	}

	/**
	 *
	 * @param event
	 */
	//action id 6
	@FXML
	public void specialActionsButtonClicked (ActionEvent event) {
		spadePane.setVisible(false);
		shippingPane.setVisible(false);
		specialActionsPane.setVisible(true);
	}

	/**
	 *
	 * @param event
	 */
	//action id 7
	@FXML
	public void passButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
		bonusCardController.decreaseBonusCardSelectCounter();

		int curBonusId = g.getCurrentPlayer().getChosenBonusCard().getId();
		g.getCurrentPlayer().returnBonusCard();
		g.getCurrentPlayer().setPassed(true);

		bonusCardStage.showAndWait();
		if ( curBonusId == 0)
			bonusCardController.select0.setVisible(true);
		else if ( curBonusId == 1)
			bonusCardController.select1.setVisible(true);
		else if ( curBonusId == 2)
			bonusCardController.select2.setVisible(true);
		else if ( curBonusId == 3)
			bonusCardController.select3.setVisible(true);
		else if ( curBonusId == 4)
			bonusCardController.select4.setVisible(true);
		else if ( curBonusId == 5)
			bonusCardController.select5.setVisible(true);
		else if ( curBonusId == 6)
			bonusCardController.select6.setVisible(true);
		else if ( curBonusId == 7)
			bonusCardController.select7.setVisible(true);
		else
			bonusCardController.select8.setVisible(true);

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shippingPane.setVisible(false);
		specialActionsPane.setVisible(false);
		spadePane.setVisible(false);
	}
}
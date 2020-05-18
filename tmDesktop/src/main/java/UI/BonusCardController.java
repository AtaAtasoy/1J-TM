package UI;

import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import javax.print.DocFlavor;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class BonusCardController<playerNo> implements Initializable {

	@FXML public Button closeButton;

	@FXML public Button select0;
	@FXML public Button select1;
	@FXML public Button select2;
	@FXML public Button select3;
	@FXML public Button select4;
	@FXML public Button select5;
	@FXML public Button select6;
	@FXML public Button select7;
	@FXML public Button select8;
	@FXML Label playerNameLabel;

	Player currentPlayer;


	//	int playerNo = NewGameController.playerNumber;
	int bonusCardSelectCounter = 0;
	int playerIndex = 0;
	ActionHandler ah = ActionHandler.getInstance();
	Game g = Game.getInstance();
	GameHandler gh = GameHandler.getInstance();
	int playerNo = gh.getNumberOfPlayer();
	// For each player set it to the currentPlayer for the actionHandler

	@FXML
	private void select0Clicked(ActionEvent event) {
		System.out.println("0 clicked");
		bonusCardSelectCounter++;
		//playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select0.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 0 ");
		System.out.println(currentPlayer);
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(0);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo-1) {
			GameplayController.bonusCardStage.close();
		//	GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select1Clicked(ActionEvent event) {
		System.out.println("1 clicked");

		bonusCardSelectCounter++;
	//	playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();

		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select1.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 1 " );
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(1);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo-1) {
			GameplayController.bonusCardStage.close();

		//	GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select2Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select2.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 2 ");
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(2);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select3Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
//		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select3.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 3 " );
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(3);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select4Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select4.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 4 ");
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(4);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select5Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select5.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 5 " );
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(5);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select6Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		//int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select6.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 6 " );
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(6);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select7Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select7.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 7 ");
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(7);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select8Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select8.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 8" );
		playerNameLabel.setFont(Font.font("Arial"));
		currentPlayer.chooseBonusCard(8);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.incomePhaseStage.show();
		}
	}


	/**
	@FXML
	private void select1Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select1.setVisible(false);
		//	closeButton.setVisible(true);
		//	select1.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 1" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}
	@FXML
	private void select2Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select2.setVisible(false);
		//	closeButton.setVisible(true);
		//	select2.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 2" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}	@FXML
	private void select3Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select3.setVisible(false);
		//	closeButton.setVisible(true);
		//	select3.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 3" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}	@FXML
	private void select4Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select4.setVisible(false);
		//	closeButton.setVisible(true);
		//	select0.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 4" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}	@FXML
	private void select5Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select5.setVisible(false);
		//	closeButton.setVisible(true);
		//	select0.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 5" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}	@FXML
	private void select6Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select6.setVisible(false);
		//	closeButton.setVisible(true);
		//	select0.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 6" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}
	@FXML
	private void select7Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select7.setVisible(false);
		//	closeButton.setVisible(true);
		//	select7.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 7" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}

	@FXML
	private void select8Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);

		GameplayController.bonusCardStage.close();
		select8.setVisible(false);
		//	closeButton.setVisible(true);
		//	select8.setVisible(false);
		playerNameLabel.setText("PLAYER i BONUS CARD : NO 8" );
		closeButton.setVisible(true);
		GameplayController.incomePhaseStage.show();
	}   */

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		if(bonusCardSelectCounter == playerNo - 1) {
			GameplayController.bonusCardStage.close();
		}
	}

/**


	@FXML
	private boolean selected1(MouseEvent e) {
		selected[1] = true;
		return true;
	}

	@FXML
	private boolean selected2(MouseEvent e) {
		selected[2] = true;
		return true;
	}

	@FXML
	private boolean selected3(MouseEvent e) {
		selected[3] = true;
		return true;
	}

	@FXML
	private boolean selected4(MouseEvent e) {
		selected[4] = true;
		return true;
	}

	@FXML
	private boolean selected5(MouseEvent e) {
		selected[5] = true;
		return true;
	}

	@FXML
	private boolean selected6(MouseEvent e) {
		selected[6] = true;
		return true;
	}

	@FXML
	private boolean selected7(MouseEvent e) {
		selected[7] = true;
		return true;
	}

	@FXML
	private boolean selected8(MouseEvent e) {
		selected[8] = true;
		return true;
	}

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.bonusCardStage.close();
	}


*/


	public void updateBonusCards() {
		// TODO - implement BonusCardController.updateBonusCards
		throw new UnsupportedOperationException();
	}



	/**
	 *
	 * @param url
	 * @param resourceBundle
	 */
	public void initialize(DocFlavor.URL url, ResourceBundle resourceBundle) {
		// TODO - implement BonusCardController.initialize
		throw new UnsupportedOperationException();
	}




	@Override
	public void initialize(URL location, ResourceBundle resources) {

		closeButton.setVisible(false);
		bonusCardSelectCounter = 0;
	}
}
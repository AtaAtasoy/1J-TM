package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController  implements Initializable {

	public static Stage cultBoardStage;
	public static Stage bonusCardStage;
	public static Stage favorTileStage;
	public static Stage roundTileStage;

	@FXML
	public Button backButton;
	@FXML
	public Button cultBoardButton;

	@FXML Group mapGroup;

	private KeyCombination fullScreenExitKeyCombination;

	//Instances for Hexagon Map
	private final static double r = 36; // the inner radius from hexagon center to outer corner
	private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
	private final static double TILE_HEIGHT = 2 * r;
	private final static double TILE_WIDTH = 2 * n;
	public static Tile[][] tileArr = new Tile[9][13];

	public GameplayController() {
	}


	@FXML
	private void backButtonClicked(ActionEvent event) throws Throwable {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/MainMenu.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setFullScreenExitKeyCombination(fullScreenExitKeyCombination);
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	@FXML
	private void cultBoardButtonClicked(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/CultBoard.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		cultBoardStage = new Stage();
		cultBoardStage.setScene(scene);
		cultBoardStage.setHeight(750);
		cultBoardStage.setWidth(750);
		cultBoardStage.initStyle(StageStyle.UNDECORATED);
		cultBoardStage.initOwner(primaryStage);
		cultBoardStage.initModality(Modality.APPLICATION_MODAL);
		cultBoardStage.showAndWait();
	}

	@FXML
	private void bonusCardButtonClicked(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/BonusCard.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		bonusCardStage = new Stage();
		bonusCardStage.setScene(scene);
		bonusCardStage.setHeight(466);
		bonusCardStage.setWidth(1103);
		bonusCardStage.initStyle(StageStyle.UNDECORATED);
		bonusCardStage.initOwner(primaryStage);
		bonusCardStage.initModality(Modality.APPLICATION_MODAL);
		bonusCardStage.showAndWait();
	}
	@FXML
	private void favorTileButtonClicked(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/FavorTile.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		favorTileStage = new Stage();
		favorTileStage.setScene(scene);
		favorTileStage.setHeight(400);
		favorTileStage.setWidth(600);
		favorTileStage.initStyle(StageStyle.UNDECORATED);
		favorTileStage.initOwner(primaryStage);
		favorTileStage.initModality(Modality.APPLICATION_MODAL);
		favorTileStage.showAndWait();
	}



	public static AnchorPane createMap() {
//		Screen screen = Screen.getPrimary();
//		Rectangle2D bounds = screen.getVisualBounds();
		AnchorPane tileMap = new AnchorPane();
		int rowCount = 9; // how many rows of tiles should be created
		int tilesPerRow = 13; // the amount of tiles that are contained in each row
	//	double xStartOffset = bounds.getWidth() / 4.55; // offsets the entire field to the right
	//	double yStartOffset = bounds.getHeight() / 6; // offsets the entire fields downwards
		double xStartOffset = 0; // offsets the entire field to the right
		double yStartOffset = 0;// offsets the entire fields downwards

		for (int x = 0; x < tilesPerRow; x++) {
			for (int y = 0; y < rowCount; y++) {
				double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
				double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
				Polygon tile = new Tile(xCoord, yCoord);
				tileArr[y][x] = (Tile) tile;
				tile.setFill(Color.ANTIQUEWHITE);
				if (x == 12) {
					if (y == 1 || y == 3 || y == 5 || y == 7)
						tile.setVisible(false);
				}
				tileMap.getChildren().add(tile);
			}
		}
		//Adjusting starting state colors of the map
		for (int x = 0; x < tilesPerRow; x++) {
			for (int y = 0; y < rowCount; y++) {
				double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
				double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
				Polygon tile = new Tile(xCoord, yCoord);
				tileArr[y][x] = (Tile) tile;
				tile.setFill(Color. ANTIQUEWHITE);
				if (x == 12) {
					if (y == 1 || y == 3 || y == 5 || y == 7)
						tile.setVisible(false);
				}
				tileMap.getChildren().add(tile);
			}
		}
		for(int x = 0; x < 9; x++) {
			for (int y = 0; y < 13; y++) {
				if (x == 0) {
					if (y == 0 || y == 6)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if (y == 1)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if (y == 2 || y == 9)
						tileArr[x][y].setFill(Color.rgb(95, 145, 25)); //green
					if (y == 3 || y == 10)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if (y == 4)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if (y == 5 || y == 8 || y == 11)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if (y == 7 || y == 12)
						tileArr[x][y].setFill(Color.rgb(86, 86, 63)); //dark grey
				}
				if(x == 1){
					if(y == 3)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 0 || y == 7 || y == 11 )
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 4 || y == 8)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 2){
					if(y == 4 || y == 10)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 6 || y == 8)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 2)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 3){
					if(y == 11)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 0)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 1 || y == 6)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 2)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 5 || y == 8 || y == 10)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
				}

				if(x == 4){
					if(y == 1 || y == 5)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 6)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 10)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 3 || y == 12)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 7)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 2)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if(y == 0 || y == 4 || y == 11)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 5){
					if(y == 9 || y == 11)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 0 || y == 10)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 1 ||y == 5)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 4)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
				}

				if(x == 6){
					if(y == 3)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 7)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 11)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 12)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 5)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if(y == 10)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 7){
					if(y == 2 || y == 10)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if( y == 9 || y == 11)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 1 || y == 6)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 0)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 7)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 8){
					if(y == 2 || y == 8)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 5 || y == 11)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 3 || y == 10)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 6)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 0 || y == 4 || y == 7 || y == 12)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if(y == 1) {
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					}
				}
			}
		}
		return tileMap;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullScreenExitKeyCombination = GameUI.stage.getFullScreenExitKeyCombination();
		GameUI.stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		mapGroup.getChildren().add(createMap());
	}


	private static class Tile extends Polygon {

		Tile(double x, double y) {
			// creates the polygon using the corner coordinates
			getPoints().addAll(
					x, y,
					x, y + r,
					x + n, y + r * 1.5,
					x + TILE_WIDTH, y + r,
					x + TILE_WIDTH, y,
					x + n, y - r * 0.5
			);

			setStrokeWidth(1);
			setStroke(Color.BLACK);
			setOnMouseClicked(e -> System.out.println("Clicked: " + this));
		}

	}
}
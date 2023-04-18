package ticTacToe;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	public static int count = 0;

	public void start(Stage primaryStage) {
		HBox h = new HBox();
		Button butt = new Button("START");
		butt.setFont(Font.font("Comic Sans MS", 20));
		butt.setPrefSize(200, 200);
		h.setAlignment(Pos.CENTER);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		VBox end = new VBox();
		end.setAlignment(Pos.CENTER);
		Label text = new Label("Play Again?");
		text.setFont(Font.font(20));
		end.getChildren().add(text);

		Button play = new Button("PLAY AGAIN");
		play.setFont(Font.font("Comic Sans MS", 20));

		end.getChildren().add(play);
		Scene endScreen = new Scene(end, 550, 500);

		ArrayList<Button> arr = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			arr.add(new Button(new Integer(i).toString()));
			arr.get(i).setPrefSize(80, 80);
			arr.get(i).setFont(new Font(20));
			arr.get(i).setAlignment(Pos.CENTER);

			final int ii = i;
			arr.get(i).setOnAction(e -> {
				if (count % 2 == 0) {
					arr.get(ii).setText("O");
				} else {
					arr.get(ii).setText("X");
				}
				count++;
				// System.out.println(arr.get(2).getText());
				if (hasWin(arr)) {

					primaryStage.setScene(endScreen);
				}
			});
		}

		int c = 0;
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				grid.add(arr.get(c), k, j);
				// System.out.println(c);
				c++;
			}
		}
		h.getChildren().add(butt);
		Scene scene1 = new Scene(h, 550, 500);
		Scene scene = new Scene(grid, 550, 500);
		play.setOnAction(e -> {
			for (int o = 0; o < 9; o++) {
				arr.get(o).setText(new Integer(o).toString());

			}
			primaryStage.setScene(scene);
		});

		butt.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		// width , height
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

	public boolean hasWin(ArrayList<Button> a) {
		boolean status = false;
		if (a.get(0).getText().equals(a.get(1).getText()) && a.get(1).getText().equals(a.get(2).getText())
				&& a.get(0).getText().equals(a.get(2).getText())) {
			status = true;

		} else if (a.get(3).getText().equals(a.get(4).getText()) && a.get(4).getText().equals(a.get(5).getText())
				&& a.get(3).getText().equals(a.get(5).getText())) {
			status = true;

		} else if (a.get(6).getText().equals(a.get(7).getText()) && a.get(7).getText().equals(a.get(8).getText())
				&& a.get(6).getText().equals(a.get(8).getText())) {
			status = true;

		} else if (a.get(0).getText().equals(a.get(4).getText()) && a.get(4).getText().equals(a.get(8).getText())
				&& a.get(0).getText().equals(a.get(8).getText())) {
			status = true;

		} else if (a.get(2).getText().equals(a.get(4).getText()) && a.get(4).getText().equals(a.get(6).getText())
				&& a.get(2).getText().equals(a.get(6).getText())) {
			status = true;

		} else if (a.get(0).getText().equals(a.get(3).getText()) && a.get(3).getText().equals(a.get(6).getText())
				&& a.get(0).getText().equals(a.get(6).getText())) {
			status = true;

		} else if (a.get(1).getText().equals(a.get(4).getText()) && a.get(4).getText().equals(a.get(7).getText())
				&& a.get(1).getText().equals(a.get(7).getText())) {
			status = true;

		} else if (a.get(2).getText().equals(a.get(5).getText()) && a.get(5).getText().equals(a.get(8).getText())
				&& a.get(2).getText().equals(a.get(8).getText())) {
			status = true;

		}

		return status;

	}

}

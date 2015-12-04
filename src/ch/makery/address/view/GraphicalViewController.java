package ch.makery.address.view;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import static javafx.scene.layout.VBox.setMargin;

public class GraphicalViewController extends Application {
	private Ellipse ceiling0;
	private Ellipse ceiling1;
	private Ellipse ceiling2;
	private Ellipse ceiling3;
	private ImageView ceiling_image;
	private VBox nav;
	private HBox buttonSet;
	private Label presentation_title;
	private TextArea info;
	private Button previous;
	private Button comment;
	private Button next;

	@Override
	public void start(Stage primaryStage) {
		AnchorPane root = new AnchorPane();
		Scene primaryScene = new Scene(root, 700, 700);
		initializeCeiling(root);
		initializeNav(root);
		initializeContent(root);
		initializePrimaryStage(primaryStage, primaryScene);
		primaryStage.show();
	}

	private void initializePrimaryStage(Stage primaryStage, Scene primaryScene) {
		primaryStage.setTitle("Refugees");
		primaryStage.setScene(primaryScene);
		primaryStage.setWidth(700);
		primaryStage.setHeight(700);
		primaryStage.setResizable(false);
		// primaryStage.minHeightProperty().setValue(800);
		// primaryStage.maxHeightProperty().setValue(800);
		// primaryStage.minWidthProperty().setValue(900);
		// primaryStage.maxWidthProperty().setValue(900);
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void initializeCeiling(AnchorPane root) {
		ceiling0 = new Ellipse();
		ceiling1 = new Ellipse();
		ceiling2 = new Ellipse();
		ceiling3 = new Ellipse();

		// relative positioning
		ceiling0.centerXProperty().bind(root.widthProperty().multiply(0.5));
		ceiling0.centerYProperty().setValue(0);
		ceiling0.radiusXProperty().bind(root.widthProperty().multiply(1.3));
		ceiling0.radiusYProperty().bind(root.heightProperty().multiply(0.5));

		ceiling1.centerXProperty().bind(root.widthProperty().multiply(0.32));
		ceiling1.centerYProperty().bind(root.widthProperty().multiply(0.38));
		ceiling1.radiusXProperty().bind(root.widthProperty().multiply(0.1));
		ceiling1.radiusYProperty().bind(root.heightProperty().multiply(0.1));

		ceiling2.centerXProperty().bind(root.widthProperty().multiply(0.65));
		ceiling2.centerYProperty().bind(root.widthProperty().multiply(0.38));
		ceiling2.radiusXProperty().bind(root.widthProperty().multiply(0.1));
		ceiling2.radiusYProperty().bind(root.heightProperty().multiply(0.1));

		ceiling3.centerXProperty().bind(root.widthProperty().multiply(0.56));
		ceiling3.centerYProperty().bind(root.widthProperty().multiply(0.38));
		ceiling3.radiusXProperty().bind(root.widthProperty().multiply(0.1));
		ceiling3.radiusYProperty().bind(root.heightProperty().multiply(0.1));

		//// absolute positioning
		// ceiling1.centerXProperty().setValue(200);
		// ceiling1.centerYProperty().setValue(250);
		// ceiling1.radiusXProperty().setValue(100);
		// ceiling1.radiusYProperty().setValue(100);
		//
		// ceiling2.centerXProperty().setValue(450);
		// ceiling2.centerYProperty().setValue(250);
		// ceiling2.radiusXProperty().setValue(100);
		// ceiling2.radiusYProperty().setValue(100);

	}

	private void initializeNav(AnchorPane root) {
		nav = new VBox();
		initializeControls(nav);
		AnchorPane.setBottomAnchor(nav, 10.0);
		AnchorPane.setLeftAnchor(nav, 120.0);
		AnchorPane.setRightAnchor(nav, 120.0);
		root.getChildren().add(nav);
	}

	private void initializeControls(VBox nav) {
		info = new TextArea();
		setMargin(info, new Insets(10, 0, 0, 0));
		info.setWrapText(true);
		info.setEditable(true);
		buttonSet = new HBox();
		initializeButtonSet(nav);
		presentation_title = new Label("About this photo");
		presentation_title.setId("titulo");
		nav.alignmentProperty().setValue(Pos.CENTER);
		nav.getChildren().addAll(presentation_title, info, buttonSet);
	}

	private void initializeButtonSet(VBox nav) {
		previous = new Button("<");
		comment = new Button("Send comments");
		comment.setId("comment_button");
		next = new Button(">");
		buttonSet.spacingProperty().bind(nav.widthProperty().multiply(0.15));
		buttonSet.setAlignment(Pos.CENTER);
		setMargin(buttonSet, new Insets(10, 0, 0, 0));
		buttonSet.getChildren().addAll(previous, comment, next);
	}

	private void initializeContent(AnchorPane root) {
		Image image = new Image("file:resources/images/pic1.jpg");

		 ceiling_image = new ImageView(image);
		 ceiling_image.setClip(ceiling0);
		 ceiling_image.setEffect(new GaussianBlur(5));
		 root.getChildren().add(ceiling_image);

		ceiling_image = new ImageView(image);
		ceiling_image.setClip(ceiling1);
		root.getChildren().add(ceiling_image);

		ceiling_image.addEventHandler(EventType.ROOT, new GenericHandler());

		ceiling_image = new ImageView(image);
		ceiling_image.setClip(ceiling2);
		root.getChildren().add(ceiling_image);

		ceiling_image = new ImageView(image);
		ceiling_image.setClip(ceiling3);
		root.getChildren().add(ceiling_image);

	}

	private class GenericHandler implements EventHandler<Event> {

		@Override
		public void handle(Event event) {
			System.out.println(event.getEventType());

		}
	}
}
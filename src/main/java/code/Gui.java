package code;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;


public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) {

        int x_position = 400;
        int y_position = 300;
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.GREEN);


        final Box box = new Box();
        box.setHeight(200);
        box.setWidth(200);
        box.setDepth(200);
        box.setMaterial(material);
        box.setLayoutX(x_position);
        box.setLayoutY(y_position);


        Group root = new Group(box);
        Scene scene = new Scene(root, 800, 600, Color.BLACK);


        AtomicReference<Double> initial_X = new AtomicReference<>(0.0);
        AtomicReference<Double> initial_Y = new AtomicReference<>(0.0);
        AtomicReference<Double> initial_Angle_X = new AtomicReference<>(0.0);
        AtomicReference<Double> initial_Angle_Y = new AtomicReference<>(0.0);


        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        rotateX.setPivotX(x_position);
        rotateX.setPivotY(y_position);
        rotateY.setPivotX(x_position);
        rotateY.setPivotY(y_position);
        root.getTransforms().addAll(rotateX, rotateY);


        root.setOnMousePressed(event -> {
            initial_X.set(event.getSceneX());
            initial_Y.set(event.getSceneY());
            initial_Angle_X.set(rotateX.getAngle());
            initial_Angle_Y.set(rotateY.getAngle());
        });


        scene.setOnMouseDragged(event -> {
            double x = event.getSceneX() - initial_X.get();
            double y = event.getSceneY() - initial_Y.get();

            rotateX.setAngle(initial_Angle_X.get() + y);
            rotateY.setAngle(initial_Angle_Y.get() - x);
        });


        primaryStage.setScene(scene);
        primaryStage.setTitle("Rubiks Cube");
        primaryStage.show();
    }

    public void begin() {
        launch();
    }

}

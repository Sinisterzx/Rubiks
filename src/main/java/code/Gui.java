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

import javax.swing.text.Position;
import java.util.concurrent.atomic.AtomicReference;


class Cubefaces extends Group {
    static Group faces(Color top, Color bottom, Color left, Color right, Color front, Color back, Integer add_x, Integer add_y, Integer add_z) {
        int x_position = 400;
        int y_position = 300;
        int z_position = 0;

        Rectangle topFace = new Rectangle(50, 50);
        topFace.setFill(top);
        topFace.setTranslateY(-50 / 2);
        topFace.setRotationAxis(Rotate.X_AXIS);
        topFace.setRotate(90);

        Rectangle bottomFace = new Rectangle(50, 50);
        bottomFace.setFill(bottom);
        bottomFace.setTranslateY(50 / 2);
        bottomFace.setRotationAxis(Rotate.X_AXIS);
        bottomFace.setRotate(-90);

        Rectangle leftFace = new Rectangle(50, 50);
        leftFace.setFill(left);
        leftFace.setTranslateX(-50 / 2);
        leftFace.setRotationAxis(Rotate.Y_AXIS);
        leftFace.setRotate(-90);

        Rectangle rightFace = new Rectangle(50, 50);
        rightFace.setFill(right);
        rightFace.setTranslateX(50 / 2);
        rightFace.setRotationAxis(Rotate.Y_AXIS);
        rightFace.setRotate(90);

        Rectangle frontFace = new Rectangle(50, 50);
        frontFace.setFill(front);
        frontFace.setTranslateZ(-50 / 2);

        Rectangle backFace = new Rectangle(50, 50);
        backFace.setFill(back);
        backFace.setTranslateZ(50 / 2);
        backFace.setRotationAxis(Rotate.Y_AXIS);
        backFace.setRotate(180);

        Group box = new Group(topFace, bottomFace, leftFace, rightFace, frontFace, backFace);

        if (add_x == 50){
            add_x += 1;
        }
        if (add_y == 50){
            add_y += 1;
        }
        if (add_z == 50){
            add_z += 1;
        }
        if (add_x == 100){
            add_x += 2;
        }
        if (add_y == 100){
            add_y += 2;
        }
        if (add_z == 100){
            add_z += 2;
        }

        box.setLayoutX(x_position + add_x);
        box.setLayoutY(y_position + add_y);
        box.setTranslateZ(z_position + add_z);


        return box;
    }
}


class cubefactory{

    static Box creator(Integer add_y, Integer add_x, Integer add_z){
        int x_position = 400;
        int y_position = 300;
        int z_position = 0;


        Box box = new Box();

        box.setHeight(50);
        box.setWidth(50);
        box.setDepth(50);


        if (add_x == 50){
            add_x += 1;
        }
        if (add_y == 50){
            add_y += 1;
        }
        if (add_z == 50){
            add_z += 1;
        }
        if (add_x == 100){
            add_x += 2;
        }
        if (add_y == 100){
            add_y += 2;
        }
        if (add_z == 100){
            add_z += 2;
        }

        box.setLayoutX(x_position + add_x);
        box.setLayoutY(y_position + add_y);
        box.setTranslateZ(z_position + add_z);


        return box;
    }


}


public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) {

        int x_position = 400;
        int y_position = 300;

        Group box1 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.GREEN, Color.BLACK, Color.BLUE, Color.BLACK, 0, 0, 0);
        Group box2 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE, Color.BLACK, 50, 0, 0);
        Group box3 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.GREEN, Color.BLACK, Color.BLUE, Color.BLACK, 0, 50, 0);
        Group box4 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE, Color.BLACK, 50, 50, 0);
        Group box5 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.BLACK, Color.ORANGE, Color.BLUE, Color.BLACK, 100, 0, 0);
        Group box6 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.GREEN, Color.BLACK, Color.BLUE, Color.BLACK, 0, 100, 0);
        Group box7 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLUE, Color.BLACK, 50, 100, 0);
        Group box8 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, Color.ORANGE, Color.BLUE, Color.BLACK, 100, 50, 0);
        Group box9 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.BLACK, Color.ORANGE, Color.BLUE, Color.BLACK, 100, 100, 0);
        Group box10 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.BLACK, Color.ORANGE, Color.BLACK, Color.BLACK, 100, 100, 50);
        Group box11 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.BLACK, Color.ORANGE, Color.BLACK, Color.RED, 100, 100, 100);
        Group box12 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, 50, 100, 50);
        Group box13 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.BLACK, Color.BLACK, Color.BLACK, Color.RED, 50, 100, 100);
        Group box14 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.GREEN, Color.BLACK, Color.BLACK, Color.BLACK, 0, 100, 50);
        Group box15 = Cubefaces.faces(Color.BLACK, Color.WHITE, Color.GREEN, Color.BLACK, Color.BLACK, Color.RED, 0, 100, 100);
        Group box16 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.BLACK, 0, 0, 50);
        Group box17 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.RED, 0, 0, 100);
        Group box18 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.BLACK, 0, 50, 50);
        Group box19 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.GREEN, Color.BLACK, Color.BLACK, Color.RED, 0, 50, 100);
        Group box20 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, 50, 0, 50);
        Group box21 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.BLACK, Color.ORANGE, Color.BLACK, Color.BLACK, 100, 0, 50);
        Group box22 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.RED, 50, 0, 100);
        Group box23 = Cubefaces.faces(Color.YELLOW, Color.BLACK, Color.BLACK, Color.ORANGE, Color.BLACK, Color.RED, 100, 0, 100);

        Group box24 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, Color.ORANGE, Color.BLACK, Color.BLACK, 100, 50, 50);
        Group box25 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, Color.ORANGE, Color.BLACK, Color.RED, 100, 50, 100);
        Group box26 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.RED, 50, 50, 100);







        Group root1 = new Group(box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16, box17, box18, box19, box20, box21, box22, box23, box24, box25, box26);
        Group root2 = new Group(box1, box3);
        Group root = new Group(root1, root2);


        Scene scene = new Scene(root, 800, 600, true);



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


        scene.setFill(Color.DARKSLATEGRAY);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rubiks Cube");
        primaryStage.show();
    }

    public void begin() {
        launch();
    }

}

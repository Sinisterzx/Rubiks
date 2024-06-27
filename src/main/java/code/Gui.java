package code;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

import java.util.HashMap;
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

        box.setLayoutX(x_position + add_x - 50);
        box.setLayoutY(y_position + add_y - 50);
        box.setTranslateZ(z_position + add_z - 50);


        return box;
    }
}



public class Gui extends Application {

    HashMap <Character, Color> chartocolor = new HashMap<Character, Color>();

    Group box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13,
            box14, box15, box16, box17, box18, box19, box20, box21, box22, box23, box24, box25, box26;

    public Group[][] allboxes;

    Group root1 = new Group(), root2 = new Group(), root3 = new Group(),
             root4 = new Group(), root5 = new Group(), root6 = new Group();

    Group[] theroots = {root1, root2, root3, root4, root5, root6};

    Rotate[] roters;

    @Override
    public void start(Stage primaryStage) {

        chartocolor.put('r', Color.RED);
        chartocolor.put('g', Color.GREEN);
        chartocolor.put('b', Color.BLUE);
        chartocolor.put('y', Color.YELLOW);
        chartocolor.put('w', Color.WHITE);
        chartocolor.put('o', Color.ORANGE);


        int x_position = 400;
        int y_position = 300;

        refresh();

        Group root = new Group(root1, root2, root3, root4, root5, root6);


        Button shuffle_button = new Button("Shuffle");
        Button solve_button = new Button("Solve");

        HBox buttonBox = new HBox(10, shuffle_button, solve_button);
        buttonBox.setAlignment(Pos.CENTER);

        VBox rubiks_box = new VBox(10, root);


        rubiks_box.setAlignment(Pos.CENTER);


        VBox mainLayout = new VBox(100, rubiks_box, buttonBox);
        mainLayout.setBackground(Background.EMPTY);


        mainLayout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(mainLayout, 800, 600, true);


        AtomicReference<Double> initial_X = new AtomicReference<>(0.0);
        AtomicReference<Double> initial_Y = new AtomicReference<>(0.0);
        AtomicReference<Double> initial_Angle_X = new AtomicReference<>(0.0);
        AtomicReference<Double> initial_Angle_Y = new AtomicReference<>(0.0);

        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        rotateX.setPivotX(x_position + 26);
        rotateX.setPivotY(y_position + 26);
        rotateX.setPivotZ(26);
        rotateY.setPivotX(x_position + 26);
        rotateY.setPivotY(y_position + 26);
        rotateY.setPivotZ(26);
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

        scene.setOnKeyPressed(this::handleKeyPress);


        scene.setFill(Color.DARKKHAKI);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rubiks Cube");
        primaryStage.show();
    }


    private void handleKeyPress(KeyEvent event) {
        Operations ops = new Operations();

        int face;

        roters = new Rotate[]{new Rotate(0, 426, 326, 0, Rotate.Z_AXIS),
                new Rotate(0, 0, 326, 1, Rotate.X_AXIS),
                new Rotate(0, 426, 0, 1, Rotate.Y_AXIS),
                new Rotate(0, 426, 0, 1, Rotate.Y_AXIS),
                new Rotate(0, 0, 326, 1, Rotate.X_AXIS),
                new Rotate(0, 426, 326, 0, Rotate.Z_AXIS)};

        for (int i = 0; i<6; i++){
            theroots[i].getChildren().clear();
        }
        // issue with green and yellow and orange
        switch (event.getCode()) {
            case R:
                face = 1;

                faceanimate(face);
                ops.red(true);
                animateRotation(roters[face], 90);

                break;
            case G:
                face = 5;

                faceanimate(face);
                ops.green(true);
                animateRotation(roters[face], -90);

                break;
            case B:
                face = 0;

                faceanimate(face);
                ops.blue(true);
                animateRotation(roters[face], 90);

                break;
            case Y:
                face = 3;

                faceanimate(face);
                ops.yellow(true);
                animateRotation(roters[face], -90);

                break;
            case W:
                face = 2;

                faceanimate(face);
                ops.white(true);
                animateRotation(roters[face], 90);

                break;
            case O:
                face = 4;

                faceanimate(face);
                ops.orange(true);
                animateRotation(roters[face], -90);

                break;
            default:
                refresh();
                break;
        }
    }

    private void faceanimate(int face){
        for (int i = 0; i<6; i++){
            if (i != face) {
                theroots[i].getChildren().addAll(allboxes[i]);
            }
        }
        theroots[face].getChildren().addAll(allboxes[face]);

        theroots[face].getTransforms().clear();

        theroots[face].getTransforms().add(roters[face]);

    }

    private void animateRotation(Rotate rotate, double endAngle) {
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.1), new KeyValue(rotate.angleProperty(), endAngle));
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event ->{
            for (int i = 0; i<6; i++){
                theroots[i].getTransforms().clear();
            }


            for (int i = 0; i < 6; i++){
                for (int j = 0; j < 9; j++){
                    if (j % 3 == 0 && j != 0 ){
                        System.out.println();
                    }
                    System.out.print(Cube.cube[i][j].toString() + ' ');

                }

                System.out.println();
                System.out.println();
            }


            refresh();
        });
        timeline.play();


    }


    void refresh(){
        box1 = Cubefaces.faces(chartocolor.get(Cube.cube[4][6]), Color.BLACK, chartocolor.get(Cube.cube[0][2]), Color.BLACK, chartocolor.get(Cube.cube[2][0]), Color.BLACK, 0, 0, 0);
        box2 = Cubefaces.faces(chartocolor.get(Cube.cube[4][7]), Color.BLACK, Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[2][1]), Color.BLACK, 50, 0, 0);
        box3 = Cubefaces.faces(chartocolor.get(Cube.cube[4][8]), Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[5][0]), chartocolor.get(Cube.cube[2][2]), Color.BLACK, 100, 0, 0);
        box4 = Cubefaces.faces(Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[0][5]), Color.BLACK, chartocolor.get(Cube.cube[2][3]), Color.BLACK, 0, 50, 0);
        box5 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[2][4]), Color.BLACK, 50, 50, 0);
        box6 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[5][3]), chartocolor.get(Cube.cube[2][5]), Color.BLACK, 100, 50, 0);
        box7 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][0]), chartocolor.get(Cube.cube[0][8]), Color.BLACK, chartocolor.get(Cube.cube[2][6]), Color.BLACK, 0, 100, 0);
        box8 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][1]), Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[2][7]), Color.BLACK, 50, 100, 0);
        box9 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][2]), Color.BLACK, chartocolor.get(Cube.cube[5][6]), chartocolor.get(Cube.cube[2][8]), Color.BLACK, 100, 100, 0);
        box10 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][5]), Color.BLACK, chartocolor.get(Cube.cube[5][7]), Color.BLACK, Color.BLACK, 100, 100, 50);
        box11 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][8]), Color.BLACK, chartocolor.get(Cube.cube[5][8]), Color.BLACK, chartocolor.get(Cube.cube[1][6]), 100, 100, 100); // 6
        box12 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][4]), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, 50, 100, 50);
        box13 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][7]), Color.BLACK, Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[1][7]), 50, 100, 100); // 7
        box14 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][3]), chartocolor.get(Cube.cube[0][7]), Color.BLACK, Color.BLACK, Color.BLACK, 0, 100, 50);
        box15 = Cubefaces.faces(Color.BLACK, chartocolor.get(Cube.cube[3][6]), chartocolor.get(Cube.cube[0][6]), Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[1][8]), 0, 100, 100);  // 8
        box16 = Cubefaces.faces(chartocolor.get(Cube.cube[4][3]), Color.BLACK, chartocolor.get(Cube.cube[0][1]), Color.BLACK, Color.BLACK, Color.BLACK, 0, 0, 50);
        box17 = Cubefaces.faces(chartocolor.get(Cube.cube[4][0]), Color.BLACK, chartocolor.get(Cube.cube[0][0]), Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[1][2]), 0, 0, 100); /// 2
        box18 = Cubefaces.faces(Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[0][4]), Color.BLACK, Color.BLACK, Color.BLACK, 0, 50, 50);
        box19 = Cubefaces.faces(Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[0][3]), Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[1][5]), 0, 50, 100); // 5
        box20 = Cubefaces.faces(chartocolor.get(Cube.cube[4][4]), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, 50, 0, 50);
        box21 = Cubefaces.faces(chartocolor.get(Cube.cube[4][5]), Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[5][1]), Color.BLACK, Color.BLACK, 100, 0, 50);
        box22 = Cubefaces.faces(chartocolor.get(Cube.cube[4][1]), Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[1][1]), 50, 0, 100); // 1
        box23 = Cubefaces.faces(chartocolor.get(Cube.cube[4][2]), Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[5][2]), Color.BLACK, chartocolor.get(Cube.cube[1][0]), 100, 0, 100); // 0
        box24 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[5][4]), Color.BLACK, Color.BLACK, 100, 50, 50);
        box25 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK,chartocolor.get(Cube.cube[5][5]), Color.BLACK, chartocolor.get(Cube.cube[1][3]), 100, 50, 100); // 3
        box26 = Cubefaces.faces(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, chartocolor.get(Cube.cube[1][4]), 50, 50, 100); // 4

        allboxes = new Group[][]{
                {box1, box2, box3, box4, box5, box6, box7, box8, box9},
                {box1, box4, box7, box16, box18, box14, box17, box19, box15},
                {box1, box2, box3, box16, box20, box21, box17, box22, box23},
                {box7, box8, box9, box14, box12, box10, box15, box13, box11},
                {box3, box6, box9, box21, box24, box10, box23, box25, box11},
                {box17, box22, box23, box19, box26, box25, box15, box13, box11}
        };

        for (int i = 0; i < 6; i++) {
            theroots[i].getChildren().clear();
        }
        for (int i = 0; i<6; i++) {
            for (int j = 0; j < 9; j++) {
                theroots[i].getChildren().add(allboxes[i][j]);
            }
        }
    }

    public static void begin(){
        launch();
    }

    public static void Main(String args[]){
        launch();

    }

}
package code;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.time.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.random.*;

public class Operations {

    public static void shuffle() throws InterruptedException {
        Integer keys[] = {0, 1, 2, 3, 4, 5};

        Random rand = new Random();
        int rotations = rand.nextInt(50, 70);


        for (int i = 0; i < rotations; i++) {
            Integer pressed_face = keys[rand.nextInt(keys.length)];
            Boolean direction = rand.nextBoolean();
            Gui.rotation_abstraction(direction, pressed_face);
        }

    }

    public void color_op(int colorval, boolean clockwise){
        int[][][] faceroter = {{{6, 3, 0}, {2, 5, 8}, {6, 3, 0}, {6, 3, 0}},
                {{8, 7, 6}, {6, 3, 0}, {0, 1, 2}, {2, 5, 8}},
                {{0, 1, 2}, {6, 3, 0}, {8, 7, 6}, {2, 5, 8}},
                {{6, 7, 8}, {6, 7, 8}, {6, 7, 8}, {6, 7, 8}},
                {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}},
                {{2, 5, 8}, {6, 3, 0}, {2, 5, 8}, {2, 5, 8}}};

        rotateCube(colorval, clockwise);
        rotateAdjacentFaces(colorval, faceroter[colorval], clockwise);

    }

    private void rotateCube(int val, Boolean clockwise) {
        if (clockwise) {
            Cube.cube[val] = new Character[]{
                    Cube.cube[val][6], Cube.cube[val][3], Cube.cube[val][0],
                    Cube.cube[val][7], Cube.cube[val][4], Cube.cube[val][1],
                    Cube.cube[val][8], Cube.cube[val][5], Cube.cube[val][2]};
        }else{
            Cube.cube[val] = new Character[]{
                    Cube.cube[val][2], Cube.cube[val][5], Cube.cube[val][8],
                    Cube.cube[val][1], Cube.cube[val][4], Cube.cube[val][7],
                    Cube.cube[val][0], Cube.cube[val][3], Cube.cube[val][6]};
        }
    }

    private void rotateAdjacentFaces(int face, int[][] indices, Boolean clockwise) {
        Integer[] adjacent = Cube.maps.get(face);
        Character[] temp = new Character[3];

        if (face == 3) {
            clockwise = !clockwise;
        }

        if (clockwise) {
            for (int i = 0; i < 3; i++) {
                temp[i] = Cube.cube[adjacent[0]][indices[0][i]];
            }

            for (int i = 0; i < 4; i++) {
                int next = (i + 1) % 4;
                for (int j = 0; j < 3; j++) {
                    Cube.cube[adjacent[i]][indices[i][j]] = Cube.cube[adjacent[next]][indices[next][j]];
                }
            }

            for (int i = 0; i < 3; i++) {
                Cube.cube[adjacent[3]][indices[3][i]] = temp[i];
            }
        }else{
            for (int i = 0; i < 3; i++) {
                temp[i] = Cube.cube[adjacent[3]][indices[3][i]];
            }

            for (int i = 3; i > 0; i--) {
                int next = (i - 1) % 4;
                for (int j = 0; j < 3; j++) {
                    Cube.cube[adjacent[i]][indices[i][j]] = Cube.cube[adjacent[next]][indices[next][j]];
                }
            }

            for (int i = 0; i < 3; i++) {
                Cube.cube[adjacent[0]][indices[0][i]] = temp[i];
            }
        }
    }

}

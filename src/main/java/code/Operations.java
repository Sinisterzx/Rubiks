package code;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.time.*;
import java.util.Random;
import java.util.random.*;

public class Operations {

    public static void shuffle(){
        Character keys[] = {'R', 'T', 'G', 'H', 'B', 'N', 'Y', 'U', 'W', 'E', 'O', 'P'};

        Random rand = new Random();

        Character pressed_letter = keys[rand.nextInt(keys.length)];
        int pressed_key = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(pressed_letter);




    }

    void red(boolean clockwise) {
        int val = 0;
        rotateCube(val);
        rotateAdjacentFaces(val, new int[][]{{6, 3, 0}, {2, 5, 8}, {6, 3, 0}, {6, 3, 0}}, clockwise);
    }

    void green(boolean clockwise) {
        int val = 1;
        rotateCube(val);
        rotateAdjacentFaces(val, new int[][]{{8, 7, 6}, {6, 3, 0}, {0, 1, 2}, {2, 5, 8}}, clockwise);
    }

    void blue(boolean clockwise) {
        int val = 2;
        rotateCube(val);
        rotateAdjacentFaces(val, new int[][]{{0, 1, 2}, {6, 3, 0}, {8, 7, 6}, {2, 5, 8}}, clockwise);
    }

    void yellow(boolean clockwise) {
        int val = 3;
        rotateCube(val);
        rotateAdjacentFaces(val, new int[][]{{6, 7, 8}, {6, 7, 8}, {6, 7, 8}, {6, 7, 8}}, clockwise);
    }

    void white(boolean clockwise) {
        int val = 4;
        rotateCube(val);
        rotateAdjacentFaces(val, new int[][]{{0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}}, clockwise);
    }

    void orange(boolean clockwise) {
        int val = 5;
        rotateCube(val);
        rotateAdjacentFaces(val, new int[][]{{2, 5, 8}, {6, 3, 0}, {2, 5, 8}, {2, 5, 8}}, clockwise);
    }

    private void rotateCube(int val) {
        Cube.cube[val] = new Character[]{
                Cube.cube[val][6], Cube.cube[val][3], Cube.cube[val][0],
                Cube.cube[val][7], Cube.cube[val][4], Cube.cube[val][1],
                Cube.cube[val][8], Cube.cube[val][5], Cube.cube[val][2]};
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

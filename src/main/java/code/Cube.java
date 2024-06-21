package code;

import java.util.HashMap;

public class Cube {

    public static Character[][] cube = new Character[6][9] ;
    public static HashMap <Integer, Integer[]> maps = new HashMap<Integer, Integer[]>() ;


    static void initialize(){
        Character[] colors = {'r', 'g', 'b', 'y', 'w', 'o'};
        for (int b = 0; b<6; b++){
            for (int i = 0; i<9; i++){
                cube[b][i] = colors[b];
            }
        }

        // r surrounded by g, y, w, o
        // 0 surrounded by 1, 3, 4, 5

        // g surrounded by b, w, r, y
        // 1 surrounded by 0, 2, 3, 4

        // b surrounded by y, o, w, g
        // 2 surrounded by 1, 3, 4, 5

        // y surrounded by b, r, g, o
        // 3 surrounded by 0, 1, 2, 4

        // w surrounded by b, r, g, o
        // 4 surrounded by 0, 1, 2, 5

        // o surrounded by b, w, r, y
        // 5 surrounded by 2, 4, 0, 3

        maps.put(0, new Integer[]{1, 3, 4, 5});
        maps.put(1, new Integer[]{0, 2, 3, 4});
        maps.put(2, new Integer[]{1, 3, 4, 5});
        maps.put(3, new Integer[]{0, 1, 2, 4});
        maps.put(4, new Integer[]{0, 1, 2, 5});
        maps.put(5, new Integer[]{2, 4, 0, 3});



    }





}



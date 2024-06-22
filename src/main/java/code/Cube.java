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


        // r surrounded by w g y b
        // 0 surrounded by 4, 1, 3, 2

        // g surrounded by y r w o
        // 1 surrounded by 3, 0, 4, 5

        // b surrounded by y, o, w, r
        // 2 surrounded by 3, 5, 4, 0

        // y surrounded by o, g, r, b
        // 3 surrounded by 5, 1, 0, 2

        // w surrounded by o, g, r, b
        // 4 surrounded by 5, 1, 0, 2

        // o surrounded by y, g, w, b
        // 5 surrounded by 3, 1, 4, 2


        maps.put(0, new Integer[]{4, 1, 3, 2});
        maps.put(1, new Integer[]{3, 0, 4, 5});
        maps.put(2, new Integer[]{3, 5, 4, 0});
        maps.put(3, new Integer[]{5, 1, 0, 2});
        maps.put(4, new Integer[]{5, 1, 0, 2});
        maps.put(5, new Integer[]{3, 1, 4, 2});



    }





}



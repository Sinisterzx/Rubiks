package code;

public class Cube {
    static Character[][][] cube = new Character[6][3][3];

    void initialize(){
        Character[] colors = {'r', 'g', 'b', 'y', 'w', 'o'};
        for (int b = 0; b<6; b++){
            for (int i = 0; i<3; i++){
                for (int a = 0; a<3; a++){
                    cube[b][a][i] = colors[b];
                }
            }
        }
    }



}



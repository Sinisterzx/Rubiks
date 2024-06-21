package code;

public class Operations {

    void red (){
        int val = 0;

        rotateCube(val);

    }


    void green (){
        int val = 1;

        rotateCube( val);
    }


    void blue (){
        int val = 2;

        rotateCube(val);
        Integer[] adjacent = Cube.maps.get(val);
        Character[] temp = new Character[3];
        for (int i = 0; i < adjacent.length; i++) {

            if (i == 0){
                temp[0] = Cube.cube[adjacent[i]][0];
                temp[1] = Cube.cube[adjacent[i]][3];
                temp[2] = Cube.cube[adjacent[i]][6];
            }

            if (i != 3){
                Cube.cube[adjacent[i]][0] =  Cube.cube[adjacent[i+1]][0];
                Cube.cube[adjacent[i]][3] = Cube.cube[adjacent[i+1]][3];
                Cube.cube[adjacent[i]][6] = Cube.cube[adjacent[i+1]][6];

            }else{
                Cube.cube[adjacent[i]][0] = temp[0];
                Cube.cube[adjacent[i]][3] = temp[1];
                Cube.cube[adjacent[i]][6] = temp[2];
            }
        }

    }


    void yellow (){
        int val = 3;

        rotateCube(val);

    }



    void white (){
        int val = 4;

        rotateCube(val);


    }


    void orange (){
        int val = 5;

        rotateCube(val);

    }


    private void rotateCube(int val) {
        Cube.cube[val] = new Character[]{Cube.cube[val][2], Cube.cube[val][5], Cube.cube[val][8],
                Cube.cube[val][1], Cube.cube[val][4], Cube.cube[val][7],
                Cube.cube[val][0], Cube.cube[val][3], Cube.cube[val][6]};
    }

}

package code;

public class Operations {

    Cube red (Cube thecube){
        int val = 0;

        rotateCube(thecube, val);

        return thecube;
    }


    Cube green (Cube thecube){
        int val = 1;

        rotateCube(thecube, val);

        return thecube;
    }


    Cube blue (Cube thecube){
        int val = 2;

        rotateCube(thecube, val);

        return thecube;
    }


    Cube yellow (Cube thecube){
        int val = 3;

        rotateCube(thecube, val);

        return thecube;
    }



    Cube white (Cube thecube){
        int val = 4;

        rotateCube(thecube, val);

        return thecube;
    }


    Cube orange (Cube thecube){
        int val = 5;

        rotateCube(thecube, val);

        return thecube;
    }


    private void rotateCube(Cube thecube, int val) {
        thecube.cube[val] = new Character[]{thecube.cube[val][2], thecube.cube[val][5], thecube.cube[val][8],
                thecube.cube[val][1], thecube.cube[val][4], thecube.cube[val][7],
                thecube.cube[val][0], thecube.cube[val][3], thecube.cube[val][6]};
    }

}

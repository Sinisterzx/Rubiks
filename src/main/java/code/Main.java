package code;

public class Main {
    public static void main(String[] args) {
        Cube cube1 = new Cube();
        cube1.initialize();

        for (int b = 0; b<6; b++){
            for (int i = 0; i<3; i++){
                for (int a = 0; a<3; a++){
                    System.out.print(Cube.cube[b][a][i]);
                }
                System.out.println();
            }
            System.out.println("------------------");

        }

        Gui gui = new Gui();

        gui.begin();


    }
}

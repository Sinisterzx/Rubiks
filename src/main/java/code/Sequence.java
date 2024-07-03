package code;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    public static List <Object[]> seq_array = new ArrayList<Object[]>();
    static Object[][] immediate = new Object[1][2];

    static void add_seq(Boolean clockwise, int face){
        seq_array.add(new Object[]{clockwise, face});
    }

    static void execute_seq(){
        while (!seq_array.isEmpty()){
            immediate[0] = seq_array.getLast();
            Gui.rotation_abstraction(!((Boolean) immediate[0][0]), (int) immediate[0][1], false);
            seq_array.removeLast();
        }
    }
}

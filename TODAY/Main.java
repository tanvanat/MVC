import Control.Control;
import Model.*;
import View.*;

public class Main {
    public static void main(String[] args) {
        View v = new View();
        Model m = new Model();
        m.print();
        Control c = new Control(v, m);
    }
}



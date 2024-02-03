package Control;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {
    private View view;
    private Model model;

    public Control(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addCalculationListener(new Listener());
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.get_type().equals("choosefromgame")) {
                String ans = model.calculategame(view.getinput());
                view.setAns(ans);
            } else if (view.get_type().equals("choosefromroom")) {
                String ans = model.calculateroom(view.getinput());
                view.setAns(ans);
            } else {
                view.displayErrorMessage("Try again with 4 or 5");
            }
        }
    }
}
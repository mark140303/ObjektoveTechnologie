package com.example.pocasie;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Kvapka extends PocasieObjekt {

    public static boolean zastavene = false;

    private double rychlost = 5;

    public Kvapka(double x, double y) {
        super(x, y);

        Ellipse telo = new Ellipse(3, 8);
        telo.setFill(Color.BLUE);

        getChildren().add(telo);
    }

    public void pohni() {
        if (zastavene == false) {
            setLayoutY(getLayoutY() + rychlost);
        }
    }

    public boolean jeVonPlochy(double sirka, double vyska) {
        if (getLayoutY() > vyska) {
            return true;
        } else {
            return false;
        }
    }
}

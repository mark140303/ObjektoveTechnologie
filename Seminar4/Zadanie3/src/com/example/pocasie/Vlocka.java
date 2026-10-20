package com.example.pocasie;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Vlocka extends PocasieObjekt {

    private double rychlostDole = 2;
    private double rychlostDoStrany;

    public Vlocka(double x, double y) {
        super(x, y);

        Circle telo = new Circle(4);
        telo.setFill(Color.WHITE);
        telo.setStroke(Color.GRAY);

        getChildren().add(telo);

        rychlostDoStrany = (Math.random() * 2) - 1;
    }

    public void pohni() {
        setLayoutY(getLayoutY() + rychlostDole);
        setLayoutX(getLayoutX() + rychlostDoStrany);
    }

    public boolean jeVonPlochy(double sirka, double vyska) {
        if (getLayoutY() > vyska) {
            return true;
        } else {
            return false;
        }
    }
}

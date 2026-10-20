package com.example.pocasie;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Oblak extends PocasieObjekt {

    private double rychlost = 0.5;
    private Ellipse elipsa1;
    private Ellipse elipsa2;
    private Ellipse elipsa3;

    public Oblak(double x, double y) {
        super(x, y);

        elipsa1 = new Ellipse(20, 15);
        elipsa1.setFill(Color.WHITE);

        elipsa2 = new Ellipse(15, 12);
        elipsa2.setCenterX(20);
        elipsa2.setCenterY(-5);
        elipsa2.setFill(Color.WHITE);

        elipsa3 = new Ellipse(15, 12);
        elipsa3.setCenterX(-20);
        elipsa3.setCenterY(-3);
        elipsa3.setFill(Color.WHITE);

        getChildren().add(elipsa1);
        getChildren().add(elipsa2);
        getChildren().add(elipsa3);
    }

    public void pohni() {
        setLayoutX(getLayoutX() + rychlost);

        if (getLayoutX() > 700) {
            setLayoutX(-60);
        }
    }

    public boolean jeVonPlochy(double sirka, double vyska) {
        return false;
    }

    public void zmenNaModru() {
        elipsa1.setFill(Color.LIGHTBLUE);
        elipsa2.setFill(Color.LIGHTBLUE);
        elipsa3.setFill(Color.LIGHTBLUE);
    }
}

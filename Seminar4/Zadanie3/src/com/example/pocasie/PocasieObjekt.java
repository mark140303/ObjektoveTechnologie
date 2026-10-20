package com.example.pocasie;

import javafx.scene.Group;

public abstract class PocasieObjekt extends Group {

    public PocasieObjekt(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
    }

    public abstract void pohni();

    public abstract boolean jeVonPlochy(double sirka, double vyska);
}

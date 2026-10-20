package com.example.robot;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Robot extends Rectangle {

    public enum Smer { HORE, DOLE, VLAVO, VPRAVO }

    private Smer smer = Smer.VPRAVO;
    private final double rychlost = 3;
    private boolean automaticky = false;

    public Robot(double x, double y) {
        super(x, y, 40, 40);
        setFill(Color.RED);
    }

    public void setSmer(Smer novySmer) {
        this.smer = novySmer;
        switch (novySmer) {
            case HORE -> setFill(Color.LIMEGREEN);
            case DOLE -> setFill(Color.ORANGE);
            case VLAVO -> setFill(Color.ROYALBLUE);
            case VPRAVO -> setFill(Color.RED);
        }
    }

    public Smer getSmer() {
        return smer;
    }

    public boolean isAutomaticky() {
        return automaticky;
    }

    public void prepniRezim() {
        automaticky = !automaticky;
    }

    public void pohni(Smer s, double maxX, double maxY) {
        double x = getX();
        double y = getY();
        switch (s) {
            case HORE -> y -= rychlost;
            case DOLE -> y += rychlost;
            case VLAVO -> x -= rychlost;
            case VPRAVO -> x += rychlost;
        }
        x = Math.max(0, Math.min(x, maxX - getWidth()));
        y = Math.max(0, Math.min(y, maxY - getHeight()));
        setX(x);
        setY(y);
    }

    public boolean narazilNaOkraj(Smer s, double maxX, double maxY) {
        return switch (s) {
            case HORE -> getY() <= 0;
            case DOLE -> getY() >= maxY - getHeight();
            case VLAVO -> getX() <= 0;
            case VPRAVO -> getX() >= maxX - getWidth();
        };
    }

    public Smer opacnySmer(Smer s) {
        return switch (s) {
            case HORE -> Smer.DOLE;
            case DOLE -> Smer.HORE;
            case VLAVO -> Smer.VPRAVO;
            case VPRAVO -> Smer.VLAVO;
        };
    }
}

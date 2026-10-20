package com.example.pocasie;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Pane plocha;

    private List<PocasieObjekt> objekty = new ArrayList<PocasieObjekt>();

    @FXML
    public void initialize() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                List<PocasieObjekt> naOdstranenie = new ArrayList<PocasieObjekt>();

                for (int i = 0; i < objekty.size(); i++) {
                    PocasieObjekt o = objekty.get(i);
                    o.pohni();

                    if (o.jeVonPlochy(plocha.getWidth(), plocha.getHeight())) {
                        naOdstranenie.add(o);
                    }
                }

                for (int i = 0; i < naOdstranenie.size(); i++) {
                    PocasieObjekt o = naOdstranenie.get(i);
                    objekty.remove(o);
                    plocha.getChildren().remove(o);
                }
            }
        };
        timer.start();
    }

    @FXML
    private void pridajOblak() {
        double x = Math.random() * (plocha.getWidth() - 60);
        double y = Math.random() * 100;

        Oblak o = new Oblak(x, y);
        objekty.add(o);
        plocha.getChildren().add(o);
    }

    @FXML
    private void pridajDazd() {
        double x = Math.random() * plocha.getWidth();
        double y = 0;

        Kvapka k = new Kvapka(x, y);
        objekty.add(k);
        plocha.getChildren().add(k);
    }

    @FXML
    private void pridajSnieh() {
        double x = Math.random() * plocha.getWidth();
        double y = 0;

        Vlocka v = new Vlocka(x, y);
        objekty.add(v);
        plocha.getChildren().add(v);
    }

    @FXML
    private void zastavDazd() {
        Kvapka.zastavene = true;
    }

    @FXML
    private void zmenOblakyNaModro() {
        for (int i = 0; i < objekty.size(); i++) {
            PocasieObjekt o = objekty.get(i);
            if (o instanceof Oblak) {
                Oblak oblak = (Oblak) o;
                oblak.zmenNaModru();
            }
        }
    }

    @FXML
    private void posunVlavo() {
        for (int i = 0; i < objekty.size(); i++) {
            PocasieObjekt o = objekty.get(i);
            o.setLayoutX(o.getLayoutX() - 20);
        }
    }
}

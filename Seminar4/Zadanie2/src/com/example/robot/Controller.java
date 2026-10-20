package com.example.robot;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.Set;

public class Controller {

    @FXML
    private Pane plocha;

    private Robot robot;
    private final Set<KeyCode> stlacene = new HashSet<>();

    @FXML
    public void initialize() {
        robot = new Robot(plocha.getPrefWidth() / 2, plocha.getPrefHeight() / 2);
        plocha.getChildren().add(robot);

        robot.setOnMouseClicked(e -> robot.prepniRezim());

        plocha.setOnKeyPressed(e -> stlacene.add(e.getCode()));
        plocha.setOnKeyReleased(e -> stlacene.remove(e.getCode()));

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double sirka = plocha.getWidth();
                double vyska = plocha.getHeight();
                if (sirka == 0 || vyska == 0) {
                    return;
                }

                if (robot.isAutomaticky()) {
                    Robot.Smer smer = robot.getSmer();
                    if (robot.narazilNaOkraj(smer, sirka, vyska)) {
                        robot.setSmer(robot.opacnySmer(smer));
                    }
                    robot.pohni(robot.getSmer(), sirka, vyska);
                } else {
                    if (stlacene.contains(KeyCode.W)) {
                        robot.setSmer(Robot.Smer.HORE);
                        robot.pohni(Robot.Smer.HORE, sirka, vyska);
                    }
                    if (stlacene.contains(KeyCode.S)) {
                        robot.setSmer(Robot.Smer.DOLE);
                        robot.pohni(Robot.Smer.DOLE, sirka, vyska);
                    }
                    if (stlacene.contains(KeyCode.A)) {
                        robot.setSmer(Robot.Smer.VLAVO);
                        robot.pohni(Robot.Smer.VLAVO, sirka, vyska);
                    }
                    if (stlacene.contains(KeyCode.D)) {
                        robot.setSmer(Robot.Smer.VPRAVO);
                        robot.pohni(Robot.Smer.VPRAVO, sirka, vyska);
                    }
                }
            }
        };
        timer.start();
    }
}

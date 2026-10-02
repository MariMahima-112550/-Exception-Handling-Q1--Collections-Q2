package com.sdg6.sdg6waterposter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SDG6WaterPoster extends Application {

    int score = 0;
    Label scoreLabel = new Label("0%");
    ProgressBar progress = new ProgressBar(0);

    @Override
    public void start(Stage stage) {

        String green = "#176B5B";
        String dark = "#123C35";
        String cream = "#FFF8E7";
        String mint = "#DDF1D8";
        String orange = "#F4A261";

        // HEADER
        Label title = new Label("💧 SDG 6");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        title.setTextFill(Color.WHITE);

        Label heading = new Label("WATER IS LIFE");
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        heading.setTextFill(Color.WHITE);

        Label sub = new Label("🌍 CLEAN WATER  •  SAFE FUTURE");
        sub.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        sub.setTextFill(Color.WHITE);

        VBox headText = new VBox(2, heading, sub);

        HBox header = new HBox(20, title, headText);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(15, 25, 15, 25));
        header.setStyle("-fx-background-color:" + green +
                ";-fx-background-radius:18;");

        // GRAPHIC
        Polygon drop = new Polygon(
                100, 0, 145, 65, 140, 105,
                110, 135, 70, 135, 40, 105, 35, 65
        );
        drop.setFill(Color.web(orange));

        Circle sun = new Circle(22, Color.web("#E9C46A"));

        StackPane graphic = new StackPane(sun, drop);

        Label graphicText = new Label("💧\nSAVE\nEVERY DROP");
        graphicText.setFont(Font.font("Arial",
                FontWeight.BOLD, 18));
        graphicText.setTextFill(Color.WHITE);
        graphicText.setAlignment(Pos.CENTER);

        StackPane visual = new StackPane(graphic, graphicText);
        visual.setPrefSize(250, 180);
        visual.setStyle("-fx-background-color:" + dark +
                ";-fx-background-radius:22;");

        // MESSAGE
        Label message = new Label(
                "💦 Water connects every part of life.\n\n"
                + "Use it wisely.\n"
                + "Protect it for everyone.\n\n"
                + "🌱 Small actions create a big change!"
        );

        message.setFont(Font.font("Arial",
                FontWeight.BOLD, 17));
        message.setTextFill(Color.web(dark));
        message.setWrapText(true);

        VBox messageBox = new VBox(message);
        messageBox.setAlignment(Pos.CENTER);
        messageBox.setPadding(new Insets(18));
        messageBox.setStyle("-fx-background-color:" + mint +
                ";-fx-background-radius:18;");

        // CONTROLS
        Label actionTitle = new Label("🚰 MY WATER ACTION");
        actionTitle.setFont(Font.font("Arial",
                FontWeight.BOLD, 18));
        actionTitle.setTextFill(Color.web(green));

        TextField name = new TextField();
        name.setPromptText("✏️ Enter your name");

        CheckBox tap = new CheckBox("🚰 Turn off taps");
        CheckBox reuse = new CheckBox("♻️ Reuse water");
        CheckBox leak = new CheckBox("🔧 Fix leaks");

        RadioButton home = new RadioButton("🏠 Save at home");
        RadioButton campus = new RadioButton("🏫 Save on campus");

        ToggleGroup group = new ToggleGroup();
        home.setToggleGroup(group);
        campus.setToggleGroup(group);

        VBox controls = new VBox(9,
                actionTitle, name, tap, reuse, leak,
                home, campus);

        controls.setPadding(new Insets(15));
        controls.setStyle("-fx-background-color:" + cream +
                ";-fx-background-radius:18;"
                + "-fx-border-color:" + orange + ";"
                + "-fx-border-radius:18;");

        // SCORE
        Label scoreTitle = new Label("🏆 WATER HERO");
        scoreTitle.setFont(Font.font("Arial",
                FontWeight.BOLD, 18));
        scoreTitle.setTextFill(Color.web(green));

        scoreLabel.setFont(Font.font("Arial",
                FontWeight.BOLD, 32));
        scoreLabel.setTextFill(Color.web(orange));

        progress.setPrefWidth(220);
        progress.setPrefHeight(20);

        Button check = new Button("💧 CHECK MY IMPACT");
        check.setFont(Font.font("Arial",
                FontWeight.BOLD, 13));
        check.setTextFill(Color.WHITE);
        check.setStyle("-fx-background-color:" + green +
                ";-fx-background-radius:10;"
                + "-fx-padding:9 18;");

        Label result = new Label(
                "🌱 Start your water mission!"
        );
        result.setFont(Font.font("Arial",
                FontWeight.BOLD, 12));
        result.setTextFill(Color.web(dark));

        check.setOnAction(e -> {

            score = 0;

            if (tap.isSelected()) score += 25;
            if (reuse.isSelected()) score += 25;
            if (leak.isSelected()) score += 25;
            if (home.isSelected() || campus.isSelected())
                score += 25;

            scoreLabel.setText(score + "%");
            progress.setProgress(score / 100.0);

            String n = name.getText().trim();
            if (n.isEmpty()) n = "Water Hero";

            if (score == 100)
                result.setText("🏆 Amazing, " + n + "!");
            else if (score >= 50)
                result.setText("🌱 Great job, " + n + "!");
            else
                result.setText("💚 Keep going, " + n + "!");
        });

        VBox scoreBox = new VBox(7,
                scoreTitle, scoreLabel,
                progress, check, result);

        scoreBox.setAlignment(Pos.CENTER);
        scoreBox.setPadding(new Insets(15));
        scoreBox.setStyle("-fx-background-color:#FFE9C9;"
                + "-fx-background-radius:18;");

        // FOOTER
        Label tips = new Label(
                "🌊 SAVE WATER   •   🌱 PROTECT NATURE"
                + "   •   💧 PROTECT LIFE"
        );

        tips.setFont(Font.font("Arial",
                FontWeight.BOLD, 14));
        tips.setTextFill(Color.WHITE);
        tips.setMaxWidth(Double.MAX_VALUE);
        tips.setAlignment(Pos.CENTER);
        tips.setPadding(new Insets(10));

        tips.setStyle("-fx-background-color:" + green +
                ";-fx-background-radius:12;");

        // LAYOUT
        HBox top = new HBox(15, visual, messageBox);
        HBox.setHgrow(messageBox, Priority.ALWAYS);

        HBox bottom = new HBox(15, controls, scoreBox);
        HBox.setHgrow(controls, Priority.ALWAYS);
        HBox.setHgrow(scoreBox, Priority.ALWAYS);

        VBox poster = new VBox(12,
                header, top, bottom, tips);

        poster.setPadding(new Insets(15));
        poster.setStyle("-fx-background-color:" + cream + ";");

        Scene scene = new Scene(poster, 960, 680);

        stage.setTitle("SDG 6 - Water Is Life");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
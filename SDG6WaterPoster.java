package com.sdg6.sdg6waterposter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SDG6WaterPoster extends Application {

    private final String BLUE = "#0077B6";
    private final String DARK_BLUE = "#023E8A";
    private final String CYAN = "#00B4D8";
    private final String LIGHT_BLUE = "#CAF0F8";
    private final String GREEN = "#52B788";
    private final String LIGHT_GREEN = "#D8F3DC";
    private final String WHITE = "#FFFFFF";

    @Override
    public void start(Stage stage) {

        // =========================
        // HEADER
        // =========================

        Label sdgNumber = new Label("SDG 6");
        sdgNumber.setFont(Font.font("Arial", FontWeight.BOLD, 34));
        sdgNumber.setTextFill(Color.WHITE);

        Label title = new Label("CLEAN WATER & SANITATION");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "Every Drop Counts • Every Action Matters"
        );
        subtitle.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        subtitle.setTextFill(Color.WHITE);

        VBox titleBox = new VBox(4, sdgNumber, title, subtitle);
        titleBox.setAlignment(Pos.CENTER_LEFT);

        // Water-drop visual
        Label drop = new Label("💧");
        drop.setFont(Font.font(70));

        HBox header = new HBox(20, drop, titleBox);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(25));

        header.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                + "#023E8A, #0077B6, #00B4D8);"
                + "-fx-background-radius: 20;"
        );

        // =========================
        // QUOTE
        // =========================

        Label quote = new Label(
                "\"Save water today, protect life tomorrow.\""
        );

        quote.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        quote.setTextFill(Color.web(DARK_BLUE));
        quote.setWrapText(true);
        quote.setAlignment(Pos.CENTER);

        VBox quoteCard = new VBox(8, quote);
        quoteCard.setAlignment(Pos.CENTER);
        quoteCard.setPadding(new Insets(18));

        quoteCard.setStyle(
                "-fx-background-color: white;"
                + "-fx-background-radius: 15;"
                + "-fx-border-color: #90E0EF;"
                + "-fx-border-width: 2;"
                + "-fx-border-radius: 15;"
        );

        // =========================
        // ABOUT SDG 6
        // =========================

        Label aboutTitle = new Label("🌍 What is SDG 6?");
        aboutTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        aboutTitle.setTextFill(Color.web(DARK_BLUE));

        Label aboutText = new Label(
                "SDG 6 focuses on ensuring the availability and "
                + "sustainable management of water and sanitation for all."
        );

        aboutText.setFont(Font.font("Arial", 14));
        aboutText.setWrapText(true);

        VBox aboutCard = new VBox(10, aboutTitle, aboutText);
        aboutCard.setPadding(new Insets(18));

        aboutCard.setStyle(
                "-fx-background-color: " + LIGHT_BLUE + ";"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // PERSONAL SECTION
        // =========================

        Label nameTitle = new Label("👤 Become a Water Hero");
        nameTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        nameTitle.setTextFill(Color.web(DARK_BLUE));

        Label nameLabel = new Label("Your Name");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setPrefHeight(38);

        Label activityLabel = new Label("Choose your main action");

        ComboBox<String> activityBox = new ComboBox<>();

        activityBox.getItems().addAll(
                "Turn off tap while brushing",
                "Take shorter showers",
                "Reuse water",
                "Fix leaking taps",
                "Collect rainwater"
        );

        activityBox.setPromptText("Select an activity");
        activityBox.setPrefWidth(300);
        activityBox.setPrefHeight(38);

        VBox personalCard = new VBox(
                10,
                nameTitle,
                nameLabel,
                nameField,
                activityLabel,
                activityBox
        );

        personalCard.setPadding(new Insets(18));

        personalCard.setStyle(
                "-fx-background-color: white;"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // CHECKBOXES
        // =========================

        Label actionsTitle = new Label("☑️ My Water-Saving Actions");
        actionsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        actionsTitle.setTextFill(Color.web(DARK_BLUE));

        CheckBox tapCheck =
                new CheckBox("Turn off taps when not needed");

        CheckBox leakCheck =
                new CheckBox("Fix or report water leaks");

        CheckBox reuseCheck =
                new CheckBox("Reuse water whenever possible");

        CheckBox rainCheck =
                new CheckBox("Collect rainwater");

        VBox actions = new VBox(
                9,
                actionsTitle,
                tapCheck,
                leakCheck,
                reuseCheck,
                rainCheck
        );

        actions.setPadding(new Insets(18));

        actions.setStyle(
                "-fx-background-color: " + LIGHT_GREEN + ";"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // GOAL SECTION
        // =========================

        Label goalTitle = new Label("🎯 Choose Your Goal");
        goalTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        goalTitle.setTextFill(Color.web(DARK_BLUE));

        RadioButton easyGoal =
                new RadioButton("Start Small");

        RadioButton mediumGoal =
                new RadioButton("Water Saver");

        RadioButton heroGoal =
                new RadioButton("Water Hero");

        ToggleGroup goalGroup = new ToggleGroup();

        easyGoal.setToggleGroup(goalGroup);
        mediumGoal.setToggleGroup(goalGroup);
        heroGoal.setToggleGroup(goalGroup);

        easyGoal.setSelected(true);

        VBox goals = new VBox(
                8,
                goalTitle,
                easyGoal,
                mediumGoal,
                heroGoal
        );

        goals.setPadding(new Insets(18));

        goals.setStyle(
                "-fx-background-color: white;"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // SLIDER
        // =========================

        Label effortTitle = new Label(
                "💪 How much effort will you give today?"
        );

        effortTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 16)
        );

        Slider effortSlider = new Slider(0, 100, 50);
        effortSlider.setShowTickLabels(true);
        effortSlider.setShowTickMarks(true);
        effortSlider.setMajorTickUnit(25);

        Label effortValue = new Label("50% effort");

        effortValue.setFont(
                Font.font("Arial", FontWeight.BOLD, 14)
        );

        effortSlider.valueProperty().addListener(
                (obs, oldValue, newValue) ->
                        effortValue.setText(
                                (int) newValue.doubleValue()
                                + "% effort"
                        )
        );

        VBox effortBox = new VBox(
                8,
                effortTitle,
                effortSlider,
                effortValue
        );

        effortBox.setPadding(new Insets(18));

        effortBox.setStyle(
                "-fx-background-color: " + LIGHT_BLUE + ";"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // PROGRESS
        // =========================

        Label progressTitle =
                new Label("📊 Your Water Hero Score");

        progressTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 20)
        );

        ProgressBar progressBar =
                new ProgressBar(0);

        progressBar.setPrefWidth(380);
        progressBar.setPrefHeight(20);

        ProgressIndicator progressIndicator =
                new ProgressIndicator(0);

        progressIndicator.setPrefSize(90, 90);

        Label progressLabel =
                new Label("0%");

        progressLabel.setFont(
                Font.font("Arial", FontWeight.BOLD, 22)
        );

        Label achievement =
                new Label("Complete actions to earn your badge!");

        achievement.setFont(
                Font.font("Arial", FontWeight.BOLD, 14)
        );

        achievement.setWrapText(true);

        VBox progressInfo = new VBox(
                8,
                progressTitle,
                progressBar,
                achievement
        );

        progressInfo.setAlignment(Pos.CENTER_LEFT);

        HBox progressCard = new HBox(
                20,
                progressInfo,
                progressIndicator
        );

        progressCard.setAlignment(Pos.CENTER);

        progressCard.setPadding(new Insets(18));

        progressCard.setStyle(
                "-fx-background-color: white;"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // CALCULATE BUTTON
        // =========================

        Button calculateButton =
                new Button("💧 CALCULATE MY SCORE");

        calculateButton.setFont(
                Font.font("Arial", FontWeight.BOLD, 15)
        );

        calculateButton.setTextFill(Color.WHITE);

        calculateButton.setPadding(
                new Insets(12, 25, 12, 25)
        );

        calculateButton.setStyle(
                "-fx-background-color: linear-gradient("
                + "to right, #0077B6, #00B4D8);"
                + "-fx-background-radius: 25;"
        );

        // =========================
        // CLEAR BUTTON
        // =========================

        Button clearButton =
                new Button("🔄 Clear");

        clearButton.setFont(
                Font.font("Arial", FontWeight.BOLD, 14)
        );

        clearButton.setPadding(
                new Insets(12, 25, 12, 25)
        );

        // =========================
        // CALCULATE ACTION
        // =========================

        calculateButton.setOnAction(e -> {

            int count = 0;

            if (tapCheck.isSelected()) count++;
            if (leakCheck.isSelected()) count++;
            if (reuseCheck.isSelected()) count++;
            if (rainCheck.isSelected()) count++;

            double actionScore = count / 4.0;

            double effortScore =
                    effortSlider.getValue() / 100.0;

            double finalScore =
                    (actionScore * 0.7)
                    + (effortScore * 0.3);

            progressBar.setProgress(finalScore);
            progressIndicator.setProgress(finalScore);

            int percentage =
                    (int) (finalScore * 100);

            progressLabel.setText(
                    percentage + "%"
            );

            String name =
                    nameField.getText().trim();

            if (name.isEmpty()) {
                name = "Water Hero";
            }

            if (percentage >= 80) {

                achievement.setText(
                        "🏆 Amazing, " + name
                        + "! You earned the WATER HERO badge!"
                );

            } else if (percentage >= 50) {

                achievement.setText(
                        "🌱 Great work, " + name
                        + "! Keep saving water!"
                );

            } else {

                achievement.setText(
                        "💙 Keep going, " + name
                        + "! Every drop matters!"
                );
            }
        });

        // =========================
        // CLEAR ACTION
        // =========================

        clearButton.setOnAction(e -> {

            nameField.clear();

            activityBox.setValue(null);

            tapCheck.setSelected(false);
            leakCheck.setSelected(false);
            reuseCheck.setSelected(false);
            rainCheck.setSelected(false);

            easyGoal.setSelected(true);

            effortSlider.setValue(50);

            progressBar.setProgress(0);
            progressIndicator.setProgress(0);

            progressLabel.setText("0%");

            achievement.setText(
                    "Complete actions to earn your badge!"
            );
        });

        HBox buttons =
                new HBox(15, calculateButton, clearButton);

        buttons.setAlignment(Pos.CENTER);

        // =========================
        // WATER-SAVING TIPS
        // =========================

        Label tipsTitle =
                new Label("💡 QUICK WATER-SAVING TIPS");

        tipsTitle.setFont(
                Font.font("Arial", FontWeight.BOLD, 20)
        );

        tipsTitle.setTextFill(Color.web(DARK_BLUE));

        Label tips =
                new Label(
                        "💧 Turn off the tap while brushing\n"
                        + "🚿 Take shorter showers\n"
                        + "🌧️ Collect rainwater\n"
                        + "🔧 Repair leaking taps\n"
                        + "🌱 Reuse water whenever possible"
                );

        tips.setFont(Font.font("Arial", 14));
        tips.setLineSpacing(5);

        VBox tipsCard =
                new VBox(10, tipsTitle, tips);

        tipsCard.setPadding(new Insets(18));

        tipsCard.setStyle(
                "-fx-background-color: " + LIGHT_BLUE + ";"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // FOOTER QUOTE
        // =========================

        Label footer =
                new Label(
                        "🌊 \"Be the change. Protect every drop.\" 🌱"
                );

        footer.setFont(
                Font.font("Arial", FontWeight.BOLD, 16)
        );

        footer.setTextFill(Color.WHITE);
        footer.setAlignment(Pos.CENTER);

        HBox footerBox =
                new HBox(footer);

        footerBox.setAlignment(Pos.CENTER);

        footerBox.setPadding(new Insets(18));

        footerBox.setStyle(
                "-fx-background-color: " + DARK_BLUE + ";"
                + "-fx-background-radius: 15;"
        );

        // =========================
        // MAIN LAYOUT
        // =========================

        VBox content = new VBox(
                15,
                header,
                quoteCard,
                aboutCard,
                personalCard,
                actions,
                goals,
                effortBox,
                progressCard,
                buttons,
                tipsCard,
                footerBox
        );

        content.setPadding(new Insets(20));

        content.setStyle(
                "-fx-background-color: linear-gradient("
                + "to bottom, #EAFBFF, #D8F3DC);"
        );

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background: #EAFBFF;"
                + "-fx-background-color: #EAFBFF;"
        );

        // =========================
        // SCENE
        // =========================

        Scene scene =
                new Scene(scrollPane, 720, 850);

        stage.setTitle(
                "SDG 6 - Clean Water & Sanitation"
        );

        stage.setScene(scene);

        stage.setMinWidth(650);
        stage.setMinHeight(700);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
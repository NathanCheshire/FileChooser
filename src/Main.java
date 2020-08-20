import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        //https://docs.oracle.com/javase/8/javafx/api/javafx/embed/swing/JFXPanel.html
        final JFXPanel fxPanel = new JFXPanel();
        Platform.runLater(() -> initFX(fxPanel, "Choose any file"));
    }

    private static void initFX(JFXPanel fxPanel, String title) {
        try {
            Stage primaryStage = new Stage();
            HBox root = new HBox();
            Scene scene = new Scene(root, 1, 1);
            fxPanel.setScene(scene);
            primaryStage.getIcons().add(new Image("CyderIcon.png"));
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.toBack();
            FileChooser fc = new FileChooser();
            fc.setTitle(title);
            File f = fc.showOpenDialog(primaryStage);
            BufferedWriter writ = new BufferedWriter(new FileWriter("File.txt"));
            writ.write(f + "");
            writ.newLine();
            writ.flush();
            writ.close();

            System.exit(0);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
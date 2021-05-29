import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        stage = primaryStage;
        scene = new Scene(loadFXML("ProgramWindow"));
        //stage.getIcons().add(new Image(App.class.getResourceAsStream("icon.png")));
        primaryStage.setTitle("Models.Solver");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    static Scene getRoot(){
        return scene;
    }
    static Stage getStage(){
        return stage;
    }
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void setResizable(boolean b){
        stage.setResizable(b);
    }

}

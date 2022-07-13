import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/Layout.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setTitle("TESTING");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }
}

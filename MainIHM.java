package IHM;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainIHM extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        Group root = new Group();

        Scene scene = new Scene(root, 600, 500);       
        stage.setResizable(false);//empecher d'agrandir ou de réduire la fenêtre ainsi que de la resize comme on le veut
        

        LinearGradient linearGrad;                
        linearGrad = new LinearGradient(                
                0,   // start X 
                0,   // start Y
                0,   // end X
                1, // end Y                              
                true, // proportional        
                CycleMethod.REFLECT, // cycle colors    
                // stops
                new Stop(0.1f, Color.rgb(176, 220, 230, .6)),
                new Stop(1.0f, Color.rgb(0, 0,0, .0)));
        scene.setFill(linearGrad);
        
        stage.getIcons().add(new Image("file:chat-bulle.jpg"));

        
        ClientAuth ca = new ClientAuth();
        root.getChildren().add(ca);  
        stage.setTitle("Sign in");
        stage.setScene(scene);
        stage.show();    
 
      
        
/*
        ClientAccount cac = new ClientAccount();
        root.getChildren().add(cac);
        
        stage.setTitle("Sign up");
        stage.setScene(scene);
        stage.show();  
*/
        //if connecté
        /*ClientPanel cp = new ClientPanel();
        root.getChildren().add(cp);
        stage.setHeight(500);
        stage.setWidth(600);
        stage.setTitle("Messagerie");
        scene.setFill(Color.WHITE); //force le fond blanc pour empecher le degradé

        stage.setScene(scene);
        stage.show();    */
    } 
    public void second(Stage stage) throws Exception {
        
        Group root = new Group();

        Scene scene = new Scene(root, 600, 500);       
        stage.setResizable(false);//empecher d'agrandir ou de réduire la fenêtre ainsi que de la resize comme on le veut
        
        
        VBox box = new VBox();
        scene = new Scene(box, 400, 400);
        scene.setFill(null);

        ClientAccount cac = new ClientAccount();
        root.getChildren().add(cac);
        
        stage.setTitle("Sign up");
        scene.setFill(Color.ALICEBLUE);
        stage.setScene(scene);
        stage.show();  
       

    } 
    public static void main(String[] args) {
        Application.launch(MainIHM.class, args);


    }
}

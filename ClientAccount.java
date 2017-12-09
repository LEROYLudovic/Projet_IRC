package IHM;

import java.awt.Graphics;
import java.awt.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ClientAccount extends Parent{
 
    private TextField textToSendNdc;// Zone de texte permettant de saisir le nom de compte
    private PasswordField  textToSendMdp;
    private PasswordField textToSendMdpRepeat;
    private Button sendBtn;
    private Button sendCompte;
    private Text textWelcome;
    private Text textPseudo;
    private Text textPassword;
    private Text textRepeatPassword;
    private Text textCompte;
    
    final Font times30BoldItalicFont = Font.font("arial", FontWeight.BOLD, FontPosture.ITALIC, 30);
    final Font times20ItalicFont = Font.font("arial", FontPosture.ITALIC, 20);
    final Font times15ItalicFont = Font.font("arial", FontPosture.ITALIC, 15);

    public ClientAccount(){
       
        textWelcome = new Text();
        textWelcome.setText("Création de votre compte :");
        textWelcome.setLayoutX(130);
        textWelcome.setLayoutY(60);
        textWelcome.setFont(times30BoldItalicFont);
        
        textPseudo = new Text();
        textPseudo.setText("Saisir un pseudo :");
        textPseudo.setLayoutX(150);
        textPseudo.setLayoutY(145);
        textPseudo.setFont(times15ItalicFont);

        textPassword= new Text();
        textPassword.setText("Saisir un mot de passe :");
        textPassword.setLayoutX(150);
        textPassword.setLayoutY(230);
        textPassword.setFont(times15ItalicFont);
        
        textRepeatPassword= new Text();
        textRepeatPassword.setText("Retapez le mot de passe :");
        textRepeatPassword.setLayoutX(150);
        textRepeatPassword.setLayoutY(280);
        textRepeatPassword.setFont(times15ItalicFont);
       
        textToSendNdc = new TextField();
        textToSendNdc.setLayoutX(150);
        textToSendNdc.setLayoutY(150);
        textToSendNdc.setPrefHeight(10);
        textToSendNdc.setPrefWidth(300);
        textToSendNdc.setEditable(true);
        
        textToSendMdp = new PasswordField();
        textToSendMdp.setLayoutX(150);
        textToSendMdp.setLayoutY(235);
        textToSendMdp.setPrefHeight(10);
        textToSendMdp.setPrefWidth(300);
        textToSendMdp.setEditable(true);
        
        textToSendMdpRepeat = new PasswordField();
        textToSendMdpRepeat.setLayoutX(150);
        textToSendMdpRepeat.setLayoutY(285);
        textToSendMdpRepeat.setPrefHeight(10);
        textToSendMdpRepeat.setPrefWidth(300);
        textToSendMdpRepeat.setEditable(true);
    
        sendBtn= new Button();
        sendBtn.setText("Création du compte");
        sendBtn.setLayoutX(150);
        sendBtn.setLayoutY(350);
        sendBtn.setPrefWidth(140);
        sendBtn.setPrefHeight(50);
        sendBtn.setVisible(true);
        sendBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("test");            
            }       
        });
       
        sendCompte = new Button();
        sendCompte.setText("Menu connexion");
        sendCompte.setLayoutX(310);
        sendCompte.setLayoutY(350);
        sendCompte.setPrefWidth(140);
        sendCompte.setPrefHeight(50);
        sendCompte.setVisible(true);
       /* sendBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Label label = new Label();
                if (textToSend.getText().isEmpty() ){
                } else { 
                    label.setText(textToSend.getText()+"\n");
                    label.setPrefWidth(400);

                    receivedText.getChildren().add(label);
                    textToSend.setText("");
                  }                         
            
        });*/    
        this.getChildren().add(textToSendNdc);
        this.getChildren().add(textToSendMdp);
        this.getChildren().add(textToSendMdpRepeat);
        this.getChildren().add(textWelcome);
        this.getChildren().add(textPseudo);
        this.getChildren().add(textPassword);
        this.getChildren().add(textRepeatPassword);
        this.getChildren().add(sendBtn);
        this.getChildren().add(sendCompte);
    }  
}

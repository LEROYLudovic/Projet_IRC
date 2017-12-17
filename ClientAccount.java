package IHM;

import javafx.scene.input.KeyEvent;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.awt.FlowLayout;
import javafx.scene.Cursor;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import static javafx.scene.text.Font.font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ClientAccount extends Parent{
 
    private TextField textToSendNdc;// Zone de texte permettant de saisir le nom de compte
    private PasswordField  textToSendMdp;
    private PasswordField textToSendMdpRepeat;
    private TextArea textToSendMdpRepeatAnnot;
    private TextArea textToSendMdpAnnot;
    private TextArea textToSendNdcAnnot;
    private Button sendBtn;
    private Button sendCompte;
    private Text textWelcome;
    private Text textPseudo;
    private Text textPassword;
    private Text textRepeatPassword;
    private Text textCompte;
    private ProgressIndicator valid;
    
    final Font times30BoldItalicFont = Font.font("arial", FontWeight.BOLD, FontPosture.ITALIC, 30);
    final Font times20ItalicFont = Font.font("arial", FontPosture.ITALIC, 20);
    final Font times15ItalicFont = Font.font("arial", FontPosture.ITALIC, 15);

    public ClientAccount(){
       
        textWelcome = new Text();
        textWelcome.setText("Création de votre compte :");
        textWelcome.setLayoutX(120);
        textWelcome.setLayoutY(70);
        textWelcome.setFont(times30BoldItalicFont);
      
        Reflection refl = new Reflection();
        refl.setFraction(0.5f);
        textWelcome.setEffect(refl);
        
        
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
        textToSendNdc.clear();
        textToSendNdcAnnot = new TextArea( "Votre pseudo doit\n" +
    "au minimum contenir\n" + "4 caractères et ne\n" +"pas inclure de carac-\n"
                +"tères spéciaux :\n"+ 
                "( , ; : ! ? . / % { * & \" ..."); //interdit , ; : ! ? . / § ù % µ * £ $ ¤ + = } ) ° ] @ ^ \ ` | ( [ ' { " # ~ & < >
        textToSendNdcAnnot.setLayoutX(5);
        textToSendNdcAnnot.setLayoutY(150);
        textToSendNdcAnnot.setPrefHeight(110);
        textToSendNdcAnnot.setPrefWidth(140);
        textToSendNdcAnnot.setVisible(false);
        textToSendNdcAnnot.setFont(font("default", FontPosture.ITALIC, 12));
        //textToSendNdc.selectionProperty().addListener(observable -> System.out.println("Sélection modifiée dans le champ d'édition !"));
        //textToSendNdc.copy();
        textToSendNdc.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent ke) {
            System.out.println("Key Pressed for pseudo : " + ke.getText());
        }
        });
        textToSendNdc.setOnKeyReleased(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent ke) {
            System.out.println("Key Released for pseudo: " + ke.getText());
        }
        });
        textToSendNdc.setOnMouseEntered(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
            System.out.println("Mouse entered");
            textToSendNdcAnnot.setVisible(true);
        }
        });

        textToSendNdc.setOnMouseExited(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
            System.out.println("Mouse exited");
            textToSendNdcAnnot.setVisible(false);
        }
        });

        //textToSendNdc.setDocument(new TStringField(10));


        TextFormatter<?> integerOnlyFormatter = null;
        textToSendNdc.setTextFormatter(integerOnlyFormatter); /*le filtrage des modifications apportées au contenu du contrôle de saisie (
           ex. : éviter la saisie de certains caractères); convertir le texte saisi dans le contrôle par l'utilisateur en une valeur de type V 
           qui sera contenue dans la propriété value du formateur. Dans le cas où le programmeur modifie la propriété value du formateur, 
           celui-ci convertira alors la valeur en texte à afficher dans le contrôle de saisie.*/
 /* final UnaryOperator<TextFormatter.Change> integerOnlyFilter = change -> { 
    final String text = change.getText(); 
    return (text.isEmpty() || text .matches("[0-9]")) ? change : null; 
}; 
final TextFormatter<Integer> integerOnlyFormatter = new TextFormatter(integerOnlyFilter);*/
        textToSendMdp = new PasswordField();
        textToSendMdp.setLayoutX(150);
        textToSendMdp.setLayoutY(235);
        textToSendMdp.setPrefHeight(10);
        textToSendMdp.setPrefWidth(300);
        textToSendMdp.setEditable(true);
        textToSendMdp.clear();
       textToSendMdpAnnot = new TextArea( "Votre mot de passe\n" +
    "doit au minimum\n" + "contenir 6 caractères\n" +"et ne pas inclure de\n"
                +"caractères spéciaux :\n"+ 
                "( , ; : ! ? . / % { * & \" ..."); //interdit , ; : ! ? . / § ù % µ * £ $ ¤ + = } ) ° ] @ ^ \ ` | ( [ ' { " # ~ & < >
        textToSendMdpAnnot.setLayoutX(5);
        textToSendMdpAnnot.setLayoutY(220);
        textToSendMdpAnnot.setPrefHeight(110);
        textToSendMdpAnnot.setPrefWidth(140);
        textToSendMdpAnnot.setVisible(false);
        textToSendMdpAnnot.setFont(font("default", FontPosture.ITALIC, 12));
        textToSendMdp.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent ke) {
            System.out.println("Key Pressed for first password: " + ke.getText());          
        }
        });
        textToSendMdp.setOnKeyReleased(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent ke) {
            System.out.println("Key Released for first password: " + ke.getText());
        }
        });
        
        textToSendMdp.setOnMouseEntered(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
            System.out.println("Mouse entered");
            textToSendMdpAnnot.setVisible(true);
        }
        });

        textToSendMdp.setOnMouseExited(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
            System.out.println("Mouse exited");
            textToSendMdpAnnot.setVisible(false);
        }
        });

        textToSendMdpRepeat = new PasswordField();
        textToSendMdpRepeat.setLayoutX(150);
        textToSendMdpRepeat.setLayoutY(285);
        textToSendMdpRepeat.setPrefHeight(10);
        textToSendMdpRepeat.setPrefWidth(300);
        textToSendMdpRepeat.setEditable(true);
        textToSendMdpRepeat.clear(); 
        textToSendMdpRepeatAnnot = new TextArea( " Retapez le même \n" +
    " mot de passe" );
        textToSendMdpRepeatAnnot.setLayoutX(25);
        textToSendMdpRepeatAnnot.setLayoutY(285);
        textToSendMdpRepeatAnnot.setPrefHeight(50);
        textToSendMdpRepeatAnnot.setPrefWidth(120);
        textToSendMdpRepeatAnnot.setVisible(false);
        textToSendMdpRepeat.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent ke) {
            System.out.println("Key Pressed for second password: " + ke.getText());
        }
        });
        textToSendMdpRepeat.setOnKeyReleased(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent ke) {
            System.out.println("Key Released for second password: " + ke.getText());
        }
        });       

        textToSendMdpRepeat.setOnMouseEntered(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
            System.out.println("Mouse entered");
            textToSendMdpRepeatAnnot.setVisible(true);
        }
        });

        textToSendMdpRepeat.setOnMouseExited(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
            System.out.println("Mouse exited");
            textToSendMdpRepeatAnnot.setVisible(false);
        }
        });
        
        sendBtn= new Button();
        sendBtn.setText("Création du compte");
        sendBtn.setLayoutX(150);
        sendBtn.setLayoutY(380);
        sendBtn.setPrefWidth(140);
        sendBtn.setPrefHeight(50);
        sendBtn.setVisible(true);
        sendBtn.setTextFill(Color.BLACK);
        sendBtn.setDefaultButton(true);  
      
        valid = new ProgressIndicator();
        valid.setLayoutX(95);
        valid.setLayoutY(380);
        valid.setVisible(false);
        sendBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
        System.out.println("Mouse entered");
        sendBtn.setCursor(Cursor.HAND);
        }
        });

        sendBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
        System.out.println("Mouse exited");
        sendBtn.setCursor(Cursor.DEFAULT);

        }
        });

        sendBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
        System.out.println("Mouse pressed");
        valid.setVisible(true);
        sendBtn.setCursor(Cursor.WAIT);

        }
        //si le ndc fait minimum 4 caractère et ne contient pas de caractere speciaux et le mot de passe fait minimum 6 caractères et ne contient pas de caractere speciaux =
        //basculer sur la fenetre Sign in pour pouvoir se connecter en affichant 
        //"Votre compte à été créer avec succès" en vert sur celui-ci
        //sinon si votre pseudo fait moins de quatre caractères (pseudo <4)
        //afficher "votre pseudo doit au minimum contenir six caractères" en rouge
        //sinon si pseudo contient caractere speciaux  (pseudo = * || ^ etc)
        //afficher "votre pseudo contient des caractères spéciaux" en rouge
        //sinon si mot de passe fait moins de six caractere  (mdp <6)
        //afficher "votre mot de passe fait moins de 6 caracteres" en rouge
        //sinon si mdp contient caractere speciaux (mdp = * || ^ etc)
        //afifcher "votre mot de passe contient des caractères speciaux" en rouge
        //sinon si mot de passe repeter n'est pas égale au mdp entrer (mdp2 != mdp)
        //afficher "vos mots de passe ne correspondent pas" en rouge
        //sinon si aucun pseudo ni mdp na etait rentrer (pseudo == "" || mdp == "")
        //griser le bouton création du compte pour empecher le clique dessus                   
        });
        valid.setVisible(false);

        sendCompte = new Button();
        sendCompte.setText("Menu connexion");
        sendCompte.setLayoutX(310);
        sendCompte.setLayoutY(380);
        sendCompte.setPrefWidth(140);
        sendCompte.setPrefHeight(50);
        sendCompte.setVisible(true);
        sendCompte.setTextFill(Color.MIDNIGHTBLUE);
        sendCompte.setDefaultButton(false);

        sendCompte.setOnMouseEntered(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
        System.out.println("Mouse entered");
        sendCompte.setCursor(Cursor.HAND);
        }
        });

        sendCompte.setOnMouseExited(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
        System.out.println("Mouse exited");
        sendCompte.setCursor(Cursor.DEFAULT);
        }
        });

        sendCompte.setOnMousePressed(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
        System.out.println("Mouse pressed");
        sendCompte.setCursor(Cursor.WAIT);
        }                       
        });   
       
        Line lineup = new Line(150, 100,   450,   100);
        lineup.setStroke(Color.GREY);
        lineup.setStrokeWidth(1);

        Line linelow = new Line(150, 360,   450,   360);
        linelow.setStroke(Color.GREY);
        linelow.setStrokeWidth(1);
        
        this.getChildren().add(textToSendNdc);
        this.getChildren().add(textToSendMdp);     
        this.getChildren().add(textToSendMdpRepeat);
        this.getChildren().add(textToSendNdcAnnot);
        this.getChildren().add(textToSendMdpAnnot);
        this.getChildren().add(textToSendMdpRepeatAnnot);
        this.getChildren().add(textWelcome);
        this.getChildren().add(textPseudo);
        this.getChildren().add(textPassword);
        this.getChildren().add(textRepeatPassword);
        this.getChildren().add(sendBtn);
        this.getChildren().add(sendCompte);
        this.getChildren().add(valid);
        this.getChildren().add(lineup);
        this.getChildren().add(linelow);
    }  
}

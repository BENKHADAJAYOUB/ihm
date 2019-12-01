
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactnatation;

import javax.mail.internet.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ayoub benkhadaj
 */
public class ContactNatation extends Application {
private void showAlertWithoutHeaderText() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mail envoyer");
 
        // Header Text: null
        alert.setHeaderText("mdr");
        alert.setContentText("Mail successfully!");
 
        alert.showAndWait();
    }
    @Override
    public void start(Stage primaryStage) {
        Image im = new Image(getClass().getResourceAsStream("img2.jpg"));
        ImageView iv = new ImageView(im);

        Image im1 = new Image(getClass().getResourceAsStream("r1.jpg"));
        ImageView iv1 = new ImageView(im1);

        //ScrollBar x = new ScrollBar();
//        x.prefWidth(160);
//        x.prefHeight(800);
//        x.setLayoutX(987);
//        x.setLayoutY(0);
        //x.setOrientation(Orientation.VERTICAL);
        iv1.setFitHeight(367);//regler height photo 
        iv1.setFitWidth(1000);

        iv1.setLayoutX(0);
        iv1.setLayoutY(124);
        iv.setLayoutX(28);
        iv.setLayoutY(33);
        iv.setFitHeight(75.0);//regler height photo 
        iv.setFitWidth(94.0);//regler width photo
        Pane root = new Pane();
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(root);//container= = pane
        //color pane
        root.setStyle("-fx-background-color:WHITE");
        //Hyperlink ACCUEIL
        scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        Hyperlink ACCUEIL = new Hyperlink("ACCUEIL");
        ACCUEIL.setLayoutX(129);
        ACCUEIL.setLayoutY(67);
        // Hyperlink COMPETITION
        Hyperlink COMPETITION = new Hyperlink("COMPETITION");
        COMPETITION.setLayoutX(198);
        COMPETITION.setLayoutY(67);
        //Hyperlink CRENAUX
        Hyperlink CRENAUX = new Hyperlink("CRENAUX");
        CRENAUX.setLayoutX(295);
        CRENAUX.setLayoutY(67);
        //Hyperlink CONTACT
        Hyperlink CONTACT = new Hyperlink("CONTACT");
        CONTACT.setLayoutX(370);
        CONTACT.setLayoutY(67);
        //Hyperlink GALERIES
        Hyperlink GALERIES = new Hyperlink("GALERIES");
        GALERIES.setLayoutX(452);
        GALERIES.setLayoutY(67);
        //Hyperlink LIENS
        Hyperlink LIENS = new Hyperlink("LIENS");
        LIENS.setLayoutX(535);
        LIENS.setLayoutY(67);
        //Hyperlink DOCUMENTS
        Hyperlink DOCUMENTS = new Hyperlink("DOCUMENTS");
        DOCUMENTS.setLayoutX(599);
        DOCUMENTS.setLayoutY(67);
        //Button S'INSCRIRE
        Button SINSC = new Button("S'INSCRIRE");
        SINSC.setLayoutX(707);
        SINSC.setLayoutY(63);
        //Button ESPACE COMPETITEUR
        Button espComp = new Button("ESPACE COMPETITEUR");
        espComp.setLayoutX(804);
        espComp.setLayoutY(63);
        //Label CONTACT
        Label cntct = new Label("CONTACT");
        cntct.setLayoutX(473);
        cntct.setLayoutY(529);
        cntct.setAlignment(Pos.CENTER);
        //Label Votre Courriel
        Label mailLab = new Label("Votre Courriel  * :");
        mailLab.setLayoutX(319);
        mailLab.setLayoutY(594);
        //Label Object email 
        Label objLab = new Label("Object email * :");
        objLab.setLayoutX(330);
        objLab.setLayoutY(638);
        //Label("Message
        Label msg = new Label("Message : ");
        msg.setLayoutX(258);
        msg.setLayoutY(709);
        //TEXTAREA MESSAGE
        TextArea messagearea = new TextArea();
        messagearea.setPromptText("Saisir votre message");
        messagearea.setLayoutX(246);
        messagearea.setLayoutY(734);
        //TextField mail 
        TextField mail = new TextField();
        mail.setPromptText("Saisir votre mail");//plac holder
        mail.setLayoutX(438);
        mail.setLayoutY(589);
        TextField object = new TextField();
        object.setPromptText("Objet mail");
        object.setLayoutX(439);
        object.setLayoutY(634);//679949
        Button env = new Button("Envoyer");
        env.setLayoutX(662);
        env.setLayoutY(949);
        EventHandler<ActionEvent> a3 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  final String username = "ayoubbenkhadaj@gmail.com";//change accordingly
                final String password = "bahloAKLIM123";//change accordingly
                Properties prop = new Properties();
                prop.put("mail.smtp.auth", "true");
                 prop.put("mail.smtp.starttls.enable", "true");
                prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//                prop.put("mail.smtp.socketFactory.port", "465");
//                prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

                prop.put("mail.smtp.port", "587");//
                Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                               username, password);
                    }
                });
                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("ayoubbenkhadaj@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getText()));
                    message.setSubject(object.getText());
                    message.setText(messagearea.getText());
                    Transport.send(message);
                    showAlertWithoutHeaderText() ;
//                    JOptionPane.showMessageDialog(null, "Mail envoyer");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

            }

        };
        env.addEventHandler(ActionEvent.ACTION, a3);
        root.getChildren().add(iv);
        root.getChildren().add(iv1);
        root.getChildren().add(ACCUEIL);
        root.getChildren().add(COMPETITION);
        root.getChildren().add(CRENAUX);
        root.getChildren().add(CONTACT);
        root.getChildren().add(LIENS);
        root.getChildren().add(DOCUMENTS);
        root.getChildren().add(espComp);
        root.getChildren().add(GALERIES);
        root.getChildren().add(SINSC);
        root.getChildren().add(cntct);
        root.getChildren().add(mail);
        root.getChildren().add(object);
        root.getChildren().add(mailLab);
        root.getChildren().add(objLab);
        root.getChildren().add(msg);
        root.getChildren().add(messagearea);
        root.getChildren().add(env);
        Scene scene = new Scene(scroll, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

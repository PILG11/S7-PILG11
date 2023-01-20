package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import javax.swing.AbstractAction;

public class ActionEnvoyerMessageClient extends AbstractAction{

    private String email;
    private String message;

    public ActionEnvoyerMessageClient(String email, String message){
        this.message = message;
        this.email = email;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println(message);
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
    
            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("emailjavaldb@gmail.com", "LesLogisDeBeaulieu");
                        }
                    });
    
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("emailjavaldb@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(this.email)
                );
                message.setSubject("Test Email");
                message.setText("Hello, this is a test email");
    
                Transport.send(message);
    
                System.out.println("Email sent successfully");
            } catch (MessagingException error) {
                error.printStackTrace();
            }
        
        
    }
    
}

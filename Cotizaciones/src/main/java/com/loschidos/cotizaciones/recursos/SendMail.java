package com.loschidos.cotizaciones.recursos;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.*;
import javax.mail.internet.*;

import com.loschidos.cotizaciones.entity.Cotizacion;

public class SendMail {
    Date fechaHoy = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("ddd-MM-yyyy");
    SimpleDateFormat formatohora = new SimpleDateFormat("hh:mm aa");
       
    long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
       
    public void EnviarCorreo(Cotizacion cotizacion) {
    	String host ="smtp.gmail.com" ;
        String user = "angel.osorio2602@gmail.com";
        String pass = "Nachtgestalt06";
        String from = "angel.osorio2602@gmail.com";
        String destinatario = cotizacion.getEmail();
        System.out.println(destinatario);
        try{   
            //  Propiedades de la conexión
            Properties props = new Properties();
            // Nombre del host de correo, es smtp.gmail.com
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            // TLS si está disponible
            props.setProperty("mail.smtp.starttls.enable", "true");
            // Puerto de gmail para envio de correos
            props.setProperty("mail.smtp.port","587");
            // Nombre del usuario
            props.setProperty("mail.smtp.user", user);
            // Si requiere o no usuario y password para conectarse.
            props.setProperty("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);
            
            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText("Texto del mensaje");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(
                new DataHandler(new FileDataSource("src/Reporte.pdf")));
            adjunto.setFileName("src/Reporte.pdf");

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            
            MimeMessage message = new MimeMessage(session);
            
            // Quien envia el correo
            message.setFrom(new InternetAddress(from));
            // A quien va dirigido
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress("doktortrash@gmail.com"));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress("heynalle@gmail.com"));
            message.setSubject("Cotizacion para campaña publicitaria");
            message.setText("Enviado: " + formato.format(fechaHoy) +" " +formatohora.format(fechaHoy));
            message.setContent(multiParte);
            
            Transport t = session.getTransport("smtp");
            t.connect(user,pass);
            t.sendMessage(message,message.getAllRecipients());
            System.out.println("Hasta aqui he llegado");
            t.close();           
        }catch(MessagingException ex){
        	System.out.println("No se ha podido enviar" +ex);
            String msjHeader = "¡ERROR!";
            String msjText = "Copiar y mandarlo por correo a noaydeh@hotmail.com";
        }
    }

}

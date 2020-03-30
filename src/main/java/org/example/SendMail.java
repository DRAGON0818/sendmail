package org.example;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class SendMail {

    private static int YEAR,MONTH,DAY;

    public static void main(String[] args) throws AddressException {
        Mail mail = new Mail();
        List<String> toUsers = new ArrayList<>();
        toUsers.add("donglxa@fotile.com");

        Properties props = new Properties();
        props.put("mail.smtp.ssl.enable", mail.isSSL());
        props.put("mail.smtp.host", mail.getHost());
        props.put("mail.smtp.port", mail.getPort());
        props.put("mail.smtp.auth", mail.isAuth());

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmaiUtils.username, EmaiUtils.password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(mail.getFROM());
            mail.setTO(toUsers);
            message.addRecipients(Message.RecipientType.TO, mail.getTO());
            // message.addRecipient(Message.RecipientType.CC, new InternetAddress("donglxa@fotile.com"));
            Calendar instance = Calendar.getInstance();
            YEAR = instance.get(Calendar.YEAR);
            MONTH=instance.get(Calendar.MONTH);
            DAY = instance.get(Calendar.DATE);
            String dateInfo = MONTH + "月" + DAY;
            String subject = "PLM-MDM接口" + dateInfo + "日报错信息";
            message.setSubject(subject);

            String text = EmaiUtils.BEGIN + dateInfo + "报错信息：\n" +
                    "   " + EmaiUtils.PLMTOMDM + "\n" +
                    "   " + EmaiUtils.MDMTOPLM + "\n" +
                    "   " + EmaiUtils.REQUIRETOMDM + "\n" +
                    "   " + EmaiUtils.BOM + "\n";
            message.setText(text);

            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("发送完毕！");
    }
}

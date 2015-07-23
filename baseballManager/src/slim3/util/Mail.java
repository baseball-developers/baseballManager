package slim3.util;

import java.io.IOException;
import java.util.List;

import com.google.appengine.api.mail.MailService.Message;
import com.google.appengine.api.mail.MailServiceFactory;

public class Mail {

    /**
     * メール送信
     * @param destination
     *            送信先
     * @param sender
     *            送信元
     * @param subject
     *            件名
     * @param text
     *            本文
     */
    public void sendMail(List<String> destination, String sender,
            String subject, String text) {

        try {

            Message message = new Message();
            message.setTo(destination);
            message.setSender(sender);
            message.setSubject(subject);
            message.setTextBody(text);

            MailServiceFactory.getMailService().send(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package slim3.util;

import java.io.IOException;
import java.util.List;

import com.google.appengine.api.mail.MailService.Message;
import com.google.appengine.api.mail.MailServiceFactory;

public class Mail {

    /**
     * ���[�����M
     * @param destination
     *            ���M��
     * @param sender
     *            ���M��
     * @param subject
     *            ����
     * @param text
     *            �{��
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

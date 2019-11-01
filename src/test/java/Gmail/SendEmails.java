package Gmail;

import org.apache.commons.mail.SimpleEmail;
public class SendEmails {
    /*
         first Step:
             go to  :
                  https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web
                     Make sure that your google account allows third part app
      */
    public static void main(String[] args) {
        Credentials obj = new Credentials();
        String userName = obj.getEmail(),
                passWord = obj.getPassword(),
                Receiver = "battal@cybertekschool.com",
                MSG ="Hello Battla, How are you doing today...",
                Subject ="Just small joke :)";

        for (int i = 0; i < 20; i++) {
            sendEmails( userName, passWord, Receiver, MSG , Subject);
            System.out.println("Send successfully");
        }

    }


    public static void sendEmails(String username, String password, String Receiver, String MSG, String Subject){
        SimpleEmail email=new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthentication(username, password);
        email.setSSLOnConnect(true);
        email.setSubject(Subject);
        try {
            email.setFrom(username);
            email.setMsg(MSG);
            email.addTo(Receiver);
            email.send();
            Thread.sleep(3000);
        } catch (Exception e) {   }
    }
}
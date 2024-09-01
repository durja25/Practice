import java.util.*;
import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Mail {
    public static void main(String[] args) {
        try {
            // Create a default MimeMessage object
            Properties properties = new Properties();
            Session session = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(session);






            // Set From: header field of the header
            message.setFrom(new InternetAddress("nyc.exp.lcl.cust@shipco.com"));



            // Set To: header field of the header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("PKESARKAR@SCAN-IT.COM.SG"));



            // Set Subject: header field
            message.setSubject("Shipping Instructions Received for Shipco Booking 10782602 to BANGKOK");



            // Set HTML content as the actual message
            String htmlContent = "<style>.header{text-align:left;padding:8px;border:2px solid #ddd;}</style>\r\n"
                    + "<table style=\"font-family: Arial,Helvetica,sans-serif;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"745px\">\r\n"
                    + "<tbody> <tr><td style=\"color:#333333; font-size:14px;\">Dear <b>SHIPPER TEST</b>, </td></tr><tr><td height=\"20px\">&nbsp;</td></tr><tr>\r\n"
                    + "<td style=\"color:#333333;font-size:14px;\">Thank you for submitting the following Shipping Instructions for your Booking <b>10782602</b> to BANGKOK .</td>\r\n"
                    + "</tr><tr><td height=\"20px\">&nbsp;</td></tr></tbody></table><table style=\" border-collapse:collapse;width:745px;border:1px solid black;\">\r\n"
                    + "<tbody><tr style=\"background-color:#F1F2F3;\"><th class=\"header\"style=\"width: 360px;\">Type</th><th class=\"header\"style=\"width: 360px;\">Shipping Instructions</th></tr><tr><td class=header style=vertical-align:top>Shipper/Exporter</td><td class=header style=vertical-align:top>SHIPPER TEST</br>BY PJAKKAPONG NYC</br>BANGKOK RESOURCE CENTER (THAILAND)</br>GREEN TOWER, 21 FL., RAMA IV RD.,</br>KWAENG KLONGTON, KHET KLONGTOEY</br>BANGKOK  10110</td></tr><tr><td class=header style=vertical-align:top>Consignee</td><td class=header style=vertical-align:top>SHIPPER TEST</br>BY PJAKKAPONG NYC</br>BANGKOK RESOURCE CENTER (THAILAND)</td></tr><tr><td class=header style=vertical-align:top>Forwarder</td><td class=header style=vertical-align:top></td></tr><tr><td class=header style=vertical-align:top>Notify Party</td><td class=header style=vertical-align:top>SHIPPER TEST</br>BY PJAKKAPONG NYC</br>BANGKOK RESOURCE CENTER (THAILAND)</td></tr><tr><td class=header style=vertical-align:top>Prepaid/Collect</td><td class=header style=vertical-align:top>Prepaid</td></tr><tr><td class=header style=vertical-align:top>Freight Terms</td><td class=header style=vertical-align:top>CFS / CFS</td></tr><tr><td class=header style=vertical-align:top>Export Reference</td><td class=header style=vertical-align:top></td></tr><tr><td class=header style=vertical-align:top>Point And Country Of Origin Of Goods</td><td class=header style=vertical-align:top></td></tr><tr><td class=header style=vertical-align:top>Number Of Originals</td><td class=header style=vertical-align:top>0/EXPRESS</td></tr><tr><td class=header style=vertical-align:top>Marks & Nos/Container Nos</td><td class=header style=vertical-align:top>SHIPPER TEST</br>BY PJAKKAPONG</br>NYC BANGKOK</br>RESOURCE</br>CENTER</br>(THAILAND)</td></tr><tr><td class=header style=vertical-align:top>No. of Pkgs</td><td class=header style=vertical-align:top>1</td></tr><tr><td class=header style=vertical-align:top>Description Of Packages And Goods</td><td class=header style=vertical-align:top>1</td></tr><tr><td class=header>Weight</td><td class=header style=vertical-align:top>1.000Kgs / 2.205Lbs</td></tr><tr><td class=header>Volume</td><td class=header style=vertical-align:top>1.000Cbm / 35.315Cbf</td></tr><tr><td class=header style=vertical-align:top>Comments</td><td class=header style=vertical-align:top>SHIPPER TEST</br>BY PJAKKAPONG NYC</br>BANGKOK RESOURCE CENTER (THAILAND)</td></tr></tbody>\r\n"
                    + "</table>\r\n"
                    + "<table style=\"font-family: Arial, Helvetica,sans-serif;\" cellpadding=\"0\" cellspacing=\"0\"border=\"0\"width=\"745px\"><tbody><tr><td height=\"20px\">&nbsp;</td>\r\n"
                    + "</tr><tr><td style=\" color:#333333; font-size:14px;\">A draft Bill of Lading will be sent to you shortly. If there are any issues with the requested changes, a Shipco representative will contact you directly.</td>\r\n"
                    + "</tr><tr><td height=\"20px\">&nbsp;</td></tr><tr><td style=\"color:#333333;font-size:14px;font-family: Arial, Helvetica, sans-serif;\">If you have any questions or concerns, please contact your local Shipco office. <tr><td height=\"20px\">&nbsp;</td></tr></td>\r\n"
                    + "</tr><tr><td height=\"20px\">&nbsp;</td><tr><td height=\"20px\">&nbsp;</td><tr><td style=\"color:#444444;font-size:14px; height:20px;\">Best Regards,</td>\r\n"
                    + "</tr><tr><td style=\" color:#444444; font-size:14px; height:20px;\">New York Customer Service</td></tr><tr><td style=\"color:#444444;font-size:14px; height:20px;\">New York, USA<br>nyc.exp.lcl.cust@shipco.com</td>\r\n"
                    + "</tr><tr> <td style=\"font-family:Arial, Helvetica,sans-serif; color:#444444;font-size:14px;height:20px;\"><a href=\"https://www.shipco.com/\" style=\"color:#1F336C;text-decoration:none;\">www.shipco.com</a></td>\r\n"
                    + "</tr><tr><td style=\"color:#333333;font-size:14px; height:50px;border-bottom:1px solid #EAEAEA\">Shipco is a member of the WorldWide Alliance - <a href=\"http://www.wwalliance.com\" style=\"color:#1F336C;font-size:14px;text-decoration:none;\"> www.wwalliance.com</a></td>\r\n"
                    + "</tr><tr><td height=\"15px\">&nbsp;</td></tr>";
            htmlContent = htmlContent.replace("</br>", "<br>");



            // Create the email body parts
            MimeMultipart multipart = new MimeMultipart("alternative");

            // Text part
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("This is the plain text part of the email.");

            // HTML part
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlContent, "text/html; charset=UTF-8");

            // Add text and HTML parts to the multipart
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(htmlPart);

            // Set the multipart as the email content
            message.setContent(multipart);

            // Generate .eml file from MimeMessage
            try (OutputStream os = new FileOutputStream("C:\\Users\\gkamble\\Desktop\\output.eml")) {
                message.writeTo(os,null);
                os.flush();
                os.close();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

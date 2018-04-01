package com.pltm.util;

import com.pltm.dto.Mail;
import com.pltm.dto.MailHost;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class MailUtil {

    public static Session getSmtpSession(Mail mail, MailHost mailHost) {
        Properties props = new Properties();
        props.put("mail.debug", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", mailHost.getSmtpHost());
        props.put("mail.smtp.port", mailHost.getSmtpHostPort());
        props.put("mail.smtp.auth", "true");
        Auth auth = new Auth(mail.getMailAcc(), mail.getMailAuth());
        Session session = Session.getInstance(props, auth);
        return session;
    }

    public static Store getStore(MailHost mailHost) {
        Properties props = new Properties();
        props.put("mail.store.protocol", "pop3");
        props.put("mail.pop3.host", mailHost.getPop3Host());
        props.put("mail.pop3.port", mailHost.getPop3HostPort());
        Session session = Session.getInstance(props);
        Store store = null;
        try {
            store = session.getStore();

        } catch (NoSuchProviderException e) {
            System.out.println("err in MailUtil.getStore()");
            e.printStackTrace();
        }
        return store;
    }

    public static boolean connect(Mail mail, Store store) {
        String mail_acc = mail.getMailAcc();
        String mail_auth = mail.getMailAuth();
        boolean isConnected = false;
        try {
            store.connect(mail_acc, mail_auth);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("connection err in MailUtil.connect()");
        }
        isConnected = store.isConnected();
        return isConnected;
    }

    public static Folder getFolder(Mail mail, Store store){
        if(!store.isConnected()){
            if(!connect(mail,store)){
                System.out.println("err in MailUtil.getFolder: connect failed");
                return null;
            }

        }
        Folder folder = null;
        try {
            folder = store.getFolder("INBOX");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return folder;

    }


    public static Folder openFolder(Folder folder, int type){
        try {
            if(!folder.isOpen()){
                System.out.println("folder is not opened!");
                if(type==Folder.READ_WRITE)
                    folder.open(Folder.READ_WRITE);
                else
                    folder.open(Folder.READ_ONLY);
                System.out.println("folder is opened? "+folder.isOpen());
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("openFolderR error");
        }
        return folder;

    }

    public static Multipart getAttachments(Multipart multipart, List<String> filePaths){
        for(String filePath:filePaths){
            System.out.println("filePath:"+filePath);
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);
            System.out.println("pathSeperator:"+File.separator);
            System.out.println("fileName:"+fileName);
            BodyPart bodyPart = new MimeBodyPart();
            DataSource dataSource = new FileDataSource(filePath);
            DataHandler dataHandler = new DataHandler(dataSource);
            try {
                bodyPart.setDataHandler(dataHandler);
                bodyPart.setFileName(MimeUtility.encodeText(fileName));
                multipart.addBodyPart(bodyPart);
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return multipart;
    }

}

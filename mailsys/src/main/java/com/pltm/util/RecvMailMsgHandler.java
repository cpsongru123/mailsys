package com.pltm.util;


import com.pltm.dao.MailMapper;
import com.pltm.vo.MailMessage;
import org.springframework.util.MimeTypeUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecvMailMsgHandler {

    public static String getSendData(Message message){
        Date date = null;
        String s_date = null;
        MimeMessage mimeMessage = (MimeMessage) message;
        try {
            date = mimeMessage.getSentDate();
            if(date == null)
                return null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            s_date = sdf.format(date);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return s_date;

    }

    public static String getFrom(Message message) {
        InternetAddress[] froms = null;
        try {
            froms = (InternetAddress[]) message.getFrom();
        } catch (MessagingException e) {
            e.printStackTrace();
            return "[]";
        }
        String person = null==froms[0]?"":froms[0].getPersonal();
        String address = null==froms[0]?"":froms[0].getAddress();
        return person+"["+address+"]";
    }

    public static String getFromName(Message message){
        InternetAddress[] froms = null;
        try {
            froms = (InternetAddress[]) message.getFrom();
        } catch (MessagingException e) {
            e.printStackTrace();
            return "";
        }
        String person = null==froms[0]?"":froms[0].getPersonal();
        return person;
    }

    public static String getFromAddr(Message message){
        InternetAddress[] froms = null;
        try {
            froms = (InternetAddress[]) message.getFrom();
        } catch (MessagingException e) {
            e.printStackTrace();
            return "";
        }
        String address = null==froms[0]?"":froms[0].getAddress();
        return address;
    }



    public static StringBuffer getMailContent(Part part, StringBuffer bodytext)
            throws MessagingException, IOException {
        String contenttype = part.getContentType();
        int nameindex = contenttype.indexOf("name");
        boolean conname = false;
        if (nameindex != -1)
            conname = true;
        if (part.isMimeType("text/html")&& !conname) {
            bodytext.append((String)part.getContent());
        }else if(part.isMimeType("text/plain")&& !conname){
            bodytext.append((String)part.getContent());
        }else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int count = multipart.getCount();
            boolean hasHtml = checkHasHtml(multipart);//这里校验是否有text/html内容
            for(int index = 0 ; index < count ; index++ ){
                Part temp = multipart.getBodyPart(index);
                if(temp.isMimeType("text/plain")&&hasHtml){
                    //有html格式的则不显示无格式文档的内容
                }else{
                    getMailContent(temp, bodytext);
                }
            }
        }else if (part.isMimeType("message/rfc822")) {
            getMailContent((Part) part.getContent(), bodytext);
        }else{}
        return bodytext;
    }

    public static boolean checkHasHtml(Multipart part) throws MessagingException, IOException{
        boolean hasHtml = false;
        int count = part.getCount();
        for(int i = 0 ; i < count ; i++ ){
            Part bodyPart = part.getBodyPart(i);
            if (bodyPart.isMimeType("text/html")) {
                hasHtml = true;
                break;
            }
        }
        return hasHtml;
    }





    public boolean isContainAttach(Part part){
        boolean attachflag = false;  //是否有附件
        try {
            String contentType = part.getContentType();
            if(part.isMimeType("multipart/*")){
                Multipart multipart = (Multipart) part.getContent();
                for(int i=0;i<multipart.getCount();i++){
                    BodyPart bodyPart = multipart.getBodyPart(i);
                    String disposition = bodyPart.getDisposition();
                    if((disposition != null) && (disposition.equals(Part.ATTACHMENT) || disposition.equals(Part.INLINE)))
                        attachflag = true;
                    else if(bodyPart.isMimeType("multipart/*"))
                        attachflag = isContainAttach((Part)bodyPart);
                    else{
                        String bodytype = bodyPart.getContentType();
                        if(bodytype.toLowerCase().indexOf("application") !=-1)
                            attachflag = true;
                        if(bodytype.toLowerCase().indexOf("name") !=-1)
                            attachflag = true;
                    }

                }
            }
            else if(part.isMimeType("message/rfc822"))
                attachflag = isContainAttach((Part)part.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attachflag;
    }

    //获取附件并生成下载链接
    public static void getFile(Message message,StringBuffer file){
        try{
            if(message.isMimeType("multipart/*")) {
                Multipart multipart = (Multipart) message.getContent();
                int bodyCounts = multipart.getCount();
                int msgnum = message.getMessageNumber();
                for (int i = 0; i < bodyCounts; i++) {
                    BodyPart bodypart = multipart.getBodyPart(i);
                    // 如果该BodyPart对象包含附件，则应该解析出来
                    if (bodypart.getDisposition() != null) {
                        String filename = bodypart.getFileName();
                        if (filename.startsWith("=?")) {
                            // 把文件名编码成符合RFC822规范
                            filename = MimeUtility.decodeText(filename);

                        }
                        // 生成打开附件的超链接
                        String url = java.net.URLEncoder.encode(filename,"utf-8");
                        file.append("<a href=/download?msgNum="
                                + msgnum + "&&bodyNum=" + i + ">" + filename + "</a></br>");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static String getSubject(Message message){
        try {
            return message.getSubject();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static MailMessage toMailMessage(Message message){
        MailMessage mailMessage = new MailMessage();
        mailMessage.setMailMsgId(message.getMessageNumber());
        mailMessage.setMailMsgDate(getSendData(message));
        mailMessage.setMailMsgSubject(getSubject(message));
        StringBuffer context = new StringBuffer();
        try {
            context = getMailContent((Part) message,context);
            System.out.println("textContent:"+context.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailMessage.setMailMsgContent(context.toString());
        mailMessage.setMailMsgFrom(getFrom(message));
        return mailMessage;
    }

}

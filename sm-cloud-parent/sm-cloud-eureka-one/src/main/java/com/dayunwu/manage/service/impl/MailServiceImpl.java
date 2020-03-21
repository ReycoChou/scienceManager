package com.dayunwu.manage.service.impl;

import com.dayunwu.manage.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @author： reyco
 * @date 2020/3/21
 */
@Component
public class MailServiceImpl implements MailService {
    private final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        // 创建简单邮件会话类
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置发送人
        simpleMailMessage.setFrom(from);
        // 设置接收人
        simpleMailMessage.setTo(to);
        // 设置主题
        simpleMailMessage.setSubject(subject);
        // 设置内容
        simpleMailMessage.setText(content);
        try{
            mailSender.send(simpleMailMessage);
            LOGGER.info("简单邮件已经发送...");
        }catch (Exception e){
            LOGGER.error("发送简单邮件时异常",e);
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        // 为底层JavaMail会话创建一个新的JavaMail MimeMessage
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,true);
            mailSender.send(mimeMessage);
            LOGGER.info("html邮件发送成功");
        } catch (MessagingException e) {
            LOGGER.error("发送HTML邮件时发生异常",e);
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,true);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            mimeMessageHelper.addAttachment(fileName,fileSystemResource);
            mailSender.send(mimeMessage);
            LOGGER.info("带附件的邮件已经发送");
        } catch (MessagingException e) {
            LOGGER.error("发送带附件的邮件发生异常",e);
        }
    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            mimeMessageHelper.addInline(rscId, res);
            mailSender.send(mimeMessage);
            LOGGER.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            LOGGER.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }
}

package com.dayunwu.manage.service;

/**
 * @author： reyco
 * @date 2020/3/21
 */
public interface MailService {
    /**
     * 简单邮件
     */
    void sendSimpleMail(String to,String subject,String content);

    /**
     * html邮件
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送带静态资源的邮件
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}

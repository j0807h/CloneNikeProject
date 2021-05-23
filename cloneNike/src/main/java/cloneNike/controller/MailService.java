package cloneNike.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	public void sendMail(String receiver, String userId, String contents, String subject) {

		String setfrom = "test.korea.mail@gmail.com";
		String tomail = receiver; // 받는 사람 이메일
		String title = subject;
		String content = contents;

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper
					= new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content, true); // 메일 내용
			mailSender.send(message);

		} catch (Exception e) {

			System.out.println(e);

		}
	}
}

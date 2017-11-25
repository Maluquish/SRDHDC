package pe.unmsm.srdhdc.back.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import pe.unmsm.srdhdc.back.service.EnviarCorreoService;
import pe.unmsm.srdhdc.domain.dto.request.CorreoDTORequest;

@Service
public class EnviarCorreoServiceImpl implements EnviarCorreoService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${mail.smtp.host}")
	private String host;

	@Value("${mail.smtp.port}")
	private String port;

	@Value("${mail.smtp.socketFactory.class}")
	private String socketFactoryClass;

	@Value("${mail.smtp.socketFactory.port}")
	private String socketFactoryPort;

	@Value("${mail.smtp.starttls.enable}")
	private String startlsEnable;
	
	@Value("${mail.correo.usuario.sistema}")
	private String correoSistema;
	
	@Value("${mail.correo.password.sistema}")
	private String passwordCorreo;

	/**
	 * Metodo para enviar correo con una cuenta de Gmail Funciona con apache tomcat
	 */
	@Override
	public void enviarCorreo(CorreoDTORequest request) throws MessagingException {

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		Session session;

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", socketFactoryPort);
		props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		props.put("mail.smtp.starttls.enable", startlsEnable);
		Authenticator authenticator = new AutentificadorSMTP(correoSistema, passwordCorreo);
		session = Session.getInstance(props, authenticator);

		Message message = new MimeMessage(session);
		Multipart multipart = new MimeMultipart();
		message.setFrom(new InternetAddress(correoSistema));

		// Agregar los destinatarios
		if (!CollectionUtils.isEmpty(request.getListaTO()))
			for (String correoDestino : request.getListaTO())
				message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
		
//		message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("correo@gmail.com"));
//		message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse("correo@gmail.com"));

		// Asunto
		message.setSubject(request.getAsunto());

		// Texto del mensaje
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(request.getMensaje(), "text/html; charset=utf-8");

		// Setting email text message
		multipart.addBodyPart(messageBodyPart);

		// Seteamos el multipart y enviamos
		message.setContent(multipart);
		Transport.send(message);
	}

	private class AutentificadorSMTP extends Authenticator {
		private String correoUsuario;
		private String passwordUsuario;

		public AutentificadorSMTP(String correoUsuario, String passwordUsuario) {
			this.correoUsuario = correoUsuario;
			this.passwordUsuario = passwordUsuario;
		}

		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(correoUsuario, passwordUsuario);
		}
	}
}
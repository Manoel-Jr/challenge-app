package challengeclient.com.br.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import challengeclient.com.br.constantes.Messages;
import challengeclient.com.br.exception.ClienteExistenteException;
import challengeclient.com.br.exception.ClienteNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorExceptionHandlerControllerAdvice {

	
	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<Object> clienteExistenteException(){
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.BAD_REQUEST.value(),Messages.CLIENTE_JA_EXISTE);
		return new ResponseEntity<>(generic, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<Object> clienteNotFoundException(){
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.NOT_FOUND.value(),Messages.CLIENTE_NAO_ENCONTRADO);
		return new ResponseEntity<>(generic, HttpStatus.NOT_FOUND);
	}
	
	
	public String getTimesTamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return formatter.format(dateTime);
	}
}

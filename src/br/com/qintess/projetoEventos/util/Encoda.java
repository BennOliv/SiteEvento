package br.com.qintess.projetoEventos.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import br.com.qintess.projetoEventos.model.Evento;

public class Encoda {

	public static List<Evento> encodaImagens(List<Evento> eventos) throws UnsupportedEncodingException{
		
		for (Evento evento : eventos) {
			byte[] encodeBase64 = Base64.getEncoder().encode(evento.getImagemEvento());
			evento.setImagemEncoded(new String (encodeBase64, "UTF-8"));
		}
		
		return eventos;
	}
	
	
	public static Evento encodaImagem(Evento evento) throws UnsupportedEncodingException{
		
			byte[] encodeBase64 = Base64.getEncoder().encode(evento.getImagemEvento());
			evento.setImagemEncoded(new String (encodeBase64, "UTF-8"));
		
		return evento;
	}
}

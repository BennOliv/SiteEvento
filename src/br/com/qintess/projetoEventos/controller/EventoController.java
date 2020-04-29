package br.com.qintess.projetoEventos.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.projetoEventos.dao.Dao;
import br.com.qintess.projetoEventos.model.Evento;
import br.com.qintess.projetoEventos.util.Encoda;

@Controller
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping("/evento/{id}")
	public String detalhe(@PathVariable(name="id") long id,
							Model model) {
		
		try {
			Evento evento = dao.buscaPorId(Evento.class, id);
			model.addAttribute("evento", Encoda.encodaImagem(evento));
			
		} catch(UnsupportedEncodingException e){
			model.addAttribute("mensagemErro", "ERRO GRAVE: " + e.getMessage());
		}
		
		return "";
	}
}

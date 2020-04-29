package br.com.qintess.projetoEventos.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.projetoEventos.dao.Dao;
import br.com.qintess.projetoEventos.model.Evento;
import br.com.qintess.projetoEventos.util.Encoda;

@Controller
public class IndexController {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		try {
			List<Evento> eventos = new ArrayList<>();
			List<Evento> eventosTop = new ArrayList<>();
			
			geraSeparado(eventosTop, eventos);
			
			if(eventosTop.size() > 0) {
				 model.addAttribute("eventosTop", Encoda.encodaImagens(eventosTop));
			}
			if(eventos.size() > 0) {
				model.addAttribute("eventos", Encoda.encodaImagens(eventos));
			}
			
		} catch(UnsupportedEncodingException e) {
			model.addAttribute("mensagemErro","ERRO: " + e.getMessage());
		}
		return "index";
	}
	
	@RequestMapping("/cabecalho")
	public String cabecalho(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
		
		model.addAttribute("usuarioLogado", auth);
		return "cabecalho";
	}
	
	@RequestMapping("/menuLateral")
	public String menuLateral(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
		
		model.addAttribute("usuarioLogado", auth);
		
		return "menuLateral";
	}
	
	private void geraSeparado(List<Evento> top, List<Evento> comum) {
		int c = 1;
		
		List<Evento> eventos = dao.buscaTodos(Evento.class);
		if(eventos.size() > 0) {
			for (Evento evento : eventos) {
				if(c<4) {
					top.add(evento);
					c++;
				} else {
					comum.add(evento);
				}
			}
		}
	}
}

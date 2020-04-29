package br.com.qintess.projetoEventos.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.qintess.projetoEventos.dao.Dao;
import br.com.qintess.projetoEventos.model.CasaShow;
import br.com.qintess.projetoEventos.model.Evento;

@Controller
@RequestMapping("/adm")
public class AdmController {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping("/casaShow")
	public String carregaCShow(Model model) {
		
		model.addAttribute("casas", dao.buscaTodos(CasaShow.class));
		model.addAttribute("casaShow", new CasaShow());
		
		return "admCasaShow";
	}
	
	@RequestMapping("/casaShow/salva")
	public String salvaCShow(@ModelAttribute CasaShow casa,
								@RequestParam(required = false, value = "cancela") String cancela,
								RedirectAttributes redirectAtt) {
		
		
		if(cancela != null) {
			return "redirect:/adm/casaShow";
		}
		if(casa.getNome() != null && casa.getCapacidadeComum() != 0) {
			if (casa.getId() == 0) {
				
				dao.salva(casa);
			} else {
				dao.atualiza(casa);
			}
		} else {
			Exception e = new RuntimeException("ERRO: Não é possível cadastar um ingrediente sem os campos Nome e/ou Cor.");
			redirectAtt.addFlashAttribute("mensagemErro", e.getMessage());
			e.printStackTrace();
		}
		
		return "redirect:/adm/casaShow";
	}
	
	@RequestMapping("/casaShow/deleta/{id}")
	public String deletaCShow(@PathVariable(name="id") long id) {
		
		CasaShow casa = dao.buscaPorId(CasaShow.class, id);
		dao.deleta(casa);
		
		return "redirect:/adm/casaShow";
	}
	
	@RequestMapping("/casaShow/altera/{id}")
	public String alteraCShow(@PathVariable(name="id") long id,
								Model model,
								RedirectAttributes redirectAtt) {
		
		model.addAttribute("casas", dao.buscaTodos(CasaShow.class));
		model.addAttribute("casaShow", dao.buscaPorId(CasaShow.class, id));
		
		
		return "admCasaShow";
	}
	
	@RequestMapping("/evento")
	public String carregaEventos(Model model) {
		
		model.addAttribute("casas", dao.buscaTodos(CasaShow.class));
		model.addAttribute("eventos", dao.buscaTodos(Evento.class));
		model.addAttribute("evento", new Evento());
		
		return "admEvento";
	}
	
	@RequestMapping("/evento/salva")
	public String salvaEvento(@ModelAttribute Evento evento,
								@RequestParam(required = false, value="imagem") MultipartFile imagem) {
		
		
		byte[] bImagem;
		
		
		
		try {
			if(imagem != null && imagem.getSize() > 0) {

				bImagem = imagem.getBytes();
				evento.setImagemEvento(bImagem);
				
			if(evento.getId() == 0) {
						dao.salva(evento);
					} else {
						dao.atualiza(evento);
					}
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return "redirect:/adm/evento";
	}
	
	@RequestMapping("/evento/deleta/{id}")
	public String deletaEvento() {
		return "";
	}
	
	@RequestMapping("/evento/altera/{id}")
	public String alteraEvento() {
		return "";
	}
}
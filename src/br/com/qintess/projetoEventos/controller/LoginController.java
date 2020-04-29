package br.com.qintess.projetoEventos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.qintess.projetoEventos.dao.Dao;
import br.com.qintess.projetoEventos.model.Cargo;
import br.com.qintess.projetoEventos.model.Usuario;

@Controller
public class LoginController {

	@Autowired
	private Dao dao;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping("/login")
	public String login (Model model) {
		return "login";
	}
	
	@RequestMapping("/carregaRegistro")
	public String carregaRegistro() {
		return "registro";
	}
	
	@RequestMapping("/registra")
	public String registra(@ModelAttribute Usuario usuario,
							RedirectAttributes redirectAtt,
							HttpServletRequest req) {
		
		String senhaOriginal = usuario.getSenha();
		
		try {
			dao.buscaTodos(Usuario.class)
				.stream()
				.filter(a -> a.getEmail().equals(usuario.getEmail()))
				.findFirst()
				.get();
			
			redirectAtt.addFlashAttribute("mensagemErro", "Usuario ja cadastrado no sistema");
			return "redirect:/login";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		criaNovoUsuario(usuario);
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuario.getEmail(), senhaOriginal);
		authToken.setDetails(new WebAuthenticationDetails(req));
		
		Authentication authentication = authenticationManager.authenticate(authToken);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/";
	}
	
	private void criaNovoUsuario(Usuario usuario) {
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String hashedPass = passEncoder.encode(usuario.getSenha());
		usuario.setSenha(hashedPass);
		
		long idCargo;
		
		idCargo = 2;
		
		if(usuario.getNome() .equals("admin")) {
			idCargo = 1;
		}
		
		Cargo cargo = dao.buscaPorId(Cargo.class, idCargo);
		
		System.out.println(cargo);
		
		cargo.addUser(usuario);
		
		dao.atualiza(cargo);
		dao.salva(usuario);
	}
}

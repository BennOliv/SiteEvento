package br.com.qintess.projetoEventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.qintess.projetoEventos.dao.Dao;
import br.com.qintess.projetoEventos.model.Cargo;
import br.com.qintess.projetoEventos.model.Usuario;

@Service
public class UsuarioLoginService implements UserDetailsService{

	@Autowired
	private Dao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username){
		
		Usuario usuario = null;
		UserBuilder builder = null;
		
		try {
			usuario = dao.buscaTodos(Usuario.class).stream()
						.filter(x -> x.getEmail().equals(username))
						.findFirst()
						.get();
			
			if(usuario != null) {
				builder = User.withUsername(usuario.getNome());
				builder.password(usuario.getSenha());
				String[] cargos = dao.buscaTodos(Cargo.class).stream().map(a -> a.getNome()).toArray(String[]::new);
				if(usuario.getCargo().getNome() == "ADMIN") {
					builder.roles(cargos);
				} else {
					builder.roles(usuario.getCargo().getNome());
				}
			}
		} catch (Exception  e) {
			e.printStackTrace();
		}
		return builder.build();
	}
}

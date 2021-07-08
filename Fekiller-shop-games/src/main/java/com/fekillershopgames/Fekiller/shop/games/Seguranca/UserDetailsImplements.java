package com.fekillershopgames.Fekiller.shop.games.Seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fekillershopgames.Fekiller.shop.games.model.Usuario;

public class UserDetailsImplements implements UserDetails{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String nomeUsuario;
	 private String senha;
	 
	 
	 public UserDetailsImplements(Usuario usuario) {
		super();
		this.nomeUsuario = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	 public UserDetailsImplements() {}
	 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nomeUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}

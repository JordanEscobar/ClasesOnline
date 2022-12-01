package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.Login;
import com.clasesOnline.clasesOnline.Repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private final LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@Override
	@Transactional
	public Login CrearLogin(Login login) {
		return loginRepository.save(login);
	}

	@Override
	@Transactional
	public Login getLoginById(Integer id) {
		return loginRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Login> findAll() {
		return loginRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteLogin(Integer id) {
		loginRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarLogin(Login login, Integer id) {
		Optional<Login> loginId = loginRepository.findById(id);
		Login loginNuevo = loginId.get();
		loginNuevo.setNivel(login.getNivel());
		loginNuevo.setUsuario(login.getUsuario());
		loginRepository.save(loginNuevo);

	}

}

package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Login;

public interface LoginService {

	public Login CrearLogin(Login login);

	public Login getLoginById(Integer id);

	public List<Login> findAll();

	public void deleteLogin(Integer id);

	public void actualizarLogin(Login login, Integer id);

}

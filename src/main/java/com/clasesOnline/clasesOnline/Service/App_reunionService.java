package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.App_reunion;

public interface App_reunionService {
	public App_reunion CrearApp_reunion(App_reunion app_reunion);

	public App_reunion getApp_reunionById(Integer id);

	public List<App_reunion> findAll();

	public void deleteApp_reunion(Integer id);

	public void actualizarApp_reunion(App_reunion app_reunion, Integer id);
}

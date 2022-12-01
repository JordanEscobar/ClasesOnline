package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.App_pago;

public interface App_pagoService {
	public App_pago CrearApp_pago(App_pago app_pago);

	public App_pago getApp_pagoById(Integer id);

	public List<App_pago> findAll();

	public void deleteApp_pago(Integer id);

	public void actualizarApp_pago(App_pago app_pago, Integer id);

}

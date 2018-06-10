package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.mysql.MysqlDAO;

@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public void importPhotoCards()
	{
		new MysqlDAO().sendAsyncPhotoCard();
	}
	
	
	
}

package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.models.ImportDTO;
import com.homeland.ui.services.StatisticService;


@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	List<ImportDTO> imports;
	
	
	
	public List<ImportDTO> getImports() {
		return imports;
	}

	public void setImports(List<ImportDTO> imports) {
		this.imports = imports;
	}


	@PostConstruct
	public void load()
	{
		this.imports = new StatisticService().listImports(10);
	}
	
	
}

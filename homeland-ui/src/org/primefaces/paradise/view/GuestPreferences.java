package org.primefaces.paradise.view;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable {
        
    
	 
	private static final long serialVersionUID = 1L;
	
	

	private String theme = "blue";
    
    private String layout = "blue";
            
    private boolean overlayMenu = false;
    
    private boolean slimMenu = false;
    
    private boolean darkMenu = false;
                
	public String getTheme() {		
		return theme;
	}
    
    public String getLayout() {		
        return layout;
    }
    
	public void setTheme(String theme) {
		this.theme = theme;
	}
    
    public void setLayout(String layout) {
		this.layout = layout;
	}
        
    public boolean isOverlayMenu() {
        return this.overlayMenu;
    }
    
    public void setOverlayMenu(boolean value) {
        this.overlayMenu = value;
        this.slimMenu = false;
    }
    
    public boolean isSlimMenu() {
        return this.slimMenu;
    }
    
    public void setSlimMenu(boolean value) {
        this.slimMenu = value;
    }
    
    public boolean isDarkMenu() {
        return this.darkMenu;
    }
    
    public void setDarkMenu(boolean value) {
        this.darkMenu = value;
    }
}

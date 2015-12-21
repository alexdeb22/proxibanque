package fr.gtm.proxibanquesi.front.mbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="conseiller")
public class ConseillerBean {
	
	private String login;
	private String mdp;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}

package fr.gtm.proxibanquesi.front.mbeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="conseiller")
public class ConseillerBean {
	
	private String login;
	private String mdp;
	
	public ConseillerBean() {
		super();
	}
	
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
	
	@PostConstruct
	public void creationBean() {
		System.out.println("Creation du bean");
	}
	
	@PreDestroy
	public void finBean() {
		System.out.println("Fin du bean: " + this.toString());
	}

	@Override
	public String toString() {
		return "ConseillerBean [login=" + login + ", mdp=" + mdp + "]";
	}

}

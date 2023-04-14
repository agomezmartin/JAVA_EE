package model;

public class Pagina {
	
	private String url;
	private String tematica;
	private String descripciion;
	public Pagina(String url) {
		super();
		this.url = url;
	}
	public Pagina(String url, String tematica, String descripciion) {
		super();
		this.url = url;
		this.tematica = tematica;
		this.descripciion = descripciion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescripciion() {
		return descripciion;
	}
	public void setDescripciion(String descripciion) {
		this.descripciion = descripciion;
	}

}

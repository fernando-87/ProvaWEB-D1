package model;

public class Comentario implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idNoticia = -1;
	private String nome;
	private String texto;
	
	public Comentario() {}
	
	public Comentario(int idNoticia, String nome, String texto) {
		super();
		this.idNoticia = idNoticia;
		this.nome = nome;
		this.texto = texto;
	}
	
	public int getIdNoticia() {
		return idNoticia;
	}
	
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
}


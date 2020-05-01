package model;

public class Comentario implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer pk;
	private String nome;
	private String texto;
	
	public Comentario() {}
	
	/*public Comentario(Integer pk, String nome, String texto) {
		super();
		this.pk = pk;
		this.nome = nome;
		this.texto = texto;
	}*/
	
	public Integer getPk() {
		return pk;
	}
	
	public void setPk(Integer pk) {
		this.pk = pk;
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


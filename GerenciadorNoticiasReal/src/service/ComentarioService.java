package service;

import java.util.List;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {
	
	private ComentarioDAO comentarioDAO;
	
	public ComentarioService() {
		this.comentarioDAO = new ComentarioDAO();
	}
	
	public void cadastrar(Comentario comentario) {
		comentarioDAO.cadastrar(comentario);
	}
	
	public List<Comentario> listar(Integer id) {
		return comentarioDAO.listarComentario(id);
	}
}
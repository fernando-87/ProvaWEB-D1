package service;

import java.util.List;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {
	
	    private NoticiaDAO noticiaDAO = new NoticiaDAO();
	    
	    public void cadastrar (Noticia noticia) {
	    	noticiaDAO.cadastrarNoticia(noticia);
	    }
	    
	    public List<Noticia> listar() {
	    	return noticiaDAO.listarNoticia();
	    }
	    		
		public void alterar(Integer id, Noticia noticia) {
			noticiaDAO.alterar(id, noticia);
		}
		
		public void excluir(Integer id) {
			noticiaDAO.excluir(id);
		}
}

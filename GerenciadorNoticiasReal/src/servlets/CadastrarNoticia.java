package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/CadastrarNoticia.do")
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		String titulo = request.getParameter("titulo_noticia");
		String descricao = request.getParameter("descricao_noticia");
		String texto = request.getParameter("texto_noticia");
		
		Noticia noticia = new Noticia();
		
		noticia.setId(id);
		noticia.setTitulo(titulo);
		noticia.setDescricao(descricao);
		noticia.setTexto(texto);
		
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.cadastrar(noticia);
	}
}
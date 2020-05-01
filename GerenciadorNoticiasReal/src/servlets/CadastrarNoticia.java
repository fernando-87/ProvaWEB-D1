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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Integer id = Integer.parseInt(request.getParameter("id_noticia"));
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		noticia.setTitulo(request.getParameter("titulo_noticia"));
		noticia.setDescricao(request.getParameter("descricao_noticia"));
		noticia.setTexto(request.getParameter("texto_noticia"));
		
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.cadastrar(noticia);
	}
}
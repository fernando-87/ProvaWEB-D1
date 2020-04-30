package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    int id = Integer.parseInt(request.getParameter("id_noticia"));
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.excluir(noticia);
		
		PrintWriter saida = response.getWriter();
		saida.println("Excluído com sucesso");
	}

}

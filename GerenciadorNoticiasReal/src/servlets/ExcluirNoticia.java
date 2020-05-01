package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticiaService;

@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Integer id = Integer.parseInt(request.getParameter("id_noticia"));
	
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.excluir(id);
		
		PrintWriter saida = response.getWriter();
		saida.println("Excluído com sucesso");
	}

}

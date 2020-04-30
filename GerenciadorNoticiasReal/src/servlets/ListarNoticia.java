package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/ListarNoticia.do")
public class ListarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        NoticiaService noticiaService = new NoticiaService();
		
		ArrayList<Noticia>listaNoticia = null;
		
		listaNoticia = noticiaService.listarRealNews();
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<table>");
		
		listaNoticia.forEach(
				p -> {
					saida.println("<tr>");
					saida.println("<td>");
					saida.println("Id:");
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getId());
					saida.println("</td>");
					saida.println("<td>");
					saida.println("Titulo:");
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getTitulo());
					saida.println("</td>");
					saida.println("<td>");
					saida.println("Descricao");
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getDescricao());
					saida.println("</td>");
					saida.println("<td>");
					saida.println("Texto:");
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getTexto());
					saida.println("</td>");
					
					saida.println("<a href='AlterarNoticia.do?id_noticia="
							+ p.getId() + "'> Alterar </a> ");
					
					saida.println("<td>");
					saida.println("<a href='ExcluirNoticia.do?id_noticia="
							+ p.getId() + "'> Excluir </a> ");
					saida.println("</td>");
					
					saida.println("<td>");
					saida.println("<a href='ListarComentarios.do?id_noticia="
							+ p.getId() +  "'> Detalhes </a> ");
					saida.println("</td>");
					
					saida.println("</tr>");
	             }
			);
		
			saida.println("</table>");
	    }
	}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import service.ComentarioService;

@WebServlet("/ListarComentarios.do")
public class ListarComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComentarioService comentarioService = new ComentarioService();
		
		ArrayList<Comentario>listaComentario = null;
		
		listaComentario = comentarioService.listarComentario();
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		/*saida.println("<form action='ListarComentarios.do' method='post'> ");
		saida.println("Id: " + comentario.getIdNoticia());
		saida.println("<input type='hidden' name='id_noticia' value= '"
				+ comentario.getIdNoticia() + "'> <br>");
		saida.println("Nome:");
		saida.println("<input type='text' name='nome_usuario' value= '"
				+ comentario.getNome() + "'> <br> ");
		saida.println("Texto: ");
		saida.println("<input type='text' name='texto_comentario' value='"
				+ comentario.getTexto() + "'> <br> ");
		saida.println("<input type='submit'> ");
		saida.println("</form> ");*/
		
		saida.println("<html>");
		saida.println("<body>");
		saida.println("<table>");
		
		listaComentario.forEach(
				p -> {
					saida.println("<tr>");
					saida.println("<td>");
					saida.println("Id:");
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getIdNoticia());
					saida.println("</td>");
					saida.println("<td>");
					saida.println("Nome:");
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getNome());
					saida.println("</td>");
					saida.println("<td>");
					saida.println("Texto");
					saida.println("</td>");
					saida.println("<td>");
					saida.println(p.getTexto());
					saida.println("</td>");
					
					saida.println("<td>");
					saida.println("<a href='index2.html'?id_noticia="
							+ p.getIdNoticia() +  "'> Entrar </a> ");
					saida.println("</td>");
					
					saida.println("</tr>");
	             }
			);
		
			saida.println("</table>");
	}
}
		/*List<Noticia> noticia = noticiaService.listarRealNews();
		PrintWriter saida = response.getWriter();
		response.getWriter().println("<a href='ListarNoticia.do'></a>");
		
		saida.println("<h1>REAL NEWS</h1>");
		saida.println("<h2>Os destaques das notícias da semana</h2>");
		if(noticia.isEmpty()) {
			saida.println("<p>Não há notícias</p>");
		} else {
			for (Noticia Noticia : noticia) {
			saida.println("<p> Titulo: <a href='ComentarioNoticia.do?id" + ((model.Noticia) noticia).getId() + "'>" + ((model.Noticia) noticia).getTitulo() + "</p>");
			saida.println("<p> Descricao: " + ((model.Noticia) noticia).getDescricao() + "</p");
			saida.println("<p> Texto: " + ((model.Noticia) noticia).getTexto() + "</p>");
			saida.println("<hr>");
			}
		}*/
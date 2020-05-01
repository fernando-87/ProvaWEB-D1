package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

@WebServlet("/ListarComentarios.do")
public class ListarComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticiaService noticiaService = new NoticiaService();
		
		List<Noticia> listaNoticia = noticiaService.listar();
		
		for (Noticia noticia : listaNoticia) {
			
			response.getWriter().println("<h1>" + noticia.getTitulo() + "</h1>" 
			+ "<h3>" + noticia.getDescricao() + "</h3>" 
					+ "<p>" + noticia.getTexto() + "</p>");
		
		ComentarioService comentarioService = new ComentarioService();
		List<Comentario> listaComentario = comentarioService.listar(noticia.getId());
		HttpSession sessao = request.getSession();
		sessao.setAttribute("pk", noticia.getId());
		for (Comentario comentario : listaComentario) {
			
			response.getWriter().println("<hr/>" + "<h5> Nome: " + comentario.getNome() + "</h5>"
			+ "<p> Texto: " + comentario.getTexto() + "</p>"+"<hr/>");
		}
		
		/*response.getWriter().println("<form method=\"post\" action=\"ComentariosNoticia.do\">" 
		+ "<br/>" 
		+ "<br/>" 
		+ "<small> <p> Adicionar comentário: </p> </small>"
		+"<p><small> Nome: <small></p>"
		+"<input type=\"text\" value=\"\" name=\"nome_usuario\" />"
		+"<br/"
		+"<br/>"
		+"<p><small> Texto: <small></p>"
		+"<input type=\text\" value=\"\" name=\"texto_comentario\" />"
		+ "<input type=\"submit\" value=\"Enviar\" />"
		+ "</form>"+"<hr/>");
	  }*/
		}
	}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
	        Integer pk = Integer.parseInt(request.getParameter("pk_noticia"));
	        	
			Comentario comentario = new Comentario();
			comentario.setPk(pk);
			comentario.setTexto(request.getParameter("texto_comentario"));
			comentario.setNome(request.getParameter("nome_usuario"));
			
			ComentarioService comentarioService = new ComentarioService();
			comentarioService.cadastrar(comentario);
			
			PrintWriter resposta = response.getWriter();
			resposta.println("Cadastrado com sucesso");
		
		
  }
}

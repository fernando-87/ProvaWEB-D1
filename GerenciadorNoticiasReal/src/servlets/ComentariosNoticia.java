package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import service.ComentarioService;

@WebServlet("/ComentariosNoticia.do")
public class ComentariosNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idNoticia = Integer.parseInt(request.getParameter("id_noticia"));
		String nome = request.getParameter("nome_usuario");
		String texto = request.getParameter("texto_comentario");
		
		Comentario comentario = new Comentario();
		
		comentario.setIdNoticia(idNoticia);
		comentario.setNome(nome);
	    comentario.setTexto(texto);
		
		ComentarioService comentarioService = new ComentarioService();
		comentarioService.cadastrar(comentario);
	}
}		
		

















        /*response.setContentType("text/html");
		PrintWriter saida = response.getWriter();
		response.getWriter().println("<a href='ListarNoticias.do'</a>");
		
		String parameterId = request.getParameter("id") != null && ! request.getParameter("id").isEmpty()
				? request.getParameter("id") : "-1";
		int id = Integer.parseInt(parameterId);
		
		if(id <= 0) {
			saida.println("<h1>Notícia não informada</h1>");
			return;
		}
		
		Noticia resultado = NoticiaDAO(id);
		
		if (!resultado.isValid()) {
			saida.println("Notícia não informada");
		} else {
			saida.println("<h1> Real News </h1>");
			saida.println("<hr>");
			saida.println("<h1>" + resultado.getTitulo()+ "</h1>");
			saida.println("<h3>" + resultado.getDescricao() + "</h3>");
			saida.println("<p>" + resultado.getTexto() + "<p>");
			saida.println("<hr>");
			saida.println("<h4>Comentário</h4>");
			
			List<ComentariosNoticia> comentario = ComentarioService.listar(id);
			
			if (comentario.isEmpty()) {
				saida.println("<p> Nenhum comentario </p>");
			} else {
				for (ComentariosNoticia Comentarios : comentario) {
					saida.println("<h5>" + ((Comentario) comentario).getNome() + "</h5>");
					saida.println("<p>" + ((Comentario) comentario).getIdComentario() + "</p>");
					saida.println("<hr>");
				}*/
	//}
			/*} 
			
			saida.println("<form method='post'");
			saida.println("<label>Adicionar comentário</label>");
			saida.println("<br>");
			saida.println("<input type'hidden' name='Id' value='" + id + "'>");
			saida.println("<input type='text' name='Nome' placeholder='Seu nome' required>");
			saida.println("<br>");
			saida.println("<textarea name='Texto' placeholder='Seu comentario' reuqired></textarea");
			saida.println("<br>");
			saida.println("<input type='submit' value='Enviar'>");
			saida.println("</form>");
		}
	 }

	     private Noticia NoticiaDAO(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/

		//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 /*String nome = request.getParameter("nome_usuario");
		 String texto = request.getParameter("texto_noticia");
		 String parameterIdNoticia = request.getParameter("idNoticia") != null && !request.getParameter("idNoticia").isEmpty()
				 ? request.getParameter("idNoticia") : "-1";
		 
		 int idNoticia = Integer.parseInt(parameterIdNoticia);
		 
		 Comentario comentario = new Comentario();
		 comentario.setIdNoticia(idNoticia);
		 comentario.setNome(nome);
		 comentario.setTexto(texto);
		
		 ComentarioService comentarioService = new ComentarioService();
		 comentarioService.cadastrar(comentario);
		 
		 doGet(request,response);
    }
}*/


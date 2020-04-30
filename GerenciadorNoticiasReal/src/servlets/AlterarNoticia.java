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

@WebServlet("/AlterarNoticia.do")
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		
		NoticiaService noticiaService = new NoticiaService();
		Noticia noticia = noticiaService.consultar(id);
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		saida.println("<form action='AlterarNoticia.do' method='post'> ");
		saida.println("Id: " + noticia.getId());
		saida.println("<input type='hidden' name='id_noticia' value= '"
				+ noticia.getId() + "'> <br>");
		saida.println("Descricao:");
		saida.println("<input type='text' name='descricao_noticia' value= '"
				+ noticia.getDescricao() + "'> <br> ");
		saida.println("Titulo: ");
		saida.println("<input type='text' name='titulo_noticia' value='"
				+ noticia.getTitulo() + "'> <br> ");
		saida.println("Texto: ");
		saida.println("<input type='text' name='texto_noticia' value= "
				+ noticia.getTexto() + "'> <br> ");
		saida.println("<input type='submit'> ");
		saida.println("</form> ");
	}
	
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id_noticia"));
        String descricao = request.getParameter("descricao_noticia");
        String titulo = request.getParameter("titulo_noticia");
        String texto = request.getParameter("texto_noticia");
        
		Noticia noticia = new Noticia();
		noticia.setId(id);
		noticia.setDescricao(descricao);
		noticia.setTitulo(titulo);
		noticia.setTexto(texto);
		
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.alterar(noticia);
		
		PrintWriter resposta = response.getWriter();
		resposta.println("Alterado com sucesso");
	}

}

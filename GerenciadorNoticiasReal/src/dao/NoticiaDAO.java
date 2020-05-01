package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import model.Noticia;
import java.sql.ResultSet;

     public class NoticiaDAO {
		
		private Connection conexao;
		
		public NoticiaDAO () {
			new ConnectionFactory(); 
			this.conexao = ConnectionFactory.conectar();
		}
		
		public void cadastrarNoticia (Noticia noticia) {
			
			String inserir = "INSERT INTO noticia "
					+ " (descricao, titulo, texto) "
					+ " VALUES (?,?,?) ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir) ) {
				
				pst.setString(1, noticia.getDescricao());
				pst.setString(2, noticia.getTitulo());
				pst.setString(3, noticia.getTexto());
				pst.execute();
				
			} catch (Exception x) {
				x.printStackTrace();
			try {
				   conexao.rollback();
				   
			} catch (SQLException ex) {
			
				System.out.println(ex.getStackTrace());
			}
		}
	}
		
		public void alterar (Integer id, Noticia noticia) {
			
			String alterar = "UPDATE noticia "
					+ "SET descricao = ?, titulo = ?, texto = ?  "
					+ " WHERE id = ? ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(alterar)) {
				
				pst.setString(1, noticia.getDescricao());
				pst.setString(2, noticia.getTitulo());
				pst.setString(3, noticia.getTexto());
				pst.setInt(4, id);
				pst.execute();
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ " a tabela Noticia");
				ex.printStackTrace();
			}
		}
		
		public void excluir (Integer id) {
			
			String excluir = "DELETE FROM noticia "
					+ " WHERE id = ? ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(excluir)) {
				
				pst.setInt(1, id);
				pst.execute();
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tebela Noticia ");
				ex.printStackTrace();
			}
		}
		
		public List<Noticia> listarNoticia() {
			
			String insert = "SELECT * FROM noticia";
			
			List<Noticia> lista = new ArrayList<>();
			
			try (PreparedStatement pst 
					= conexao.prepareStatement(insert)) {
				
				ResultSet resultado = pst.executeQuery();
				
				while (resultado.next()) {
					Noticia p = new Noticia();
					p.setDescricao(resultado.getString("descricao"));
					p.setTitulo(resultado.getString("titulo"));
					p.setId(resultado.getInt("id"));
					p.setTexto(resultado.getString("texto"));
					lista.add(p);
				  }
				} catch (SQLException ex) {
					
					/*System.err.println("Não foi possível manipular "
							+ "a tabela Noticia ");*/
					ex.printStackTrace();
			    }
					return lista;
				}
	}
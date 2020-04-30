package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Noticia;
import java.sql.ResultSet;

     public class NoticiaDAO {
		
		private Connection conexao;
		
		public NoticiaDAO() {
			this.conexao = ConnectionFactory.conectar();
		}
		
		public void cadastrar (Noticia noticia) {
			
			String inserir = "INSERT INTO noticia "
					+ " (id, descricao, titulo, texto) "
					+ " VALUES (?,?,?,?) ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir) ) {
				
				pst.setInt(1, noticia.getId());
				pst.setString(2, noticia.getDescricao());
				pst.setString(3, noticia.getTitulo());
				pst.setString(4, noticia.getTexto());
				
				pst.execute();
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("N�o foi poss�vel manipular "
						+ "a tabela Noticia");
				ex.printStackTrace();
			}
		}
		
		public void alterar (Noticia noticia) {
			
			String inserir = "UPDATE noticia "
					+ "SET descricao = ?, titulo = ?, texto = ?  "
					+ " WHERE id = ? ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir)) {
				
				pst.setString(1, noticia.getDescricao());
				pst.setString(2, noticia.getTitulo());
				pst.setString(3, noticia.getTexto());
				pst.setInt(4, noticia.getId());
				
				pst.execute();
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("N�o foi poss�vel manipular "
						+ " a tabela Noticia");
				ex.printStackTrace();
			}
		}
		
		public void excluir (Noticia noticia) {
			
			String inserir = "DELETE FROM noticia "
					+ " WHERE id = ? ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir)) {
				
				pst.setInt(1, noticia.getId());
				
				pst.execute();
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("N�o foi poss�vel manipular "
						+ "a tebela Noticia ");
				ex.printStackTrace();
			}
		}
		
		public Noticia consultar(int id) {
			
			String inserir = "SELECT * FROM noticia "
					+ " WHERE id = ? "; 
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir)) {
				
				pst.setInt(1, id);
				
				ResultSet resultado = pst.executeQuery();
				
				Noticia p = new Noticia();
				if(resultado.next()) {
					p.setDescricao(resultado.getString("descricao"));
					p.setTitulo(resultado.getString("titulo"));
					p.setId(id);
					p.setTexto(resultado.getString("texto"));
				}
				
				return p;
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("N�o foi poss�vel manipular "
						+ "a tabela Noticia.");
				ex.printStackTrace();
		     
			    return null;
			}
		}
		
		public ArrayList<Noticia> listarNoticia() {
			
			String inserir = "SELECT * FROM noticia";
			
			try (PreparedStatement pst 
					= conexao.prepareStatement(inserir)) {
				
				ResultSet resultado = pst.executeQuery();
				
				ArrayList<Noticia> lista = new ArrayList<>();
				
				while (resultado.next()) {
					Noticia p = new Noticia();
					p.setDescricao(resultado.getString("descricao"));
					p.setTitulo(resultado.getString("titulo"));
					p.setId(resultado.getInt("id"));
					p.setTexto(resultado.getString("texto"));
					lista.add(p);
				  }
				return lista;
				
				} 
			
			  catch (SQLException ex) {
					
					System.err.println("N�o foi poss�vel manipular "
							+ "a tabela Noticia ");
					ex.printStackTrace();
		
					return null;
				}
		}
	}     
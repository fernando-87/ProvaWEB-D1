package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import model.Comentario;
import java.sql.ResultSet;

public class ComentarioDAO {
	
	private Connection conexao;
	
	public ComentarioDAO() {
		new ConnectionFactory();
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void cadastrar (Comentario comentario) {
		
		String inserir = "INSERT INTO comentario " 
		                  + " (fk_noticia_id, nome, texto) " 
				          + " VALUES (?,?,?) ";
		
		try (PreparedStatement pst =
				conexao.prepareStatement(inserir)) {
			
			pst.setInt(1, comentario.getPk());
			pst.setString(2, comentario.getNome());
			pst.setString(3, comentario.getTexto());
			
			pst.execute();
			
		} catch (Exception s) {
			s.printStackTrace();
		try {
			conexao.rollback();
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
		}
	  }
	}
		
		/*public void alterar (Comentario comentario) {
			
			String inserir = "UPDATE comentario "
					+ "SET nome = ?, texto = ? "
					+ " WHERE idNoticia = ? ";
			
			try(PreparedStatement pst =
					conexao.prepareStatement(inserir)) {
				
				pst.setString(1, comentario.getNome());
				pst.setString(2, comentario.getTexto());
				pst.setInt(3, comentario.getIdNoticia());
				
				pst.execute();
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela Comentario");
				ex.printStackTrace();
			}
		}
		
		public void excluir(Comentario comentario) {
			
			String inserir = "DELETE FROM comentario "
					+ " WHERE idNoticia = ? ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir)) {
				
				pst.setInt(1, comentario.getIdNoticia());
				
				pst.execute();
				
			} catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela Comentario ");
				ex.printStackTrace();
			}
		}
		
		public Comentario consultar(int idNoticia) {
			
			String inserir = "SELECT * FROM comentario "
					+ " WHERE idNoticia = ? ";
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(inserir)) {
				
				pst.setInt(1, idNoticia);
				
				ResultSet resultado = pst.executeQuery();
				
				Comentario p = new Comentario();
				if(resultado.next()) {
					p.setTexto(resultado.getString("texto"));
					p.setIdNoticia(idNoticia);
					p.setNome(resultado.getString("nome"));
				}
				
				return p;
				
			} 
			
			catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela Comentario ");
				ex.printStackTrace();
				
				return null;
			}
		}*/
		
		public List<Comentario> listarComentario(Integer id) {
			
			String insertion = "SELECT * FROM comentario WHERE fk_noticia_id = ?";
			
			List<Comentario> lista = new ArrayList<>();
			
			try (PreparedStatement pst = 
					conexao.prepareStatement(insertion)) {
				
				pst.setInt(1, id);
				
				ResultSet resultado = pst.executeQuery();
				
				while(resultado.next()) {
					Comentario p = new Comentario();
					p.setTexto(resultado.getString("texto"));
					p.setNome(resultado.getString("nome"));
					lista.add(p);
				}
			} catch (SQLException ex) {
				
				ex.printStackTrace();
			}
				return lista;
			}
		}

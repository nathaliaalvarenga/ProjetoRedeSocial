package projeto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuario {
	private conexaoBD conexao;

	public DAOUsuario() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de comandos
		// ao banco
		this.conexao = new conexaoBD();
	}

	public void criarUsuario(Usuario u) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros (representados pelo '?')
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into pessoas(email,senha,nome,idade,ID) values(?,?)");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada. A sequência é determinada por índices, iniciando do valor 1.
		pst.setString(1, u.getEmail());
	pst.setInt(2, u.getSenha());
	pst.setString(3, u.getNome());
               pst.setInt(4, u.idade());
		pst.setInt(6, u.getID ());
        			// solicitação da execução da query, após seu preparo
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}

	}

	// busca de pessoas por seu código de identificação no banco (id)
	@SuppressWarnings("unused")
	public Usuario buscarUsuario(int ID) {
		// abrindo a conexão com o BD
		conexao.conectar();
		// busca utilizando o método de consulta do objeto ConexaoBD
		ResultSet resultado = conexao.executarSQL("select * from pessoas where cod_pessoa = \'" + ID + "\'");
		Usuario u = new Usuario();

		try {
			resultado.next();
			// os métodos get devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada
	int IDUsuario = resultado.getInt("cod_pessoa");
	String emailUsuario = resultado.getString("email");
	int senhaUsuario = resultado.getInt("senha");
	int nomeUsuario = resultado.getInt("nome");
	int idadeUsuario = resultado.getInt("idade");
			u.setID(IDUsuario);
			u.setEmail(emailUsuario);
			u.setSenha(senhaUsuario);
			u.setNome(nomeUsuario);
			u.setIdade(idadeUsuario);
		
			

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return u;
	}

	public void excluirUsuario(int ID) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from pessoas where cod_pessoa = \'" + ID + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}

	public void editarUsuario(int ID,String email, int senha, String nome, int idade) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update pessoas set nome = ?, idade = ? "
					+ "where cod_pessoa = \'" + ID + "\'");
			stm.setString(1, email);
			stm.setInt(2, senha);
			stm.setString(3, nome);
			stm.setInt(4, idade);
			stm.setInt(6, ID);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}

	@SuppressWarnings("unused")
	public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		// abrindo a conexão com o BD
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from pessoas");

		try {
			// para iterar sobre os resultados de uma consulta, deve-se utilizar o método next()
			while (resultado.next()) {
	int idUsuario = resultado.getInt("cod_pessoa");
        String emailUsuario = resultado.getString("email");
	String nomeUsuario = resultado.getString("nome");	
	int senhaUsuario = resultado.getInt("senha");
	int idadeUsuario = resultado.getInt("idade");
	int IDUsuario = resultado.getInt("ID");
	usuarios.add(new Usuario());
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return usuarios;
	}


}

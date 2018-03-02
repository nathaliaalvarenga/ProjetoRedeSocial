package projeto;
import java.util.ArrayList;
import projeto.DAOUsuario;
import projeto.Usuario;
public class Teste {
	
	private static final String String = null;
	public static void main(String[] args) {
		DAOUsuario conexao = DAOUsuario();
		
	DAOUsuario conexao1 = new DAOUsuario();
	int senha;
	Usuario user01 = new Usuario(String email, int senha, String nome, int idade);
	conexao1.criarUsuario(user01);
	
	}

}

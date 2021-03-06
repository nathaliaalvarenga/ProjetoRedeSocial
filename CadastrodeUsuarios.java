package projeto;
import java.util.List;
import projeto.Usuario;
import java.util.Scanner;
import java.util.ArrayList;

	@SuppressWarnings("unused")
	public class CadastrodeUsuarios {
		private Scanner l;
		private boolean execute;
		private List<Dados> dados;
		public static void main(String[] args) {
			new CadastrodeUsuarios();
		}
		private CadastrodeUsuarios() {
			l = new Scanner(System.in);
			execute = true;
			dados = new ArrayList<Dados>();
			System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS DO ANIMALSBOOK");
			while (execute) {
				String opcao = menu();
				if (opcao.equalsIgnoreCase("n")) {
					cadastrar();
				} else if (opcao.equalsIgnoreCase("l")) {
					listarCadastros();
				} else if (opcao.equalsIgnoreCase("x")) {
					execute = false;
				} else {
					System.out.println("\nOpção Inválida!\n");
				}
			}
		}
		private String menu() {
			System.out.println("Selecione a opção:");
			System.out.println("N - Novo cadastro");
			System.out.println("L - Listar cadastros");
			System.out.println("X - Sair");
			return l.nextLine();
		}
		private void cadastrar() {
			boolean cadastrando = true;
			while (cadastrando) {
				System.out.println("Cadastro de Usuário do Animalsbook");
				Dados d = new Dados();
				d.setNome(textInput("Nome completo: "));
				d.setLogin(textInput("Login: "));
				d.setIdade(textInput("Idade: "));
				d.setSenha(textInput("Senha: "));
				d.setEmail(textInput("Email: "));
				String cadastrar = textInput("Adicionar cadastro (Sim/Não) ?");
				if (cadastrar.equalsIgnoreCase("Sim")) {
					System.out.println("Cadastro adicionado !!!");
					dados.add(d);
				} else if (cadastrar.equalsIgnoreCase("Não")){
					System.out.println("Cadastro ignorado !!!");
				} else {
					System.out.println("\nOpção inválida!\n");
				}
				String continua = textInput("Continuar cadastrando (Sim/Não) ?");
				if (continua.equalsIgnoreCase("Não")) {
					cadastrando = false;
				} else if (continua.equalsIgnoreCase("Sim")){
					
				} else {
					System.out.println("\nOpção inválida!\n");
					cadastrando = false;
				}
			}
		}
		private void listarCadastros() {
			if (dados.size() == 0) {
				System.out.println("\nNão existem cadastros !!!\n");
			} else {
				System.out.println("\nLista de Cadastros\n");
				for (int i = 0; i < dados.size(); i++) {
					Dados d = dados.get(i);
					System.out.println("Cadastro número: " + i);
					System.out.println("\tNome: " + d.getNome());
					System.out.println("\tLogin: " + d.getLogin());
					System.out.println("\tIdade: " + d.idade() + "\n");
					System.out.println("\tSenha: " + d.getSenha());
					System.out.println("\tEmail: " + d.getEmail());
				}
				System.out.println("\nFim da lista\n");
			}
		}
		private String textInput(String label) {
			System.out.println(label);
			return l.nextLine();
		}
	}



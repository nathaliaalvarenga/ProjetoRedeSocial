package projeto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		DAOUsuario conexao = new DAOUsuario();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite seu e-mail: ");
		String email = sc.next();
		
		int senha = 0;
		boolean senhaInvalida = true;
		
		while(senhaInvalida) {
		
		try{
			System.out.println("Digite sua senha: ");
			senha = sc.nextInt();
			senhaInvalida = false;
		} catch(InputMismatchException e){
			System.out.println("Senha inválida! Digite apenas números.");
			continue;
		}
		System.out.println("Digite seu nome: ");
		String nome = sc.next();
		System.out.println("Digite seu id de usuário: ");
		int ID = sc.nextInt();
		System.out.println("Digite sua idade: ");
		int idade = sc.nextInt();
	
		
		
		Usuario U = new Usuario();
		conexao.criarUsuario(U);
		U.mostrarCadastrados();	
	}
}
}

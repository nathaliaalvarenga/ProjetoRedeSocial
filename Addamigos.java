package projeto;
import java.util.ArrayList;
import java.util.List;
import projeto.Usuario;
import java.util.Scanner;
import projeto.CadastrodeUsuarios;

@SuppressWarnings("unused")
class addAmigos{
      String nomeDeAmigo;

  addAmigos(String nomeDeAmigo){this.nomeDeAmigo = nomeDeAmigo;
  }
}

class GrupoAmigos{ 
   String descricao;
   List<addAmigos> membros = new ArrayList<addAmigos>();

   GrupoAmigos(String descricao){this.descricao = descricao;
   }
}

class Teste
{
   void teste(){
	   addAmigos joao = new addAmigos ("João");
	   addAmigos maria = new addAmigos ("Maria");
	   addAmigos jose = new addAmigos ("José");

      GrupoAmigos dogs = new GrupoAmigos("dogs");
      dogs.membros.add(joao);
      dogs.membros.add(maria);
      dogs.membros.add(jose);

      GrupoAmigos cats = new GrupoAmigos("cats");
      cats.membros.add(maria);
   }    
}


package projeto;
    import java.util.ArrayList;
    import java.util.List;

    public class Feed {
            private int ID;
            private String nome;
            private String email;
            private String postagem;
            private int senha;
            private int idade;


        static List <Feed> postagens = new ArrayList<>();
        List <String> postagensenviadas = new ArrayList<>();
        
        public Feed (String email, String nome,int ID, String postagem, int senha, int idade) {
            this.email = email;
            this.senha = senha;
            this.nome = nome;
            this.ID = ID;
            this.idade = idade;
            this.postagem = postagem;
            Feed.this.setPostagem(this);
        }
    public Feed(){}

    public int getID() {
        return ID;
    }
    public void setId_usuario(int ID) {
        this.ID = ID;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPostagem() {
        return postagem;
    }
    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }
    public static List<Feed> getPostagens() {
        return postagens;
    }
    public static void setPostagens(List<Feed> postagens) {
        Feed.postagens = postagens;
    }

    public void postar() {
        for (Feed x : postagens) {
            System.out.println(x);
        
    }
    }
    }
}


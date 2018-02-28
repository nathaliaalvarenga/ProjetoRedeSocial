
package projeto;


    package projeto;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    public addAmigos {
        private ArrayList listaDeAmigos;
       
        private String meuLogin;
        private String nome;
        private String login;
        
        public Amigo(){
            this.listaDeAmigos = new ArrayList();
        }
        
        public Amigo(String meuLogin){
            this.listaDeAmigos = new ArrayList();
            this.meuLogin = meuLogin;
        }
        
        
        public Amigo(String nome, String login){
            this.nome = nome;
            this.login = login;
        }
        
        public void loadAmigos() throws SQLException {
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSetQuery = null;
            
            this.listaDeAmigos.clear();

            try {
                Class.forName("org.postgresql.Driver").newInstance( );
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testes","postgres","ifpb");

                statement = conn.createStatement();
                resultSetQuery = statement.executeQuery("SELECT * FROM amigos JOIN usuarios ON amigos.seulogin = usuarios.login WHERE meulogin = '" + getMeuLogin() + "' ORDER BY nome");
                
                while(resultSetQuery.next()){
                    this.listaDeAmigos.add(new Amigo(resultSetQuery.getString("nome"), resultSetQuery.getString("seulogin")));
                }
                System.out.println("Carregado Lista de amigos em 'ArrayList listaDeAmigos' com sucesso!");
                
                statement.close();

                } catch (Exception ex) {
                    } finally {
                        if (statement != null) {
                            statement.close( );
                        }
                        if (conn != null) {
                            conn.close( );
                        }
            }
        }
        
        public ArrayList getAmigosSugeridosRandom(String login, int limite) throws SQLException {
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSetQuery = null;
            ArrayList l = new ArrayList();

            try {
                Class.forName("org.postgresql.Driver").newInstance( );
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testes","postgres","ifpb");

                statement = conn.createStatement();
                resultSetQuery = statement.executeQuery("SELECT resultado.login, resultado.nome FROM (SELECT * FROM usuarios WHERE login <> '" + login + "'ORDER BY RANDOM() ) AS resultado LEFT JOIN (SELECT seulogin FROM amigos WHERE meulogin = '" + login + "') AS amg ON resultado.login = amg.seulogin WHERE amg.seulogin is null LIMIT " + limite);
                
                while(resultSetQuery.next()){
                    l.add(new Usuario(resultSetQuery.getString("nome"), resultSetQuery.getString("login"), ""));
                }
                
                statement.close();

                } catch (Exception ex) {
                    System.out.print("");
                    System.out.println("Erro ao carregar lista de sugestão de amigos.");
                    System.out.print("");
                    System.out.println(ex.getMessage());
                    } finally {
                        if (statement != null) {
                            statement.close( );
                        }
                        if (conn != null) {
                            conn.close( );
                        }
            }
            
            return l;
        }
        
        public ArrayList getAmigosSugeridos(String login, int limite) throws SQLException {
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSetQuery = null;
            ArrayList l = new ArrayList();
            boolean temAmigosMutuos = false;

            try {
                Class.forName("org.postgresql.Driver").newInstance( );
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testes","postgres","ifpb");

                statement = conn.createStatement();
                resultSetQuery = statement.executeQuery("SELECT resultado.login, resultado.nome FROM (SELECT * FROM amigos WHERE meulogin = '" + login + "') as amg3 RIGHT JOIN (SELECT amg1.seulogin as login, amg1.nome as nome, COUNT(amg1.seulogin) as contador FROM (SELECT amigos.meulogin, amigos.seulogin, usuarios.nome FROM amigos JOIN usuarios ON amigos.seulogin = usuarios.login WHERE amigos.seulogin <> '" + login + "') as amg1 JOIN (SELECT * FROM amigos WHERE amigos.meulogin = '" + login + "') as amg2 ON amg1.meulogin = amg2.seulogin GROUP BY amg1.seulogin, amg1.nome ) as resultado ON amg3.seulogin = resultado.login WHERE seulogin is null ORDER BY contador DESC LIMIT " + limite);
                
                while(resultSetQuery.next()){
                    temAmigosMutuos = true;
                    l.add(new Usuario(resultSetQuery.getString("nome"), resultSetQuery.getString("login"), ""));
                }
                
                System.out.println("");
                System.out.println("Carregada lista de sugestão de amigos em 'ArrayList listaRandom' com sucesso!");
                
                statement.close();

                } catch (Exception ex) {
                    System.out.print("");
                    System.out.println("Excessão ao carregar lista de sugestão de amigos.");
                    System.out.print("");
                    System.out.println(ex.getMessage());
                    } finally {
                        if (statement != null) {
                            statement.close( );
                        }
                        if (conn != null) {
                            conn.close( );
                        }
            }
            
            if(temAmigosMutuos == false){
                l = getAmigosSugeridosRandom(login, limite);
            }
            
            return l;
        }
        
        public void insert(String NovoAmigoLogin) throws SQLException {
            

            insert1(NovoAmigoLogin);
           
            insert2(NovoAmigoLogin);
        }
        
        public void insert1(String NovoAmigoLogin) throws SQLException {
            Connection conn;
            conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("org.postgresql.Driver").newInstance( );
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testes","postgres","ifpb");

                String SQL = "INSERT INTO amigos(meulogin, seulogin) VALUES (?,?)";
                
                pst = conn.prepareStatement(SQL);
                pst.setString(1, this.meuLogin);
                pst.setString(2, NovoAmigoLogin);
                
                pst.executeUpdate( );
                pst.clearParameters( );

                } catch (Exception ex) {
                    System.out.println("");
                    System.out.println("Excessão ao adicionar amigo.");
                    
                    System.out.println("");
                    System.out.println(ex.getMessage());
                    } finally {
                        if (pst != null) {
                            pst.close( );
                        }
                        if (conn != null) {
                            conn.close( );
                        }
            } 
        }
           
        public boolean jaSomosAmigos(String login){
            boolean exist = false;
            
            for(int i = 0; i < this.listaDeAmigos.size() ;i++){
                Amigo amigo = (Amigo) this.listaDeAmigos.get(i);
                String seulogin = amigo.getLogin();
                
                if(seulogin.equals(login)){
                    exist = true;
                    break;
                }
            }

            return exist;
        }
        
        
        public void exclui1(String LoginDoAmigo) throws SQLException {
            Connection conn = null;
            Statement statement = null;

            try {
                Class.forName("org.postgresql.Driver").newInstance( );
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testes","postgres","ifpb");

                statement = conn.createStatement();
                statement.execute("DELETE FROM amigos WHERE meulogin = '" + getMeuLogin() + "' AND seulogin = '" + LoginDoAmigo + "'");
                
                System.out.println("");
                System.out.println("Amigo foi excluído com sucesso!");
                
                statement.close();

                } catch (Exception ex) {
                    } finally {
                        if (statement != null) {
                            statement.close( );
                        }
                        if (conn != null) {
                            conn.close( );
                        }
            }
        }

        public void excluir(String LoginDoAmigo) throws SQLException {
  
            exclui1(LoginDoAmigo);
          
      
        public ArrayList getlistaDeAmigos() {
            return listaDeAmigos;
        }


        public String getMeuLogin() {
            return meuLogin;
        }
          public void setMeuLogin(String meuLogin) {
            this.meuLogin = meuLogin;
        }
        
        
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getLogin() {
            return login;
        }
        public void setLogin(String login) {
            this.login = login;
        }
    }

}


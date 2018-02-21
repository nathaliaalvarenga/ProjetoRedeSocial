package projeto;

public class Login {

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;

    private static final projeto.Usuario Usuario = null;

    public String logar(){
        try{
             DAOUsuario ud = new DAOUsuario();
            Usuario user = ud.logar(Usuario);
            Usuario = user;
            if(user != null){
                return "Bem vindo a sua rede social!";
            }else{
                FacesContext.getCurrentInstance().addMessage("opa", new FacesMessage("usuario invalido"));
                }

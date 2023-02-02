import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerTestes {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Iniciando...");
        
        ParametrosConexaoJdbc parametrosConexao = new ParametrosConexaoJdbc(TipoDriverJdbc.SQLSERVER);
        parametrosConexao.setServidor("Ametista");
        parametrosConexao.setPorta(1433);
        parametrosConexao.setBancoDados("ERP_Bergerson");
        parametrosConexao.setUsuario("sa");
        parametrosConexao.setSenha("@adventure.");
        parametrosConexao.setTimeOut(15);
        
        Class.forName(parametrosConexao.getClassForName());
        Connection con = DriverManager.getConnection(parametrosConexao.getConnectionString());
        con.close();
        
        System.out.println(".. finalizando!");
    }
}

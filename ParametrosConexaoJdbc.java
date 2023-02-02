public class ParametrosConexaoJdbc {
    private TipoDriverJdbc tipoDriver;
    private String servidor;
    private int porta;
    private String bancoDados;    
    private String usuario;
    private String senha;
    private int timeOut;
    private boolean criptografado;
    
    public ParametrosConexaoJdbc(TipoDriverJdbc tipoDriver) {
        this.limpar();
        this.tipoDriver = tipoDriver;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    
    public String getServidor() {
        return this.servidor;
    }
    
    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    public int getPorta() {
        return this.porta;
    }
    
    public void setBancoDados(String bancoDados) {
        this.bancoDados = bancoDados;
    }
    
    public String getBancoDados() {
        return this.bancoDados;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
    
    public int getTimeOut() {
        return this.timeOut;
    }
    
    public void setCriptografado(boolean criptografado) {
        this.criptografado = criptografado;
    }
    
    public boolean getCriptografado() {
        return this.criptografado;
    }
    
    public String getClassForName() {
        switch (this.tipoDriver) {
            case SQLSERVER: return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            default: return "";
        }
    }
    
    public String getConnectionString() {
        StringBuilder stringConexao = new StringBuilder();
        
        // Driver.
        stringConexao.append("jdbc:");
        
        switch (this.tipoDriver) {
            case SQLSERVER: stringConexao.append("sqlserver");
                 break;
            default: stringConexao.append("ideterminado");
                     break;
        }
        
        // Servidor.
        stringConexao.append("://");
        stringConexao.append(this.servidor);
        
        // Porta.
        if (this.porta > 0) {
            stringConexao.append(":");
            stringConexao.append(this.porta);            
        }
        
        // Banco de dados.
        stringConexao.append(";");
        stringConexao.append("databaseName=" + this.bancoDados);
        
        // Usuário.
        stringConexao.append(";");
        stringConexao.append("user=" + this.usuario);

        // Senha.
        stringConexao.append(";");
        stringConexao.append("password=" + this.senha);
        
        // Criptografado.
        stringConexao.append(";");
        stringConexao.append("encrypt=" + this.criptografado);
        
        return stringConexao.toString();        
    }

    public void limpar() {
        this.tipoDriver = null;
        this.servidor = "";
        this.porta = 0;
        this.usuario = "";
        this.senha = "";
        this.timeOut = 0;
        this.criptografado = false;
    }
}
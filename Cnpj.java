/*
 * Cnpj.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0.
 */

/**
 * Classe pública representando um número de CNPJ.
 * @author Marcio Alves (marcioalv@yahoo.com.br)
 * @version 1.0.0
 */
public class Cnpj {
    /**
     * Atributo privado com o número do CNPJ.
     */
    long numero;
    
    
    /**
     * Construtor público padrão somente limpa os atributos.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public Cnpj() {
        this.limpar();
    }

    /**
     * Construtor público que inicializa o número do CNPJ.
     * @param numero Número do CNPJ.
     * @throws IllegalCnpjException Caso o número do CNPJ informado seja inconsistente.     
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public Cnpj(String numero) throws IllegalCnpjException {
        this.limpar();
        this.setNumero(numero);
    }
    
    /**
     * Construtor público que inicializa o número do CNPJ.
     * @param numero Número do CNPJ.
     * @throws IllegalCnpjException Caso o número do CNPJ informado seja inconsistente.     
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public Cnpj(long numero) throws IllegalCnpjException {
        this.limpar();
        this.setNumero(numero);
    }    
    
    /**
     * Método público para atribuir um número de CNPJ.
     * @param numero Número do CNPJ.
     * @throws IllegalCnpjException Caso o número do CNPJ informado seja inconsistente.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public void setNumero(String numero) throws IllegalCnpjException {
        try {
            UtilsCnpj.validar(numero);
        }
        catch (IllegalCnpjException excecao) {
            throw excecao;
        }
        
        this.numero = Long.parseLong(UtilsCnpj.desformatar(numero));                    
    };
    
    /**
     * Método público para atribuir um número de CNPJ.
     * @param numero Número do CNPJ.
     * @throws IllegalCnpjException Caso o número do CNPJ informado seja inconsistente.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public void setNumero(long numero) throws IllegalCnpjException {
        try {
            UtilsCnpj.validar(numero);
        }
        catch (IllegalCnpjException excecao) {
            throw excecao;
        }
        
        this.numero = numero;
    };    

    /**
     * Método público para recuperar o número do CNPJ desformatado.
     * @return Número do CNPJ desformatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public String getNumero() {
        return UtilsCnpj.desformatar(String.valueOf(this.numero));
    };
    
    /**
     * Método público para recuperar o número do CNPJ desformatado.
     * @return Número do CNPJ desformatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public long getNumeroLong() {
        return this.numero;
    };    

    /**
     * Método público para recuperar o número do CNPJ formatado.
     * @return Número do CNPJ formatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public String getNumeroFormatado() {
        return UtilsCnpj.formatar(this.numero);
    };
    
    /**
     * Método público para limpar os atributos da classe.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */        
    public void limpar() {
        this.numero = 0;
    }
}
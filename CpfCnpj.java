/*
 * CpfCnpj.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0.
 */

/**
 * Classe pública representando um número de CPF/CNPJ.
 * @author Marcio Alves (marcioalv@yahoo.com.br)
 * @version 1.0.0
 */
public class CpfCnpj {
    /**
     * Atributo privado com o número do CPF/CNPJ.
     */
    long numero;
    
    
    /**
     * Construtor público padrão somente limpa os atributos.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public CpfCnpj() {
        this.limpar();
    }

    /**
     * Construtor público que inicializa o número do CPF/CNPJ.
     * @param numero Número do CPF/CNPJ.
     * @throws IllegalCpfException Caso o número do CPF/CNPJ informado seja inconsistente.     
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public CpfCnpj(String numero) throws IllegalCpfCnpjException {
        this.limpar();
        this.setNumero(numero);
    }
    
    /**
     * Construtor público que inicializa o número do CPF/CNPJ.
     * @param numero Número do CPF/CNPJ.
     * @throws IllegalCpfCnpjException Caso o número do CPF/CNPJ informado seja inconsistente.     
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public CpfCnpj(long numero) throws IllegalCpfCnpjException {
        this.limpar();
        this.setNumero(numero);
    }    
    
    /**
     * Método público para atribuir um número de CPF/CNPJ.
     * @param numero Número do CPF/CNPJ.
     * @throws IllegalCpfException Caso o número do CPF/CNPJ informado seja inconsistente.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public void setNumero(String numero) throws IllegalCpfCnpjException {
        try {
            UtilsCpfCnpj.validar(numero);
        }
        catch (IllegalCpfCnpjException excecao) {
            throw excecao;
        }
        
        this.numero = Long.parseLong(UtilsCpfCnpj.desformatar(numero));                    
    };
    
    /**
     * Método público para atribuir um número de CPF/CNPJ.
     * @param numero Número do CPF/CNPJ.
     * @throws IllegalCpfException Caso o número do CPF/CNPJ informado seja inconsistente.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public void setNumero(long numero) throws IllegalCpfCnpjException {
        try {
            UtilsCpfCnpj.validar(numero);
        }
        catch (IllegalCpfCnpjException excecao) {
            throw excecao;
        }
        
        this.numero = numero;
    };    

    /**
     * Método público para recuperar o número do CPF/CNPJ desformatado.
     * @return Número do CPF/CNPJ desformatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public String getNumero() {
        return UtilsCpfCnpj.desformatar(String.valueOf(this.numero));
    };
    
    /**
     * Método público para recuperar o número do CPF/CNPJ desformatado.
     * @return Número do CPF/CNPJ desformatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public long getNumeroLong() {
        return this.numero;
    };    

    /**
     * Método público para recuperar o número do CPF/CNPJ formatado.
     * @return Número do CPF/CNPJ formatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public String getNumeroFormatado() {
        return UtilsCpfCnpj.formatar(this.numero);
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
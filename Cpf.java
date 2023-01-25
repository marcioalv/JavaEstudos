/*
 * Cpf.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0.
 */

/**
 * Classe pública representando um número de CPF.
 * @author Marcio Alves (marcioalv@yahoo.com.br)
 * @version 1.0.0
 */
public class Cpf {
    /**
     * Atributo privado com o número do CPF.
     */
    long numero;
    
    
    /**
     * Construtor público padrão somente limpa os atributos.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public Cpf() {
        this.limpar();
    }

    /**
     * Construtor público que inicializa o número do CPF.
     * @param numero Número do CPF.
     * @throws IllegalCpfException Caso o número do CPF informado seja inconsistente.     
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public Cpf(String numero) throws IllegalCpfException {
        this.limpar();
        this.setNumero(numero);
    }
    
    /**
     * Construtor público que inicializa o número do CPF.
     * @param numero Número do CPF.
     * @throws IllegalCpfException Caso o número do CPF informado seja inconsistente.     
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0
     */
    public Cpf(long numero) throws IllegalCpfException {
        this.limpar();
        this.setNumero(numero);
    }    
    
    /**
     * Método público para atribuir um número de CPF.
     * @param numero Número do CPF.
     * @throws IllegalCpfException Caso o número do CPF informado seja inconsistente.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public void setNumero(String numero) throws IllegalCpfException {
        try {
            UtilsCpf.validar(numero);
        }
        catch (IllegalCpfException excecao) {
            throw excecao;
        }
        
        this.numero = Long.parseLong(UtilsCpf.desformatar(numero));                    
    };
    
    /**
     * Método público para atribuir um número de CPF.
     * @param numero Número do CPF.
     * @throws IllegalCpfException Caso o número do CPF informado seja inconsistente.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public void setNumero(long numero) throws IllegalCpfException {
        try {
            UtilsCpf.validar(numero);
        }
        catch (IllegalCpfException excecao) {
            throw excecao;
        }
        
        this.numero = numero;
    };    

    /**
     * Método público para recuperar o número do CPF desformatado.
     * @return Número do CPF desformatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public String getNumero() {
        return UtilsCpf.desformatar(String.valueOf(this.numero));
    };
    
    /**
     * Método público para recuperar o número do CPF desformatado.
     * @return Número do CPF desformatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public long getNumeroLong() {
        return this.numero;
    };    

    /**
     * Método público para recuperar o número do CPF formatado.
     * @return Número do CPF formatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves) --> versão 1.0.0     
     */
    public String getNumeroFormatado() {
        return UtilsCpf.formatar(this.numero);
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
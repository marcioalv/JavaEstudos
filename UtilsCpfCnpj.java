/*
 * UtilsCpfCnpj.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0.
 */
 
/**
 * Classe pública com métodos estáticos úteis para tratar CPFs e CNPJs.
 * @author Marcio Alves (marcioalv@yahoo.com.br)
 * @version 1.0.1
 */
public class UtilsCpfCnpj {
    /**
     * Método público estático para executar testes com a classe.
     */
    public static void main(String[] args) {
        long cpfCnpj = 1861915968L;
        System.out.println(cpfCnpj);
        
        try {
            validar(cpfCnpj);
            System.out.println("CPF/CNPJ válido!");
        }
        catch (IllegalCpfCnpjException excecao) {
            System.out.println(excecao.getMessage());
        }
    }

    /**
     * Método público estático para avaliar se o número é um CPF.
     * @param numero Número que será avaliado.
     * @return TRUE se o número for de um CPF.
     */
    public static boolean isCpf(String numero) {
        return (numero.length() <= UtilsCpf.QUANTIDADE_MAXIMA_DIGITOS);
    }

    /**
     * Método público estático para avaliar se o número é um CPF.
     * @param numero Número que será avaliado.
     * @return TRUE se o número for de um CPF.
     */
    public static boolean isCpf(long numero) {
        return isCpf(String.valueOf(numero));
    }    

    /**
     * Método público estático para avaliar se o número é um CNPJ.
     * @param numero Número que será avaliado.
     * @return TRUE se o número for de um CNPJ.
     */
    public static boolean isCnpj(String numero) {
        return (numero.length() > UtilsCpf.QUANTIDADE_MAXIMA_DIGITOS &&
                numero.length() <= UtilsCnpj.QUANTIDADE_MAXIMA_DIGITOS);
    }

    /**
     * Método público estático para avaliar se o número é um CNPJ.
     * @param numero Número que será avaliado.
     * @return TRUE se o número for de um CNPJ.
     */
    public static boolean isCnpj(long numero) {
        return isCnpj(String.valueOf(numero));
    }    

    /**
     * Método público estático para desformatar um número de CPF/CNPJ.
     * @param numero Número do CPF/CNPJ que será desformatado.
     * @return Número do CPF/CNPJ desformatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br).
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */    
    public static String desformatar(String numero) {
        String retorno = "";
        if (isCpf(numero)) retorno = UtilsCpf.desformatar(numero);
        if (isCnpj(numero)) retorno = UtilsCnpj.desformatar(numero);
        return retorno;
    }

    /**
     * Método público estático para formatar um número de CPF/CNPJ.
     * @param numero Número do CPF/CNPJ que será formatado.
     * @return Número do CPF/CNPJ formatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br).
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String formatar(String numero) {
        String retorno = "";        

        if (isCpf(numero)) {
            retorno = UtilsCpf.formatar(numero);
        }

        if (isCnpj(numero)) {
            retorno = UtilsCnpj.formatar(numero);
        }
        
        return retorno;
    }
    
    /**
     * Método público estático para formatar um número de CPF/CNPJ.
     * @param numero Número do CPF/CNPJ que será formatado.
     * @return Número do CPF/CNPJ formatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br).
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String formatar(long numero) {
        return UtilsCpfCnpj.formatar(String.valueOf(numero));
    }   

    /**
     * Método público estático para validar um número de CPF/CNPJ.
     * @param numero Número do CPF/CNPJ que será validado.
     * @throws IllegalCpfCnpjException Caso o CPF/CNPJ informado seja inconsistente. 
     * @author Marcio Alves (marcioalv@yahoo.com.br).
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static void validar(String numero) throws IllegalCpfCnpjException {
        try {
          if (isCpf(numero)) UtilsCpf.validar(numero);
          if (isCnpj(numero)) UtilsCnpj.validar(numero);
        }
        catch (IllegalCpfException | IllegalCnpjException excecao) {
            throw new IllegalCpfCnpjException(excecao.getMessage());
        }
    }

    /**
     * Método público estático para validar um número de CPF/CNPJ.
     * @param numero Número do CPF/CNPJ que será validado.
     * @throws IllegalCpfCnpjException Caso o CPF/CNPJ informado seja inconsistente. 
     * @author Marcio Alves (marcioalv@yahoo.com.br).
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static void validar(long numero) throws IllegalCpfCnpjException {
        validar(String.valueOf(numero));
    }    
}
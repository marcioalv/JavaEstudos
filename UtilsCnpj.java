/*
 * UtilsCnpj.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br
 *
 * Autor(es): Marcio Alves (marcioalv@yahoo.com.br) 
 *
 * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
 */
 
 import java.util.InputMismatchException;

/**
 * Classe pública com métodos estáticos úteis para tratar CNPJs.
 * @author Marcio Alves
 * @version 1.0.0
 */
public class UtilsCnpj {
    /**
     * Atributo público estático para indicar a quantidade máxima de dígitos em um CNPJ.
     */
    public static final int QUANTIDADE_MAXIMA_DIGITOS = 14;

    /**
     * Método público estático para executar testes com a classe.
     */
    public static void main(String[] args) {
        long cnpj = 76535111000164L;
        System.out.println(cnpj);
        
        try {
            validar(cnpj);
            System.out.println("CNPJ válido!");
            System.out.println(desformatar(String.valueOf(cnpj)));
            System.out.println(formatar(cnpj));
        }
        catch (IllegalCnpjException excecao) {
            System.out.println("CNPJ inválido!");
        }
    }

    /**
     * Método público estático para desformatar um número de CNPJ.
     * @param numero Número do CNPJ que será desformatado.
     * @return Número do CNPJ desformatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */    
    public static String desformatar(String numero) {
        String cnpj = UtilsString.extrairSomenteNumeros(numero);
        cnpj = UtilsString.recortarDireita(cnpj, QUANTIDADE_MAXIMA_DIGITOS);
        cnpj = UtilsString.preencherEsquerda(cnpj, "0", QUANTIDADE_MAXIMA_DIGITOS);
        return cnpj;
    }

    /**
     * Método público estático para formatar um número de CNPJ.
     * @param numero Número do CNPJ que será formatado.
     * @return Número do CNPJ formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String formatar(String numero) {
        String cnpj = desformatar(String.valueOf(numero));
        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
    }

    /**
     * Método público estático para formatar um número de CNPJ.
     * @param numero Número do CNPJ que será formatado.
     * @return Número do CNPJ formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static String formatar(long numero) {
        return formatar(String.valueOf(numero));        
    }   

    /**
     * Método público estático para validar um número de CNPJ.<br/>
     * @param numero Número do CNPJ que será validado.
     * @throws IllegalCnpjException Caso o CNPJ informado seja inconsistente. 
     * @author Marcio Alves
     * @version 1.0.0
     * Algoritmo originalmente escrito na web por Wolmir Cezer Garbin em 17/Novembro/2017:
     *     https://receitasdecodigo.com.br/java/classe-java-completa-para-gerar-e-validar-cpf-e-cnpj     
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static void validar(String numero) throws IllegalCnpjException {
        //
        // Desformatar o número do CNPJ.
        //
        String cnpj = desformatar(numero);
        
        //
        // Erro caso CNPJ seja composto uma sequência de números iguais.
        //
        String[] valores = {"00000000000000", "11111111111111", "22222222222222", "33333333333333", "44444444444444",
                            "55555555555555", "66666666666666", "77777777777777", "88888888888888", "99999999999999"};
                            
        if (UtilsString.contem(cnpj, valores)) {
            throw new IllegalCnpjException("O CNPJ informado não pode ser composto por uma sequência de números iguais!");
        }
        
        //
        // Variáveis para a verificação.
        // 
        char dig13, dig14;
        int sm, i, r, num, peso;

        //
        // Protege o codigo com um try para eventuais erros de conversao de tipo (int).
        //
        try {
            //
            // Cálculo do primeiro dígito verificador (13).
            //
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                //
                // converte o i-ésimo caractere do CNPJ em um número:
                //     por exemplo, transforma o caractere '0' no inteiro 0 (48 é a posicao de '0' na tabela ASCII).
                //
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else
                dig13 = (char) ((11 - r) + 48);

            //
            // Cálculo do segundo dígito verificador (14).
            //
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else
                dig14 = (char) ((11 - r) + 48);

            //
            // Verifica se os dígitos calculados conferem com os dígitos informados.
            //
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                return;
            }

            //
            // Número do CNPJ inconsistente.
            //
            throw new IllegalCnpjException("O número do CNPJ informado é inconsistente!");
        } catch (InputMismatchException erro) {
            throw new IllegalCnpjException("O número do CNPJ informado é inconsistente!");
        }        
    }

    /**
     * Método público estático para validar um número de CNPJ.
     * @param numero Número do CNPJ que será validado.
     * @throws IllegalCnpjException Caso o CNPJ informado seja inconsistente. 
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static void validar(long numero) throws IllegalCnpjException {
        String cnpj = String.valueOf(numero);
        validar(cnpj);
    }    
}

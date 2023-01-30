/*
 * UtilsCpf.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Autor(es): Marcio Alves (marcioalv@yahoo.com.br)  
 *
 * (1) Criado em 24/Janeiro/2023 por Marcio Alves (versão 1.0.0).
 * (2) Alterado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.1):
 *         Correção no método desformatar() para preencher com zeros à esquerda.
 *         Criados métodos validar(String) e validar(long).
 */
 
 import java.util.InputMismatchException;

/**
 * Classe pública com métodos estáticos úteis para tratar CPFs.
 * @author Marcio Alves
 * @version 1.0.1
 */
public class UtilsCpf {
    /**
     * Atributo público estático para indicar a quantidade máxima de dígitos em um CPF.
     */
    public static final int QUANTIDADE_MAXIMA_DIGITOS = 11;

    /**
     * Método público estático para executar testes com a classe.
     */
    public static void main(String[] args) {
        long cpf = 11111111111L;
        System.out.println(cpf);
        
        try {
            validar(cpf);
            System.out.println("CPF válido!");
        }
        catch (IllegalCpfException excecao) {
            System.out.println("CPF inválido!");
        }
    }

    /**
     * Método público estático para desformatar um número de CPF.
     * @param numero Número do CPF que será desformatado.
     * @return Número do CPF desformatado.
     * @author Marcio Alves
     * @version 1.0.1
     * Criado em 24/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     * Alterado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.1):
     *     Preenchido com zeros à esquerda.
     */    
    public static String desformatar(String numero) {
        String cpf = UtilsString.extrairSomenteNumeros(numero);
        cpf = UtilsString.recortarDireita(cpf, QUANTIDADE_MAXIMA_DIGITOS);
        cpf = UtilsString.preencherEsquerda(cpf, "0", QUANTIDADE_MAXIMA_DIGITOS);
        return cpf;
    }

    /**
     * Método público estático para formatar um número de CPF.
     * @param numero Número do CPF que será formatado.
     * @return Número do CPF formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 24/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static String formatar(String numero) {
        String cpf = desformatar(numero);        
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }
    
    /**
     * Método público estático para formatar um número de CPF.
     * @param numero Número do CPF que será formatado.
     * @return Número do CPF formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 24/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static String formatar(long numero) {
        return formatar(String.valueOf(numero));
    }   

    /**
     * Método público estático para validar um número de CPF.<br/>
     * @param numero Número do CPF que será validado.
     * @throws IllegalCpfException Caso o CPF informado seja inconsistente. 
     * @author Marcio Alves
     * @version 1.0.0
     * Algoritmo originalmente escrito na web por Wolmir Cezer Garbin em 17/Novembro/2017:
     *     https://receitasdecodigo.com.br/java/classe-java-completa-para-gerar-e-validar-cpf-e-cnpj
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static void validar(String numero) throws IllegalCpfException {
        //
        // Desformatar o número do CPF.
        //
        String cpf = desformatar(numero);
        
        //
        // Erro caso CPF seja composto uma sequência de números iguais.
        //
        String[] valores = {"00000000000", "11111111111", "22222222222", "33333333333", "44444444444",
                            "55555555555", "66666666666", "77777777777", "88888888888", "99999999999"};
                            
        if (UtilsString.contem(cpf, valores)) {
            throw new IllegalCpfException("O CPF informado não pode ser composto por uma sequência de números iguais!");
        }
        
        //
        // Variáveis para a verificação.
        //        
        char dig10, dig11;
        int sm, i, r, num, peso;

        //
        // Protege o codigo com um try para eventuais erros de conversao de tipo (int).
        //
        try {
            //
            // Cálculo do primeiro dígito verificador (10).
            //
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                //
                // converte o i-ésimo caractere do CPF em um número:
                //     por exemplo, transforma o caractere '0' no inteiro 0 (48 é a posicao de '0' na tabela ASCII).
                //
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // Converte no respectivo caractere numérico.

            //
            // Cálculo do segundo dígito verificador (11).
            //
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            //
            // Verifica se os dígitos calculados conferem com os dígitos informados.
            //
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return;
            }
            
            //
            // Número do CPF inconsistente.
            //
            throw new IllegalCpfException("O número do CPF informado é inconsistente!");
        } catch (InputMismatchException erro) {
            //
            // Número do CPF inconsistente.
            //            
            throw new IllegalCpfException("O número do CPF informado é inconsistente!");
        }
    }

    /**
     * Método público estático para validar um número de CPF.
     * @param numero Número do CPF que será validado.
     * @throws IllegalCpfException Caso o CPF informado seja inconsistente. 
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static void validar(long numero) throws IllegalCpfException {
        String cpf = String.valueOf(numero);
        validar(cpf);
    }    
}

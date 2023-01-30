/*
 * IllegalCpfException.java
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

/**
 * Exceção verificada lançada para um CPF inconsistente.
 * @author  Marcio Alves
 * @version 1.0.0
 */
public class IllegalCpfException extends Exception {
    /**
     * Construtor que inicializa a mensagem de exceção.
     * @param message Texto com a mensagem de exceção.
     */
    public IllegalCpfException(String message) {
        super(message);
    }
}
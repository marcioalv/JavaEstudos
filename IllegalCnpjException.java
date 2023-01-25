/*
 * IllegalCnpjException.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0.
 */

/**
 * Exceção verificada lançada para um CNPJ inconsistente.
 * @author  Marcio Alves (marcioalv@yahoo.com.br)
 * @version 1.0.0
 */
public class IllegalCnpjException extends Exception {
    /**
     * Construtor que inicializa a mensagem de exceção.
     * @param message Texto com a mensagem de exceção.
     */
    public IllegalCnpjException(String message) {
        super(message);
    }
}
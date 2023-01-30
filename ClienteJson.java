/*
 * ClienteJson.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Autor(es): Marcio Alves (marcioalv@yahoo.com.br)
 *
 * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).
 * Alterado em 27/Janeiro/2023 por Marcio Alves (versão 1.1.0):
 *     Incluído método toJson().
 */

/**
 * Classe pública representando um cliente no formato JSON.
 * @author Marcio Alves
 * @version 1.0.0
 */
public class ClienteJson {
    /**
     * Atributo privado indicando se o cliente é estrangeiro.
     */
    private boolean estrangeiro;
    
    /**
     * Atributo privado nom o nome do cliente.
     */
    private String nome;
    
    /**
     * Método público para indicar se o cliente é estrangeiro.
     * @param estrangeiro O cliente é estrangeiro?
     * @author Marcio Alves.
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).     
     */
    public void setEstrangeiro(boolean estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    /**
     * Método público para recuperar a indicação se o cliente é estrangeiro.
     * @return estrangeiro TRUE caso o cliente seja estrangeiro.
     * @author Marcio Alves.
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).     
     */    
    public boolean getEstrangeiro() {
        return this.estrangeiro;
    }
    
    /**
     * Método público com o nome do cliente.
     * @param nome Nome do cliente.
     * @author Marcio Alves.
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).     
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método público para recuperar o nome do cliente.
     * @return Nome do cliente.
     * @author Marcio Alves.
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).     
     */
    public String getNome() {
        return this.nome;
    }
 
    /**
     * Método público para retornar os atributos formatados em JSON.
     * @return Texto no formato JSON.
     * @author Marcio Alves.
     * @version 1.0.0
     * Criado em 27/Janeiro/2023 por Marcio Alves (versão 1.0.0).     
     */
    public String toJson() {
        return "";
    }
}
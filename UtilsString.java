/*
 * UtilsString.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * (1) Criado em 24/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0.
 * (2) Alterado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.1.0.
 *         Incluídos métodos: removerEspacos(), substituir(), reverter(), replicar(),
 *                            recortar(), recortarEsquerda(), recortarDireita(),
 *                            preencher(), preencherEsquerda(), preencherDireita().
 *                            contem() e formatarCapitalizedCase().
 */

/**
 * Classe pública com métodos estáticos úteis para tratar strings.
 * @author Marcio Alves (marcioalv@yahoo.com.br)
 * @version 1.1.0
 */
public class UtilsString {
    /**
     * Método público estático para executar testes com a classe.
     */    
    public static void main(String[] args) {
        String valor = "018.619.159-69";
        System.out.println(isSomenteNumeros(valor));
    }

    /**
     * Método público estático para remover os espaços em branco desnecessários.
     * @param texto Texto que será tratado.
     * @return Conteúdo tratado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String removerEspacos(String texto) {
        String retorno = texto.trim();
        retorno = retorno.replaceAll("\\s+", " ");
        return retorno;
    }
    
    /**
     * Método público estático para substituir uma string por outra.
     * @param texto Texto que será tratado.
     * @return Conteúdo tratado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String substituir(String texto, String procurar, String alterar) {
        return texto.replace(procurar, alterar);
    }    
    
    /**
     * Método público estático para reverter o conteúdo de um texto.
     * @param texto Texto que será revertido.
     * @return Conteúdo revertido.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String reverter(String texto) {
        String caracter = "";
        String revertido = "";
        for (int contador = texto.length() - 1; contador >= 0 ; contador--) {
            caracter = texto.substring(contador, contador + 1);            
            revertido += caracter;
        }
        return revertido;
    }
    
    /**
     * Método público estático para replicar um texto por uma quantidade de vezes.
     * @param texto Texto que será replicado.
     * @param quantidade Quantidade de vezes que o texto será replicado.
     * @return Conteúdo replicado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String replicar(String texto, int quantidade) {
        String conteudo = "";
        for (int contador = 0; contador < quantidade; contador++) {
            conteudo += texto;
        }
        return conteudo;
    }

    /**
     * Método público estático para recortar um texto em um determinado tamanho e direção.
     * @param texto Texto que será recortado.
     * @param tamanho  Novo tamanho do texto após recorte.
     * @param direcao Direção horizontal na qual o texto será recortado: ESQUERDA ou DIREITA.
     * @return Conteúdo recortado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String recortar(String texto, int tamanho, DirecaoHorizontal direcao) {
        //
        // Tamanho original do texto.
        //
        int tamanhoOriginal = texto.length();
        
        //
        // Se o tamanho original do texto é menor ou igual ao tamanho desejado então retorno texto atual sem nenhuma modificação.
        //
        if (tamanhoOriginal <= tamanho) {
            return texto;
        }
        
        //
        // Recorta o texto na direção desejada.
        //
        String recorte = "";
        
        if (direcao == DirecaoHorizontal.ESQUERDA) {
            recorte = texto.substring(0, tamanho);
        }
        
        if (direcao == DirecaoHorizontal.DIREITA) {
            recorte = texto.substring(tamanhoOriginal - tamanho, tamanhoOriginal);
        }
        
        return recorte;
    }

    /**
     * Método público estático para recortar um texto em um determinado tamanho à esquerda.
     * @param texto Texto que será recortado.
     * @param tamanho  Novo tamanho do texto após recorte.
     * @return Conteúdo recortado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String recortarEsquerda(String texto, int tamanho) {
        return recortar(texto, tamanho, DirecaoHorizontal.ESQUERDA);
    }

    /**
     * Método público estático para recortar um texto em um determinado tamanho à direita.
     * @param texto Texto que será recortado.
     * @param tamanho  Novo tamanho do texto após recorte.
     * @return Conteúdo recortado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String recortarDireita(String texto, int tamanho) {
        return recortar(texto, tamanho, DirecaoHorizontal.DIREITA);
    }    

    /**
     * Método público estático para preencher um texto com um conteúdo até um determinado tamanho e direção.
     * @param texto Texto que será preenchido.
     * @param conteudo Conteúdo com o qual será preenchido.
     * @param tamanho  Novo tamanho do texto após preenchimento.
     * @param direcao Direção horizontal na qual o texto será recortado: ESQUERDA ou DIREITA.
     * @return Conteúdo preenchido.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String preencher(String texto, String conteudo, int tamanho, DirecaoHorizontal direcao) {
        //
        // Tamanho original do texto.
        //
        int tamanhoOriginal = texto.length();
        
        //
        // Se o tamanho original do texto for maior ou igual ao tamanho desejado então trunca.
        //
        if (tamanhoOriginal >= tamanho) {
            return recortar(texto, tamanho, direcao);
        }
        
        //
        // Monta conteúdo replicado.
        //
        String preenchido = replicar(conteudo, tamanho - tamanhoOriginal);
        
        //
        // Retorna conteúdo preenchido.
        //
        if (direcao == DirecaoHorizontal.ESQUERDA) {
            return preenchido + texto;
        }
        
        if (direcao == DirecaoHorizontal.DIREITA) {
            return texto + preenchido;
        }
        
        return "";        
    }

    /**
     * Método público estático para preencher um texto com um conteúdo até um determinado tamanho à esquerda.
     * @param texto Texto que será preenchido.
     * @param conteudo Conteúdo com o qual será preenchido.
     * @param tamanho  Novo tamanho do texto após preenchimento.
     * @return Conteúdo preenchido.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String preencherEsquerda(String texto, String conteudo, int tamanho) {
        return preencher(texto, conteudo, tamanho, DirecaoHorizontal.ESQUERDA);
    }

    /**
     * Método público estático para preencher um texto com um conteúdo até um determinado tamanho à direita.
     * @param texto Texto que será preenchido.
     * @param conteudo Conteúdo com o qual será preenchido.
     * @param tamanho  Novo tamanho do texto após preenchimento.
     * @return Conteúdo preenchido.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String preencherDireita(String texto, String conteudo, int tamanho) {
        return preencher(texto, conteudo, tamanho, DirecaoHorizontal.DIREITA);
    }

    /**
     * Método público estático para verificar se um valor existem em uma lista de valores.
     * @param valor Valor que será localizado na lista.
     * @param valores Lista de valores.
     * @return TRUE se a lista contiver o valor.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static boolean contem(String valor, String[] valores) {
        for (int contador = 0; contador < valores.length; contador++) {
            if (valores[contador].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método público estático para indicar se um texto contém somente números.
     * @param texto Texto original de onde os caracteres serão avaliados.
     * @return TRUE se o texto conter somente números.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 24/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static boolean isSomenteNumeros(String texto) {
        String[] valores = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String caracter = "";
        for (int contador = 0; contador < texto.length(); contador++) {
            caracter = texto.substring(contador, contador + 1);           
            if (!contem(caracter, valores)) return false;
        }
        return true;
    }

    /**
     * Método público estático para retornar somente os números em um texto.
     * @param texto Texto original de onde serão extraídos somente os números.
     * @return Somente os números do texto.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 24/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String somenteNumeros(String texto) {
        String caracter = "";
        String numeros = "";
        for (int contador = 0; contador < texto.length(); contador++) {
            caracter = texto.substring(contador, contador + 1);
            if (isSomenteNumeros(caracter)) numeros += caracter;
        }
        return numeros;
    }

    /**
     * Método público estático para formatar um texto no padrão "capitalized case".
     * @param texto Texto original.
     * @return Texto formatado.
     * @author Marcio Alves (marcioalv@yahoo.com.br)
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (marcioalv@yahoo.com.br) --> versão 1.0.0
     */
    public static String formatarCapitalizedCase(String texto) {
        return "";
    }    
}

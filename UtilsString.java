/*
 * UtilsString.java
 *
 * Copyright (C) 2023 DoxCode Tecnologia e Informação LTDA 
 *
 * Outras informações podem ser obtidas em:
 *     https://www.doxcode.dev.br 
 *
 * Autor(es): Marcio Alves (marcioalv@yahoo.com.br)
 *
 * (1) Criado em 24/Janeiro/2023 por Marcio Alves (versão 1.0.0).
 * (2) Alterado em 25/Janeiro/2023 por Marcio Alves (versão 1.1.0):
 *         Incluídos métodos: removerEspacos(), substituir(), reverter(), replicar(),
 *                            recortar(), recortarEsquerda(), recortarDireita(),
 *                            preencher(), preencherEsquerda(), preencherDireita().
 *                            contem() e formatarCapitalizedCase().
 * (3) Alterado em 26/Janeiro/2023 por Marcio Alves (versão 1.2.0):
 *         Renomeado método de somenteNumeros() para extrairSomenteNumeros().
 */

/**
 * Classe pública com métodos estáticos úteis para tratar strings.
 * @author Marcio Alves
 * @version 1.2.0
 */
public class UtilsString {
    /**
     * Método público estático para executar testes com a classe.
     */    
    public static void main(String[] args) {
        String nome = "Carina Aparecida Dos Santos";

        System.out.println(formatarCapitalizedCase(nome));
        System.out.println("Titulo: " + formatarTitulo(nome));        
    }

    /**
     * Método público estático para remover os espaços em branco desnecessários.
     * @param texto Texto que será tratado.
     * @return Conteúdo tratado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String substituir(String texto, String procurar, String alterar) {
        return texto.replace(procurar, alterar);
    }    
    
    /**
     * Método público estático para reverter o conteúdo de um texto.
     * @param texto Texto que será revertido.
     * @return Conteúdo revertido.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String recortarEsquerda(String texto, int tamanho) {
        return recortar(texto, tamanho, DirecaoHorizontal.ESQUERDA);
    }

    /**
     * Método público estático para recortar um texto em um determinado tamanho à direita.
     * @param texto Texto que será recortado.
     * @param tamanho  Novo tamanho do texto após recorte.
     * @return Conteúdo recortado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String preencherDireita(String texto, String conteudo, int tamanho) {
        return preencher(texto, conteudo, tamanho, DirecaoHorizontal.DIREITA);
    }

    /**
     * Método público estático para verificar se um valor existem em uma lista de valores.
     * @param valor Valor que será localizado na lista.
     * @param valores Lista de valores.
     * @return TRUE se a lista contiver o valor.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 25/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 24/Janeiro/2023 por Marcio Alves (versão 1.0.0).
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
     * Método público estático para extrair somente os números em um texto.
     * @param texto Texto original de onde serão extraídos somente os números.
     * @return Somente os números do texto.
     * @author Marcio Alves
     * @version 1.1.0
     * Criado em 24/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     * Alterado em 26/Janeiro/2023 por Marcio Alves (versão 1.1.0):
     *     renomeado método de somenteNumeros() para extrairSomenteNumeros().
     */
    public static String extrairSomenteNumeros(String texto) {
        String caracter = "";
        String numeros = "";
        for (int contador = 0; contador < texto.length(); contador++) {
            caracter = texto.substring(contador, contador + 1);
            if (isSomenteNumeros(caracter)) numeros += caracter;
        }
        return numeros;
    }

    /**
     * Método público estático para separar uma string a cada ocorrência de um delimitador.
     * @param texto Texto original com os delimitadores inseridos.
     * @param delimitador Delimitador que irá forçar a separação do texto.
     * @return Array de strings para cada separação do texto.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String[] separar(String texto, String delimitador) {
        String regex = delimitador + "+";
        return texto.split(regex);
    }
    
    /**
     * Método público estático para formatar um texto em letras minúsculas.
     * @param texto Texto original.
     * @return Texto formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String formatarMinusculas(String texto) {
        return texto.toLowerCase();
    }
    
    /**
     * Método público estático para formatar um texto em letras maiúsculas.
     * @param texto Texto original.
     * @return Texto formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String formatarMaiusculas(String texto) {
        return texto.toUpperCase();
    }
    
    /**
     * Método público estático para formatar um texto com a primeira letra em maiúsculas e as demais em minúsculas.
     * @param texto Texto original.
     * @return Texto formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0)
     */
    public static String formatarMaiusculasMinusculas(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.toLowerCase().substring(1, texto.length());
    }

    /**
     * Método público estático para formatar um texto no padrão "capitalized case".
     * @param texto Texto original.
     * @return Texto formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String formatarCapitalizedCase(String texto) {       
        //
        // Separar o conteúdo em palavras sem espaços desnecessários.
        //
        String[] listaPalavras = separar(removerEspacos(texto), " ");
        
        //
        // Para cada palavra da lista deixar a primeira letra em maiúsculas.
        //
        String retorno = "";
        String palavra = "";
        for (int contador = 0; contador < listaPalavras.length; contador++) {
            palavra = listaPalavras[contador];
            palavra = formatarMinusculas(palavra);
            palavra = formatarMaiusculasMinusculas(palavra);
            
            if (!retorno.equals("")) retorno += " ";
            retorno += palavra;
        }
       
        return retorno;
    }

    /**
     * Método público estático para formatar um texto no padrão "título".
     * @param texto Texto original.
     * @return Texto formatado.
     * @author Marcio Alves
     * @version 1.0.0
     * Criado em 26/Janeiro/2023 por Marcio Alves (versão 1.0.0).
     */
    public static String formatarTitulo(String texto) {
        System.out.println("");
        String[] listaPalavras = separar(formatarCapitalizedCase(texto), " ");
        String titulo = "";
        String palavra = "";
        for (int contador = 0; contador < listaPalavras.length; contador++) {
            palavra = listaPalavras[contador];            

            if (contador > 0) {                        
                if (palavra.equals("E")) palavra = "e";
       
                if (palavra.equals("O")) palavra = "o";
                if (palavra.equals("Os")) palavra = "os";
        
                if (palavra.equals("Da")) palavra = "da";
                if (palavra.equals("Das")) palavra = "das";
        
                if (palavra.equals("De")) palavra = "de";
        
                if (palavra.equals("Do")) palavra = "do";
                if (palavra.equals("Dos")) palavra = "dos";

                if (palavra.equals("Na")) palavra = "na";
                if (palavra.equals("Nas")) palavra = "nas";       

                if (palavra.equals("No")) palavra = "no";
                if (palavra.equals("Nos")) palavra = "nos";                
        
                if (palavra.equals("Em")) palavra = "em";
        
                if (palavra.equals("Para")) palavra = "para";

                if (palavra.equals("Ltd.")) palavra = "Ltda";
                if (palavra.equals("Ltd")) palavra = "Ltda";
        
                if (palavra.equals("Ltda.")) palavra = "Ltda";
        
                if (palavra.equals("S/c")) palavra = "S/C";
                if (palavra.equals("S.c")) palavra = "S/C";
                if (palavra.equals("S.c.")) palavra = "S/C";
                        
                if (palavra.equals("S/a")) palavra = "S/A";
                if (palavra.equals("S.a")) palavra = "S/A";
                if (palavra.equals("S.a.")) palavra = "S/A";

                if (palavra.equals("Of")) palavra = "of";
            }
            
            if (contador == listaPalavras.length - 1) {
                if (palavra.equals("Lt")) palavra = "Ltda";
            }
            
            if (titulo != "") titulo += " ";
            titulo += palavra;
        }
        System.out.println("");

        return titulo;
    }    
}
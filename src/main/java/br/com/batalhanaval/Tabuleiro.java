package br.com.batalhanaval;

import java.util.Arrays;
import java.util.Random;

class Tabuleiro {
    public int tamanho = 10; // tamanho
    public char[][] tabuleiro;
    public char[] tabLinhas;
    public Random random;
    public int linhas;
    public int colunas;
    public String[] posisaoBarcos = new String[10];
    public String[] posicoesBombardeadas = new String[100];
    

    // Se o tamanho vai ser 10, não precisa passar o tamanho como parâmetro
    public Tabuleiro() {
        // this.tamanho = tamanho;
        this.tabuleiro = new char[tamanho][tamanho];
        this.tabLinhas = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
        this.random = new Random();
        // this.linhas = linhas;
        // this.colunas = colunas;
    }

    public boolean constroiTabuleiro() {
        if (tabuleiro != null) {
            System.out.println("Tabuleiro criado.");
            for (int i = 0; i < tamanho; i++) {
                Arrays.fill(tabuleiro[i], '.');
            }
            return true;
        } else {
            return false;
        }
    }

    public void preencheTabuleiroComputador() {
        for (int contador = 0; contador < 10;) {
            linhas = random.nextInt(tamanho);
            colunas = random.nextInt(tamanho);
            if (insereNavio(linhas, colunas)) {
                posisaoBarcos[contador] = tabLinhas[linhas] + " " + colunas;
                contador++;
            }
        }
    }

    public boolean insereNavio(int linhas, int colunas) {
        if (verificaTabuleiro(linhas, colunas)) {
            tabuleiro[linhas][colunas] = '#';
            return true;
        } else {
            return false;
        }
    }

    // Modifiquei aqui para que ele retornasse true, para ter mais sentindo
    public boolean verificaTabuleiro(int linha, int coluna) {
        return tabuleiro[linha][coluna] != '#';
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(tabLinhas[i] + " |");
            imprimeLinha(tabuleiro[i]);
        }
        System.out.print("----------------------- \n  |");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    private void imprimeLinha(char[] parte) {
        for (int i = 0; i < parte.length; i++) {
            if (parte[i] == '#') {
                System.out.print("$ "); // ". " pra esconder o navio
            } else {
                System.out.print(parte[i] + " ");
            }
        }
        System.out.println();
    }

    public boolean verificarQuantidadeDeBarcos() {
        int contador = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == '#') {
                    contador++;
                }
            }
        }
        return contador == 10;
    }

public boolean posicaoFoiBombardeada(){
    for (int i = 0; i < posicoesBombardeadas.length; i++) {
        if(posicoesBombardeadas[i] == tabLinhas[linhas] + " " + colunas){
            return true;
        }
    }
    return false;
}

    public int getTamanho() {
        return tamanho;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }
}
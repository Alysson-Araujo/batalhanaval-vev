package br.com.batalhanaval;

import java.util.Scanner;
import java.util.Locale;

class Jogador {
    public Scanner scanner;
    public Tabuleiro tabuleiro;

    public Jogador() {
        this.scanner = new Scanner(System.in);
        this.tabuleiro = new Tabuleiro();
    }

    public boolean constroiTabuleiro() {
        return tabuleiro.constroiTabuleiro();
    }

    public void preencheTabuleiroComputador() {
        tabuleiro.preencheTabuleiroComputador();
    }

    public void preencherTabuleiroJogador() {
        System.out.println("Jogador, preencha o tabuleiro com os barcos.");
        int navios = 0;
        if (tabuleiro.posisaoBarcos[0] != null) {
            while (navios < 10) { // 10
                System.out.printf("Insira as coordenadas para o barco %d (Exemplo: B 5): ", navios + 1);
                String[] posicoe = tabuleiro.posisaoBarcos[navios].split(" ");
                if (tabuleiro.insereNavio(posicoe[0].toUpperCase(Locale.ROOT).charAt(0) - 65,
                        posicoe[1].charAt(0) - 48)) {
                    navios++;
                } else {
                    System.out.println("Não é possível posicionar um barco nessa posição. Tente novamente.");
                }
            }
        } else {
            while (navios < 2) { // 10
                System.out.printf("Insira as coordenadas para o barco %d (Exemplo: B 5): ", navios + 1);
                tabuleiro.linhas = scanner.next().toUpperCase(Locale.ROOT).charAt(0) - 65;
                tabuleiro.colunas = scanner.next().charAt(0) - 48;

                if (tabuleiro.insereNavio(tabuleiro.linhas, tabuleiro.colunas)) {
                    navios++;
                } else {
                    System.out.println("Não é possível posicionar um barco nessa posição. Tente novamente.");
                }
            }
        }
        System.out.println("\nTabuleiro preenchido pelo jogador:");
    }

    public void imprimirTabuleiro() {
        tabuleiro.imprimirTabuleiro();
    }
}
package br.com.batalhanaval;

import java.util.Scanner;
import java.util.Locale;

public class Jogo {
    private int vitoriasJogador1;
    private int vitoriasJogador2;
    private Scanner scanner;

    public Jogo() {
        this.vitoriasJogador1 = 0;
        this.vitoriasJogador2 = 0;
        this.scanner = new Scanner(System.in);
    }

    public void jogo(Tabuleiro tab) {
        int round = 0;
        int ships = 0;

        while (ships < 10) {
            do {
                System.out.println("Digite as coordenadas da sua tentativa. (Exemplo: B 5)");
                tab.linhas = scanner.next().toUpperCase(Locale.ROOT).charAt(0) - 65;
                tab.colunas = scanner.next().charAt(0) - 48;
            } while (verificaCoordenada(tab));

            System.out.println("-----------------------------------");
            System.out.printf("Tentativa: %d \n -------------------", round++);

            if (jogarBomba(tab)) {
                ships++;
            }
        }

        System.out.print("Todos os navios foram afundados. \nParabéns por vencer o jogo!");
    }

    public boolean verificaCoordenada(Tabuleiro tab) {
        int tamanhoTabuleiro = tab.getTamanho();

        if (tab.linhas < 0 || tab.linhas >= tamanhoTabuleiro || tab.colunas < 0 || tab.colunas >= tamanhoTabuleiro) {
            System.out.println("Coordenadas inválidas");
            return true;
        }
        if (tab.tabuleiro[tab.linhas][tab.colunas] == '%' || tab.tabuleiro[tab.linhas][tab.colunas] == 'x') {
            System.out.println("Não é possível fazer esse movimento.");
            return true;
        }
        return false;
    }

    public void jogoPVP(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2) {
        boolean jogador1Venceu = false;
        boolean jogador2Venceu = false;

        int linhas, colunas;

        for (int rodada = 0; !jogador1Venceu && !jogador2Venceu; rodada++) {
            System.out.println("-------------------");
            System.out.println("Rodada " + (rodada + 1));
            System.out.println("-------------------");
            System.out.println("Jogador 1:");

            do {
                System.out.println("Digite as coordenadas da sua tentativa. (Exemplo: B 5)");
                tabuleiro1.linhas = scanner.next().toUpperCase(Locale.ROOT).charAt(0) - 65;
                tabuleiro1.colunas = scanner.next().charAt(0) - 48;
            } while (jogarBomba(tabuleiro1));

            if (verificaVitoria(tabuleiro1)) {
                jogador1Venceu = true;
                break;
            }

            System.out.println("-------------------");
            System.out.println("Jogador 2:");

            do {
                System.out.println("Digite as coordenadas da sua tentativa. (Exemplo: B 5)");
                tabuleiro2.linhas = scanner.next().toUpperCase(Locale.ROOT).charAt(0) - 65;
                tabuleiro2.colunas = scanner.next().charAt(0) - 48;
            } while (jogarBomba(tabuleiro2));

            if (verificaVitoria(tabuleiro2)) {
                jogador2Venceu = true;
                break;
            }
        }

        if (jogador1Venceu) {
            System.out.println("Jogador 1 venceu o jogo!");
            vitoriasJogador1++;
        } else if (jogador2Venceu) {
            System.out.println("Jogador 2 venceu o jogo!");
            vitoriasJogador2++;
        } else {
            System.out.println("Empate! Nenhum jogador venceu o jogo.");
        }
    }

    public boolean verificaVitoria(Tabuleiro tab) {
        int naviosRestantes = 0;
        int tamanhoTabuleiro = tab.getTamanho();
        for (int i = 0; i < tamanhoTabuleiro; i++) {
            for (int j = 0; j < tamanhoTabuleiro; j++) {
                if (tab.tabuleiro[i][j] == '#') {
                    naviosRestantes++;
                }
            }
        }
        return naviosRestantes == 0;
    }

    public boolean jogarBomba(Tabuleiro tab) {
        System.out.println("Lançando bomba...");
        if (tab.tabuleiro[tab.linhas][tab.colunas] == '.') {
            tab.tabuleiro[tab.linhas][tab.colunas] = '%';
            System.out.println("Tentativa errada!");
            tab.imprimirTabuleiro();
            return false;
        } else if (tab.tabuleiro[tab.linhas][tab.colunas] == '%') {
            System.out.println("Tentativa errada!");
            tab.imprimirTabuleiro();
            return false;
        } else {
            tab.tabuleiro[tab.linhas][tab.colunas] = 'x';
            System.out.println("Tentativa certa!");
            tab.imprimirTabuleiro();
            return true;
        }
    }
}
package br.com.batalhanaval;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void clearTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            Process process;
            if (os.contains("win")) {
                process = Runtime.getRuntime().exec("cmd /c cls");
            } else {
                process = Runtime.getRuntime().exec("clear");
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Bem vindo ao Batalha Naval");
            // Explicar as regras do jogo
            System.out.println("1. Jogador vs Computador");
            System.out.println("2. Jogador vs Jogador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Jogador computador = new Jogador();
                    computador.constroiTabuleiro();
                    computador.preencheTabuleiroComputador();
                    computador.imprimirTabuleiro(); // apaga

                    Jogador jogador = new Jogador();
                    jogador.constroiTabuleiro();
                    jogador.preencherTabuleiroJogador();
                    jogador.imprimirTabuleiro();

                    Jogo jogoVsPC = new Jogo();
                    // jogoVsPC.jogo(jogador1.tabuleiro);
                    jogoVsPC.jogoVsComputador(computador.tabuleiro, jogador.tabuleiro);
                    break;
                case 2:
                    Jogador jogador2 = new Jogador();
                    jogador2.constroiTabuleiro();
                    jogador2.preencherTabuleiroJogador();
                    jogador2.imprimirTabuleiro();

                    Jogador jogador3 = new Jogador();
                    jogador3.constroiTabuleiro();
                    jogador3.preencherTabuleiroJogador();
                    jogador3.imprimirTabuleiro();

                    Jogo jogoPVP = new Jogo();
                    jogoPVP.jogoPVP(jogador3.tabuleiro, jogador2.tabuleiro);
                    break;
                case 0:
                    System.out.println("Saindo do jogo. Obrigado por jogar!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
package br.com.batalhanaval;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class JogadorTest {
    

    @Test
    public void oJogadorDeveConterUmTabuleiro(){
        Jogador jogador = new Jogador();

        boolean tabuleiroPreenchido = jogador.constroiTabuleiro();

        assertEquals(true, tabuleiroPreenchido);
    }

    // Como seria feito o teste para essa situação? 
    @Test
    public void oJogadorDevePreencherOSeuTabuleiroComDezNavios(){
        Jogador jogador = new Jogador();

        jogador.constroiTabuleiro();
        String posisaoBarcos[] = new String[10];
        posisaoBarcos[0] = "A 0";
        posisaoBarcos[1] = "B 0";
        posisaoBarcos[2] = "C 0";
        posisaoBarcos[3] = "D 0";
        posisaoBarcos[4] = "E 0";
        posisaoBarcos[5] = "F 0";
        posisaoBarcos[6] = "G 0";
        posisaoBarcos[7] = "H 0";
        posisaoBarcos[8] = "I 0";
        posisaoBarcos[9] = "J 0";
        jogador.tabuleiro.posisaoBarcos = posisaoBarcos;
        jogador.preencherTabuleiroJogador();
        
        assertEquals(true, jogador.tabuleiro.verificarQuantidadeDeBarcos());
    }
    @Test
    public void oJogadorDeveSelecionarUmaPosicaoNoTabuleiroParaAtacarOInimigo(){
        Jogo jogo = new Jogo();
        Jogador jogador = new Jogador();
        jogador.tabuleiro.linhas = 0;
        jogador.tabuleiro.colunas = 0;
        boolean atacou = jogo.jogarBomba(jogador.tabuleiro);
        assertEquals(true, atacou);
    }

}


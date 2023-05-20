package br.com.batalhanaval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JogadorTest {
    

    @Test
    public void oJogadorDeveConterUmTabuleiro(){
        Jogador jogador = new Jogador();

        jogador.constroiTabuleiro();

        assertEquals(true, jogador.tabuleiro != null);
    }

    // Como seria feito o teste para essa situação? 
    // @Test
    // public void oJogadorDevePreencherOSeuTabuleiroComDoisNavios(){
    //     Jogador jogador = new Jogador();

    //     jogador.constroiTabuleiro();
    //     jogador.preencherTabuleiroJogador();

    //     assertEquals(2, jogador.tabuleiro.navios);
    // }
    @Test
    public void oJogadorDeveSelecionarUmaPosicaoNoTabuleiroParaAtacarOInimigo(){
        Jogo jogo = new Jogo();
    }
}

package br.com.batalhanaval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TabuleiroTest {


    @Test
    public void verificarSeAPosicaoPodeInserirUmBarcoNoTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro();

        boolean posicaoLivre = tabuleiro.verificaTabuleiro(0, 0);

        assertEquals(true, posicaoLivre);
    }

    @Test
    public void verificarSeAPosicaoNaoPodeInseridoUmBarcoNoTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.tabuleiro[0][0] = '#';
        boolean posicaoLivre = tabuleiro.verificaTabuleiro(0, 0);

        assertEquals(false, posicaoLivre);
    }

    @Test
    public void inserirUmNavioEmUmaPosicaoQueEstejaLivreNoTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro();

        boolean posicaoLivre = tabuleiro.insereNavio(0, 0);

        assertEquals(true, posicaoLivre);
    }

    @Test
    public void inserirUmNavioEmUmaPosicaoQueNaoEstejaLivreNoTabuleiro(){
        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.tabuleiro[0][0] = '#';
        boolean posicaoLivre = tabuleiro.insereNavio(0, 0);

        assertEquals(false, posicaoLivre);
    }

    @Test
    public void verificarSeOTabuleiroFoiCriadoComTamanho10(){
        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.constroiTabuleiro();

        assertEquals(10, tabuleiro.tamanho);
    }

    @Test
    public void verificarSeOTabuleiroTem10Navios(){
        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.preencheTabuleiroComputador();
        boolean tem10NaviosNoTabuleiro = tabuleiro.verificarQuantidadeDeBarcos();

        assertEquals(tem10NaviosNoTabuleiro, true);
    }
}

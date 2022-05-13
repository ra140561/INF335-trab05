package br.unicamp.ic.inf335.app.inf335_trab04;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class AnuncioBeanTest {
	
	@Test
	void testaConstrutorDefaultAnunciosMaisGetters() {
		//Anuncio sem atributos
		final AnuncioBean anuncioDummy = new AnuncioBean();
		
		assertTrue(anuncioDummy.getProduto() instanceof ProdutoBean);
		assertEquals(Collections.EMPTY_LIST, anuncioDummy.getFotosUrl());
		assertEquals(0.0, anuncioDummy.getDesconto());
		assertEquals((long)1L, AnuncioBean.getSerialversionuid());
	}
	
	@Test
	void testaSetters() throws MalformedURLException {
		//Anuncio inicializado sem atributos
		final AnuncioBean anuncioAlterado = new AnuncioBean();
		
		//objetos que sao parametros para criacao de um Anuncio
		final ProdutoBean produto = new ProdutoBean(
				"A350",	"Aspirador", "Aspira po", 150.0, "novo");
		final URL myURL = new URL("http://xpTotrab02xpTo.com/foto1/");
		final ArrayList<URL> fotos = new ArrayList<URL>();
		fotos.add(myURL);
		final Double desconto = 0.1;

		
		//alteracao dos atributos do anunciante
		anuncioAlterado.setProduto(produto);
		anuncioAlterado.setFotosUrl(fotos);
		anuncioAlterado.setDesconto(desconto);
		
		assertEquals("A350", anuncioAlterado.getProduto().getCodigo());
		assertEquals("Aspirador", anuncioAlterado.getProduto().getNome());
		assertEquals(0.1, anuncioAlterado.getDesconto());
	}
	
	@Test
	void testaConstrutorParametrizado() throws MalformedURLException {
		
		//objetos que sao parametros para criacao de um Anuncio
		final ProdutoBean produto = new ProdutoBean(
				"A350",	"Aspirador", "Aspira po", 150.0, "novo");
		final URL myURL = new URL("http://xpTotrab02xpTo.com/foto1/");
		final ArrayList<URL> fotos = new ArrayList<URL>();
		fotos.add(myURL);
		final Double desconto = 0.1;

		//Anuncio com atributos
		final AnuncioBean anuncio = new AnuncioBean(produto, fotos, desconto);
		
		assertEquals("A350", anuncio.getProduto().getCodigo());
		assertEquals("Aspirador", anuncio.getProduto().getNome());
		assertEquals(myURL, anuncio.getFotosUrl().get(0));
		assertEquals(0.1, anuncio.getDesconto());
	}

	@Test
	void testaGetValor() throws MalformedURLException {
		//Anuncio inicializado sem atributos
		final AnuncioBean anuncioComDesconto = new AnuncioBean();
		
		//objetos que sao parametros para criacao de um Anuncio
		final ProdutoBean produto = new ProdutoBean(
				"A350",	"Aspirador", "Aspira po", 150.0, "novo");
		final URL myURL = new URL("http://xpTotrab02xpTo.com/foto1/");
		final ArrayList<URL> fotos = new ArrayList<URL>();
		fotos.add(myURL);
		final Double desconto = 0.1;
		final Double valorComDesconto = produto.getValor()*(1-desconto);

		
		//alteracao dos atributos do anunciante
		anuncioComDesconto.setProduto(produto);
		anuncioComDesconto.setFotosUrl(fotos);
		anuncioComDesconto.setDesconto(desconto);
		
		assertEquals("A350", anuncioComDesconto.getProduto().getCodigo());
		assertEquals("Aspirador", anuncioComDesconto.getProduto().getNome());
		assertEquals(0.1, anuncioComDesconto.getDesconto());
		assertEquals(valorComDesconto, anuncioComDesconto.getValor());
	}
	
	
	
	
}

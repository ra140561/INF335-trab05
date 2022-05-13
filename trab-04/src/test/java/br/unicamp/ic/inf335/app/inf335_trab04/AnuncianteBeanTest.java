package br.unicamp.ic.inf335.app.inf335_trab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

class AnuncianteBeanTest {

	@Test
	void testaConstrutorDefaultAnuncianteMaisGetters() {
		//Anunciante sem atributos
		final AnuncianteBean anuncianteDummy = new AnuncianteBean();
		
		assertEquals("", anuncianteDummy.getNome());
		assertEquals("", anuncianteDummy.getCPF());
		assertEquals(Collections.EMPTY_LIST, anuncianteDummy.getAnuncios()); 
	}
	
	@Test
	void testaSetters() throws MalformedURLException {
		//Anunciante inicializado sem atributos
		final AnuncianteBean anuncianteAlterado = new AnuncianteBean();
		
		//objetos que sao parametros para criacao de um Anuncio
		final ProdutoBean produto = new ProdutoBean(
				"A350",	"Aspirador", "Aspira po", 150.0, "novo");
		final URL myURL = new URL("http://xpTotrab02xpTo.com/foto1/");
		final ArrayList<URL> fotos = new ArrayList<URL>();
		fotos.add(myURL);

		//Novo Anuncio
		final AnuncioBean anuncio = new AnuncioBean(produto, fotos, 0.0);
		
		//alteracao dos atributos do anunciante
		anuncianteAlterado.setNome("Jose Oliveira");
		anuncianteAlterado.setCPF("123.456.789-0");
		anuncianteAlterado.addAnuncio(anuncio);
		
		assertEquals("Jose Oliveira", anuncianteAlterado.getNome());
		assertEquals("123.456.789-0", anuncianteAlterado.getCPF());
		assertNotEquals(Collections.EMPTY_LIST, anuncianteAlterado.getAnuncios());
		assertEquals("Aspirador", anuncianteAlterado.getAnuncios().
				get(0).getProduto().getNome());
		assertEquals("A350", anuncianteAlterado.getAnuncios().
				get(0).getProduto().getCodigo());
		
		//remove anuncio existente
		anuncianteAlterado.removeAnuncio(0);
		
		assertEquals(Collections.EMPTY_LIST, anuncianteAlterado.getAnuncios());
	}
	
	@Test
	void testaConstrutorParametrizado() {
		//Anunciante com atributos
		final ArrayList<AnuncioBean> listaAnuncios = 
				new ArrayList<AnuncioBean>();
		//Anunciante com atributos
		final AnuncianteBean anuncianteA = new AnuncianteBean(
				"Jose Adamantio", "123.456.789-0", listaAnuncios); 
		
		assertEquals("Jose Adamantio", anuncianteA.getNome());
		assertEquals("123.456.789-0", anuncianteA.getCPF());
		assertEquals(Collections.EMPTY_LIST, anuncianteA.getAnuncios());
	}
	
	@Test
	void testaValorMedioAnuncios() throws MalformedURLException {
		//objetos que sao parametros para criacao de um Anuncio
		//produto1 + URL para anuncio
		final ProdutoBean produtoA = new ProdutoBean(
				"A350",	"Aspirador", "Aspira po", 150.0, "novo");
		final URL uRLProd1 = new URL("http://xpTotrab02xpTo.com/foto1/");
		
		//produto2 + URL para anuncio
		final ProdutoBean produtoB = new ProdutoBean(
				"T100",	"Torradeira", "tosta paes", 40.0, "semi-novo");
		final URL uRLProd2 = new URL("http://xpTotrab02xpTo.com/foto2/");
				
		final ArrayList<URL> fotos = new ArrayList<URL>();
		fotos.add(uRLProd1);
		fotos.add(uRLProd2);
		
		//Criacao dos 2 Anuncios sem descontos
		final AnuncioBean anuncio1 = new AnuncioBean(produtoA, fotos, 0.0);
		final AnuncioBean anuncio2 = new AnuncioBean(produtoB, fotos, 0.0);
		
		//Inclusao dos anuncios numa lista
		final ArrayList<AnuncioBean> listaAnuncios = new ArrayList<AnuncioBean>();
		listaAnuncios.add(anuncio1);
		listaAnuncios.add(anuncio2);
		
		//Criacao do anunciante e associacao com sua lista de anuncios
		final AnuncianteBean anunciante = new AnuncianteBean();
		anunciante.setAnuncios(listaAnuncios);
		
		//expected (150+40)/2 = 95 , versus calculado por valorMedioAnuncios()
		assertEquals( ( (anuncio1.getProduto().getValor() + 
						anuncio2.getProduto().getValor()) / 2),
						anunciante.valorMedioAnuncios());
		
	}

	
	
	
	
	
}

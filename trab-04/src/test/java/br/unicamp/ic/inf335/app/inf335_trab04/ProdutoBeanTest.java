package br.unicamp.ic.inf335.app.inf335_trab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoBeanTest {

	@Test
	void testaConstrutorDefaultProdutoMaisGetters() {
		//Produto sem atributos
		final ProdutoBean produtoDummy = new ProdutoBean();
		
		assertEquals("", produtoDummy.getCodigo());
		assertEquals("", produtoDummy.getNome());
		assertEquals("", produtoDummy.getDescricao());
		assertEquals(0.0, produtoDummy.getValor());
		assertEquals("", produtoDummy.getEstado());
		assertEquals((long)1L, ProdutoBean.getSerialversionuid());
	}
	
	@Test
	void testaSetters() {
		//Produto sem atributos
		final ProdutoBean produtoAlterado = new ProdutoBean();
		
		//definicao de cada atributo
		produtoAlterado.setCodigo("T100");
		produtoAlterado.setNome("Torradeira");
		produtoAlterado.setDescricao("tosta paes");
		produtoAlterado.setValor(40.0);
		produtoAlterado.setEstado("semi-novo");
		
		assertEquals("T100", produtoAlterado.getCodigo());
		assertEquals("Torradeira", produtoAlterado.getNome());
		assertEquals("tosta paes", produtoAlterado.getDescricao());
		assertEquals(40.0, produtoAlterado.getValor());
		assertEquals("semi-novo", produtoAlterado.getEstado());
		
	}
	
	@Test
	void testaConstrutorParametrizado() {
		//Produto com atributos
		final ProdutoBean produtoA = new ProdutoBean(
				"A350",	"Aspirador", "Aspira po", 150.0, "novo"); 
		
		assertEquals("A350", produtoA.getCodigo());
		assertEquals("Aspirador", produtoA.getNome());
		assertEquals("Aspira po", produtoA.getDescricao());
		assertEquals(150.0, produtoA.getValor());
		assertEquals("novo", produtoA.getEstado());
	}
	
	@Test
	void testaComparacaoEntreProdutos() {
		
		//Produto com maior valor
		final ProdutoBean produtoA = new ProdutoBean(
				"A350",	"Aspirador", "Aspira po", 150.0, "novo"); 
		
		//Produto com menor valor
		final ProdutoBean produtoB = new ProdutoBean(
				"T100",	"Torradeira", "tosta paes", 40.0, "semi-novo");
		
		//Produto A é mais caro do que Produto B? Se sim, esperamos 1
		assertEquals(1, produtoA.compareTo(produtoB));
		
		//Produto B é mais barato do que Produto A? Se sim, esperamos -1
		assertEquals(-1, produtoB.compareTo(produtoA));
		
		/*
		 * Define-se o valor do Produto A para que  
		 * tenha o mesmo valor do produto B 
		 */
		produtoA.setValor(produtoB.getValor());

		//Produto A tem o mesmo preco do Produto B? Se sim, esperamos 0
		assertEquals(0, produtoA.compareTo(produtoB));
	}

}















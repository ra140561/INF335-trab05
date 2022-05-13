/**
 * 
 */
package br.unicamp.ic.inf335.app.inf335_trab04;

import java.util.ArrayList;

/**
 * @author bonacin
 * Classe que representa um anunciante, com respectivos dados e anuncios associados
 */
public class AnuncianteBean {
	/**
	 * Nome do anunciante
	 */
	private String nome;
	/**
	 * CPF do anuncioante
	 */
	private String CPF;
	/**
	 * Lista de anuncios de um anunciante
	 */
	private ArrayList<AnuncioBean> anuncios;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public ArrayList<AnuncioBean> getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(ArrayList<AnuncioBean> anuncios) {
		this.anuncios = anuncios;
	}
	
	/**
	 * Construtor deafult
	 */
	public AnuncianteBean() {
		nome = new String();
		CPF = new String();
		anuncios = new ArrayList<AnuncioBean>();
	}
	
	
	/**
	 * Construtor com parametros
	 * @param nome
	 * @param cPF
	 * @param anuncios
	 */
	public AnuncianteBean(String nome, String cPF, ArrayList<AnuncioBean> anuncios) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.anuncios = anuncios;
	}
	

	/**
	 * Inclui novo anuncio na lista de anuncios de um anunciante
	 * @param nAnuncio Anuncio a ser incluido
	 */
	public void addAnuncio (AnuncioBean nAnuncio) {
		anuncios.add(nAnuncio);	
	}
	
	/**
	 * Remove i-ésimo anuncio existente na lista de anuncios de um Anunciante 
	 * @param i índice do ArrayList que deve ser removido da lista
	 */
	public void removeAnuncio (int i) {
		anuncios.remove(i);	
	}
	
	/**
	 * Calcula o valor medio de anuncios de um anuciante
	 * @return valor medio dos anuncios 
	 */
	public Double valorMedioAnuncios() {
		Double soma = 0.0;
		for (AnuncioBean an:anuncios) {
			soma += an.getProduto().getValor(); //Acumula o valor do produto
		}
		return soma/anuncios.size();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}

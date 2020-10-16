package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTeste {
	
	
	@Test
	public void teste() {
		
		//Cenário
		LocacaoService service = new LocacaoService();
		Usuario us1 = new Usuario("Egberto de Oliveira");
		Filme filme1 = new Filme("Titanic", 2, 5.0);
		
		//Ação
		Locacao locacao = service.alugarFilme(us1, filme1);
		
		//Verificação
		assertThat(locacao.getValor(), is(equalTo(5.0)));
		assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
	}

	
}
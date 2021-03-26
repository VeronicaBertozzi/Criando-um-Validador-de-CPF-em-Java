package com.cpfValidador.validaCPF;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import com.cpfValidador.validaCPF.models.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ValidaCpfApplicationTests {

	@Test
	@DisplayName("Dado que eu faça um teste com CPF válido")
	
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156.091.920-56");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156.091.920-57");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("1560919205");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMais() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156091920569");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156.091.920-56");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156.091.920-57");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156,091.920-57");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156.091.920-56 ");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf(" 156.091.920-56");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoMeio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("946 220 360 10");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteComCpfMalucoQuePassou() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComCaracteres() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("Veronica");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComCaracteresEspeciais() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		cliente.setCpf("156091%205");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteSemPassarCPF() {
		Cliente cliente = new Cliente();
		cliente.setNome("Veronica");
		assertEquals(false, cliente.validarCPF());
	}
}

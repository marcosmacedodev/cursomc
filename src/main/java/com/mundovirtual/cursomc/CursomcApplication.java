package com.mundovirtual.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mundovirtual.cursomc.domain.Categoria;
import com.mundovirtual.cursomc.domain.Cidade;
import com.mundovirtual.cursomc.domain.Cliente;
import com.mundovirtual.cursomc.domain.Endereco;
import com.mundovirtual.cursomc.domain.Estado;
import com.mundovirtual.cursomc.domain.ItemPedido;
import com.mundovirtual.cursomc.domain.Pagamento;
import com.mundovirtual.cursomc.domain.PagamentoComBoleto;
import com.mundovirtual.cursomc.domain.PagamentoComCartao;
import com.mundovirtual.cursomc.domain.Pedido;
import com.mundovirtual.cursomc.domain.Produto;
import com.mundovirtual.cursomc.domain.enums.EstadoPagamento;
import com.mundovirtual.cursomc.domain.enums.TipoCliente;
import com.mundovirtual.cursomc.repositories.CategoriaRepository;
import com.mundovirtual.cursomc.repositories.CidadeRepository;
import com.mundovirtual.cursomc.repositories.ClienteRepository;
import com.mundovirtual.cursomc.repositories.EnderecoRepository;
import com.mundovirtual.cursomc.repositories.EstadoRepository;
import com.mundovirtual.cursomc.repositories.ItemPedidoRepository;
import com.mundovirtual.cursomc.repositories.PagamentoRepository;
import com.mundovirtual.cursomc.repositories.PedidoRepository;
import com.mundovirtual.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Inform??tica");
		Categoria cat2 = new Categoria(null, "Escrit??rio");
		
		Produto p1 = new Produto(null, "Computador", 2000);
		Produto p2 = new Produto(null, "Impressora", 800);
		Produto p3 = new Produto(null, "Mouse", 80);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "S??o Paulo");
		
		Cidade c1 = new Cidade(null, "Uberl??ndia", est1);
		Cidade c2 = new Cidade(null, "S??o Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		
		Set<String> telefones = new HashSet<>();
		telefones.add("27363323");
		telefones.add("93838393");
		
		cli1.setTelefones(telefones);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "36220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		//pagto1.setPedido(ped1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		//pagto2.setPedido(ped2);
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().add(ip1);
		ped1.getItens().add(ip2);
		ped2.getItens().add(ip3);
		
		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);
		
		cli1.setPedidos(Arrays.asList(ped1, ped2));
		//---------------------------------------------------------//
		cli1.setEnderecos(Arrays.asList(e1, e2));
		//---------------------------------------------------------//
		cat1.setProdutos(Arrays.asList(p1, p2, p3));
		cat2.setProdutos(Arrays.asList(p2));
		//---------------------------------------------------------//
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1, cat2));
		p3.setCategorias(Arrays.asList(cat1));
		//---------------------------------------------------------//
		est1.setCidades(Arrays.asList(c1));
		est2.setCidades(Arrays.asList(c2, c3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		this.estadoRepository.saveAll(Arrays.asList(est1, est2));
		this.cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		this.clienteRepository.saveAll(Arrays.asList(cli1));
		this.enderecoRepository.saveAll(Arrays.asList(e1, e2));
		this.pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		this.pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		this.itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}

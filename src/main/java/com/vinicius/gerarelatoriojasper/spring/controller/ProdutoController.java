package com.vinicius.gerarelatoriojasper.spring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Classe ProdutoController que representa os nossos serviços REST. Será o nosso controller.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private DataSource dataSource;
	
	/**
	 * Exibindo relatorio em formato PDF com Jasper Reports.
	 * @param response - HttpServletResponse - response.
	 * @throws JRException - Exceção JRException.
	 * @throws SQLException - Exceção SQLException.
	 */
	@RequestMapping( value = "/relatorios", method = RequestMethod.GET)
	public void exibirRelatorioPDF( HttpServletResponse response) throws JRException, SQLException {
		
		InputStream reportStream = this.getClass().getResourceAsStream("/relatorios/Produtos.jasper");
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		// Outra maneira de se trabalhar com relatorios utilizando jasper é usar o HashMap params.
//		params.put("PARAM_1", "CUSTOM PARAM");
		
		// O trecho abaixo é o necessarios para geração de relatorio em formato PDF.
		// Faço a captura dos meu item(JasperReports)
		JasperReport jasperReport = ( JasperReport ) JRLoader.loadObject(reportStream);
		
		//Preencho com os meus dados.
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());
		
		// Altero a minha resposta
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=produtos_games.pdf");
		
		try {
			//Em um bloco try/catch finalizo com OutPutStream
			//Obs: poderia usar ByteArrayOutPutStream também
			OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

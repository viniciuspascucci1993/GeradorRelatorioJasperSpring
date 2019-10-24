package com.vinicius.gerarelatoriojasper.spring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JREmptyDataSource;
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
	
	@RequestMapping( value = "/relatorios", method = RequestMethod.GET)
	public void imprimirRelatorio( HttpServletResponse response) throws JRException {
		
		InputStream reportStream = this.getClass().getResourceAsStream("/relatorios/Produtos.jasper");
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		JasperReport jasperReport = ( JasperReport ) JRLoader.loadObject(reportStream);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
		
		response.setContentType("application/pdf");
		
		response.setHeader("Content-Disposition", "inline; filename=produtos_games.pdf");
		
		try {
			OutputStream outputStream = response.getOutputStream();
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

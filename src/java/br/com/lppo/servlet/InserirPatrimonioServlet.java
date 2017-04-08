/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lppo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tiago
 */
@WebServlet(name = "InserirPatrimonioServlet", urlPatterns = {"/InserirPatrimonio.html"})
public class InserirPatrimonioServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.getRequestDispatcher("WEB-INF/NovoPatrimonio.jsp").forward(request, response);
	
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	//pegar dados do formulario e inserir no banco
	Patrimonio patrimonio = new Patrimonio();
	
	patrimonio.setSerie(request.getParameter("serie"));
	patrimonio.setLocal(request.getParameter("local"));
	patrimonio.setDescricao(request.getParameter("descricao"));
	patrimonio.setEstado(Integer.parseInt(request.getParameter("estado")));
	
	try {
	    Class.forName("org.apache.derby.jdbc.ClientDriver");

	    String url = "jdbc:derby://localhost:1527/lppo-2017-1";

	    Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
	    
	    Statement operacao = conexao.createStatement();
	    
	    String sql = "INSERT INTO patrimonio(serie, local, descricao, estado) VALUES( '"
		    +patrimonio.getSerie()+ "','"
		    +patrimonio.getLocal()+ "','"
		    +patrimonio.getDescricao()+ "',"
		    +patrimonio.getEstado()+ ")";
	    
	    operacao.executeUpdate(sql);
	    
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(InserirPatrimonioServlet.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(InserirPatrimonioServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	response.sendRedirect("lista.html");
	    
    }

   
}

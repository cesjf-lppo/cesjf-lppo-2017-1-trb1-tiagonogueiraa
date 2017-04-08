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
import java.sql.ResultSet;
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
@WebServlet(name = "EditaPatrimonio", urlPatterns = {"/EditaPatrimonio.html"})
public class EditaPatrimonio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	Patrimonio patrimonio = new Patrimonio();
	Long id = Long.parseLong(request.getParameter("id"));

	try {
	    //pegar dados do banco
	    Class.forName("org.apache.derby.jdbc.ClientDriver");
	    Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
	    Statement operacao = conexao.createStatement();
	    ResultSet resultado = operacao.executeQuery("SELECT * patrimonio WHERE id=" + id);

	    if (resultado.next()) {
		patrimonio.setId(resultado.getLong("id"));
		patrimonio.setSerie(resultado.getString("serie"));
		patrimonio.setDescricao(resultado.getString("descricao"));
		patrimonio.setLocal(resultado.getString("local"));
		patrimonio.setEstado(resultado.getInt("estado"));

	    }
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(EditaPatrimonio.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(EditaPatrimonio.class.getName()).log(Level.SEVERE, null, ex);
	}

	request.setAttribute("patrimonio", patrimonio);
	request.getRequestDispatcher("WEB-INF/EditaPatrimonio.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	Patrimonio patrimonio = new Patrimonio();

	patrimonio.setLocal(request.getParameter("local"));
	patrimonio.setEstado(Integer.parseInt(request.getParameter("estado")));

	try {
	    Class.forName("org.apache.derby.jdbc.ClientDriver");

	    Connection conexao = DriverManager.getConnection("jdbc.derby://localhost:1527/lppo-2017-1", "usuario", "senha");

	    Statement operacao = conexao.createStatement();

	    operacao.executeUpdate("UPDATE patrimonio SET local'"
		    + patrimonio.getLocal() + "',estado="
		    + patrimonio.getEstado());

	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(EditaPatrimonio.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(EditaPatrimonio.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	response.sendRedirect("lista.html");

    }

}

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
@WebServlet(name = "ExcluiPatrimonio", urlPatterns = {"/ExcluiPatrimonio.html"})
public class ExcluiPatrimonio extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	//pegar os parametros
	Long id = Long.parseLong(request.getParameter("id"));
	
	//excluir registro e pegar os dados do banco
	
	try{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
		Statement operacao = conexao.createStatement();
		operacao.executeUpdate("DELETE FROM patrimonio WHERE id=" +id);
		
		response.sendRedirect("ListaPatrimonio.html");

    }	catch (SQLException ex) {
	    Logger.getLogger(ExcluiPatrimonio.class.getName()).log(Level.SEVERE, null, ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(ExcluiPatrimonio.class.getName()).log(Level.SEVERE, null, ex);
	}

   
    }}

   


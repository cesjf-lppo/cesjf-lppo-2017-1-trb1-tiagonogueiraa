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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaPatrimonioSevlet", urlPatterns = {"/ListaPatrimonio.html"})
public class ListaPatrimonioSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	//criar lista
	List<Patrimonio> patrimonios = new ArrayList<>();
	
	//pegar dados do banco
	try{
	    //configurando conexao
	    Class.forName("org.apache.derby.jdbc.ClientDriver");
	    Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
	    Statement operacao = conexao.createStatement();
	    ResultSet resultado = operacao.executeQuery("SELECT * FROM patrimonio ORDE BY local");
	    
	    while (resultado.next()){
		Patrimonio patrimonio = new Patrimonio();
		patrimonio.setId(resultado.getLong("id"));
		patrimonio.setSerie(resultado.getString("serie"));
		patrimonio.setLocal(resultado.getString("local"));
		patrimonio.setDescricao(resultado.getString("descricao"));
		patrimonio.setEstado(resultado.getInt("estado"));
		patrimonios.add(patrimonio);
		
		request.setAttribute("patrimonio", patrimonios);
		request.getRequestDispatcher("WEB-INF/ListaPatrimonio.jsp").forward(request, response);
	    }
	    
	    
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(ListaPatrimonioSevlet.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(ListaPatrimonioSevlet.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {



}}

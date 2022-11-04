/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.distributed.webapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ResponseDto;
import repository.DbContext;

/**
 *
 * @author thunv
 */
public class ControllerBase extends HttpServlet {

    private DbContext _context;

    public ControllerBase() {
        this._context = new DbContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/":
            case "/home":
                home(request, response);
                break;
            case "/getSubjects": {
                try {
                    getSubject(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControllerBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                Logger.getLogger(ControllerBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            break;
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }

    private void getSubject(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {
        List subjects = _context.getSubjects();
        responseClient(new ResponseDto(true, "Thành công", subjects), response);
    }

    public void responseClient(ResponseDto res, HttpServletResponse response) throws JsonProcessingException, IOException {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(res);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(jsonStr);
        out.flush();
    }
}

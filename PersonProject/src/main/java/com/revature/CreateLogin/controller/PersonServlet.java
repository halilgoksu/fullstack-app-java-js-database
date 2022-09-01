package com.revature.CreateLogin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.CreateLogin.entity.Person;
import com.revature.CreateLogin.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonServlet extends HttpServlet {

    // register, but also logging in:
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // print writer and person service intiliaze
        PrintWriter out = resp.getWriter();
        PersonService personService = new PersonService();

        // set up variables to store the person object from the body:
        ObjectMapper mapper = new ObjectMapper();
        Person person;

        // try to read in the credential information:
        try {
            // Object Mapper requires default constructor:
            person = mapper.readValue(req.getReader(), Person.class);
        }catch(Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid person format");
            return;
        }

        // either login or register:
        String authType = req.getParameter("auth");
        if(authType.equals("login")) {
            person = personService.login(person.getId(), person.getPassword(),person.getStafftype());
        }
        else if (authType.equals("register")){
            person = personService.register(person);
        }

        // if invalid credentials, return error code:
        if(person == null) {
            resp.sendError(400, "Invalid credentials");
            return;
        }

        // otherwise print out the person:
        out.println(person.getName());

        // update the session with the person's id: (indicates if we are logged in/registered
        req.getSession().setAttribute("id", person.getId());
    }

}

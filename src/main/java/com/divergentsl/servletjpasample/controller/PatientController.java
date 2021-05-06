package com.divergentsl.servletjpasample.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.divergentsl.servletjpasample.entity.Patient;
import com.divergentsl.servletjpasample.service.PatientService;
import com.divergentsl.servletjpasample.service.PatientServiceImpl;


@WebServlet("/patientController")
public class PatientController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final PatientService patientService = new PatientServiceImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String patientName = req.getParameter("patientname");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		int weight = Integer.parseInt(req.getParameter("weight"));
		int contactNumber = Integer.parseInt(req.getParameter("contactno"));
		String address = req.getParameter("address");
		
		patientService.add(patientName, age, weight, gender, contactNumber, address);
		
		List<Patient> allPatient = patientService.listAll();
		req.setAttribute("allPatient", allPatient);
		RequestDispatcher dispatcher = req.getRequestDispatcher("patient.jsp");
		dispatcher.forward(req, resp);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		patientService.remove(id);

		List<Patient> allPatient = patientService.listAll();
		req.setAttribute("allPatient", allPatient);
		RequestDispatcher dispatcher = req.getRequestDispatcher("patient.jsp");
		dispatcher.forward(req, resp);
	}

}

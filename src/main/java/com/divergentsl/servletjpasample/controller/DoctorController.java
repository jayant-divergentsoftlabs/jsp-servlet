package com.divergentsl.servletjpasample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.divergentsl.servletjpasample.entity.Doctor;
import com.divergentsl.servletjpasample.service.DoctorService;
import com.divergentsl.servletjpasample.service.DoctorServiceImpl;

@WebServlet("/doctorController")
public class DoctorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final DoctorService doctorService = new DoctorServiceImpl();

	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String doctorName = req.getParameter("name");
		String doctorSpeciality = req.getParameter("speciality");
		int doctorFee = Integer.parseInt(req.getParameter("fee"));

		Doctor doctor = new Doctor(doctorName, doctorSpeciality, doctorFee);
		doctorService.insert(doctor);

		List<Doctor> allDoctors = doctorService.findAllDoctor();
		req.setAttribute("allDoctors", allDoctors);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Doctor.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		doctorService.removeDoctor(doctorId);

		List<Doctor> allDoctors = doctorService.findAllDoctor();
		req.setAttribute("allDoctors", allDoctors);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Doctor.jsp");
		dispatcher.forward(req, resp);
	}
}

package Controller;
//import Controller.EmployeeController;
import Model.Employee;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeController employeeController;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet initialized");
        employeeController = new EmployeeController("database"); // or "file" or "jdbc"
        gson = new Gson();
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BufferedReader reader = request.getReader();
    Employee employee = gson.fromJson(reader, Employee.class);

    try {
        employeeController.addEmployee(employee);
        response.setStatus(HttpServletResponse.SC_CREATED);
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(employee));
        out.flush();
    } catch (Exception e) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        PrintWriter out = response.getWriter();
        out.print("{\"message\": \"" + e.getMessage() + "\"}");
        out.flush();
    }
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (idParam != null) {
            // Get employee by ID
            int id = Integer.parseInt(idParam);
            Employee employee = employeeController.getEmployeeById(id);
            if (employee != null) {
                out.print(gson.toJson(employee));
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.print("{\"message\": \"Employee not found\"}");
            }
        } else {
            // Get all employees
            List<Employee> employees = employeeController.getAllEmployees();
            out.print(gson.toJson(employees));
        }
        out.flush();
    }

    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BufferedReader reader = request.getReader();
//        Employee updatedEmployee = gson.fromJson(reader, Employee.class);
//
//        try {
//            employeeController.updateEmployee(updatedEmployee.getId(), updatedEmployee.getName(), updatedEmployee.getAddress().getLocation(), updatedEmployee.getAddress().getPin());
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.print(gson.toJson(updatedEmployee));
//            out.flush();
//        } catch (Exception e) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            PrintWriter out = response.getWriter();
//            out.print("{\"message\": \"" + e.getMessage() + "\"}");
//            out.flush();
//        }
//    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Employee updatedEmployee = gson.fromJson(reader, Employee.class);

        try {
            employeeController.updateEmployee(updatedEmployee.getId(), updatedEmployee.getName(), updatedEmployee.getAddress().getLocation(), updatedEmployee.getAddress().getPin());
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(updatedEmployee));
            out.flush();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            PrintWriter out = response.getWriter();
            out.print("{\"message\": \"" + e.getMessage() + "\"}");
            out.flush();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            employeeController.deleteEmployee(id);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            PrintWriter out = response.getWriter();
            out.print("{\"message\": \"Employee ID is required\"}");
            out.flush();
        }
    }
}

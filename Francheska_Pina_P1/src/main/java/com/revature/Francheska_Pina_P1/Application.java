package com.revature.Francheska_Pina_P1;

import com.revature.Francheska_Pina_P1.Controller.EmployeeController;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8081);

        new EmployeeController(app).employeeEndpoint();


    }
}

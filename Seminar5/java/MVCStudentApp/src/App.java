import java.util.ArrayList;
import java.util.List;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.FileModelClass;
import Model.ModelClass;
import Model.Domain.Student;
import View.ViewClass;

public class App {
    public static void main(String[] args) throws Exception {
       
        ControllerClass controller = new ControllerClass();
        controller.run();

    }
}

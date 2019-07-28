import controller.*;
import model.*;
import view.*;

//this runs the application
public class Test 
{
	public static void main(String[] args) 
	{
		LoginModel model= new LoginModel();
		Login view = new Login();
		LoginController controller = new LoginController(view, model);
		controller.loginmethod();
	}
}

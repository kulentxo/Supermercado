package julenmartin.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import julenmartin.accesodatos.UsuarioDaoTreeMap;
import julenmartin.pojo.Usuario;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		UsuarioDaoTreeMap dao = UsuarioDaoTreeMap.getInstancia();

		Usuario u = dao.validarEmail(email);

		if (u == null || !u.getPass().equals(pass)) {
			response.sendRedirect("login");
		} else {
			request.getSession().setAttribute("usuario", u);
			request.getRequestDispatcher("principal").forward(request, response);
		}
	}

}

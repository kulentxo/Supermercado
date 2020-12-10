package julenmartin.controladoresAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import julenmartin.accesodatos.ProductoDaoTreeMap;

@WebServlet("/admin/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public index() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("productos", ProductoDaoTreeMap.getInstancia().listar());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

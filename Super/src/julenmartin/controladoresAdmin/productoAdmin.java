package julenmartin.controladoresAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/productoAdmin")
public class productoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public productoAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/admin/producto.jsp").forward(request, response);
	}

}

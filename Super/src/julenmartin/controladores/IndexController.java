package julenmartin.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import julenmartin.accesodatos.Dao;
import julenmartin.accesodatos.ProductoDaoTreeMap;
import julenmartin.pojo.producto;

@WebServlet("/principal")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao<producto> dao = ProductoDaoTreeMap.getInstancia();
		Iterable<producto> producto = dao.listar();

		request.setAttribute("producto", producto);
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package julenmartin.controladores;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import julenmartin.accesodatos.Dao;
import julenmartin.accesodatos.ProductoDaoTreeMap;
import julenmartin.pojo.producto;

@WebServlet("/AgregarCarrito")
public class AgregarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgregarCarrito() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao<producto> dao = ProductoDaoTreeMap.getInstancia();

		LinkedHashMap<Long, producto> carrito = new LinkedHashMap<Long, producto>();

		Enumeration<String> ids = request.getParameterNames();

		String sId;
		int id;
		Integer cantidad;

		producto p;
		while (ids.hasMoreElements()) {
			sId = ids.nextElement();
			id = Integer.parseInt(sId);
			cantidad = Integer.parseInt(request.getParameter(sId));

			if (cantidad > 0) {
				p = dao.recuperar(id);
				p.setCantidad(cantidad);

				carrito.put((long) id, p);
			}
		}
		request.getSession().setAttribute("carrito", carrito);

		response.sendRedirect(request.getContextPath() + "/carrito");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

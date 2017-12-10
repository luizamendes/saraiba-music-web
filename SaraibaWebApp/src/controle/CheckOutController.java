package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import dao.CompraDao;
import negocio.Cliente;
import negocio.Compra;
import negocio.Musica;

public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckOutController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if(session.getAttribute("loginCliente") != null){
		
			@SuppressWarnings("unchecked")
			List<Musica> cart = (List<Musica>)session.getAttribute("cart");
			
			session.setAttribute("cart", cart);
			
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
			
		} else {
						
			request.getRequestDispatcher("naoLogado.jsp").forward(request, response);

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		Cliente clienteLogado = (Cliente)session.getAttribute("loginCliente");		
	
		@SuppressWarnings("unchecked")
		List<Musica> cart = (List<Musica>)session.getAttribute("cart");
		
		session.setAttribute("cart", cart);
		
		Compra compra = new Compra();
		compra.setCompra(cart);
		compra.setCliente(clienteLogado);
		
		double valorTotal = 0;		

		for(Musica m : cart) {
			
			valorTotal += m.getPreco();
		}
		
		compra.setPrecoTotal(valorTotal);

		CompraDao.salvarCompra(compra);
		
		cart.clear();
		
		request.getRequestDispatcher("compraRealizada.jsp").forward(request, response);
	
	}

}

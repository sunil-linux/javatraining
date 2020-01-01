package com.nobel.oshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nobel.oshop.cart.ShoppingCart;
import com.nobel.oshop.model.CartProduct;

@WebServlet("/listCart")
public class ListCartItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// How to access cart here ?
		HttpSession httpSession = request.getSession(false);

		if (httpSession == null) {
			response.sendRedirect("index.html");
		} else {

			//ServletContext context = getServletContext();

			ShoppingCart cart = (ShoppingCart) httpSession.getAttribute("cart");

			PrintWriter out = response.getWriter();
			

			if (cart != null) {
				out.println("<html><body>");
				out.println("<h2> Welcome, "+httpSession.getAttribute("currentUser")+"</h2>");
				out.println("<h2> Your shopping cart </h2> <table border=1>");
				out.println("<tr><th>Name</th><th>Price</th><th> Qty</th><th>Action</th> </tr>");

				Iterator<CartProduct> itr = cart.listItr();
				while (itr.hasNext()) {
					CartProduct prod = itr.next();
					out.println("<tr>");
					out.println("<td>" + prod.getProdName() + "</td>");
					out.println("<td>" + prod.getPrice() + "</td>");
					out.println("<td>" + prod.getQty() + "</td>");
					out.println("<td><a href='removeFromCart?pid=" + prod.getPid() + "'>Remove</a></td>");
					out.println("</tr>");
				}

				out.println("</table>");
				out.println("<h3> Total:" + cart.getTotal() + "</h3>");
				out.println("<h2><a href='categories'>Continue Shopping</a></h2>");
				out.println("<h2><a href='placeOrder'>Place Order</a></h2>");
				out.println("<h2><a href='logout'>Logout</a></h2>");
				out.println("</body></html>");
			}
		}
	}

}

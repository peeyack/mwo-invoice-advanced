package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	public void addProduct(Product product) {
		ArrayList<Product> lista = new ArrayList<Product>();
		lista.add(product);
	}

	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
	}

	public BigDecimal getNetSubtotal() {
		return null;
	}

	public BigDecimal getTax() {
		return null;
	}

	public BigDecimal getGrossTotal() {
		return null;
	}
}

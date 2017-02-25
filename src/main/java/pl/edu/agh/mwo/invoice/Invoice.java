package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private int numerFaktury;
	private static int nextNumber=0;
	
	public Invoice(){
		this.numerFaktury = nextNumber;
		nextNumber+=1;
	}
	public static void resetNextNumber(){
		nextNumber=1;
	}

	public int getNumber() {
		
		return numerFaktury ;
	}
	
	public void zmienNrFaktury(){
		numerFaktury+=1;
	}
	
	
	
	
	private Map<Product, Integer> products = new HashMap<Product, Integer>();

	public void addProduct(Product product) {
		addProduct(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException();
		}
		products.put(product, quantity);
	}

	public BigDecimal getNetTotal() {
		BigDecimal totalNet = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalNet = totalNet.add(product.getPrice().multiply(quantity));
		}
		return totalNet;
	}
	
	
	public BigDecimal getTaxTotal() {
		return getGrossTotal().subtract(getNetTotal());
	}

	public BigDecimal getGrossTotal() {
		BigDecimal totalGross = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
		}
		return totalGross;
	}
	public String printedVersion() {  // Nasz metoda 1 - drukowanie
		String print = String.valueOf(numerFaktury);
		for (Product product : products.keySet()){
			print = "\n "+ print +  product.getName()+product.getPrice()+product.getClass();
		}
		
		return print;
	}

}

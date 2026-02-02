package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department dp = new Department(1, "Books");
		System.out.println(dp);
		
		Seller sl = new Seller(1, "Enzo", "enzo@gmail.com", new Date(), 3200.00, dp);
		System.out.println(sl);
	}

}

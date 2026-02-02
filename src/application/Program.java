package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== seller findById ===");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);

		System.out.println("\n=== seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== seller findByAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== seller insert ===");
		Seller newSeller = new Seller(null, "Maria", "maria@gmail.com", new Date(), 3800.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n=== seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Enzo Henrique Favaro");
		sellerDao.update(seller);
		System.out.println("Update completed!!");

		System.out.println("\n=== seller delete ===");
		System.out.print("Enter id to delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("User Deleted!");
		sc.close();

	}
}
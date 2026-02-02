package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n=== department insert ===");
		System.out.print("New Department name: ");
		String newDepartmentName = sc.nextLine();
		Department insertDepartment = new Department(null, newDepartmentName);
		departmentDao.insert(insertDepartment);
		System.out.println("Inserted! New id = " + insertDepartment.getId());

		System.out.println("\n=== department update ===");
		System.out.print("Edit Department name: ");
		String editDepartment = sc.nextLine();
		System.out.println("Department id to update: ");
		int id = sc.nextInt();
		Department updateDepartment = new Department(id, editDepartment);
		departmentDao.update(updateDepartment);

		System.out.println("\n=== department delete ===");
		System.out.print("Enter department id to delete: ");
		int deleteId = sc.nextInt();
		departmentDao.deleteById(deleteId);
		System.out.println("Department Deleted!");

		System.out.println("\n=== department findById ===");
		System.out.print("Enter department id: ");
		int selectId = sc.nextInt();
		Department department = departmentDao.findById(selectId);
		System.out.println(department);

		System.out.println("\n=== department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department dp : list) {
			System.out.println(dp);
		}

		sc.close();
	}

}

package application;



import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Department obj = new Department(1, "Books");
        System.out.println(obj);

        SellerDAO sellerDAO = DaoFactory.createSellerDao();
        System.out.println(".:: TESTE 01: Seller findById ::..");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println(".:: TESTE 02: Seller findByDepartment ::..");
        Department department = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(department);
        for (Seller seller1 : list){
            System.out.println(seller1);
        }

        System.out.println(".:: TESTE 03: Seller findAll ::..");
        list = sellerDAO.findByDepartment(department);
        for (Seller seller1 : list){
            System.out.println(seller1);
        }

        System.out.println(".:: TESTE 04: Seller insert ::..");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDAO.insert(newSeller);
        System.out.println("Inserted! New seller ID: " + newSeller.getId());

        System.out.println(".:: TESTE 05: Seller update ::..");
        seller = sellerDAO.findById(5);
        seller.setName("Bruce Parker");
        sellerDAO.update(seller);
        System.out.println("UPDATE completed");

        System.out.println(".:: TESTE 06: Seller delete ::..");
        System.out.println("Enteder id number to delete: ");
        int id = sc.nextInt();
        sellerDAO.deleteById(id);
        System.out.println("Delete completed");

        sc.close();

    }
}

package application;



import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {
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
    }
}

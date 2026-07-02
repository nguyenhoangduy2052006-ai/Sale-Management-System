package manager;

import model.customer.Customer;
import java.util.ArrayList;
import java.util.Comparator;

// 👉 THÊM IMPORT NÀY
import java.io.*;

public class CustomerManager {

    private ArrayList<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }

    // 1. Thêm khách hàng mới
    public boolean addCustomer(Customer customer) {
        if (customer == null) return false;

        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(customer.getCustomerID())) {
                System.out.println("Duplicate ID! Cannot add customer.");
                return false;
            }
        }

        customerList.add(customer);
        return true;
    }

    // 2. Tìm kiếm khách hàng theo ID
    public Customer searchCustomer(String id) {
        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // 3. Cập nhật thông tin khách hàng
    public boolean updateCustomer(String id, String name, String phone, String address) {
        Customer c = searchCustomer(id);

        if (c != null) {
            c.setCustomerName(name);
            c.setPhoneNumber(phone);
            c.setAddress(address);
            return true;
        }

        return false;
    }

    // 4. Xóa khách hàng
    public boolean removeCustomer(String id) {
        Customer c = searchCustomer(id);

        if (c != null) {
            customerList.remove(c);
            return true;
        }

        return false;
    }

    public void displayCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customer found!");
            return;
        }

        for (Customer c : customerList) {
            System.out.println(c);
            System.out.println("-------------------");
        }
    }

    public void displayTopCustomers(int topN) {
        if (customerList.isEmpty()) {
            System.out.println("No customer found!");
            return;
        }

        ArrayList<Customer> sortedList = new ArrayList<>(customerList);

        sortedList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return Double.compare(c2.getTotalPurchase(), c1.getTotalPurchase());
            }
        });

        for (int i = 0; i < topN && i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
            System.out.println("-------------------");
        }
    }

    public void saveToFile(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (Customer c : customerList) {
                bw.write(c.getCustomerID() + ","
                        + c.getCustomerName() + ","
                        + c.getPhoneNumber() + ","
                        + c.getAddress() + ","
                        + c.getTotalPurchase());
                bw.newLine();
            }

            bw.close();
            System.out.println("Save customer success!");

        } catch (IOException e) {
            System.out.println("Save file error!");
        }
    }

    // =========================
    // FILE I/O - LOAD
    // =========================
    public void loadFromFile(String filename) {
        try {
            File file = new File(filename);

            if (!file.exists()) {
                System.out.println("File not found, skip load.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split(",");

                Customer c = new Customer(
                        p[0],
                        p[1],
                        p[2],
                        p[3],
                        Double.parseDouble(p[4])
                );

                customerList.add(c);
            }

            br.close();
            System.out.println("Load customer success!");

        } catch (Exception e) {
            System.out.println("Load file error!");
        }
    }

}

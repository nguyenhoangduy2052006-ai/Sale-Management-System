package manager;

import model.supplier.Supplier;
import java.util.ArrayList;

public class SupplierManager {

    private ArrayList<Supplier> listSupplier = new ArrayList<>();

    public Supplier findSupplier(String supplierID) {
        for (Supplier s : listSupplier) {
            if (s.getSupplierID().equalsIgnoreCase(supplierID)) {
                return s;
            }
        }
        return null;
    }

    public boolean addSupplier(Supplier supplier) {
        if (findSupplier(supplier.getSupplierID()) != null) {
            return false;
        }
        listSupplier.add(supplier);
        return true;
    }

    public boolean updateSupplier(String id, String name, String contact, String phone) {
        // Validate input rỗng
        if (id == null || id.trim().isEmpty()
                || name == null || name.trim().isEmpty()
                || contact == null || contact.trim().isEmpty()
                || phone == null || phone.trim().isEmpty()) {
            return false;
        }

        Supplier s = findSupplier(id);
        if (s == null) {
            return false;
        }
        s.setSupplierName(name.trim());
        s.setContactName(contact.trim());
        s.setPhoneNumber(phone.trim());
        return true;
    }

    public boolean deleteSupplier(String supplierID) {
        for (int i = 0; i < listSupplier.size(); i++) {
            if (listSupplier.get(i).getSupplierID().equalsIgnoreCase(supplierID)) {
                listSupplier.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Supplier> searchSupplier(String keyword) {
        ArrayList<Supplier> searchResults = new ArrayList<>();
        String kw = keyword.toLowerCase();

        for (Supplier s : listSupplier) {
            if (s.getSupplierID().toLowerCase().contains(kw)
                    || s.getSupplierName().toLowerCase().contains(kw)) {
                searchResults.add(s);
            }
        }
        return searchResults;
    }

    public ArrayList<Supplier> getListSupplier() {
        return listSupplier;
    }
}

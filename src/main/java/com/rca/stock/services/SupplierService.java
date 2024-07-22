package com.rca.stock.services;

import com.rca.stock.model.Supplier;
import com.rca.stock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        return optionalSupplier.orElse(null);
    }

    public Supplier updateSupplier(Integer id, Supplier updatedSupplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier existingSupplier = optionalSupplier.get();
            existingSupplier.setName(updatedSupplier.getName());
            existingSupplier.setContactDetails(updatedSupplier.getContactDetails());
            return supplierRepository.save(existingSupplier);
        }
        return null;
    }

    public void deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
    }
}

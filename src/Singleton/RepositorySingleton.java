// src/main/java/Singleton/RepositorySingleton.java
package Singleton;

import Factory.RepositoryFactory;
import Repository.*;

public class RepositorySingleton {
    private static EmployeeRepository employeeRepository;
    private static AddressRepository addressRepository;
//    private static DepartmentRepository departmentRepository;

    public static EmployeeRepository getEmployeeRepository(String type) {
        if (employeeRepository == null) {
            employeeRepository = RepositoryFactory.getEmployeeRepository(type);
        }
        return employeeRepository;
    }

    public static AddressRepository getAddressRepository(String type) {
        if (addressRepository == null) {
            addressRepository = RepositoryFactory.getAddressRepository(type);
        }
        return addressRepository;
    }

}
package Factory;

import Repository.*;
import Service.Impl.InMemoryEmployeeRepository;
import Service.Impl.FileAddressRepository;
import Service.Impl.FileEmployeeRepository;
import Service.Impl.InMemoryAddressRepository;

public class RepositoryFactory {

    public static EmployeeRepository getEmployeeRepository(String type) {
        if (type.equalsIgnoreCase("memory")) {
            return new InMemoryEmployeeRepository();
        } else if (type.equalsIgnoreCase("file")) {
            return new FileEmployeeRepository();
        }
        throw new IllegalArgumentException("Invalid repository type");
    }

    public static AddressRepository getAddressRepository(String type) {
        if (type.equalsIgnoreCase("memory")) {
            return new InMemoryAddressRepository();
        } else if (type.equalsIgnoreCase("file")) {
            return new FileAddressRepository();
        }
        throw new IllegalArgumentException("Invalid repository type");
    }

}
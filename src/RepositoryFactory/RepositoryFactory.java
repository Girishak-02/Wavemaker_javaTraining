package RepositoryFactory;

import Repository.EmployeeRepository;
import Service.Impl.InMemoryEmployeeRepository;
import Service.Impl.FileEmployeeRepository;

public class RepositoryFactory {
    public static EmployeeRepository getRepository(String type) {
        if (type.equalsIgnoreCase("memory")) {
            return new InMemoryEmployeeRepository();
        } else if (type.equalsIgnoreCase("file")) {
            return new FileEmployeeRepository();
        }
        throw new IllegalArgumentException("Unknown repository type");
    }

}

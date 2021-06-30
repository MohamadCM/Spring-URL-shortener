package ir.mohamadcm.restservice;

import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface URLRepository extends MongoRepository<URL, String>{
    public URL findByNewAddress(String newAddress);
    public List<URL> findByOldAddress(String oldAddress);

}
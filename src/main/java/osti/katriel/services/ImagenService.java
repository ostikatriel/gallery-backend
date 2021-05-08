package osti.katriel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osti.katriel.entities.Imagen;
import osti.katriel.repositories.ImagenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    @Autowired
    ImagenRepository imagenRepository;

    public List<Imagen> list(){
        return imagenRepository.findByOrderById();
    }

    public Optional<Imagen> getOne(int id){
        return imagenRepository.findById(id);
    }

    public void save(Imagen imagen){
        imagenRepository.save(imagen);
    }

    public void delete(int id){
        imagenRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }

}

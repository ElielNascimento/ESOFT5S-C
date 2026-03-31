package com.bn.crud.matheus_pintor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatheusPintorService {
    @Autowired
    private MatheusPintorRepository matheusPintorRepository;

    public List<MatheusPintorModel> findAll() {
        return matheusPintorRepository.findAll();
    }

    public Optional<MatheusPintorModel> findById(Long id) {
        return matheusPintorRepository.findById(id);
    }

    public MatheusPintorModel save(MatheusPintorModel categoriaEntity) {
        return matheusPintorRepository.save(categoriaEntity);
    }

    public void delete(Long id) {
        matheusPintorRepository.deleteById(id);
    }
}

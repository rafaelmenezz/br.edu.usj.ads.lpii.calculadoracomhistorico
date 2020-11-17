package br.edu.usj.ads.lpii.calculadorahistorico.calculadorahistorico;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface CalculosRepository extends CrudRepository<Calculos, Long>{

    List<Calculos> findAll();
}
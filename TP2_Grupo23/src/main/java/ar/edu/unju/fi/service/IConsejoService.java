package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;
import jakarta.validation.Valid;

public interface IConsejoService {

    List<Consejo> getLista();

    void guardar (@Valid Consejo consejo);

    Consejo getBy(String titulo);

    void modificar (Consejo consejo);

    void eliminar (Consejo consejoEncontado);

    Consejo getConsejo();

}
package services;

import entidades.Articulo;
import entidades.Comentario;
import services.GestionDb;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ComentarioServices extends GestionDb<Comentario> {
    private static ComentarioServices instancia;

    private ComentarioServices(){
        super(Comentario.class);
    }

    public static ComentarioServices getInstancia(){
        if(instancia==null){
            instancia = new ComentarioServices();
        }
        return instancia;
    }
    public List<Comentario> findAllByArticulo(Articulo articulo){
        EntityManager entityManager = getEntityManager();
        Query query= entityManager.createNamedQuery("Comentario.findAllByArticulo");
        query.setParameter("articulo", articulo);
        return query.getResultList();
    }


}
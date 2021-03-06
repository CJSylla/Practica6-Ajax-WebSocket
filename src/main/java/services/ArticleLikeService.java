package services;


import entidades.ArticleLike;
import entidades.Articulo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class ArticleLikeService extends GestionDb<ArticleLike> {
    private static ArticleLikeService instancia;

    private ArticleLikeService(){
        super(ArticleLike.class);
    }

    public static ArticleLikeService getInstancia(){
        if(instancia==null){
            instancia = new ArticleLikeService();
        }
        return instancia;
    }

    public List<ArticleLike> findAllByArticulo(Articulo articulo){
        EntityManager entityManager = getEntityManager();
        Query query= entityManager.createQuery("select a from ArticleLike a where a.articulo like :articulo");
        query.setParameter("articulo", articulo);
        return query.getResultList();
    }
    public Boolean deleteAllByArticulo(Articulo articulo){
        EntityManager entityManager = getEntityManager();
        Query query= entityManager.createQuery("delete from ArticleLike a where a.articulo like :articulo");
        query.setParameter("articulo", articulo);
        return true;
    }
}

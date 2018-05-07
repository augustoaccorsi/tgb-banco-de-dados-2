package br.unisinos.bancodedados2.tgb.daos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.unisinos.bancodedados2.tgb.models.PaginatedList;

public class PaginatorQueryHelper{

   public <T> PaginatedList list(TypedQuery<T> query, TypedQuery<Number> countQuery, int currentPage, int max){
      List<T> currentList = query.setFirstResult(currentPage * max).setMaxResults(max).getResultList();
      Number count = countQuery.getSingleResult();
      return new PaginatedList(currentList, count);
   }

   public <T> PaginatedList list(EntityManager manager, Class<T> classParam, int currentPage, int max){
	   
      if (!classParam.isAnnotationPresent(Entity.class)){
         throw new IllegalArgumentException("Your entity is not annotated with @Entity");
      }
      
      String simpleName = classParam.getSimpleName();

      TypedQuery<T> listQuery = manager.createQuery( "select o from " + simpleName + " o", classParam);
      TypedQuery<Number> countQuery = manager.createQuery( "select count(1) from " + simpleName + " o", Number.class);

      return list(listQuery, countQuery, currentPage, max);
   }
}

package br.unisinos.bancodedados2.tgb.models;

import java.util.List;

public class PaginatedList{

   private final List<?> list;
   private final Number count;

   public PaginatedList(List<?> list, Number count){
      this.list = list;
      this.count = count;
   }

   public List<?> getList()
   {
      return list;
   }

   public int getCount()
   {
      return count.intValue();
   }

   public int getNumberOfPages(int recordsPerPage){
      int total = getCount();
      int pages = total / recordsPerPage;

      if (total % recordsPerPage > 0){
         pages++;
      }
      
      if (pages == 0){
    	  pages = 1;
      }
      
      return pages;
   }
}
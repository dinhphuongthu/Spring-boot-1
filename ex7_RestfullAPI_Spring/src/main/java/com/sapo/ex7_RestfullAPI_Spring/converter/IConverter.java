package com.sapo.ex7_RestfullAPI_Spring.converter;

public interface IConverter<E,T> {
   E toEntity(T dto);
   T toDTO(E entity);
   E toEntity(E entity, T dto);
   
}

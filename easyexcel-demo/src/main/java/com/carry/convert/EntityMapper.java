package com.carry.convert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Deprecated,please turn to {@link}
 * 
 * @param <D> DTO Class
 * @param <E> Entity Class
 */
public interface EntityMapper<E, D> {

  /**
   * Convert a entity Object to it's dto.
   * 
   * @param entity the entity to convert
   * @return the dto
   */
  public abstract D entityToDto(E entity);

  /**
   * Convert a list of entities to the list of dtos.
   * 
   * @param entities the list to convert
   * @return the list of dtos
   */
  public default List<D> entitiesToDtos(List<E> entities) {
    if (entities == null) {
      return new ArrayList<>();
    }
    return entities.stream().map(this::entityToDto).collect(Collectors.toList());
  }

  /**
   * Convert a dto to it's object entity.
   * 
   * @param dto the dto to convert
   * @return the entity
   */
  public abstract E dtoToEntity(D dto);

  /**
   * Convert a list of dtos to the list of entities.
   * 
   * @param dtos the list to convert
   * @return the list of entities
   */
  public default List<E> dtosToEntities(List<D> dtos) {
    if (dtos == null) {
      return new ArrayList<>();
    }
    return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
  }

}

package com.hoangminh.converter;

import com.hoangminh.dto.NewDTO;
import com.hoangminh.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

    public NewEntity toEntity(NewDTO dto) {
        NewEntity entity = new NewEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDesc(dto.getShortDesc());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

    public NewDTO toDTO(NewEntity entity) {
        NewDTO dto = new NewDTO();
        if(entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setShortDesc(entity.getShortDesc());
        dto.setThumbnail(entity.getThumbnail());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setCreatedDate(entity.getModifiedDate());
        return dto;
    }

    public NewEntity toEntity(NewDTO dto, NewEntity entity) {
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDesc(dto.getShortDesc());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }
}

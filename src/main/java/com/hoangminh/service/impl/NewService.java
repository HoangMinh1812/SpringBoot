package com.hoangminh.service.impl;

import com.hoangminh.converter.NewConverter;
import com.hoangminh.dto.NewDTO;
import com.hoangminh.entity.CategoryEntity;
import com.hoangminh.entity.NewEntity;
import com.hoangminh.repository.CategoryRepository;
import com.hoangminh.repository.NewRepository;
import com.hoangminh.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if(newDTO.getId() != null) {
            NewEntity oldNewEntity = newRepository.getOne(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO, oldNewEntity);
        } else {
            newEntity = newConverter.toEntity(newDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item: ids) {
            newRepository.deleteById(item);
        }
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for (NewEntity item : entities) {
            NewDTO newDTO = newConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for (NewEntity item : entities) {
            NewDTO newDTO = newConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }
}

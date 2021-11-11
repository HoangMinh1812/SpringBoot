package com.hoangminh.api;

import com.hoangminh.api.output.NewOutput;
import com.hoangminh.dto.NewDTO;
import com.hoangminh.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class NewAPI {

    @Autowired
    private INewService newService;

    @GetMapping(value = "/new")
    public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page,
                             @RequestParam(value = "limit", required = false) Integer limit) {
        NewOutput result = new NewOutput();
        if (page != null && limit != null) {
            result.setPage(page);
            Pageable pageable = PageRequest.of(page-1, limit);
            result.setListResult(newService.findAll(pageable));
            result.setTotalPage((int) Math.ceil((double)(newService.totalItem()/limit)));
        } else {
            result.setListResult(newService.findAll());
        }
        return result;
    }

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return  newService.save(model);
    }

    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return  newService.save(model);
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }


}

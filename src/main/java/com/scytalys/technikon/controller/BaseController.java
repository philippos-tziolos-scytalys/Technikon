package com.scytalys.technikon.controller;

import com.scytalys.technikon.base.BaseComponent;
import com.scytalys.technikon.domain.BaseModel;
import com.scytalys.technikon.mapper.BaseMapper;
import com.scytalys.technikon.service.BaseService;
import com.scytalys.technikon.transfer.resource.BaseResource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseController <T extends BaseModel, R extends BaseResource> extends BaseComponent {

    protected abstract BaseService<T, Long> getBaseService();

    protected abstract BaseMapper<T, R> getMapper();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        getBaseService().deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody final R resource) {
        if (getBaseService().exists(getMapper().toDomain(resource))) {
            getBaseService().delete(getMapper().toDomain(resource));
        }
    }

}

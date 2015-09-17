package com.nitish.mapper;

/**
 * Created by nsm1211 on 11-09-2015.
 */
public interface BasicMapper<L,R> {
    R mapToModel(L bean);
    L mapToBean(R model);

}

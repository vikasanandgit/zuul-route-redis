package com.cfeindia.examples.zuul.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cfeindia.examples.zuul.model.DynamicRoute;

@Repository
public interface DynamicRouteRedisRepository extends CrudRepository<DynamicRoute, String> {}
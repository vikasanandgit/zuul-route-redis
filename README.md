# zuul-route-redis

This project provide rest APIs to register dynamic routes in zuul server at run time. It saves the route details in Redis cache.

It is fault tolerant and restarting the zuul server restores the previous routes from redis cache. 

Other database or cache can be used instead of redis but to explain the process redis is sufficient.

This example includes saving and retrieving data using Redis. This example also demonstrates how to load data at server startup in Spring boot/Spring MVC. 


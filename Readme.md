# easymind.dashboard

# EasyMind Backend Service
Backend is uses Spring Boot framework and Postgresql database, it is straightforward for local development.You can tun Postgresql on docker and set connection string on properties.

For database you can run following docker command :
Previously you should create a folder on your local computer for persisting data like this example in linux :

```mkdir /local/computer/folder/postrgeseasymind```

Pull postgres image from docker hub :
```docker pull postgres```

Then run following command :
```docker run -p 5432:5432 --name easymind-postgres -v /local/computer/folder/postrgeseasymind:/var/lib/postgresql/data -e POSTGRES_PASSWORD=12345 -e POSTGRES_DB=easymind -d postgres:13.6```
And run backend application with maven :

```mvn spring-boot:run``` 
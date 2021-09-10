# refs
https://qiita.com/supi89/items/1008e633f6ac2028e1e9

# flyway-docker-migration

### create postgresql container

```
docker-compose up -d db
```

### flyway-migration
- clean

```
docker-compose run --rm flyway-clean
```

- migrate

```
docker-compose run --rm flyway-migrate
```

- info

```
docker-compose run --rm flyway-info
```

- baseline

```
docker-compose run --rm flyway-baseline
```

- exec

```
docker-compose exec db bash
psql -h localhost -p 5432 -U user -d test_db
```
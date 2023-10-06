# Microservicio de Gestión de Modelos

## Descripción

El microservicio de Gestión de Modelos se encarga de gestionar la información relativa a los diferentes modelos de producción en un sistema de fabricación.

## Endpoints

### GET Endpoints

- `GET /`: Retorna una lista de todos los modelos.
- `GET /piezas/{idModelo}`: Retorna el número de piezas necesarias para un modelo específico.
- `GET /coste/{idModelo}`: Retorna el costo de un modelo específico.
- `GET /filtro-piezas/{piezasMinimo}/{piezasMaximo}`: Retorna modelos que requieran un número de piezas dentro del rango especificado.
- `GET /filtro-coste/{costeMinimo}/{costeMaximo}`: Retorna modelos que tienen un costo dentro del rango especificado.
- `GET /filtro-nombre/{filtro}`: Retorna modelos cuyos nombres contienen el substring proporcionado en el filtro.

### POST Endpoints

- `POST /`: Crea un nuevo modelo basado en el objeto JSON proporcionado en el cuerpo de la solicitud.

### PUT Endpoints

- `PUT /actualizar-piezas-necesarias/{idModelo}/{piezasNecesarias}`: Actualiza el número de piezas necesarias para un modelo específico.
- `PUT /actualizar-nombre-modelo/{idModelo}/{nombreModelo}`: Actualiza el nombre de un modelo específico.
- `PUT /actualizar-coste/{idModelo}/{coste}`: Actualiza el costo de un modelo específico.

### DELETE Endpoints

- `DELETE /{idModelo}`: Elimina el modelo correspondiente al ID proporcionado.

### Pasos para ejecutar

1. Clona el repositorio a tu máquina local
2. Crear base de datos MySQL si fuera necesario con las sentencias documentadas en el archivo create.sql dentro de la carpeta META-INF
3. Ejecuta `mvn spring-boot:run` para iniciar el microservicio.
4. El servicio ahora está corriendo y los endpoints pueden ser accedidos vía `localhost:8080`.

 

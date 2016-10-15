# NameFinder
NameFinder using OpenNLP

Download the model and place it under the input directory.
```
http://opennlp.sourceforge.net/models-1.5/en-ner-person.bin
```

Running with maven:
```
mvn spring-boot:run
```

Frontend:
```
http://localhost:8080/
```

Swagger:
```
http://localhost:8080/swagger-ui.html
```

TODO:
* Wrap as a web application (Spring-boot?)
* Expose as a ReST service (JAX-RS?)
* Integrate an OCR library (OpenCV, Tesseract, ...)
* Akka for parallelization 

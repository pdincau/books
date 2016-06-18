Simple Spike with Apollo

Compile and Run
---------------

    $ mvn package
    $ java -jar target/apollo.jar

Try a request:

Create Book:

    $ curl -v -XPOST --data "{\"title\": \"tdd\", \"author\": \"beck\", \"isbn\":\"any isbn\"}" http://localhost:8080/books/add

Vote Book:

    $ curl -v -XPOST --data "{\"rate\": 2}" http://localhost:8080/books/anybookid/rate

Next to do
----------

1) Improve rabbitmq publisher (async, instantiation, etc)
2) Store first views


Books

Compile and Run
---------------

    $ mvn package
    $ java -jar target/books.jar

You will need also a rabbit-mq server running.

Try a request:

Create Book:

    $ curl -v -XPOST --data "{\"title\": \"tdd\", \"author\": \"beck\", \"isbn\":\"any isbn\"}" http://localhost:8080/books/add

Vote Book:

    $ curl -v -XPOST --data "{\"rate\": 2}" http://localhost:8080/books/anybookid/rate

Resources used:
--------------

* https://msdn.microsoft.com/en-us/library/dn568103.aspx
* http://www.cqrs.nu/tutorial/cs/02-domain-logic
* https://github.com/gregoryyoung
* https://dzone.com/articles/getting-started-rabbitmq-java


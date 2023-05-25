# Read Me First
This project collects the information of consortiums,providers,clients and dois from [Datacite](https://datacite.org/) and can be accessed in the form of a tree through API

This app contains three api:
* ``/consortium/{consortiumId}/providers``: fetch providers of a specific consortium
* ``/provider/{providerId}/clients``: fetch clients of a specific provider
* ``/client/{clientId}``: fetch total doi of a specific client

# What You Need
* Java 17
* Maven 3.5+
* You can also import the code straight into your IDE:
    * IntelliJ IDEA
    * VSCode

# Getting Started

* For up and running spring boot app just use this command :
  ```mvn spring-boot:run```
* Swagger doc:
  ``http://localhost:8080/swagger-ui/index.html``

### Reference Documentation

For further reference, please consider the following sections:

* [Datacite Api Reference Guide](https://support.datacite.org/reference/introduction)


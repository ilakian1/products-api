# Product — UML class diagram

```mermaid
classDiagram
    class Product {
        -id : Long
        -name : String
        -price : double
        +Product()
        +Product(id : Long, name : String, price : double)
        +getId() Long
        +getName() String
        +getPrice() double
    }
```

# ProductController, ProductService and Product — UML class diagram

PlantUML source: [`ProductService.puml`](ProductService.puml)

```mermaid
classDiagram
    class Product {
        -id : Long
        -name : String
        -price : double
        +getId() Long
        +getName() String
        +getPrice() double
        +setId(id : Long) void
        +setName(name : String) void
        +setPrice(price : double) void
    }
    class ProductService {
        -products : List~Product~
        -nextId : Long
        +getAllProducts() List~Product~
        +getProductById(id : Long) Optional~Product~
        +addProduct(product : Product) Product
        +deleteProduct(id : Long) void
        +findByName(name : String) List~Product~
    }
    class ProductController {
        -productService : ProductService
        +getAllProducts() List~Product~
        +getProductById(id : Long) Product
        +addProduct(product : Product) Product
        +deleteProduct(id : Long) void
        +search(name : String) List~Product~
    }
    ProductController ..> ProductService
    ProductService --> Product
```

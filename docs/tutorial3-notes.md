# Tutorial 3 — Notes

Collections, Generics & the Service Layer.

## Activity 0 — Predict the output

| # | Statement | Compiles? | What happens — or why not? |
|---|---|---|---|
| 1 | `products.add(new Product(3L, "Mug", 8.50));` | Yes | Adds the Mug. The list now holds 3 products. |
| 2 | `products.add("Mug");` | No | The list only accepts `Product`. A `String` is not a `Product`. |
| 3 | `String s = products.get(0);` | No | `get` returns a `Product`, which cannot be assigned to a `String`. |
| 4 | `Product p = products.get(5);` | Yes | Throws `IndexOutOfBoundsException` at runtime. The list has no index 5. |
| 5 | `int n = products.size();` | Yes | `n` is 2. |
| 6 | `fixed.add(new Product(3L, "Mug", 8.50));` | No | Arrays have no `add()` method. Their size is fixed. |
| 7 | `Product q = byId.get(99L);` | Yes | `q` is `null`. The map has no key 99. |
| 8 | `System.out.println(q.getName());` | Yes | Throws `NullPointerException` at runtime, because `q` is `null`. |

**Rows 4 and 8 vs rows 2, 3 and 6:** rows 2, 3 and 6 are type errors, so the compiler catches them. Rows 4 and 8 have correct types; they fail because of what is *in* the collection when the line runs (how many items, which keys). The compiler only checks types, not runtime contents, so it has to trust us about sizes, indexes and nulls.

## Task 14 — Full sweep

| # | Call | Status | Body |
|---|---|---|---|
| 1 | `POST /products` `{"name":"Laptop","price":899.99}` | 200 | `{"id":1,"name":"Laptop","price":899.99}` |
| 2 | `POST /products` `{"name":"Mouse","price":24.99}` | 200 | `{"id":2,"name":"Mouse","price":24.99}` |
| 3 | `GET /products` | 200 | `[{"id":1,...Laptop},{"id":2,...Mouse}]` |
| 4 | `GET /products/1` | 200 | `{"id":1,"name":"Laptop","price":899.99}` |
| 5 | `DELETE /products/1` | 200 | *(empty)* |
| 6 | `GET /products` | 200 | `[{"id":2,"name":"Mouse","price":24.99}]` |

The service assigns the ids. No id is sent in the POST body.

## Task 15 — 404 experiment

`GET /products/99` → **status 200, empty body**.

This is wrong. 200 means "OK, here is what you asked for", but there was nothing to give. The right answer is **404 Not Found** with a message saying product 99 does not exist. It happens because the controller returns `orElse(null)` and Spring sends `null` as an empty 200 response. This gets fixed in Lecture 6 (custom exceptions + `@ControllerAdvice`).

## Task 18 — Search

| Call | Status | Body |
|---|---|---|
| `GET /products/search?name=Lap` | 200 | `[{"id":3,"name":"Laptop",...},{"id":4,"name":"Lap desk",...}]` |
| `GET /products/search?name=zzz` | 200 | `[]` — no matches is an empty list, not an error |

## Stretch tasks

**`GET /products/cheaper-than?price=50`** — added as `findCheaperThan(double price)` in `ProductService`, with a one-line endpoint in the controller. With Laptop (899.99), Mouse (24.99) and Lap desk (30.00), `price=50` returns Mouse and Lap desk; `price=10` returns `[]`.

*Service or controller?* The **service**. "Which products are cheaper than X" is a rule about products, not about HTTP. The controller only reads `price` from the URL and hands it on. If the filter lived in the controller, a desktop app reusing `ProductService` would lose it.

**Swapping `List<Product>` for `Map<Long, Product>`** — the controller would not need to change, because it never touches the collection. It only calls the service's public methods, and their signatures stay the same. The `products` field is private, so how it is stored is hidden. That is encapsulation: the service can change its internals freely as long as its public methods stay the same. The repository interface in Lecture 7 relies on the same idea.

## Exit ticket

1. **Controller or service?** If the line knows about HTTP (URLs, path variables, request bodies, status codes), it belongs in the controller; if it knows about products (storing, numbering, finding, filtering), it belongs in the service.
2. **Still fuzzy:** *(your own answer)*
3. **Confidence (1–5) writing a class that manages a collection:** *(your own answer)*

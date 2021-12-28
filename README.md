# Spring Challenge

## Entidades da aplicação

#### Product
```java
public class Product {
    private Long productId;
    private String name;
    private String category;
    private String brand;	
    private BigDecimal price;
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;
    
    // Getters e Setters
}
```

### Rotas da aplicação

(Henrique) Uma lista de todos os produtos disponíveis:

`GET /api/v1/articles`

(Henrique) Uma lista de produtos filtrados por categoria:

`GET /api/v1/articles?category=categoryName`

(Lemuel) Uma lista que permite a combinação de qualquer um dos filtros. 
**Exemplo 1:** Categoria + Frete Grátis. (Todas as combinações de 2 possíveis MENOS
quantidade):

`GET /api/v1/articles?category=categoryName&freeShipping=true`

**Exemplo 2:** Nome + Marca

`GET /api/v1/articles?product=productName&brand=brandName`

(Lemuel) Alfabético (crescente e decrescente):

`GET /api/v1/articles?category=categoryName&freeShipping=true&order=0`

`GET /api/v1/articles?category=categoryName&freeShipping=true&order=1`

(Vinicius) Maior preço:

`GET /api/v1/articles?category=categoryNamefreeShipping=true&order=2`

(Vinicius) Menor preço:

`GET /api/v1/articles?category=categoryName&freeShipping=true&order=3`

### Parâmetros de Ordenação

|paramOrder|Description|
|----------|-----------|
|0|Alfabético crescente|
|1|Alfabético decrescente|
|2|Maior a menor preço|
|3|Menor a maior preço|

### Solicitação de compra

(Everton) Enviando uma solicitação de compra:

`POST /api/v1/purchase-request`

Payload:
```json
{
    "articlesPurchaseRequest": [
        {
            "productId": 1,
            "name": "Teste",
            "brand": "Teste",
            "quantity": 2
        },
        {
            "productId": 2,
            "name": "Teste",
            "brand": "Teste",
            "quantity": 4
        }
    ]
}
```

Response:
```json
{
    "ticket": {
        "id": 530,
        "articles": [
            {
                "productId": 2,
                "name": "Teste",
                "category": "Ferramentas",
                "brand": "FORTGPRO",
                "price": 1800.00,
                "quantity": 5,
                "freeShipping": true,
                "prestige": "*****"
            },
            {
                "productId": 2,
                "name": "Teste",
                "category": "Ferramentas",
                "brand": "FORTGPRO",
                "price": 1800.00,
                "quantity": 5,
                "freeShipping": true,
                "prestige": "*****"
            }
        ],
        "total": 9999
    }
}
```

(Lucca) Cadastro de Produtos:

`POST /api/v1/insert-articles-request`

Payload:
```json
{
    "articles": [
        {
            "productId": 1,
            "name": "Teste",
            "category": "Ferramentas",
            "brand": "Teste",
            "price": 1800.00,
            "quantity": 2,
            "freeShipping": true,
            "prestige": "****"
        },
        {
            "productId": 1,
            "name": "Teste",
            "category": "Ferramentas",
            "brand": "Teste",
            "price": 1800.00,
            "quantity": 2,
            "freeShipping": true,
            "prestige": "****"
        }
    ]
}
```

Response:
```json
{
    "articlesDTO": [
        {
            "productId": 2,
            "name": "Teste",
            "category": "Ferramentas",
            "brand": "FORTGPRO",
            "price": 1800.00,
            "quantity": 5,
            "freeShipping": true,
            "prestige": "*****"
        },
        {
            "productId": 2,
            "name": "Teste",
            "category": "Ferramentas",
            "brand": "FORTGPRO",
            "price": 1800.00,
            "quantity": 5,
            "freeShipping": true,
            "prestige": "*****"
        }
    ]
}
```
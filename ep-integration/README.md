# Integration Order Status

This POC demonstrates how you can integrate Order Status in EPCC order from a generic ERP.

## How to use locally

When running this example locally it's recommended you use a service like [ngrok](https://ngrok.com) to tunnel your dev
environment to the outside world.

Once you have the repo running locally, you'll want to add the integration via
the [Moltin Dashboard](https://dashboard.moltin.com/app/settings/integrations). The `URL` will be the one provided by
ngrok.

### 1. Download the POC

Clone the repository:

```bash

```

### 2. Configure Flows

Moltin provides you the ability to extend core resources with the Flows feature. Go to
the [Moltin Dashboard](https://dashboard.moltin.com/app/settings/flows) and navigate to `Settings > Flows`.

Here you will want to create a new Flow (or edit if it already exists) for extending Orders. Give it a name and
description you will recognise, but **make sure** the `slug` is set to `orders`.

Next you will want to create a new Field for the Flow you just created.

Give the new Field a name and description you will recognise. **Make sure** the `slug` is set to `short_id` as this is
what the serverless function expects.

Save this Field

### 3. Start the server and ngrok

Start the development server

The server will typically start on PORT `60000`, if not, make a note for the next step.

Start ngrok

```bash
ngrok http localhost:60000
```

This will expose PORT `60000` to the outside world. Make a note of the `http` URL ngrok provides.

### 4. Start database

Run docker-compose.yml in the repository.

Create table:
```bash
CREATE TABLE orders (
    order_id varchar(40) NOT NULL,
    status_erp varchar(40) NULL,
    status varchar(40) NULL,
    payment varchar(40) NULL,
    shipping varchar(40) NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (order_id)
);
```

### 4.Create a new Moltin integration

You must now tell Moltin the ngrok URL above. Head to
the [Moltin Dashboard](https://dashboard.moltin.com/app/settings/integrations), login and go
to `Settings > Integrations` and click `Create`.

Enter a name and description for your Integration.

Next, enter the `URL`.

Now finally you'll want to configure when this webhook will be invoked, in this example check the `Order` => `Created` box.

That's it! Click Save

### 5. Download postman collection

- [Collection](https://documentation.elasticpath.com/assets/epcc/postman/collection.json)

- [Enviroment](https://documentation.elasticpath.com/assets/epcc/postman/environment.json)

### 6. Authenticate

Requests to Commerce Cloud require an Authorization header containing your Bearer token. There are two token types;
implicit and client_credentials.

This guide uses the client_credentials grant type.

Get your API keys Head to the Dashboard, sign in, select your project, and make a copy of your Client ID and Client
secret.

Get an access token

Send POST request: `Get client credential token`.

A successful request responds with something similar to:

```bash
{
    "expires": 1608306461,
    "access_token": "7562c99c854f6d355c078ab0e5ad7c6ddbc058c5",
    "identifier": "client_credentials",
    "expires_in": 3600,
    "token_type": "Bearer"
}
```

Copy Congratulations!

Now youʼll want to make a copy of your access_token. This is your Bearer token that is required for future requests.

### 7. Get a Cart

Letʼs go ahead and request a new Cart. Weʼll use the unique reference `abc` for the
Cart. Weʼll need this when requesting the items, adding items and checking out.

Send GET request: `Get a cart`.

Youʼll receive a response similar to:

```bash
{
  "data": {
    "id": "abc",
    "type": "cart",
    "state": "NY",
    "country": null,
    "zipcode": null,
    "name": "Cart",
    "description": "",
    "links": {
      "self": "https://api.moltin.com/v2/carts/abc"
    },
    "meta": {
      "display_price": {
        "with_tax": {
          "amount": 129900,
          "currency": "EUR",
          "formatted": "€1,299.00"
        },
        "without_tax": {
          "amount": 129900,
          "currency": "EUR",
          "formatted": "€1,299.00"
        },
        "tax": {
          "amount": 0,
          "currency": "EUR",
          "formatted": "€0.00"
        }
      },
      "timestamps": {
        "created_at": "2020-12-02T19:47:44Z",
        "updated_at": "2020-12-18T14:47:59Z"
      }
    },
    "relationships": {
      "items": {
        "data": [
          {
            "type": "custom_item",
            "id": "18f7cdbf-2c21-4f42-b904-990a93e33afb"
          },
          {
            "type": "cart_item",
            "id": "050d06e7-87c7-4def-b68d-9c32ec93199b"
          }
        ]
      },
      "customers": {
        "data": [
          {
            "type": "customer",
            "id": "62796c51-0797-4058-98ed-f0cf4bc4e081"
          }
        ]
      }
    }
  }
}
```

Now that we have successfully authenticated and retrieved a Cart, now we add a custom item to the Cart.

### 8.Add to Cart

Letʼs go ahead and add a custom_item to the Cart. We are using the same cart reference `abc`.

Send POST request: `Add product to cart`.

Now we have items in the cart, now we convert the Cart to an unpaid Order using the /checkout endpoint.

### 9.Check out a Cart

You can check out a Cart using an existing Customer ID or an object including the customer name and email. In the
following example, weʼll provide a name and an email, as we have no customers yet.

Along with the customers information, we must also provide the billing and shipping information.

Send POST request: `Checkout as costumer`.

Copy When the request is complete, youʼll receive a 201 CREATED response similar to the following example:

Whit this request also the observe Order.created is been trigger. In our local database we can find the order that we
have just created. Our service update the attribute status_erp. We can see it by doing this request:

Send GET request: `Get an order` using the order_id what we have created before.

Youʼll receive a response similar to:

```bash
{
  "data": {
    "id": "e59437fb-1db0-476e-a8f2-89aba2c16b1b",
    "type": "order",
    "status_erp": "1 - Sent to Erp",
    "status": "incomplete",
    "payment": "unpaid",
    "shipping": "unfulfilled",
    "customer": {
      "name": "Jamie Barton",
      "email": "jamie.barton@moltin.com"
    },
    "shipping_address": {
      "first_name": "Ron",
      "last_name": "Swanson",
      "phone_number": "",
      "company_name": "Ron Swanson Enterprises",
      "line_1": "1 Sunny Street",
      "line_2": "",
      "city": "Sunny Town",
      "postcode": "SU33 1YY",
      "county": "Sunnyville",
      "country": "GB",
      "instructions": ""
    },
    "billing_address": {
      "first_name": "Ron",
      "last_name": "Swanson",
      "company_name": "Ron Swanson Enterprises",
      "line_1": "1 Sunny Street",
      "line_2": "",
      "city": "Sunny Town",
      "postcode": "SU33 1YY",
      "county": "Sunnyville",
      "country": "GB"
    },
    "links": {},
    "meta": {
      "display_price": {
        "with_tax": {
          "amount": 139900,
          "currency": "EUR",
          "formatted": "€1,399.00"
        },
        "without_tax": {
          "amount": 139900,
          "currency": "EUR",
          "formatted": "€1,399.00"
        },
        "tax": {
          "amount": 0,
          "currency": "EUR",
          "formatted": "€0.00"
        }
      },
      "timestamps": {
        "created_at": "2020-12-18T15:46:03Z",
        "updated_at": "2020-12-18T15:46:06Z"
      }
    },
    "relationships": {
      "items": {
        "data": [
          {
            "type": "item",
            "id": "3b9c6f49-afbe-4f10-8383-6555bb87edef"
          },
          {
            "type": "item",
            "id": "29a3b452-a4fa-4a50-b7de-dc64d3761660"
          }
        ]
      }
    }
  }
}
```

### 10.Update Status by ERP

We can simulate that the status of the order change. ERP communicate us that the order is delivered.

Sobstitute order_id with the order_id that we have created before. Send GET
request: `http://127.0.0.1:60000/order/updateStatusErp/order_id/status/2-delivered`

Youʼll receive a response similar to:

```bash
{
  "data": {
    "id": "e59437fb-1db0-476e-a8f2-89aba2c16b1b",
    "type": "order",
    "status": "incomplete",
    "payment": "unpaid",
    "shipping": "unfulfilled",
    "customer": {
      "name": "Jamie Barton",
      "email": "jamie.barton@moltin.com"
    },
    "links": {},
    "meta": {
      "timestamps": {
        "createdAt": "2020-12-18T15:46:03Z",
        "updatedAt": "2020-12-18T15:57:11Z"
      },
      "displayPrice": {
        "tax": {
          "amount": 0,
          "currency": "EUR",
          "formatted": "€0.00"
        },
        "withTax": {
          "amount": 139900,
          "currency": "EUR",
          "formatted": "€1,399.00"
        },
        "withoutTax": {
          "amount": 139900,
          "currency": "EUR",
          "formatted": "€1,399.00"
        }
      }
    },
    "relationships": {
      "items": {
        "data": [
          {
            "type": "item",
            "id": "3b9c6f49-afbe-4f10-8383-6555bb87edef"
          },
          {
            "type": "item",
            "id": "29a3b452-a4fa-4a50-b7de-dc64d3761660"
          }
        ]
      }
    },
    "statusErp": "2-delivered",
    "shippingAddress": {
      "city": "Sunny Town",
      "postcode": "SU33 1YY",
      "county": "Sunnyville",
      "country": "GB",
      "instructions": "",
      "firstName": "Ron",
      "lastName": "Swanson",
      "phoneNumber": "",
      "companyName": "Ron Swanson Enterprises",
      "line1": "1 Sunny Street",
      "line2": ""
    },
    "billingAddress": {
      "city": "Sunny Town",
      "postcode": "SU33 1YY",
      "county": "Sunnyville",
      "country": "GB",
      "firstName": "Ron",
      "lastName": "Swanson",
      "companyName": "Ron Swanson Enterprises",
      "line1": "1 Sunny Street",
      "line2": ""
    }
  }
}
```

Our service update the attribute status_erp. We can see it by doing this request:

Send GET request: `Get an order` using the order_id what we have created before.

That's it!
# _hair-salon_

#### _hair-salon, 03-31-2017_

#### By _**Xi Xia**_

## Description
_Example text for the description of the project_


## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
|create a client object|new client|client|
|get client name|.getClientName()|Mary|
|create a client stylist id|.getClientStylist()|1|
|get all clients|.all()|{client, client}|
|get a client  id|.getClientId()| id>0|
|find client  |.find()| client|
|delete client  |.delete()| null|
|update client name  |.updateClientName()| "Sara"|
|create a stylist object|new stylist|stylist|
|get stylist name|.getStylistName()|"Mary"|
|get all stylists|.all()|{stylist, stylist}|
|get a stylist  id|.getStylistId()| id>0|
|find stylist  |.find()| stylist|
|delete stylist  |.delete()| null|
|reassign clients of deleted stylist |.delete()| client_stylist_id = -1|
|update stylist name  |.updateStylistName()| "Sara"|
|get clients of Stylist  |.getYourClients()| {client,client}|









## Setup/Installation Requirements

* _Clone the repository_
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_


### License

Copyright (c) 2017 **_Xi Xia_**

This software is licensed under the MIT license.

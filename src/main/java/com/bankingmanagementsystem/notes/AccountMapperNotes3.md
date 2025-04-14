AccountMapper.java

=>Converts between Account(Entity) and AccountDTO(Data Transfer Object)

1.Why is this needed?

=> Entity = connects database (account.java)
=> DTO = used for sending Account (Entity) to AccountDto (Data Transfer Object)
=> We don't directly expose entities to the user/client, so we convert them and using this mapper.

2.Class => AccountMapper

=> Two methods(both static methods so we can use them without creating an Object).
=> 1.mapToAccount(AccountDTO accountDto).
    =>Converts AccountDTO --> Account
    =>Used when we receive data from the client/user (e.g. create or update Account)
    => Builds an Account entity that can be saved to the database.

=> 2.mapToAccountDto(Account account)
    => Converts Account --> AccountDTO
    => Used when sending data back to the frontend or API client.
    => Converts an entity to a safe and clean DTO (no database config inside)

    Class	                    Purpose	        Exposed to client?	        Connected to DB?
    Account	Entity,         used for DB storage	         No	                 Yes
    AccountDto	        Used for API communication	     Yes	              No

=> In short:
    => Account -> used to talk to database
    => AccountDTO -> used to talk to the outside world(like frontend,Postman etc..)


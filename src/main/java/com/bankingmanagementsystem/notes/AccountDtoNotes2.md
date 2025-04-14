=> AccountDto.java class

1.what is it?
=> AccountDto is a simple java class used to carry account data between the backend and the outside world.(like frontend or postman).
=> DTO (Data Transfer Object).

2.Why do we use it?
=> To send only required data in API responses or requests.
=> To hide or protect internal details of our database structures and schemas.(Account Entity).
=> we say also say it for security purposes.

3.What does it carry?
=> id, accouNum, accHoldername, email, mobNum, balance

4.Annotations used?
=> @Data : (from lombok) Adds getters, setters, toString, equals, hashcode
=> @AllArgsConstructor: Adds a constructor with all fields.
=> @NoArgsConstrutor: Adds a Constructor with no fields.

5.How is it connected to Account.java?
=> AccountDto and Account are two separate classes.
=> They don't directly import each other.
=> we manually convert between them using a Mapper class.
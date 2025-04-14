=> AccountRepository

1. What is a Repository?
=> It's an interface tha talks to the database.
=> Instead of writing SQL manually, we use Spring Data JPA which auto-generates the queries for us.

2. How does this work?
=> We are extending JpaRepository<Account, Long>  # Jpa repository is part of Spring data Jpa, privides basic CRUD auto..
=> Account is the Entity (the model class that maps to the database table).
=> Long is the datatype of the primary key (id).

=> This Jpa Repository gives us lot of in=built methods like:
    => findById()
    => save()
    => delete()
    => findAll()


==> Custom Methods:
    1.Optional<Account> findByEmail(String Email).
        => finds account by email address.
        => returns optional(so we can check if it exists or not => safely)
        => Example.. SELECt * FROM accounts WHERE email = 'example@gmaail.com'
    
    2.Optional<Account> findByMobileNumber(String mobileNumber)
        => same as above, but for mobile number.
    
    3.boolean existsByEmail(String email):
        => Returns true if account exists with that email (used for validation).
    
    4.boolean existsByMobileNumber(String mobileNumber):
        => Returns true if mobile number already exists in DB.


==> Why Optional<Account>?
        =>It means the method might return an Account, or it might return nothing (null).
        =>Optional helps avoid null pointer exceptions and forces you to check before using.
=> Account Service

1. What is this Interface?
=> It's just an contract or blueprint.
=> It defines what actions are possible for managing bank accounts.

2. What method does it declare?
=> AccountDto createAccount(AccountDto account);
=> Input: AccountDto — the details provided by the user.
=> Output: AccountDto — the saved account after it's stored in the database.
=> This method says: “We should be able to create an account using the provided details.”

3. Summary:
=> Interface = defines “what should be done”.
+> Implementation class (AccountServiceImpl) = defines “how it’s done”.
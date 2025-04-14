-> Account.java (class)

This class represents a bank account in the system,
it used to store account details like account number, account holder name etc..

What does this class do?
It connects to the database table called accounts.
Each object of this class becomes a row in that table.
Here, we used lombok to automatically generate getter/setter methods and cnstructors.

Annotations used in this class:

@Entity => Tells java/springboot that this class is for the database table.

@Table(name = "accounts") => Sets the name in the database as "accounts".

@Id => This field is the primary key-unique for evry account.

@GeneratedValue => Auto generates the id number.

@Column(unique = true) => makes sure the specific value should be unique, if the unique is true.

@Getter/@Setter => lombok annotations to add get/set methods for all variables.

@NoArgsConstructor => Adds a constructor with no arguments (it is needed to frameworks).

@AllArgsContructor => Adds a constructor with all fields.
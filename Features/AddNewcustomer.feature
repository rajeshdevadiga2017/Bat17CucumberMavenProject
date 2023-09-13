Feature:Customer

@raj
Scenario Outline: Add New Customer
 Given User Lanch Chrome Browser
  When   User open url "https://admin-demo.nopcommerce.com/login"
  And   User enter Email as "<email>" and password as "<password>"
  And   User click on Login button
  Then User can view Dashboard
   When user click on customers menu
   And  User click on customers menu item
   And User click on new add button
   Then User can view add new customer page
   When user enter customer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<adminCommenet>"
   And user click on save button
   Then User can view confirmation msg "The new customer has been added successfully."
   And close browser
   
    Examples:
   |email|password|newEmail|newPass|fname|lname|gender|comName|adminCommenet|
   |admin@yourstore.com|admin|raj11@gmail.com|1234|Bali17|Raj|Male|ABC|Test1|
   |admin@yourstore.com|admin|radh1ika33@gmail.com|4537|Radha|Patel|Female|xyz|Test2|
   |admin@yourstore.com|admin|Madhari21@gmail.com|4589|Madhu|Patil|Female|pqr|Test3|
   
   
 

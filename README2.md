# SOLID Refactoring Kata

## Outline 
It's been months since the project has been refreshed. The business has announced today that we are going to become a global scale bank. 
The business needs us to support multi-currency payments. 

## Requirements
Assuming all the downstreams and upstreams have not been impacted yet (HTTP clients, controllers, which are out of the scope for now).
The team is now in preparations of integrating new business logics into the app.
The new features include:
- Making Payments between UK, DE, FR, AU, CA, US
- Payments made locally in the same country may have different payment processing logic
- Payments can be considered in the scope of Instant, Withdraw, Saving, International
- Cashback of 5% interests on all payments for every purchase
- Premium User will receive additional 3% on cashback
- An external AuditSystem will be needed for checking every payment against user's current account at the end of each payment process

## Task
You need to make the project more extensible and maintainable. Bugs are hard to find and fix. Plus there are several new business requirements in the pipeline.

First, identify what is wrong with it.

Think about good design principles, good practice. There are two big hints:
SOLID,
TDD

- You need to implement these new features 
- The goal of this exercise is not to come up with a perfect solution, but to make sure your work done is future-proof and easy to extend and maintain.
- A big hint, SOLID, data structure, interface, DI
- You may not have enough time to implement all the feature, but feel free to start to fulfill the requirements in any order

### Specific new requirements
International payment of more than 500 pounds will be rejected if more than 2 suspicious thing has been flagged
(Exact suspicious things can be defined later)



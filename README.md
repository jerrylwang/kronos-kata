# SOLID Refactoring Kata

## Outline 
We have a project. It meets our customers needs but is difficult to maintain. You need are now in charge of supporting it.


## Requirements
The application receives an HTTP request from a client. It takes this request and creates a request object which it passes to a service.
The service is the code that you are working on. The HTTP client is out of scope for now. 
The service carries out some business logic on the request data. 
Based on this logic it may call a downstream. The call to the downstream is behind a facade - the HTTP send (if it is indeed HTTP) is out of scope for now.
Again depending on business logic and what it has received, it may send a message to a queueing system. (Yet again, the actual implementation of the queueing system is out of scope)

## Task
You need to make the project more extensible and maintainable. Bugs are hard to find and fix. Plus there are several new business requirements in the pipeline.

First, identify what is wrong with it.

Think about good design principles, good practice. There are two big hints:
SOLID,
TDD

### Specific new requirements
We want to be able to make a payment of less than 100 pounds if only one suspicious thing has been flagged

We want to be able to increase the time window for payments based on whether a customer is a premium customer




# Train Reservation System - Spring Boot application
This application uses Spring Boot to develop a REST service for Train reservation system. The service contains the following functionalities:

- /reserveTicket POST reserves train tickets
- /reservationDetails/{reserveId} GET reservation details by id
- /fetchUsersDetails/{trainId}/{sectionType} GET reserved users for the section type
- /removeUser/{trainId}/{userId} DELETE user from reservation
- /updateSeat/{trainRefId}/{userId} PUT update seat for the reservation


## Security 
- Enforce HEADER Uniquie Key authentication
- Set security context for retrieving authorities

## References

- [Spring Boot Documentation](https://spring.io/guides/gs/spring-boot/)
- Spring Security Authentications

Name
- Revenue Analysis Rest API

Description
- This Rest API will provide the user to get Revenue analysis details from mapped database based on input parameters such as Member ID, MonthYear, Game ID etc.  

Installation
- Rest API Development:
> JDK 1.8
> Eclipse IDE for Enterprise Java Developers
> Tomcat Apache Server
> Maven plugin if not added
> Maven dependencies
> ojdbc jars
> Databsae connection details

- Execute Rest API:
> Postman

Usage
- 3 GET methods created
> Get Win Amount
> Get Wager Amount
> Get Number of Wagers

> Parameters can be combination of MemberId, monthYear and GameId.
> In below requests, monthYear used is '201712' and GameId used is '7723'. These 2 parameters are optional and can take dynamic values. User can use API with or without these parameters.
> In case MemberId is not present in database, response will be '404 Not Found'


- Get Win Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/winamount/
> Parameters:{memberId}
> Response:
{
    "activityYearmonth": "0",
    "gameId": "0",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "0.0",
    "winAmount": "30.8"
}
> Status: 200 OK

- Get Win Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/winamount/
> Parameters:{memberId}?byMonth=201712
> Response:
{
    "activityYearmonth": "201712",
    "gameId": "0",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "0.0",
    "winAmount": "16.5"
}
> Status: 200 OK


- Get Win Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/winamount/
> Parameters:{memberId}?byGameType=7723
> Response:
{
    "activityYearmonth": "0",
    "gameId": "7723",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "0.0",
    "winAmount": "16.5"
}
> Status: 200 OK

- Get Win Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/winamount/
> Parameters:{memberId}?byMonth=201712&byGameType=7723
> Response:
{
    "activityYearmonth": "201712",
    "gameId": "7723",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "0.0",
    "winAmount": "16.5"
}
> Status: 200 OK

- Get Wager Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/wageramount/
> Parameters:{memberId}
> Response:
{
    "activityYearmonth": "0",
    "gameId": "0",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "9.8",
    "winAmount": "0.0"
}
> Status: 200 OK

- Get Wager Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/wageramount/
> Parameters:{memberId}?byMonth=201712
> Response:
{
    "activityYearmonth": "201712",
    "gameId": "0",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "0.9",
    "winAmount": "0.0"
}
> Status: 200 OK


- Get Wager Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/wageramount/
> Parameters:{memberId}?byGameType=7723
> Response:
{
    "activityYearmonth": "0",
    "gameId": "7723",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "0.1",
    "winAmount": "0.0"
}
> Status: 200 OK

- Get Wager Amount
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/wageramount/
> Parameters:{memberId}?byMonth=201712&byGameType=7723
> Response:
{
    "activityYearmonth": "201712",
    "gameId": "7723",
    "memberId": "1001",
    "noOfWagers": "0",
    "wagerAmount": "0.1",
    "winAmount": "0.0"
}
> Status: 200 OK

- Get Number of Wagers
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/numberOfWagers/
> Parameters:{memberId}
> Response:
{
    "activityYearmonth": "0",
    "gameId": "0",
    "memberId": "1001",
    "noOfWagers": "12",
    "wagerAmount": "0.0",
    "winAmount": "0.0"
}
> Status: 200 OK

- Get Number of Wagers
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/numberOfWagers/
> Parameters:{memberId}?byMonth=201712
> Response:
{
    "activityYearmonth": "201712",
    "gameId": "0",
    "memberId": "1001",
    "noOfWagers": "3",
    "wagerAmount": "0.0",
    "winAmount": "0.0"
}
> Status: 200 OK


- Get Number of Wagers
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/numberOfWagers/
> Parameters:{memberId}?byGameType=7723
> Response:
{
    "activityYearmonth": "0",
    "gameId": "7723",
    "memberId": "1001",
    "noOfWagers": "1",
    "wagerAmount": "0.0",
    "winAmount": "0.0"
}
> Status: 200 OK

- Get Number of Wagers
> Method: GET
> EndPoint:http://localhost:8081/revenue/webresources/
> Resource: revenuedetails/numberOfWagers/
> Parameters:{memberId}?byMonth=201712&byGameType=7723
> Response:
{
    "activityYearmonth": "201712",
    "gameId": "7723",
    "memberId": "1001",
    "noOfWagers": "1",
    "wagerAmount": "0.0",
    "winAmount": "0.0"
}
> Status: 200 OK

Roadmap
-This API can be extending to get response based on other parameters
-Can add Post, Put and Delete method to add or update records in the database
# Documentation for Yellow Backend application

In this document short description of the application is shown. To run the application You just need to run the following commands: 

  cd docker
  docker-compose up
  
 Then open the application at http://localhost:8080 the other instructions are on the page. To stream an Kafka event this commands are used:
 
 ## Stream an Event
 
  curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"id":"3","name":"Dev - NonDev","startsAt":"2030-06-02T20:00:00","status":"ACTIVE","markets":[{"id":"3-1","marketId":"3way","status":"ACTIVE","outcomes":[{"id":"3-1-1","outcome_id":"3way-1","status":"ACTIVE","odd":1.1},{"id":"3-1-2","outcomeId":"3way-2","status":"ACTIVE","odd":20.1},{"id":"3-1-3","outcomeId":"3way-x","status":"ACTIVE","odd":5.1}]}]}' http://localhost:8080/stream/event
 
 ## Stream an Market
 
  curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"id":"total","name":"Total","status":"ACTIVE","outcomes":[{"id":"total-0.5","name":"1","status":"ACTIVE"},{"id":"total-1.5","name":"2","status":"ACTIVE"}]}' http://localhost:8080/stream/market
 

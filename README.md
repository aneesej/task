# Clock Service
Microservice application name : CLOCK-SERVICE <br/>

Service endpoints :<br />
http://CLOCK-SERVICE/speakCurrentTime <br />
http://CLOCK-SERVICE/getdaytype <br />

Test URLs<br />
http://localhost:8081/speakCurrentTime <br />
http://localhost:8081/getdaytype/12:00 <br />

# Is mid Day or mid Night Consumer client
Microservice application name : CLOCK-CLIENT <br />
endpoint URL http://localhost:8082/getdaytype/12:00  

# Speak Clock Consumer client
Microservice application name : CLOCK-CLIENT <br />
endpoint URL http://localhost:8082/getcurrenttime

#Discovery server
http://localhost:8761

#Steps to start
1. start discovery server <br />
2. start clock-service <br />
3. start clock-client <br />


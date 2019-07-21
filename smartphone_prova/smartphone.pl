%====================================================================================
% smartphone description   
%====================================================================================
mqttBroker("192.168.1.122", "1883").
context(ctxsmartphone, "localhost",  "MQTT", "0" ).
context(ctxfridge, "localhost",  "MQTT", "0" ).
 qactor( fridge, ctxfridge, "external").
  qactor( smartphone, ctxsmartphone, "it.unibo.smartphone.Smartphone").

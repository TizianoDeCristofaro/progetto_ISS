%====================================================================================
% fridge description   
%====================================================================================
mqttBroker("192.168.1.122", "1883").
context(ctxfridge, "localhost",  "MQTT", "0" ).
context(ctxsmartphone, "localhost",  "MQTT", "0" ).
 qactor( smartphone, ctxsmartphone, "external").
  qactor( fridge, ctxfridge, "it.unibo.fridge.Fridge").

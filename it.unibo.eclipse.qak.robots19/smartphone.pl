%====================================================================================
% smartphone description   
%====================================================================================
mqttBroker("192.168.1.122", "1883").
context(ctxsmartphone, "localhost",  "MQTT", "0" ).
 qactor( smartphone, ctxsmartphone, "it.unibo.smartphone.Smartphone").

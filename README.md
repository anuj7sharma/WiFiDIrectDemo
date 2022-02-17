# WiFiDIrectDemo
This demo is built with the help of Android native code of WiFiDIrect.
But i added some functionality to make this code Bi-Directional. Here One will be server and other will be client.


In WiFiP2P api onConnectionInfoAvailable method call and tells that wifi connection has been established. Here we know which device is server and which is client.
To create code Bi-Directional, Server should know the IP address of client.

Interesting Fact-> Server IP is defined by the API itself and its 192.168.49.1 and for client IP is also defined by API. 
So here in this code when connection establish, client sent a ping to server silently without knowing user. In Async Task which wait for opening a connection. Here 
server receives the IP of client and server stores that IP to sharedprefrene.

And there is simple logic which defines file is to be sent to which device.

You can find APK file to test the functionality.
https://play.google.com/store/apps/details?id=anuj.wifidirect

Take a look on this code and surely you will understand, in case of an kind of problem just put your comment and let me know about.

# WiFiDIrectDemo
This demo is built with the help of Android native code of WiFiDIrect.
But i added some functionality to make this code Bi-Directional. Here One will be server and other will be client.


In WiFiP2P api onConnectionInfoAvailable method call and tells that wifi connection has been established. Here we know which device is servre and which is client.
To create code Bi-Directional, Server should know the IP address of client.

Interesting Fact-> Server IP is defined by the API itself and its 192.168.49.1 and for client IP is also defined by API. 
So here in this code when connection establish, client send a ping to server sliently without knowing user. In Async Task which wait for opening a conection. Here 
server receives the IP of client and server store that IP to sharedprefrene.

And there is simple logic which define file is to be send to which device.

You can find APK file to test the functionality.
https://play.google.com/store/apps/details?id=anuj.wifidirect

Take a look on this code and surely you will understand, in case of an kind of problem just put your comment and let me know about.

My Email id: anujs1991@gmail.com


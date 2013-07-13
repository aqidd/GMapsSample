GMapsSample
===========

sebuah sampel aplikasi berisi list lokasi dan opsi untuk melihat lokasi tersebut di google maps atau
menentukan rute menuju lokasi tersebut dari lokasi asal kita yang telah ditentukan sebelumnya.


#### Requirements :
* Android 4.2.2 & Android 2.2 SDK Platform
* Google APIs 17
* Google Play Services
* Android Support Library

#### How-To-Run :
* Download / Clone Repository

* Extract & Import Projects 
* ![import project](https://raw.github.com/aqidd/GMapsSample/master/screen%20capture/step1%20import.PNG)

* Fix Project Library Reference (remove invalid project library location and add google-play-services_lib library project)
* ![update library reference](https://raw.github.com/aqidd/GMapsSample/master/screen%20capture/step2%20update%20library.PNG)




NB : untuk mencari lattitude & longitude sebuah lokasi bisa menggunakan : http://www.latlong.net/

fitur yang tersedia :
* list lokasi yang sudah diinput (di ListActivity.java)
* mendapatkan rute menuju lokasi dari posisi awal yang sudah ditentukan di kode (hardcode di ListActivity.java)
* menampilkan marker lokasi di maps (di MapActivity.java)

#### Project Screenshots
![home screen](https://raw.github.com/aqidd/GMapsSample/master/screen%20capture/SC20130713-231124.png)
![options](https://raw.github.com/aqidd/GMapsSample/master/screen%20capture/SC20130713-231130.png)
![route - 1](https://raw.github.com/aqidd/GMapsSample/master/screen%20capture/SC20130713-231156.png)
![view route on map](https://raw.github.com/aqidd/GMapsSample/master/screen%20capture/SC20130713-231224.png)
![view location on map](https://raw.github.com/aqidd/GMapsSample/master/screen%20capture/SC20130713-231249.png)

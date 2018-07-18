cd %~dp0
mkdir java8-okhttp-gson
del java8-okhttp-gson\pom.xml
del java8-okhttp-gson\build.gradle
rmdir java8-okhttp-gson\src\main  /s /q
mkdir java8-jersey2
del java8-jersey2\pom.xml
del java8-jersey2\build.gradle
rmdir java8-jersey2\src\main  /s /q
mkdir java8-retrofit2
del java8-retrofit2\pom.xml
del java8-retrofit2\build.gradle
rmdir java8-retrofit2\src\main  /s /q
mkdir csharp-net35
rmdir csharp-net35\src\Sphereon.SDK.Barcode  /s /q
mkdir csharp-net45
rmdir csharp-net45\src\Sphereon.SDK.Barcode  /s /q

call mvn -Pjava8-jersey2 clean install
start mvn -Pjava8-okhttp-gson clean install
REM start mvn -Pjava8-okhttp-gson_versioned clean install
start mvn -Pjava8-retrofit2 clean install
start mvn -Pcsharp-net45 clean install
start mvn -Pcsharp-net35 clean install
start mvn -Pjavascript clean install
start mvn -Ptypescript-angular2 clean install
start mvn -Phtml-docs clean install

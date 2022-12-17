# Readme

This project is full Kotlin, from gradle to source.
Cause it's way more efficient and consistent than Java.. (sorry Oracle)

Here, it could adds some clarity to Minecraft plugin development.

Of course, you still can have Java class inside the same project.
They both compile together.

## Requirements :
 * Java 17 on your system
 * An IDE (i recommend Jetbrains IntelliJ)
 
## Make this POC yours :

Update project naming concerns in those files
 * /build.gradle.kts
 * /settings.gradle
 * /src/main/resource/plugin.yml

Put your java or kotlin code in **/src/java/**

## Build the jar :

In shell prompt, type the following line at the project root dir :

| OS      | Command           |
|---------|-------------------|
| windows | gradlew.bat build |
| linux   | ./gradlew build   |
 
On linux, you may need make gradlew executable with: chmod +x gradlew
See gradle for additional goals like: clean

On compile success, you will find you **jar**
In the folder **build/libs/poc-1.0.0.jar**

You can then copy/paste it to you server plugin folder.

NB: 
The minimal size of the jar is around 3MB.
It indeed contains all the kotlin classes need at runtime.




javac --modulepath --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls -d bin src/*.java
java --modulepath --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls -cp bin Executable
#!/bin/bash

javac Swingy.java
java Swingy console
rm world/*.class
rm hero/*.class
rm display/*.class
rm utils/*.class
rm *.class
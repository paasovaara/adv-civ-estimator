#!/bin/bash
gradle clean app:jar
java -jar app/build/libs/app.jar $@

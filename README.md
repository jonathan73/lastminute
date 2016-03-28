# The lastminute exercise

##Use these maven goals .

###For java doc :

mvn javadoc:javadoc

###For build :

mvn clean install

One jar maven plugin creates into the target directory an executable file  names purchase.jar. From target directory launch the command as follow :

java -jar purchase.jar [inputfile.txt] [outputfile.txt]

For example if you want test with input_1.txt. From linux launch this command.

java -jar purchase.jar ../../test/src/test/resources/inputfiles/input_3.txt output.txt; cat output.txt

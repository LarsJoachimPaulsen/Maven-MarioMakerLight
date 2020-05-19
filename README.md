
# Initial start up of the framework
 
The framework is built in the dependency management system Maven. 
To use the frameworks existing dependencies, as well as expanding it with new dependencies is as easy as adding them to the pom.xml-file.
New dependencies can be found on https://mvnrepository.com/. The easiest way to get the framework to start, is to open the pom.xml-file, 
located in the main folder, and allowing for auto-importing. 

Sometimes the IDE might not set the project up as a Maven project, a small pop-up window in the lower right corner will in this case ask you if you want to add the project as a maven project. 
If you miss this window you can press on "Event Log" in the lower right corner and find the option there. 

When auto-importing is done, the program should be ready to compile. 
If it for some reason is not, these steps might fix the problem. 

Checking that folders are marked correctly. 
Finde the java-folder located in: 
       Maven-MarioMakerLight -> src -> main
right click the folder, find Mark Directory as, choose Sources root. 

Find the resources-folder located in 
       Maven-MarioMakerLight -> src -> resources
right click the folder, find Mark Directory as, choose resources

The program should come with a predefined TestConsole class, with the corresponding configuration. If it does not, or you want to create your own class for testing do the following: 

Choose add configuration in the pulldown menu in the upper rigth corner. 
On the following screen give the appropriate path to the Main class you want to use, easiest way is to press the button with the three dots to the right of input-field. 
The working directory should end on \Maven-MarioMakerLight. 
The Use Class Path of module should be MarioMakerLight. 
JRE should be 13. An earlier JRE might be used, but since the code is based on Java 13. we can not guarantee that it will compile correctly. 

Press apply, and OK, you should now be ready. 
## This repo has been archived
Superseded by using a real minecraft instance with Xvfb

# HeadlessForge
Run Minecraft 1.8.9 mods without a window server (headless) <br>
The key use case is for analyzing suspicious 1.8.9 Minecraft mods
## Running locally
Since I'm not legally allowed to distribute the Minecraft jar, you have to add it yourself.<br>
Find your Minecraft jar (libraries dir in MultiMC/PolyMC),
then run `mvn install:install-file -Dfile=<path-to-minecraft-jar> -DgroupId=com.mojang -DartifactId=minecraft -Dversion=1.8.9 -Dpackaging=jar -DlocalRepositoryPath=<path to repo dir in this folder>`<br>
After you can run `mvn package` (makes a jar, takes ~1 minute) or run from your IDE 
## Security notice
This executes arbitrary code from external mods which may or may not be safe. If mods are untrusted, use docker or a VM.

BUILD="build"
RUN="run"
CLEAN="clean"

if  [ "$1" = "$BUILD" ];
then
	javac JLauncher/*.java
elif [ "$1" = "$RUN" ];
then
	java JLauncher/Main $2
elif [ "$1" = "$CLEAN" ];
then
	rm -f JLauncher/*.class
	rm -f simulation.txt
fi

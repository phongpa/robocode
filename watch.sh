#! /bin/bash

REQUIRES=(pkill fswatch mvn)
ROBOCODE_VER=1.9.2.5

# check requirements
for i in ${REQUIRES[@]}; do 
    if ! type "$i" > /dev/null; then
        echo "$i is required. Plz install it before continue."
        exit 1
    fi
done

# instruction
echo "Press r to rebuild workspace and restart robocode."
echo "Press q or Ctrl+Z to stop script."

# do smt with this function
haizz()
{
    # kill robocode if running
    echo "Trying to stop robocode..."
    pkill -f robocode

    echo "Rebuild robocode..."
    ./mvnassembly.sh -DskipTests=true

    # restart robocode (as background job)
    echo "Restart robocode..."
    chmod +x ./robocode.distribution/target/robocode-$ROBOCODE_VER-setup/robocode.sh
    ./robocode.distribution/target/robocode-$ROBOCODE_VER-setup/robocode.sh &

}

while :
do
    # XXX watch changes then do smt
    # it works!! But so stupid...
#    fswatch -xr $PWD | haizz

    # get user input
    read -n 1 key
    if [ $key == "r" ]; then
        haizz
    elif [ $key == "q" ]; then
        exit 0
    fi
done
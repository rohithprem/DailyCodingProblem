FOLDER_NAME="Problem#"$1
PROBLEM_NUMBER=$1
if [ -d $FOLDER_NAME ]; then
    echo "Folder: "$FOLDER_NAME" : already exists!"
else
    echo "Creating Problem#"$1
    mkdir $FOLDER_NAME
    mkdir -p $FOLDER_NAME/src/com/rohithprem/dcp/problem$PROBLEM_NUMBER
    mkdir -p $FOLDER_NAME/test/com/rohithprem/dcp/problem$PROBLEM_NUMBER
    cp Problem#1/build.gradle $FOLDER_NAME/build.gradle
    echo "include '"$FOLDER_NAME"'" >> settings.gradle
fi

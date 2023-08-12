#!/bin/bash

JAVA_PID=$(pgrep -f "java -cp target/classes com.mycompany.app.App")

if [ -n "$JAVA_PID" ]; then
  echo "Killing Java process with PID $JAVA_PID"
  kill $JAVA_PID
else
  echo "Java process not found"
fi

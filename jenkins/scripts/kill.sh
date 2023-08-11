#!/bin/bash

# Get the process ID (PID) of the running application
PID=$(pgrep -f "java -jar your-app.jar")

if [ -n "$PID" ]; then
    # Send SIGTERM signal to gracefully terminate the application
    kill -15 $PID
    
    # Wait for the process to exit
    wait $PID
fi

#!/bin/bash

PID=$(pgrep -f "java -jar com.mycompany.app.jar")

if [ -n "$PID" ]; then
    # Send SIGTERM signal to gracefully terminate the application
    kill -15 $PID
    
    # Wait for the process to exit
    wait $PID
fi
#!/bin/bash

pid=$(ps aux | grep '[j]ava -cp target/classes com.mycompany.app.App' | awk '{print $2}')

if [ -n "$pid" ]; then
  echo "Killing Java process with PID $pid"
  kill "$pid"
else
  echo "Java process not found"
fi

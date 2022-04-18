#!/bin/bash

echo "Starting gecko driver with args: $@"
SOURCE="${BASH_SOURCE[0]}"
DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"

$DIR/geckodriver "$@" 2>&1 | grep -Ev '(addons.manager|DEBUG|INFO)'

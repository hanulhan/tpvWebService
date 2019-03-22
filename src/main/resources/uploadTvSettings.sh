#!/bin/bash
curl -X POST -H "Content-Type: multipart/form-data" --form TVSettings=@TVSettings.zip http://localhost:8080/register

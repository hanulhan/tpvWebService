#!/bin/bash
curl -X POST -H "Content-Type: multipart/form-data" --form RoomSpecificSettings=@RoomSpecificSettings.zip http://localhost:8080/register

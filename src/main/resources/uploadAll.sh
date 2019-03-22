#!/bin/bash
curl -X POST -H "Content-Type: multipart/form-data" --form TVSettings=@TVSettings.zip \
                                                    --form RoomSpecificSettings=@RoomSpecificSettings.zip  \
                                                    http://localhost:8080/register

#!/bin/bash

echo Deploy deploy-petclinic-web-v2........

cd /projects/quarkus-workshop-labs/quarkus-petclinic-web-v2

#
# Quarkus App
#
mvn clean package -Dquarkus.kubernetes.deploy=true

# clear
echo "Done! Verify by using steps below:"
echo
echo "Open a web browser and visit the URL to view the petclinic app:"
echo "http://$(oc get route petclinic-web-v2 -o=go-template --template='{{ .spec.host }}')"

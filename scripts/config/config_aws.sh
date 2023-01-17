#!/bin/bash

#Variable pour config AWS
AWS_FILE="/vagrant/data/gnupg/config.sh"

echo "=> [1]: Config AWS credentials"
source $AWS_FILE
aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID
aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY
aws configure set default.region $AWS_REGION

echo "=> [2]: Verification identité"
aws sts get-caller-identity